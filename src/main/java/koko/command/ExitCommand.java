package koko.command;

import koko.task.TaskList;
import koko.ui.Ui;
import koko.storage.Storage;

public class ExitCommand extends Command {

    @Override
    public void execute(TaskList taskList, Ui ui, Storage storage) {
        ui.showExit();
    }

    @Override
    public boolean isExit() {
        return true;
    }
}
