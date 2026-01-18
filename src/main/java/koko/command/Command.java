package koko.command;

import koko.task.TaskList;
import koko.ui.Ui;
import koko.storage.Storage;
import koko.exception.KokoException;

public abstract class Command {

    public abstract void execute(TaskList taskList, Ui ui, Storage storage) throws KokoException;

    public boolean isExit() {
        return false;
    }
}
