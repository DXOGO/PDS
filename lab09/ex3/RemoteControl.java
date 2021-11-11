import java.util.Collection;

public class RemoteControl<T> {
    private Command command;

    public void setCommand(Command command) {
        this.command = command;
    }

    public boolean execute(T element) {
        return this.command.execute(element);
    }

    public boolean undo() {
        return this.command.undo();
    }

    public void printList() {
        Collection col = this.command.getCommands();

        for (Object el : col) {
            System.out.println(el.toString());
        }
    }
}