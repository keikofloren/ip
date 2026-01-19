package koko.task;

/**
 * Represents a to-do task that has only a description.
 */
public class ToDoTask extends Task {

    /**
     * Creates a ToDoTask with the specified description.
     *
     * @param description Description of the task.
     */
    public ToDoTask(String description) {
        super(description);
    }

    /**
     * Returns the task formatted for display as a to-do task.
     *
     * @return String representation of the to-do task.
     */
    @Override
    public String toString() {
        return "[T]" + super.toString();
    }
}
