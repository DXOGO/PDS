import java.util.ArrayList;
import java.util.HashMap;

public class ConcreteTranslator implements Translator {
    private ArrayList<String> stack = new ArrayList<>();

    public void sendMsg(String msg) {
        stack.add(msg);
    }

    public String receiveMsg(String lang, int received) {
        if (received >= this.stack.size()) {
            System.out.println("No new messages");
            return "";
        }

        String toSend = "";

        switch (lang) {
            case "PT":
                toSend += "[Translated to PT] ";
                break;
            case "ENG":
                toSend += "[Translated to ENG] ";
                break;        
            default:
                System.out.println("[ERROR] Language not available. Only PT and ENG.");
                return "";
        }
        toSend += stack.get(received);
        return toSend;
    }
}