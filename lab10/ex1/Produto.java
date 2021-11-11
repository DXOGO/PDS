import java.util.ArrayList;
import java.util.List;

/* 
Caraterizado por um código único atribuído automaticamente (int), descrição (String) e preço base (double). 
Cada produto pode estar num dos seguintes estados: stock, leilão, vendas. 
 -> A passagem a leilão deve incluir o tempo de duração neste estado.
 -> Caso não seja licitado deverá ser reposto no stock;
 -> Caso vendido passará para a lista de vendas.
 */
public class Produto extends Subject<ProdutoState> {
    
    private static int codeCounter = 0;
    private int code;               // vai ser o codigo do 1º produto
    private String descr;
    private double base_price;
    private ProdutoState state;
    private double highestBid;          // usado para saber qual a maior bid atual
    private Observer highestBidder;

    private List<Integer> prodCodes = new ArrayList<>();    // product codes
    private List<Observer> observers = new ArrayList<>();   // array field for storing a list of references to subscriber objects

    Produto(String descr, double base_price){
        
        this.code = ++codeCounter;   // prod1 : 1, prod2 : 2, prod3 : 3, ...
        this.prodCodes.add(this.code);
        // para cada produto diferente registado o código vai ser a ordem q foram criados

        this.descr = descr;
        this.base_price = base_price;
        this.highestBid = base_price;       // a maior bid é no mínimo o preço base do produto
        this.state = ProdutoState.STOCK;    // produto criado, logo está em stock
    }

    public boolean registerBid(Produto p, double bid, Observer obs) {   // observer pode ser cliente ou gestor e 
                                                                        // para cada um temos ações diferentes
        if (prodExists(p)){
            if (this.state == ProdutoState.AUCTION){    // se o produto tiver a ser auctioned
                if (bid > this.highestBid) {
                    this.highestBid = bid;
                    this.highestBidder = obs;
                    this.observers.add(obs);    // é adicionado um cliente para a lista de pessoas a notificar sobre o produto
                    this.updateObservers("[OBSERVERS] - ["+ p.descr +"] A new bid with value " + bid + " was placed by " + obs.getName());
                    return true;
                } else if (bid < this.base_price || bid < this.highestBid) {
                    System.out.println(obs.getName() + ", your bid can't be lower than "+ (this.highestBid) +" for this product");
                }

                /*for (Observer obs2 : this.observers) {
                    if (obs2.getType() == "Gestor"){ 
                        obs2.update("[MANAGERS] - ["+ p.descr +"] A new bid with value " + bid + " was placed by " + obs.getName()); 
                    }
                }*/

                return false;    
            } 
            else if (this.state == ProdutoState.SOLD) {
                this.updateObservers("[OBSERVERS] - ["+ p.descr +"] was sold to " + this.highestBidder.getName() + " for " + this.highestBid);
                return true;
            }
            else { return false; }
        } else { System.out.println("Product doesn't exist!"); return false; }                                                            
        
    }

    private boolean prodExists(Produto p) {
        int product_code = p.getCode();
        //System.out.println(prodCodes.toString());
        //System.out.println(product_code);
        if (this.prodCodes.contains(product_code)){
            return true;
        }
        return false;
    }

    private int getCode() {
        return this.code;
    }

    public void setState(ProdutoState state) {
        this.state = state;

        if (this.state == ProdutoState.SOLD){
            this.registerBid(this, 0.0, null);
        }
    }

    @Override
    public String toString(){
        return this.descr;
    }

    private void updateObservers(String update_msg) {   // update observers 
        for (Observer obs : this.observers){ 
            obs.update(update_msg); 
        }  
    }

    public void registerObserver(Observer obs) {   // registar um observer -> adiconar ao array
        if (!this.observers.contains(obs)){
            observers.add(obs);
        }
    }

}