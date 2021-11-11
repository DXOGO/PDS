public abstract class Nationality {
    private Translator trans;
    private static int received = 0;

    public Nationality(Translator t) {
        this.trans = t;
    }

    public void sendMsg(String msg){
        trans.sendMsg(msg);
    }
    
    public String receiveMsg(String lang) {        
        String ret = trans.receiveMsg(lang, this.received);
        if (ret.length() > 0) {
            this.received++;
        }
        return ret;
    }

    public abstract void getMsg();
}