package koko.command;

import koko.task.TaskList;
import koko.ui.Ui;
import koko.storage.Storage;

public class ListCommand extends Command {
    @Override
    public void execute(TaskList taskList, Ui ui, Storage storage) {
        taskList.listTasks();
    }
}
