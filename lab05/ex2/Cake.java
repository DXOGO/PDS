public class Cake {
    private Shape shape;
    private String cakeLayer;
    private int numCakeLayers;
    private Cream midLayerCream;
    private Cream topLayerCream;
    private Topping topping;
    private String message;

    // métodos

    // os bolos têm 1 layer e são redondos por default
    Cake() {
        this.shape = Shape.Circle;
        this.numCakeLayers = 1;
    }

    /**
     * @return Shape return the shape
     */
    public Shape getShape() {
        return shape;
    }

    /**
     * @param shape the shape to set
     */
    public void setShape(Shape shape) {
        this.shape = shape;
    }

    /**
     * @return String return the cakeLayer
     */
    public String getCakeLayer() {
        return cakeLayer;
    }

    /**
     * @param cakeLayer the cakeLayer to set
     */
    public void setCakeLayer(String cakeLayer) {
        this.cakeLayer = cakeLayer;
    }

    /**
     * @return int return the numCakeLayers
     */
    public int getNumCakeLayers() {
        return numCakeLayers;
    }

    /**
     * @param numCakeLayers the numCakeLayers to set
     */
    public void setNumCakeLayers(int numCakeLayers) {
        this.numCakeLayers = numCakeLayers;
    }

    /**
     * @return Cream return the midLayerCake
     */
    public Cream getMidLayerCream() {
        return midLayerCream;
    }

    /**
     * @param midLayerCake the midLayerCake to set
     */
    public void setMidLayerCream(Cream midLayerCream) {
        this.midLayerCream = midLayerCream;
    }

    /**
     * @return Cream return the topLayerCream
     */
    public Cream getTopLayerCream() {
        return topLayerCream;
    }

    /**
     * @param topLayerCream the topLayerCream to set
     */
    public void setTopLayerCream(Cream topLayerCream) {
        this.topLayerCream = topLayerCream;
    }

    /**
     * @return Topping return the topping
     */
    public Topping getTopping() {
        return topping;
    }

    /**
     * @param topping the topping to set
     */
    public void setTopping(Topping topping) {
        this.topping = topping;
    }

    /**
     * @return String return the message
     */
    public String getMessage() {
        return message;
    }

    /**
     * @param message the message to set
     */
    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        // Your cake is ready: Soft chocolate cake with 1
        // layers, topped with Whipped_Cream cream
        // and Fruit. Message says: "Congratulations".

        String ret = this.cakeLayer + " cake with " + this.numCakeLayers + " layers";
        
        if (this.numCakeLayers > 1) {
            ret += " and " + this.midLayerCream + " cream";
        }

        ret += ", topped with " + this.topLayerCream + " cream and " + this.topping + ".";

        if (this.message.isEmpty() != true) {
            ret += " Message says: \"" + this.message + "\".";
        }

        return ret;
    }
}
