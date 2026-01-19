package koko.task;

import koko.exception.InvalidCommandFormatException;

/**
 * Represents a generic task with a description and completion status.
 */
public class Task {

    /** Description of the task. */
    private String description;

    /** Whether the task has been marked as completed. */
    private boolean isDone;

    /**
     * Creates a Task with the specified description.
     *
     * @param description Description of the task.
     * @throws InvalidCommandFormatException If the description is empty.
     */
    public Task(String description) throws InvalidCommandFormatException {
        if (description == null || description.isBlank()) {
            throw new InvalidCommandFormatException(
                    "Nani?! You can't give me an empty task! I need... a description!!\n"
            );
        }
        this.description = description;
        this.isDone = false;
    }

    /**
     * Returns the task formatted for display, including its completion status.
     *
     * @return String representation of the task.
     */
    @Override
    public String toString() {
        return "["
                + (this.isDone ? "X" : " ")
                + "] "
                + this.description;
    }

    /**
     * Returns the description of the task.
     *
     * @return Description of the task.
     */
    public String getDescription() {
        return this.description;
    }

    /**
     * Returns the task formatted for file storage.
     *
     * @return String representation of the task in storage format.
     */
    public String getFileDescription() {
        return this.description;
    }

    /**
     * Marks the task as completed.
     *
     * @return The current Task instance.
     */
    public Task mark() {
        this.isDone = true;
        return this;
    }

    /**
     * Marks the task as not completed.
     *
     * @return The current Task instance.
     */
    public Task unmark() {
        this.isDone = false;
        return this;
    }

    /**
     * Returns whether the task has been marked as completed.
     *
     * @return True if the task is done, false otherwise.
     */
    public boolean isDone() {
        return this.isDone;
    }
}
