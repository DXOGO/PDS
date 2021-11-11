public interface State {

    public void register(Book b);
	public void request(Book b);
	public void _return(Book b);
    public void reserve(Book b);
	public void cancelReserve(Book b);
	public String toString();

}
