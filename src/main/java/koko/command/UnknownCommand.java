package koko.command;

import koko.storage.Storage;
import koko.task.TaskList;
import koko.ui.Ui;

public class UnknownCommand extends Command {
    @Override
    public void execute(TaskList taskList, Ui ui, Storage storage) {
        ui.showCommandNotFound();
    }
}
