package koko.command;

import koko.storage.Storage;
import koko.task.DeadlineTask;
import koko.task.TaskList;
import koko.ui.Ui;

/**
 * Represents a command that adds a deadline task to the task list.
 */
public class DeadlineCommand extends Command {

    /** Deadline task to be added to the task list. */
    private DeadlineTask task;

    /**
     * Creates a DeadlineCommand with the specified deadline task.
     *
     * @param task Deadline task to be added.
     */
    public DeadlineCommand(DeadlineTask task) {
        this.task = task;
    }

    /**
     * Adds the deadline task into the task list and displays a confirmation message.
     *
     * @param taskList Task list containing all current tasks.
     * @param ui User interface used for displaying messages to the user.
     * @param storage Storage used for loading and saving task data.
     */
    @Override
    public String execute(TaskList taskList, Ui ui, Storage storage) {
        taskList.addTask(this.task);
        return ui.showAddDeadlineTask(this.task, taskList);
    }
}
