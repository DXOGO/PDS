public class Conferencia {
    public static void main(String[] args) {
        Translator t = new ConcreteTranslator();

        Nationality pt = new Portugues(t);
        Nationality eng = new English(t);

        pt.sendMsg("Olá tu");
        pt.sendMsg("Como estás tu ?");

        eng.getMsg();
        eng.getMsg();
        eng.getMsg();

        eng.sendMsg("Hello friend");

        pt.getMsg();
    }
}