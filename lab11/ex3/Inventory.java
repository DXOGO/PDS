public class Inventory implements State {

    // qd o livro é registado no ent passa de inventario para o estado de disponivel 
    @Override 
    public void register(Book b) { b.setState(new Available()); }

    public String toString() { return "[Inventory]"; }

    
    // resto das operações não são suportadas neste estado
    @Override
    public void request(Book b) { System.err.println("Operation not available"); }

    @Override
    public void _return(Book b) { System.err.println("Operation not available"); }

    @Override
    public void reserve(Book b) { System.err.println("Operation not available"); }

    @Override
    public void cancelReserve(Book b) { System.err.println("Operation not available"); }
    
}
