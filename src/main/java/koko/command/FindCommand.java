package koko.command;

import koko.storage.Storage;
import koko.task.TaskList;
import koko.ui.Ui;

public class FindCommand extends Command {

    private String keyword;

    public FindCommand(String keyword) {
        this.keyword = keyword;
    }

    @Override
    public void execute(TaskList taskList, Ui ui, Storage storage) {
        taskList.findTask(keyword);
    }
}
