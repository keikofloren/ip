package koko.task;

import koko.exception.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeParseException;
import java.time.format.DateTimeFormatter;

public class EventTask extends Task {

    private LocalDateTime startTime;
    private LocalDateTime endTime;

    public EventTask(String description, String startTime, String endTime) {
        super(description);
        if (startTime == null || startTime.isBlank() || endTime == null || endTime.isBlank()) {
            throw new InvalidCommandFormatException(
                    "E-eh?! Your event has no time range… (＠_＠;)\n"
                            + "Please use: event <task> /from <dd/MM/yyyy HHmm> /to <dd/MM/yyyy HHmm>\n"
            );
        }
        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HHmm");
            this.startTime = LocalDateTime.parse(startTime, formatter);
            this.endTime = LocalDateTime.parse(endTime, formatter);
        } catch (DateTimeParseException e) {
            throw new WrongDateFormatException("Uwaaa! That date/time looks impossible… (＠_＠;)\n"
                    + "Please use dd/MM/yyyy HHmm!\n");
        }

    }

    @Override
    public String toString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HHmm");
        return "[E]" + super.toString()
                + " (from: " + startTime.format(formatter)
                + " to: " + endTime.format(formatter) + ")";
    }

    @Override
    public String getFileDescription() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HHmm");
        return super.getFileDescription()
                + " | from " + this.startTime.format(formatter)
                + " to " + this.endTime.format(formatter) ;
    }
}
