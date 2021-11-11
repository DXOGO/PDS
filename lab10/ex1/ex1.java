public class ex1 {
    
    public static void main(String[] args) {
        
        // criar produtos
        Produto p1 = new Produto("Produto 1", 10.0);
        Produto p2 = new Produto("Produto 2", 15.0);
        Produto p3 = new Produto("Produto 3", 20.0);
        Produto p4 = new Produto("Produto 4", 25.0);
        Produto p5 = new Produto("Produto 5", 30.0);

        // criar clientes
        Cliente cl1 = new Cliente("Cliente 1");
        Cliente cl2 = new Cliente("Cliente 2");
        Cliente cl3 = new Cliente("Cliente 3");

        // criar gestor
        Gestor gestor = new Gestor("Gestor");

        // registar observers para os produtos (neste caso o gestor)
        p1.registerObserver(gestor);
        p2.registerObserver(gestor);
        p3.registerObserver(gestor);
        p4.registerObserver(gestor);
        p5.registerObserver(gestor);

        p2.setState(ProdutoState.AUCTION);
        p1.setState(ProdutoState.AUCTION);

        cl1.placeBid(p2, 20.3);
        System.out.println("");
        cl1.placeBid(p1, 25);
        System.out.println("");

        p3.setState(ProdutoState.AUCTION);
        cl2.placeBid(p3, 32);
        System.out.println("");

        cl3.placeBid(p3, 21);
        System.out.println("");

        p4.setState(ProdutoState.AUCTION);
        p5.setState(ProdutoState.AUCTION);

        cl2.placeBid(p2, 22);
        System.out.println("");
        System.out.println("E vai 1...");
        System.out.println("E vai 2...");
        p2.setState(ProdutoState.SOLD);
        System.out.println("");

        System.out.println("E vai 1...");
        System.out.println("E vai 2...");
        p1.setState(ProdutoState.SOLD);
        System.out.println("");

        cl3.placeBid(p3, 35);
        System.out.println("");

        System.out.println("E vai 1...");
        System.out.println("E vai 2...");
        p3.setState(ProdutoState.SOLD);
        System.out.println("");

        p4.setState(ProdutoState.STOCK);
        p5.setState(ProdutoState.STOCK);
    }
}
