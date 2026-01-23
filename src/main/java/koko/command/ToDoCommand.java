package koko.command;

import koko.storage.Storage;
import koko.task.TaskList;
import koko.task.ToDoTask;
import koko.ui.Ui;

/**
 * Represents a command that adds a to-do task to the task list.
 */
public class ToDoCommand extends Command {

    /** To-do task to be added to the task list. */
    private ToDoTask task;

    /**
     * Creates a ToDoCommand with the specified to-do task.
     *
     * @param task To-do task to be added.
     */
    public ToDoCommand(ToDoTask task) {
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
        return ui.showAddTodoTask(this.task, taskList);
    }
}
