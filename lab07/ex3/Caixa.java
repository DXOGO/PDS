import java.util.ArrayList;

class Caixa extends tipoProduto {

    private ArrayList<tipoProduto> tp = new ArrayList<>();
    private String prod;
    private float box_weight;
    private float full_weight;

    public Caixa(String prod, float box_weight) {
        this.prod = prod;
        this.box_weight = box_weight;

    }

    public void add(tipoProduto p) { tp.add(p); }

    public float getWeight(){
        this.full_weight = this.box_weight;

        for (tipoProduto p : tp){
            float prod_weight = p.getWeight();
            this.full_weight += prod_weight;
        }
        return this.full_weight;
    }

    public void draw() {
        System.out.println(super.getIndent().toString() + "* Caixa " + "'" + this.prod + " '" + "[ Weight: " + this.box_weight + " ; Total: " + getWeight() + "]");

        super.getIndent().append("   ");    // indent

        for (tipoProduto p : tp){
            p.draw();
            
        }

        super.getIndent().setLength(super.getIndent().length() - 3); // reset

    }

}
