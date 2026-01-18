package koko.command;

import koko.task.ToDoTask;
import koko.task.TaskList;
import koko.ui.Ui;
import koko.storage.Storage;

public class ToDoCommand extends Command {

    private ToDoTask task;

    public ToDoCommand(ToDoTask task) {
        this.task = task;
    }

    @Override
    public void execute(TaskList taskList, Ui ui, Storage storage) {
        taskList.addTask(this.task);
        ui.showAddTodoTask(this.task, taskList);
    }
}
