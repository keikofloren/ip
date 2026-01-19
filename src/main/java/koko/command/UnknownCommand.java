package koko.command;

import koko.task.TaskList;
import koko.ui.Ui;
import koko.storage.Storage;

/**
 * Represents a command used when the user's input does not match any known command.
 */
public class UnknownCommand extends Command {

    /**
     * Displays an error message indicating that the command is not recognised.
     *
     * @param taskList Task list containing all current tasks.
     * @param ui User interface used for displaying messages to the user.
     * @param storage Storage used for saving task data.
     */
    @Override
    public void execute(TaskList taskList, Ui ui, Storage storage) {
        ui.showCommandNotFound();
    }
}
