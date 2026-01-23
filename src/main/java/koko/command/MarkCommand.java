package koko.command;

import koko.storage.Storage;
import koko.task.Task;
import koko.task.TaskList;
import koko.ui.Ui;

/**
 * Represents a command that marks a task as completed.
 */
public class MarkCommand extends Command {

    /** Index of the task to mark, provided as a string from user input. */
    private String taskIndex;

    /**
     * Creates a MarkCommand with the specified task index.
     *
     * @param taskIndex Index of the task to mark.
     */
    public MarkCommand(String taskIndex) {
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
        Task markedTask = taskList.markTask(this.taskIndex);
        return ui.showMarkTask(markedTask);
    }
}
