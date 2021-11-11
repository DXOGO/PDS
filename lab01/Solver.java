// package pds_2021_111.lab01;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.HashMap;
import java.io.IOException;


public class Solver extends WordSoup{
    private ArrayList<String> soup = new ArrayList<String>();       // guarda a sopa de letras
    private ArrayList<String> words_list = new ArrayList<String>();  // guarda a lista original de palavras

    public boolean readFile(String filename) {
        Boolean ret = true;

        try {
			File obj = new File(filename);
            Scanner reader = new Scanner(obj);
            boolean is_word = false;
            while (reader.hasNextLine()) {
                String data = reader.nextLine();
                
                if (is_word || data.indexOf(';') != -1 || data.indexOf(',') != -1 || data.indexOf(' ') != -1) {
                    is_word = true;     // boolean passa para verdadeiro quando é identidficada uma palavra da lista 

                    // separar e adicionar ao array
                    String[] words = data.split(";|,| ");
                    for (int i = 0; i < words.length; i++) {
                        if (!words[i].matches("[a-zA-Z]+")) { // verifica quando nao é uma letra do alfabeto e devolve ret = false
                            ret = false;
                            System.out.println("Error! The wordslist can only contain letters. (Regex [a-zA-Z]+)");
                        }
                        else{
                            words_list.add(words[i]);   // adiciona a palavra no array de palavras
                        }                        
                    }
                }
                else {
                    if (!data.matches("[A-Z]+")) { // Verifica se na sopa de letras só existem letras maiusculas
                        ret = false;
                        System.out.println("Error! The word soup can only contain uppercase letters. (Regex [A-Z]+)");
                    }
                    else{
                        soup.add(data);     // adiciona ao array da sopa de letras
                    }                      
                }
            }
            
            reader.close();

            if (soup.size() > 40) {
                System.out.println("Error! The matrix must not be larger than 40x40.");
                ret = false;
            }

            for(int i = 1 ; i < soup.size(); i++){ // loop para verificar se a sopa é quadrada ou alguma das linhas tem mais de 40 caracteres
                if (soup.get(i).length() > 40){
                    System.out.println("Error! The matrix must not be larger than 40x40.");
                    ret = false;
                    break;
                }
                else if (soup.size() != soup.get(i).length()) {  
                    System.out.println("Error! The matrix is not square.");
                    ret = false;
                    break;
                }
            }
		}
		catch(FileNotFoundException e) {
            System.out.println("An error occurred while reading the file.");
            e.printStackTrace();
            ret = false;
		}     
        
        return ret;
    }

    public HashMap<String, Solution> solve() {                                      // funçao solve
        HashMap<String, Solution> solution = new HashMap<String, Solution>();       // array da solution

        String[] puzzle = new String[soup.size()];        
        puzzle = soup.toArray(puzzle);
        
        Solution ret;

        ArrayList<String> words = new ArrayList<String>();
        words.addAll(words_list);   // criar copia do array original

        StringSizeComp comp = new StringSizeComp();
        java.util.Collections.sort(words, comp); // ordenar a copia por ordem decrescente de tamanho

        // ao analisarmos as palavras por ordem decrescente podemos ver se alguma palavra pequena está dentro de outra já encontrada maior

        for (int i = 0; i < words.size(); i++) {
            ret = this.search(words.get(i), puzzle, solution);
            if (ret != null) {
                solution.put(words.get(i), ret);
            }
            else {
                System.out.println("Error! The script could not find the word " + words.get(i).toUpperCase());
            }
            
        }

        return solution;
    }

    private Solution search(String word, String[] puzzle, HashMap<String, Solution> solution) {
        Solution data = null;
        // procurar pela primeira letra da palavra
        // percorrer direções e ver onde cabe
        // ver se existe em algumas dessas direções

        String word_upper = word.toUpperCase();     // pega na palavra na lista e mete em UPPERCASE 
        char first = word_upper.charAt(0);          // 1º caracter da palavra
        boolean found = false;

        for (int i = 0; i < puzzle.length; i++) {           // para cada linha
            for (int j = 0; j < puzzle[i].length(); j++) {  // para cada coluna
                if (first == puzzle[i].charAt(j)) {         // comparar caracter da palavra com o caracter atual do puzzle 
                    int dir = 0;                            // se forem igual começa o processo de encontrar a direcao
                    for (dir = 1; dir <= 8; dir++) {
                        if (this.fits(puzzle.length, word_upper, i, j, dir)) {
                            // já sabemos que a primeira letra está na posição [i,j]
                            // e que a palavra cabe nesta direção (dir)
                            // Agora temos de ver se a palavra é igual
                            // se for dá return depois de preencher o array

                            Coordinates puzzle_coor = new Coordinates(i, j);
                            if (!this.isInside(word_upper, i, j, dir, solution) && this.checkWord(puzzle, word_upper, this.move(dir, puzzle_coor), dir, 1)) {
                                if (!found) {
                                    Direction direction = Direction.Up;                                                                                         
                                    data = new Solution(word, new Coordinates(i, j), direction.getDirection(dir));
                                    found = true;
                                }
                                else {
                                    System.out.println("Error! The script found the word " + word + " more than once. Printing the first occurrence.");
                                    return data;
                                }                            
                            }
                            
                        }
                    }                   
                }
            }
        }

        return data;
    }

    private boolean checkWord(String[] puzzle, String word, Coordinates coordinates, int direction, int pos) {
        // condição de paragem
        if (pos == word.length()) {
            return true;
        }

        // enquanto for igual vai chamando
        if (puzzle[coordinates.getX()].charAt(coordinates.getY()) == word.charAt(pos)) {
            return checkWord(puzzle, word, move(direction, coordinates), direction, ++pos);
        }
        else {
            return false;
        }
    }

    public void printSolution(HashMap<String, Solution> solution, String fn) { 
        // para testar alterações

        String output = this.createOutput(solution);

        System.out.println(output);

        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(fn));

            writer.write(output);
            writer.close();

        } catch (IOException e) {
            System.err.println("Erro na escrita do ficheiro!");
            e.printStackTrace();
        }

	}

    public String createOutput(HashMap<String, Solution> solution){
        
        String str = "";

        for (String i : this.words_list){
            if (solution.containsKey(i)){
                str += solution.get(i).toString() + "\n";  
            }                      
        }

        String[] grid = new String[this.soup.size()];

        for (int i = 0; i < this.soup.size(); i++) {
            grid[i] = ".".repeat(this.soup.size());
        }

        for (String i : this.words_list) {
            if (solution.containsKey(i)){
                Solution values = solution.get(i);

                int x = values.getStart().getX(); 
                int y = values.getStart().getY();

                Coordinates pos = new Coordinates(x, y);    // pos da 1ª letra da palavra atual

                char[] chars = grid[pos.getX()].toCharArray();
                chars[pos.getY()] = i.charAt(0);
                grid[pos.getX()] = String.valueOf(chars).toUpperCase();
            
                for (int j = 1; j < i.length(); j++) {
                    
                    pos = this.move(values.getDir().getNumber(), pos);

                    chars = grid[pos.getX()].toCharArray();
                    chars[pos.getY()] = i.charAt(j);
                    grid[pos.getX()] = String.valueOf(chars).toUpperCase();

                }
            }
        }

        for (int m = 0; m < this.soup.size(); m++) {
            str += grid[m].replace("", " ").trim() + "\n";
        }

        return str;
    }
}
