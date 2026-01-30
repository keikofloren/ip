package koko.command;

import koko.storage.Storage;
import koko.task.Task;
import koko.task.TaskList;
import koko.ui.Ui;

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

    @Override
    public String execute(TaskList taskList, Ui ui, Storage storage) {
        Task deletedTask = taskList.deleteTask(taskIndex);
        return ui.showDeleteTask(deletedTask, taskList);
    }
}
