public abstract class Command {

    public abstract void execute(TaskList taskList, Ui ui, Storage storage) throws KokoException;

    public boolean isExit() {
        return false;
    }
}
