package koko.command;

import koko.storage.Storage;
import koko.task.TaskList;
import koko.ui.Ui;

public class ListCommand extends Command {
    @Override
    public void execute(TaskList taskList, Ui ui, Storage storage) {
        taskList.listTasks();
    }
}
