package koko.command;

import koko.storage.Storage;
import koko.task.TaskList;
import koko.ui.Ui;

/**
 * Represents a command that displays all tasks in the task list.
 */
public class ListCommand extends Command {

    /**
     * Displays the tasks currently stored in the task list.
     *
     * @param taskList Task list containing all current tasks.
     * @param ui User interface used for displaying messages to the user.
     * @param storage Storage used for saving task data.
     */
    @Override
    public void execute(TaskList taskList, Ui ui, Storage storage) {
        taskList.listTasks();
    }
}
