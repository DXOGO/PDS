public class Contact {
    String name;
    int number;

    public Contact(String name, int number){
        this.name = name;
        this.number = number;
    }

    public String getName() {
        return this.name;
    }

    @Override
    public String toString() {
        return this.name + " " + this.number;
    }
}
