package koko.command;

import koko.task.Task;
import koko.task.TaskList;
import koko.ui.Ui;
import koko.storage.Storage;

/**
 * Represents a command that deletes a task from the task list.
 */
public class DeleteCommand extends Command {

    /** Index of the task to delete, provided as a string from user input. */
    private String taskIndex;

    /**
     * Creates a DeleteCommand with the specified task index.
     *
     * @param taskIndex Index of the task to delete.
     */
    public DeleteCommand(String taskIndex) {
        this.taskIndex = taskIndex;
    }

    /**
     * Deletes the specified task from the task list and displays a confirmation message.
     *
     * @param taskList Task list containing all current tasks.
     * @param ui User interface used for displaying messages to the user.
     * @param storage Storage used for saving task data.
     */
    @Override
    public void execute(TaskList taskList, Ui ui, Storage storage) {
        Task deletedTask = taskList.deleteTask(taskIndex);
        ui.showDeleteTask(deletedTask, taskList);
    }
}
