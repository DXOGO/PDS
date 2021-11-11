import java.util.Collection;
import java.util.ArrayList;

public class Client {
    public static void main(String[] args) {
        RemoteControl addRemoteControl = new RemoteControl();
        RemoteControl removeRemoteControl = new RemoteControl();

        Collection elements = new ArrayList<>();

        elements.add("Informatica");
        elements.add("Telematica");

        Command addCommand = new AddCommand(elements);
        Command removeCommand = new RemoveCommand(elements);

        addRemoteControl.setCommand(addCommand);
        removeRemoteControl.setCommand(removeCommand);


        addRemoteControl.undo();
        addRemoteControl.execute("Eletronica");
        System.out.println("------------------");
        addRemoteControl.printList();
        addRemoteControl.undo();        
        System.out.println("------------------");
        addRemoteControl.printList();
        addRemoteControl.execute("Mecanica");
        addRemoteControl.execute("Ambiente");        
        System.out.println("------------------");
        addRemoteControl.printList();
        addRemoteControl.undo();


        System.out.println("------------------");
        removeRemoteControl.execute("Informatica");
        removeRemoteControl.printList();
        removeRemoteControl.undo();        
        System.out.println("------------------");
        removeRemoteControl.printList();

    }
}