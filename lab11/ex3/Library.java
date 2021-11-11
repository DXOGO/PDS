import java.util.ArrayList;
import java.util.Scanner;

public class Library {
    
    ArrayList<Book> books = new ArrayList<>();  // array para adicionar e guardar os livros da biblioteca
    
    public void addBook(Book b) { books.add(b); }   // adicionar livro

    public ArrayList<Book> getAllBooks(){ return books; }   // retorna array

    public void showBooks(){

        int counter = 0; 

        System.out.println("*** Library ***");

        for (Book b : books) {
            counter++;
            System.out.printf("%-3d %-30s %-15s %-10s%n", counter, b.getTitle(), b.getFAuthor(), b.state());
        }
        System.out.println(">> <book>, <operation: (1)register; (2)request; (3)return; (4)reserve; (5)cancel\n");
    }   

    public void operation(){

        int b = 0;
        int op = 0;

        while ( true ) { 
            showBooks();
            System.out.println("Type 'exit' to leave");
            System.out.print(">> ");

            Scanner s = new Scanner(System.in);
            String answer = s.nextLine();

            if (answer.matches("exit")) {System.out.println("Until next time!\n"); return;};

            String inp[] = answer.split(",");  // op vai receber 2 numeros separados por virgula

            if (inp.length != 2 ) { System.out.println("[ERROR] Please follow the rules depicted above!"); continue; }

            try{
                b = Integer.parseInt(inp[0]);  // antes da virgula tem o livro
                if (b < 1 || b > books.size() ) { System.out.println("[ERROR] Book or operation not available!"); }
            
            } catch (NumberFormatException e){
                System.out.println("[ERROR] Input isn't integer!");
            }

            try{
                op = Integer.parseInt(inp[1]); // depois da virgula tem a op
                if (op < 0 || op > 5) { System.out.println("[ERROR] Book or operation not available!"); } 
            
            } catch (NumberFormatException e){
                System.out.println("[ERROR] Input isn't integer!");
            }
            

            Book book = books.get(b-1); // get book from array

            if (op == 1) { book.register(); }
            else if (op == 2) { book.request(); }
            else if (op == 3) { book._return(); }
            else if (op == 4) { book.reserve(); }
            else { book.cancelReserve(); }

            //s.close();
        }
    }
}
