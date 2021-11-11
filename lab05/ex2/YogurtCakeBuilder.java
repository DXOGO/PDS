public class YogurtCakeBuilder implements CakeBuilder {
    private Cake myCake = new Cake();

    // mudamos a forma do bolo
    public void setCakeShape(Shape s) {
        this.myCake.setShape(s);
    }
    
    public void createCake() {
        this.myCake.setCakeLayer("Yogurt");
    }

    public void addCakeLayer(int n_layers) {
        this.myCake.setNumCakeLayers(n_layers);
    }

    public void addCreamLayer() {
        this.myCake.setMidLayerCream(Cream.Vanilla);
    }

    public void addTopLayer() {
        this.myCake.setTopLayerCream(Cream.Red_Berries);
    }

    public void addTopping() {
        this.myCake.setTopping(Topping.Chocolate);
    }

    public void addMessage(String m) {
        this.myCake.setMessage(m);
    }

    // devolver o bolo
    public Cake getCake() {
        return this.myCake;
    }
}
