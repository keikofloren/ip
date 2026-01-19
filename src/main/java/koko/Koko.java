package koko;

import koko.command.Command;
import koko.exception.KokoException;
import koko.parser.Parser;
import koko.storage.Storage;
import koko.task.TaskList;
import koko.ui.Ui;

public class Koko {

    private TaskList taskList;
    private Ui ui;
    private Storage storage;
    private Parser parser;

    public Koko(String filePath) {
        this.ui = new Ui();
        this.storage = new Storage(filePath);
        this.parser = new Parser();
        try {
            this.taskList = new TaskList(this.storage.load());
        } catch (KokoException e) {
            this.ui.showLoadingError();
            this.taskList = new TaskList();
        }
    }

    public static void main(String[] args) {
        new Koko("data/tasks.txt").run();
    }

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
}
