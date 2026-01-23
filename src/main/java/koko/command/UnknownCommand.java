package koko.command;

import koko.storage.Storage;
import koko.task.TaskList;
import koko.ui.Ui;

/**
 * Represents a command used when the user's input does not match any known command.
 */
public class UnknownCommand extends Command {

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
        return ui.showCommandNotFound();
    }
}
