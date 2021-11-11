public class CakeMaster {
    private CakeBuilder cake_builder;

    public void setCakeBuilder(CakeBuilder builder) {
        this.cake_builder = builder;
    }

    // as várias implemetações de createCake
    // apenas a mensagem
    public void createCake(String message) {
        this.cake_builder.createCake();       
        this.cake_builder.addCreamLayer();
        this.cake_builder.addTopLayer();
        this.cake_builder.addTopping();
        this.cake_builder.addMessage(message);
    }

    // número de camadas e mensagem
    public void createCake(int nLayers, String message) {
        this.cake_builder.createCake();     
        this.cake_builder.addCakeLayer(nLayers);
        this.cake_builder.addMessage(message);   
        this.cake_builder.addCreamLayer();
        this.cake_builder.addTopLayer();
        this.cake_builder.addTopping();
    }

    // forma, número de camadas e mensagem
    public void createCake(Shape shape, int nLayers, String message) {
        this.cake_builder.createCake();     
        this.cake_builder.setCakeShape(shape);
        this.cake_builder.addCakeLayer(nLayers);
        this.cake_builder.addMessage(message);  
        this.cake_builder.addCreamLayer();
        this.cake_builder.addTopLayer();
        this.cake_builder.addTopping();
    }

    // devolver o bolo
    public Cake getCake() {
        return this.cake_builder.getCake();
    }

}
