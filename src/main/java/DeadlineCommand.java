public class DeadlineCommand extends Command {

    private DeadlineTask task;

    public DeadlineCommand(DeadlineTask task) {
        this.task = task;
    }

    @Override
    public void execute(TaskList taskList, Ui ui, Storage storage) {
        taskList.addTask(this.task);
        ui.showAddDeadlineTask(this.task, taskList);
    }
}
