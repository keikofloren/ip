import java.util.Scanner;

public class Koko {

    private TaskList taskList;
    private Ui ui;
    private Storage storage;
    private Parser parser;

    public Koko(String filePath) {
        this.ui = new Ui();
        this.storage = new Storage(filePath);
        try {
            //this.taskList = new TaskList(this.storage.load());
            this.taskList = new TaskList();
            this.parser = new Parser(this.taskList);
        } catch (KokoException e) {
            this.ui.showLoadingError();
            this.taskList = new TaskList();
        }
    }

    public void run() {
        ui.showWelcome();
        boolean isExit = false;
        while (!isExit) {
            try {
                String fullCommand = ui.readCommand();
                Command c = parser.parse(fullCommand);
                c.execute(taskList, ui, storage);
                isExit = c.isExit();
            } catch (KokoException e) {
                ui.showError(e.getMessage());
            }
        }
    }

    public static void main(String[] args) {
        new Koko("data/tasks.txt").run();
    }
}
