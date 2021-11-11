import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;
import java.util.Scanner;


// package pds_2021_111.lab01;

public class Generator extends WordSoup{    
    private ArrayList<String> soup = new ArrayList<String>();
    private ArrayList<String> words_list = new ArrayList<String>();
    private HashMap<String, Solution> inserted_words = new HashMap<String, Solution>();
    
    public boolean readFile(String in_file) {
        boolean ret = true;
        try {	
            File obj = new File(in_file);
            if (obj.exists()) {
                Scanner reader = new Scanner(obj);

                while (reader.hasNextLine() && ret) {
                    String data = reader.nextLine();
                    
                    String[] words = data.split(";|,| ");
                    for (int i = 0; i < words.length; i++) {
                        if (!words[i].matches("[a-zA-Z]+")) {
                            ret = false;
                        }
                        else {
                            words_list.add(words[i]);
                        }                    
                    }
                }
                reader.close();
            }
            else {
                System.err.println("File does not exist");
                ret = false;
            }          
		}
		catch(FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
            ret = false;
		}

        return ret;
    }

    public ArrayList<String> createWS(int size) {
        String dots = ".".repeat(size);
        for (int i = 0; i < size; i++){
            soup.add(dots);
        }

        // percorrer as palavras
        // escolher coordenada random
        // ver se está ocupada - se sim ver se é igual à primeira letra
        // excluir direção da palavra com igual coordenada
        // se não for igual - escolher outra coordenada
        // selecionar direção random
        // verificar se cabe
        // se couber, ver se não tem nenhuma letra naquela direção
        // se tiver ver se é igual
        // se não couber, ou tiver letras no meio -> escolher outra direção
        // criar array com as direções proibidas (dar refresh sempre que muda de palavra)

        ArrayList<String> words = new ArrayList<String>();
        words.addAll(this.words_list);   // criar copia do array original

        for (String s : words) {
            if (s.length() > size) {
                System.err.println("You cannot have a word bigger than the word soup!");
                System.exit(1);
            }

            Coordinates pos = new Coordinates();

            boolean inserted = false;
            while (!inserted) {
                pos.randomCoordinate(size);
                char first = this.soup.get(pos.getX()).charAt(pos.getY());
                if (first == '.' || first == s.charAt(0)) {
                    
                    ArrayList<Integer> unwanted_dir = new ArrayList<Integer>();
                    while(unwanted_dir.size() < 8) {                    
                        Random rand = new Random();
                        
                        int dir;
                        // ver se está no unwanted
                        do {
                            dir = rand.nextInt(8); // [0; 7]
                        } while (unwanted_dir.contains(dir));
                        unwanted_dir.add(dir);

                        
                        // A palavra cabe?
                        // A palavra está dentro de outra?
                        // A palavra vai passar por cima de outra?
                        if (this.fits(size, s, pos.getX(), pos.getY(), dir) && !this.isInside(s, pos.getX(), pos.getY(), dir, this.inserted_words) 
                        && !this.over(s.length(), pos, dir)) {

                            Coordinates c = new Coordinates();
                            c.setX(pos.getX());
                            c.setY(pos.getY());

                            boolean canCreate = true;
                            for (int j = 0; j < s.length(); j++) {                                
                                char x = this.soup.get(c.getX()).charAt(c.getY());
                                if (x != '.' && x != s.charAt(j)) {
                                    canCreate = false;
                                    break;
                                }
                                c = this.move(dir, c);
                            }

                            if (canCreate) {
                                c.setX(pos.getX());
                                c.setY(pos.getY());

                                for (int j = 0; j < s.length(); j++) {                                    

                                    String line = this.soup.get(c.getX());
                                    line = line.substring(0, c.getY()) + s.charAt(j) + line.substring(c.getY() + 1);
                                    this.soup.set(c.getX(), line.toUpperCase());
                                    c = this.move(dir, c);
                                }
                                inserted = true;
                            }
                        }

                        if (inserted) { // foi inserida e unwanted_dir não chegou a 8
                            break;
                        }
                    }
                }
            }
        }
        
        this.populateWS(size);

        return this.soup;
    }

    private boolean over(int size, Coordinates pos, int dir) {
        boolean ret = false;
        
        for (String k : this.inserted_words.keySet()) {
            Solution val = this.inserted_words.get(k);

            if (val.getDir().getNumber() == dir) {
                Coordinates w2 = new Coordinates();
                w2 = val.getStart();
                for (int j = 0; j < k.length(); j++) {
                    if (w2.equals(pos)) {
                        ret = true;
                        break;
                    }

                    w2 = this.move(dir, w2);
                }
                if (!ret) {
                    for (int j = 0; j < size; j++) {
                        if (pos.equals(val.getStart())) {
                            ret = true;
                            break;
                        }

                        pos = this.move(dir, pos);
                    }
                }
            }
        }

        return ret;
    }

    private void populateWS(int size) {
        String[] letters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ".split("");
        Random rand = new Random();
        for (int i = 0; i < size; i++) {
            String line = this.soup.get(i);
            for (int j = 0; j < line.length(); j++){
                if (line.charAt(j) == '.') {
                    int letter = rand.nextInt(letters.length);
                    line = line.substring(0, j) + letters[letter] + line.substring(j+1);
                }
            }
            this.soup.set(i, line);
        }
    }

    public String getFromFile(String infn){

        String print = "";

        try {
            BufferedReader r = new BufferedReader( new FileReader(infn));
            String line = null;

            while ((line = r.readLine()) != null) {
                print += line + "\n";
            }

            r.close();
        
        } catch (IOException e) {
            System.out.println("Error reading from file!");
            e.printStackTrace();
        }

        return print;
    }

    public void printSolution(ArrayList<String> solution, String outfn, String infn, int size ) { 
        // para testar alterações

        String output = this.createOutput(solution, infn, size);

        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(outfn));

            writer.write(output);
            writer.close();

        } catch (IOException e) {
            System.err.println("Erro na escrita do ficheiro!");
            e.printStackTrace();
        }

	}

    public String createOutput(ArrayList<String> solution, String list, int size){        
        String str = "";
        
        for (String k : solution) {
            str += k.replace("", " ").trim() + "\n";
        }
        
        str += this.getFromFile(list);
        return str;
    }
}
