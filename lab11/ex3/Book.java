public class Book {

    private String title, fAuthor;
    private int isbn, year;
    State state;        // estado atual do livro

    // A entidade livro permite operações tais como: regista, requisita, reserva, cancelaReserva, disponível, etc
    // No entanto, cada uma destas operações depende da situação do livro na biblioteca:
    //      se está em situação de inventário, por exemplo, só permite a operação regista

    public Book(String title, String fAuthor, int isbn, int year) {
        this.title = title;
        this.fAuthor = fAuthor;
        this.isbn = isbn;
        this.year = year;
        this.state = new Inventory();
    }

    // getters ands setters
    public String getTitle() { return this.title; }

    public void setTitle(String title) { this.title = title; }

    public String getFAuthor() { return this.fAuthor; }

    public void setFAuthor(String fAuthor) { this.fAuthor = fAuthor; }

    public int getIsbn() { return this.isbn; }

    public void setIsbn(int isbn) { this.isbn = isbn; }

    public int getYear() { return this.year; }

    public void setYear(int year) { this.year = year; }

    
    // definir estados 
    public void setState(State s){ state = s; }
    public String state(){ return this.state.toString(); }

    public void register(){ state.register(this); }

    public void request(){ state.request(this); }

	public void _return(){ state._return(this); }

    public void reserve(){ state.reserve(this); }

	public void cancelReserve(){ state.cancelReserve(this); }
}