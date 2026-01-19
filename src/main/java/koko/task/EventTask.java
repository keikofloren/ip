package koko.task;

import koko.exception.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeParseException;
import java.time.format.DateTimeFormatter;

/**
 * Represents a task that takes place over a specific time period.
 */
public class EventTask extends Task {

    /** Start date and time of the event. */
    private LocalDateTime startTime;

    /** End date and time of the event. */
    private LocalDateTime endTime;

    /**
     * Creates an EventTask with the specified description, start time, and end time.
     *
     * @param description Description of the task.
     * @param startTime Start date and time in the format dd/MM/yyyy HHmm.
     * @param endTime End date and time in the format dd/MM/yyyy HHmm.
     * @throws InvalidCommandFormatException If the start time or end time is missing.
     * @throws WrongDateFormatException If the start time or end time cannot be parsed.
     */
    public EventTask(String description, String startTime, String endTime) {
        super(description);
        if (startTime == null || startTime.isBlank() || endTime == null || endTime.isBlank()) {
            throw new InvalidCommandFormatException(
                    "E-eh?! Your event has no time range...\n"
                            + "Please use: event <task> /from <dd/MM/yyyy HHmm> /to <dd/MM/yyyy HHmm>\n"
            );
        }
        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HHmm");
            this.startTime = LocalDateTime.parse(startTime, formatter);
            this.endTime = LocalDateTime.parse(endTime, formatter);
        } catch (DateTimeParseException e) {
            throw new WrongDateFormatException("Uwaaa! That date/time looks impossible...\n"
                    + "Please use dd/MM/yyyy HHmm!\n");
        }

    }

    /**
     * Returns the task formatted for display, including its start and end time.
     *
     * @return String representation of the event task.
     */
    @Override
    public String toString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HHmm");
        return "[E]" + super.toString()
                + " (from: " + startTime.format(formatter)
                + " to: " + endTime.format(formatter) + ")";
    }

    /**
     * Returns the task formatted for file storage.
     *
     * @return String representation of the task in storage format.
     */
    @Override
    public String getFileDescription() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HHmm");
        return super.getFileDescription()
                + " | from " + this.startTime.format(formatter)
                + " to " + this.endTime.format(formatter) ;
    }
}
