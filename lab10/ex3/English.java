public class English extends Nationality {
    public English(Translator t) {
        super(t);
    }

    public void getMsg() {
        String rec = super.receiveMsg("ENG");
        System.out.println("[English] Received a message: " + rec);
    }
}