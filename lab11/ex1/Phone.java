public class Phone {

    private String brand;
    private String model;
    private double price;
    private double camera;
    private int memory;

    public Phone(String brand, String model, double price, double camera, int memory){
        this.brand = brand;
        this.model = model;
        this.price = price;
        this.camera = camera;
        this.memory = memory;
    }

    public String getBrand() { return this.brand; }

    public void setBrand(String brand) { this.brand = brand; }

    public String getModel() { return this.model; }

    public void setModel(String model) { this.model = model; }

    public double getPrice() { return this.price; }

    public void setPrice(double price) { this.price = price; }

    public double getCamera() { return this.camera; }

    public void setCamera(double camera) { this.camera = camera; }

    public int getMemory() { return this.memory; }

    public void setMemory(int memory) { this.memory = memory; }

    @Override

    public String toString(){
        return "[" + this.brand + " " + this.model + "] " + "Price: " + this.price + "$; Camera: " + this.camera + "mp; Memory: " + this.memory + "G";
    }

}