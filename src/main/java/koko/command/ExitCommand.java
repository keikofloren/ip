package koko.command;

import koko.storage.Storage;
import koko.task.TaskList;
import koko.ui.Ui;

/**
 * Represents a command that exits the application.
 */
public class ExitCommand extends Command {

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
        return ui.showExit();
    }

    /**
     * Returns whether this command should cause the application to exit.
     *
     * @return True since this command ends the program.
     */
    @Override
    public boolean isExit() {
        return true;
    }
}
