package koko.task;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

import koko.exception.*;
import koko.ui.Ui;

public class TaskListTest {

    @Test
    void getTask_validTaskIndex_returnsCorrectTask() throws KokoException {
        TaskList list = new TaskList();
        Task task1 = new ToDoTask("CS2103T ip");
        Task task2 = new ToDoTask("CS2103T tp");
        list.addTask(task1);
        list.addTask(task2);
        Task res = list.getTask("2");
        assertEquals(task2, res);
    }

    @Test
    void getTask_outOfRange_throwsInvalidCommandInputException() throws InvalidCommandInputException {
        Ui ui = new Ui();
        TaskList list = new TaskList();
        Task task = new ToDoTask("CS2103T");
        try {
            list.getTask("2");
            fail();
        } catch (InvalidCommandInputException e) {
            ui.showError(e.getMessage());
        }
    }

    @Test
    void getTask_nonNumberIndex_throwsInvalidCommandFormatException() throws InvalidCommandInputException {
        Ui ui = new Ui();
        TaskList list = new TaskList();
        Task task = new ToDoTask("CS2103T");
        try {
            list.getTask("abc");
            fail();
        } catch (InvalidCommandFormatException e) {
            ui.showError(e.getMessage());
        }
    }

    @Test
    void getTask_nullIndex_throwsInvalidCommandFormatException() throws InvalidCommandInputException {
        Ui ui = new Ui();
        TaskList list = new TaskList();
        Task task = new ToDoTask("CS2103T");
        try {
            list.getTask("");
            fail();
        } catch (InvalidCommandFormatException e) {
            ui.showError(e.getMessage());
        }
    }
}
