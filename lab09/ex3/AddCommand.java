import java.util.Collection;

public class AddCommand<T> implements Command<T> {
    private Collection<T> commands;
    private T lastCommand;
    private boolean canUndo = false;

    public AddCommand(Collection<T> col) {
        this.commands = col;
    }

    public boolean execute(T element) {
        if (this.commands.add(element)) {
            this.lastCommand = element;
            this.canUndo = true;
            return true;
        }

        return false;
    }

    public boolean undo(){
        if (this.canUndo && this.commands.remove(this.lastCommand)) {
            this.canUndo = false;
            return true;
        }

        System.out.println("[ERROR] Unable to undo");
        return false;
    }

    public Collection<T> getCommands() {
        return this.commands;
    }
}