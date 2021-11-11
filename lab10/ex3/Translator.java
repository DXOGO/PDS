public interface Translator {
    public void sendMsg(String msg);
    public String receiveMsg(String lang, int received);
}