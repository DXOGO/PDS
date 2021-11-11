public enum Topping {
    Fruit("Fruit"),
    Chocolate("Chocolate");

    private final String name;

    private Topping(String s) {
        this.name = s;
    }

    @Override
    public String toString() {
        return this.name;
    }
}
