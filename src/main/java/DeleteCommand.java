public class DeleteCommand extends Command {

    private String taskIndex;

    public DeleteCommand(String taskIndex) {
        this.taskIndex = taskIndex;
    }

    @Override
    public void execute(TaskList taskList, Ui ui, Storage storage) {
        Task deletedTask = taskList.deleteTask(taskIndex);
        ui.showDeleteTask(deletedTask, taskList);
    }
}
