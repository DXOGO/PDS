import java.util.Collection;

public interface Command<T> {
    public boolean execute(T element);
    public boolean undo();
    public Collection<T> getCommands();
}