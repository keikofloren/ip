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
     * Unmarks the specified task and displays a confirmation message.
     *
     * @param taskList Task list containing all current tasks.
     * @param ui User interface used for displaying messages to the user.
     * @param storage Storage used for saving task data.
     */
    @Override
    public void execute(TaskList taskList, Ui ui, Storage storage) {
        Task unmarkedTask = taskList.unmarkTask(taskIndex);
        ui.showUnmarkTask(unmarkedTask);
    }
}
