public enum Shape {
    Square("Square"),
    Rectangle("Rectangle"),
    Circle("Circle");

    private final String name;

    private Shape(String s) {
        this.name = s;
    }

    @Override
    public String toString() {
        return this.name;
    }
}
