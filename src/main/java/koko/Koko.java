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

    /** Task list used to store tasks in memory. */
    private TaskList taskList;

    /** User interface used for reading input and displaying output. */
    private Ui ui;

    /** Storage used for loading and saving tasks. */
    private Storage storage;

    /** Parser used for converting user input into commands. */
    private Parser parser;

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

    /**
     * Runs the main command loop of the application until an exit command is received.
     */
    public void run() {
        ui.showWelcome();
        boolean isExit = false;
        while (!isExit) {
            try {
                String fullCommand = ui.readCommand();
                Command c = parser.parse(fullCommand);
                c.execute(taskList, ui, storage);
                storage.update(taskList);
                isExit = c.isExit();
            } catch (KokoException e) {
                ui.showError(e.getMessage());
            }
        }
    }

    /**
     * Starts the application using the default storage file path.
     *
     * @param args Command-line arguments, which are not used.
     */
    public static void main(String[] args) {
        new Koko("data/tasks.txt").run();
    }
}
