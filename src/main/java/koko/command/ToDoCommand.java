package koko.command;

import koko.task.ToDoTask;
import koko.task.TaskList;
import koko.ui.Ui;
import koko.storage.Storage;

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
     * Adds the to-do task into the task list and displays a confirmation message.
     *
     * @param taskList Task list containing all current tasks.
     * @param ui User interface used for displaying messages to the user.
     * @param storage Storage used for saving task data.
     */
    @Override
    public void execute(TaskList taskList, Ui ui, Storage storage) {
        taskList.addTask(this.task);
        ui.showAddTodoTask(this.task, taskList);
    }
}
