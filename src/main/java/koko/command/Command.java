package koko.command;

import koko.task.TaskList;
import koko.ui.Ui;
import koko.storage.Storage;
import koko.exception.KokoException;

/**
 * Represents an executable command in the Koko task manager application.
 * Each command performs an action that may modify the task list and interact with the user.
 */
public abstract class Command {

    /**
     * Executes the command using the provided task list, user interface, and storage.
     *
     * @param taskList Task list containing all current tasks.
     * @param ui User interface used for displaying messages to the user.
     * @param storage Storage used for loading and saving task data.
     * @throws KokoException If an error occurs while executing the command.
     */
    public abstract void execute(TaskList taskList, Ui ui, Storage storage) throws KokoException;

    /**
     * Returns whether this command should cause the application to exit.
     *
     * @return True if this command ends the program, false otherwise.
     */
    public boolean isExit() {
        return false;
    }
}
