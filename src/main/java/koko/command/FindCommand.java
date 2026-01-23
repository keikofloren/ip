package koko.command;

import koko.storage.Storage;
import koko.task.TaskList;
import koko.ui.Ui;

/**
 * Represents a command that searches for tasks containing a given keyword.
 */
public class FindCommand extends Command {

    /** Keyword used to filter tasks in the task list. */
    private String keyword;

    /**
     * Creates a FindCommand with the specified keyword.
     *
     * @param keyword Keyword to search for in task descriptions.
     */
    public FindCommand(String keyword) {
        this.keyword = keyword;
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
        return taskList.findTask(keyword);
    }
}
