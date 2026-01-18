public class EventCommand extends Command {

    private EventTask task;

    public EventCommand(EventTask task) {
        this.task = task;
    }

    @Override
    public void execute(TaskList taskList, Ui ui, Storage storage) {
        taskList.addTask(this.task);
        ui.showAddEventTask(this.task, taskList);
    }
}
