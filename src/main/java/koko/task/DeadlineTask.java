package koko.task;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

import koko.exception.InvalidCommandFormatException;
import koko.exception.KokoException;
import koko.exception.WrongDateFormatException;

public class DeadlineTask extends Task {

    private LocalDateTime deadline;

    public DeadlineTask(String description, String deadline) throws KokoException {
        super(description);
        if (deadline == null || deadline.isBlank()) {
            throw new InvalidCommandFormatException(
                    "Uwaaa! Your deadline task is missing the /by date…\n"
                            + "Please use: deadline <task> /by <dd/MM/yyyy HHmm>!\n"
            );
        }
        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HHmm");
            this.deadline = LocalDateTime.parse(deadline, formatter);
        } catch (DateTimeParseException e) {
            throw new WrongDateFormatException("Uwaaa! That date looks impossible…\n"
                    + "Please use: deadline dd/MM/yyyy HHmm!\n");
        }
    }

    @Override
    public String toString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d/M/yyyy HHmm");
        return "[D]" + super.toString() + " (by: " + this.deadline.format(formatter) + ")";
    }

    @Override
    public String getFileDescription() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d/M/yyyy HHmm");
        return super.getFileDescription() + " | by " + this.deadline.format(formatter);
    }
}
