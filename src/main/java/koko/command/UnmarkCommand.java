package koko.command;

import koko.storage.Storage;
import koko.task.Task;
import koko.task.TaskList;
import koko.ui.Ui;

/**
 * Represents a command that marks a task as not completed.
 */
public class UnmarkCommand extends Command {

    /** Index of the task to unmark, provided as a string from user input. */
    private String taskIndex;

    /**
     * Creates an UnmarkCommand with the specified task index.
     *
     * @param taskIndex Index of the task to unmark.
     */
    public UnmarkCommand(String taskIndex) {
        this.taskIndex = taskIndex;
    }

    /**
     * Executes the command using the provided task list, user interface, and storage.
     *
     * @param taskList Task list containing all current tasks.
     * @param ui User interface used for displaying messages to the user.
     * @param storage Storage used for loading and saving task data.
     * @return A response message to be shown to the user.
     */
    @Override
    public String execute(TaskList taskList, Ui ui, Storage storage) {
        Task unmarkedTask = taskList.unmarkTask(taskIndex);
        return ui.showUnmarkTask(unmarkedTask);
    }
}
