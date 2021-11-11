public enum Cream {
    Whipped_Cream("Whipped_Cream"),
    Red_Berries("Red_Berries"),
    Vanilla("Vanilla");

    private final String name;

    private Cream(String s) {
        this.name = s;
    }

    @Override
    public String toString() {
        return this.name;
    }
}
