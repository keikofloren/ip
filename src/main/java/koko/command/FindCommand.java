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

    @Override
    public String execute(TaskList taskList, Ui ui, Storage storage) {
        return taskList.findTask(keyword);
    }
}
