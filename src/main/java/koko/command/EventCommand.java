package koko.command;

import koko.storage.Storage;
import koko.task.EventTask;
import koko.task.TaskList;
import koko.ui.Ui;

/**
 * Represents a command that adds an event task to the task list.
 */
public class EventCommand extends Command {

    /** Event task to be added to the task list. */
    private EventTask task;

    /**
     * Creates an EventCommand with the specified event task.
     *
     * @param task Event task to be added.
     */
    public EventCommand(EventTask task) {
        this.task = task;
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
        taskList.addTask(this.task);
        return ui.showAddEventTask(this.task, taskList);
    }
}
