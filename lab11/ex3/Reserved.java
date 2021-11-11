public class Reserved implements State {

    // ao estar reservado só pode ser cancelada a reserva e volta para o estado de disponivel
    @Override
    public void cancelReserve(Book b) { b.setState(new Available()); }

    public String toString() { return "[Reserved]"; }

    
    // resto das operações não são suportadas neste estado
    @Override
    public void register(Book b) { System.err.println("Operation not available"); }

    @Override
    public void request(Book b) { System.err.println("Operation not available"); }

    @Override
    public void _return(Book b) { System.err.println("Operation not available"); }

    @Override
    public void reserve(Book b) { System.err.println("Operation not available"); }
    
}
