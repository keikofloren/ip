package koko.task;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

import koko.exception.*;
import koko.ui.Ui;

public class DeadlineTaskTest {

    @Test
    void instantiateTask_validDateTime_createsTask() throws KokoException {
        String description = "CS2103T";
        String deadline = "23/01/2026 2359";
        Task t1 = new DeadlineTask(description, deadline);
        assertEquals("[D][ ] CS2103T (by: 23/1/2026 2359)", t1.toString());
    }

    @Test
    void instantiateTask_nullDateTime_throws_InvalidCommandFormatException() throws InvalidCommandFormatException {
        Ui ui = new Ui();
        try {
            String description = "CS2103T";
            String deadline = "";
            Task t1 = new DeadlineTask(description, deadline);
            fail();
        } catch (InvalidCommandFormatException e) {
            ui.showError(e.getMessage());
        }
    }

    @Test
    void instantiateTask_invalidDateTime_throws_WrongDateFormatException() throws WrongDateFormatException {
        Ui ui = new Ui();
        try {
            String description = "CS2103T";
            String deadline = "23 Jan 12am";
            Task t1 = new DeadlineTask(description, deadline);
            fail();
        } catch (WrongDateFormatException e) {
            ui.showError(e.getMessage());
        }
    }
}
