package koko.command;

import koko.exception.KokoException;
import koko.storage.Storage;
import koko.task.TaskList;
import koko.ui.Ui;

public abstract class Command {

    public abstract void execute(TaskList taskList, Ui ui, Storage storage) throws KokoException;

    public boolean isExit() {
        return false;
    }
}
