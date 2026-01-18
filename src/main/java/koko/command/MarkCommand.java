package koko.command;

import koko.task.Task;
import koko.task.TaskList;
import koko.ui.Ui;
import koko.storage.Storage;

public class MarkCommand extends Command {

    private String taskIndex;

    public MarkCommand(String taskIndex) {
        this.taskIndex = taskIndex;
    }

    @Override
    public void execute(TaskList taskList, Ui ui, Storage storage) {
        Task markedTask = taskList.markTask(this.taskIndex);
        ui.showMarkTask(markedTask);
    }
}
