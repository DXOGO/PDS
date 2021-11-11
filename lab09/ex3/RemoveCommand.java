import java.util.Collection;

public class RemoveCommand<T> implements Command<T> {
    private Collection<T> commands;
    private T lastRemoved;
    private boolean canUndo = false;

    public RemoveCommand(Collection<T> col) {
        this.commands = col;
    }

    public boolean execute(T element) {
        if (this.commands.remove(element)) {
            this.lastRemoved = element;
            this.canUndo = true;
            return true;
        }

        return false;
    }

    public boolean undo(){
        if (this.canUndo && this.commands.add(this.lastRemoved)) {
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