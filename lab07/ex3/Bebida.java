class Bebida extends tipoProduto {

    private String name;
    private float weight;

    public Bebida(String name, float weight) {
        this.name = name;
        this.weight = weight;
    }

    @Override
    public float getWeight() { return this.weight; }

    @Override
    public void draw(){
        System.out.println(super.getIndent().toString() + "Bebida " + "'" + this.name + " '" + " - Weight : " + this.weight);
    }
    
}
