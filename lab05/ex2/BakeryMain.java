public class BakeryMain {
    public static void main(String[] args) {
        CakeMaster cakeMaster = new CakeMaster();

        CakeBuilder chocolate = new ChocolateCakeBuilder();
        cakeMaster.setCakeBuilder(chocolate);
        cakeMaster.createCake("Congratulations"); // 1 cake layer
        Cake cake = cakeMaster.getCake();
        System.out.println("Your cake is ready: " + cake);

        
        CakeBuilder sponge = new SpongeCakeBuilder();
        cakeMaster.setCakeBuilder(sponge);
        cakeMaster.createCake(Shape.Square, 2, "Well done"); // squared, 2 layers
        cake = cakeMaster.getCake();
        System.out.println("Your cake is ready: " + cake);

        CakeBuilder yogurt = new YogurtCakeBuilder();
        cakeMaster.setCakeBuilder(yogurt);
        cakeMaster.createCake(3, "The best"); // 3 layers
        cake = cakeMaster.getCake();
        System.out.println("Your cake is ready: " + cake);

        // adicionar mais exemplos
        CakeBuilder wedding = new WeddingCakeBuilder();
        cakeMaster.setCakeBuilder(wedding);
        cakeMaster.createCake(3, "Olá Manel"); // 3 layers
        cake = cakeMaster.getCake();
        System.out.println("Your cake is ready: " + cake);
    }
} 