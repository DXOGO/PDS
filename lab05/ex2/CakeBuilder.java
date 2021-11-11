public interface CakeBuilder {
    public void setCakeShape(Shape shape);
    public void addCakeLayer(int n);
    public void addCreamLayer();
    public void addTopLayer();
    public void addTopping();
    public void addMessage(String m);
    public void createCake();
    public Cake getCake();
}

