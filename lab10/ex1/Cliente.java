/*
Caraterizado por nome (String). 
 -> Pode consultar os produtos em leilão.
 -> Pode licitar 1+ produtos por determinado valor, recebendo a informação smp q esse produto receba uma oferta maior.
 -> Deverá ser informado quando a licitação termina e o produto é vendido.
*/
public class Cliente implements Observer {       // gestor e cliente tem de implementar observer

    private String name;

    public Cliente(String name) { this.name = name; }

    public boolean placeBid(Produto p, double bid) { return p.registerBid(p, bid, this); }            
        // cliente pode fazer bid a 1+ produtos com o valor q desejar
        // chama método em Produto para registar a bid do cliente

    @Override
    public String getType() { return "Client"; };   // metodo do observer

    @Override
    public String getName() { return this.name; }   // metodo do observer

    @Override
    public void update(String update_msg) {         // metodo do observer 
        System.out.println("Updating info for client " + this.name + ": " + update_msg); 
    }  

}