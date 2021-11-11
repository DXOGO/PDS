public class Available implements State {

    // ao estar disponível pode ser requisitado por alguem e passa para o estado de emprestado
    @Override
    public void request(Book b) { b.setState(new Borrowed()); }
    
    // ao estar disponível pode ser reservado por alguem e passa para o estado de reservado
    @Override
    public void reserve(Book b) { b.setState(new Reserved()); }

    public String toString() { return "[Available]"; }


    // resto das operações não são suportadas neste estado
    @Override
    public void register(Book b) { System.err.println("Operation not available"); }

    @Override
    public void _return(Book b) { System.err.println("Operation not available"); }

    @Override
    public void cancelReserve(Book b) { System.err.println("Operation not available"); }
    
}
