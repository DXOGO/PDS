public class Portugues extends Nationality {
    public Portugues(Translator t) {
        super(t);
    }

    public void getMsg() {
        String rec = super.receiveMsg("PT");
        System.out.println("[Portugues] Recebi uma mensagem: " + rec);
    }
}