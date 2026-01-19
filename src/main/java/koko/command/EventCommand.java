package koko.command;

import koko.storage.Storage;
import koko.task.EventTask;
import koko.task.TaskList;
import koko.ui.Ui;

public class EventCommand extends Command {

    private EventTask task;

    public EventCommand(EventTask task) {
        this.task = task;
    }

    @Override
    public void execute(TaskList taskList, Ui ui, Storage storage) {
        taskList.addTask(this.task);
        ui.showAddEventTask(this.task, taskList);
    }
}
