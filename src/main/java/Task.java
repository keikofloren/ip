public class Task {

    private String description;
    private boolean isDone;

    public Task(String description) throws InvalidCommandFormatException {
        if (description == null || description.isBlank()) {
            throw new InvalidCommandFormatException(
                    "OOPS!!! The description of a task cannot be empty.\n"
            );
        }
        this.description = description;
        this.isDone = false;
    }

    @Override
    public String toString() {
        return "["
                + (this.isDone ? "X" : " ")
                + "] "
                + this.description;
    }

    public Task mark() {
        this.isDone = true;
        return this;
    }

    public Task unmark() {
        this.isDone = false;
        return this;
    }
}
