public class ex3 {
    
    public static void main(String[] args) {
        
        // criar biblioteca
        Library LeitolinoLivraria = new Library();

        // criar 3 livros
        Book b1 = new Book("Anti-Stress Java", "Omodionah", 555555555, 2021);
        Book b2 = new Book("The War of the Patterns", "George Omel", 123456789, 1948);
        Book b3 = new Book("Searching for Light", "Khumatk", 219537190, 1985);

        // adicionar os 3 livros à nossa biblioteca
        LeitolinoLivraria.addBook(b1);
        LeitolinoLivraria.addBook(b2);
        LeitolinoLivraria.addBook(b3);

        // fazer as operações
        LeitolinoLivraria.operation();

    }
}
