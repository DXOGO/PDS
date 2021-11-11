public class Borrowed implements State {

    // ao estar emprestado só pode ser devolvido e passa para o estado de disponível
    @Override
    public void _return(Book b) { b.setState(new Available()); }

    public String toString(){ return "[Borrowed]"; }
    

    // resto das operações não são suportadas neste estado
    @Override
    public void register(Book b) { System.err.println("Operation not available"); }
    
    @Override
    public void request(Book b) { System.err.println("Operation not available"); }

    @Override
    public void reserve(Book b) { System.err.println("Operation not available"); }

    @Override
    public void cancelReserve(Book b) { System.err.println("Operation not available"); }
    
}
