public class UnmarkCommand extends Command {

    private String taskIndex;

    public UnmarkCommand(String taskIndex) {
        this.taskIndex = taskIndex;
    }

    @Override
    public void execute(TaskList taskList, Ui ui, Storage storage) {
        Task unmarkedTask = taskList.unmarkTask(taskIndex);
        ui.showUnmarkTask(unmarkedTask);
    }
}
