public class SpongeCakeBuilder implements CakeBuilder {
    private Cake myCake = new Cake();

    // mudamos a forma do bolo
    public void setCakeShape(Shape s) {
        this.myCake.setShape(s);
    }
    
    public void createCake() {
        this.myCake.setCakeLayer("Sponge");
    }

    public void addCakeLayer(int n_layers) {
        this.myCake.setNumCakeLayers(n_layers);
    }

    public void addCreamLayer() {
        this.myCake.setMidLayerCream(Cream.Red_Berries);
    }

    public void addTopLayer() {
        this.myCake.setTopLayerCream(Cream.Whipped_Cream);
    }

    public void addTopping() {
        this.myCake.setTopping(Topping.Fruit);
    }

    public void addMessage(String m) {
        this.myCake.setMessage(m);
    }

    // devolver o bolo
    public Cake getCake() {
        return this.myCake;
    }
}
