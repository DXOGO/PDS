class Conserva extends tipoProduto {

    private String name;
    private float weight;

    public Conserva(String name, float weight) {
        this.name = name;
        this.weight = weight;
    }

    @Override
    public float getWeight() { return this.weight; }

    @Override
    public void draw(){
        System.out.println(super.getIndent().toString() + "Conserva " + "'" + this.name + " '" + " - Weight : " + this.weight);
    }

}
