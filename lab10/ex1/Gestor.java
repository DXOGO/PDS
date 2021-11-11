/*
Caraterizado por nome (String). 
 -> Tem acesso à lista de produtos em stock, em leilão e vendidos.
 ->Deve receber informação sempre que uma licitação é feita, ou um produto é vendido
*/
public class Gestor implements Observer {   // gestor e cliente tem de implementar observer

    private String name;

    public Gestor(String name) { this.name = name; }

    @Override
    public String getType() { return "Gestor"; };   // metodo do observer

    @Override
    public String getName() { return this.name; }   // metodo do observer

    @Override
    public void update(String update_msg) {          // metodo do observer
        System.out.println("Updating info for manager " + this.name + ": " + update_msg); 
    }     
}
