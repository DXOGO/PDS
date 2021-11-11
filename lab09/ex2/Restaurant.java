import java.util.ArrayList;

public class Restaurant {
    public static void main(String[] args) {
        ArrayList<String> asks = new ArrayList<>();

        asks.add("Can I please get a veggie burger?");
        asks.add("Can I please get a Pasta Carbonara?");
        asks.add("Can I please get a PLAIN pizza, no toppings!?");
        asks.add("Can I please get a sushi nigiri and sashimi?");
        asks.add("Can I please get a salad with tuna?");
        asks.add("Can I please get a strawberry ice cream and waffles dessert?");

        Chef cooker = new SushiChef("sushi", 14).setNextChef(
            new PastaChef("pasta", 14).setNextChef(
                new BurgerChef("burger", 19).setNextChef(
                    new PizzaChef("pizza", 7).setNextChef(
                        new DessertChef("dessert", 17)
                    )
                )
            )
        );

        for (String ask : asks) {
            System.out.println(ask);
            cooker.cook(ask);
            System.out.println();
        }
            
    }
}