package koko;

import koko.command.Command;
import koko.exception.KokoException;
import koko.parser.Parser;
import koko.storage.Storage;
import koko.task.TaskList;
import koko.ui.Ui;

/**
 * Represents the main entry point of the Koko task manager application.
 * This class initialises the core components and runs the command loop.
 */
public class Koko {

    /**
     * Task list used to store tasks in memory.
     */
    private TaskList taskList;

    /**
     * User interface used for reading input and displaying output.
     */
    private Ui ui;

    /**
     * Storage used for loading and saving tasks.
     */
    private Storage storage;

    /**
     * Parser used for converting user input into commands.
     */
    private Parser parser;

    private boolean isExit;

    /**
     * Creates a Koko instance that loads tasks from the specified file path.
     *
     * @param filePath File path used for saving and loading tasks.
     */
    public Koko(String filePath) {
        this.ui = new Ui();
        this.storage = new Storage(filePath);
        this.parser = new Parser();
        try {
            this.taskList = new TaskList(this.storage.load());
        } catch (KokoException e) {
            this.ui.showError(e.getMessage());
            this.taskList = new TaskList();
        }
    }

    public String showWelcome() {
        return ui.showWelcome();
    }

    public boolean isExit() {
        return isExit;
    }

    /**
     * Generates a response for the user's chat message.
     */
    public String getResponse(String input) throws KokoException {
        try {
            Command c = parser.parse(input);
            String response = c.execute(taskList, ui, storage);
            storage.update(taskList);
            if (c.isExit()) {
                isExit = true;
            }
            return response;
        } catch (KokoException e) {
            return ui.showError(e.getMessage());
        }
    }
}
