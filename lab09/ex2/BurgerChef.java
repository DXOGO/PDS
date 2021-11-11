public class BurgerChef extends Chef {
    public BurgerChef (String key, int time) {
        super(key, time);
    }

    public void cook (String phrase) {
        String ask = phrase.replace("Can I please get a ", "").replace("?", "");

        if (canCook(ask, this.getKeyword())) {
            System.out.println("BurguerChef: Starting to cook " + ask + ". Out in " + this.getTime() + " minutes!");
        }
        else {
            System.out.println("BurguerChef: I can't cook that.");
            super.cook(phrase);
        }
    }
}