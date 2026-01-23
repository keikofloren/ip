package koko.command;

import koko.storage.Storage;
import koko.task.TaskList;
import koko.ui.Ui;

/**
 * Represents a command that exits the application.
 */
public class ExitCommand extends Command {

    /**
     * Displays the exit message to the user.
     *
     * @param taskList Task list containing all current tasks.
     * @param ui User interface used for displaying messages to the user.
     * @param storage Storage used for saving task data.
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
