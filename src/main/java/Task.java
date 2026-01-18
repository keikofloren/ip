public class Task {

    private String description;
    private boolean isDone;

    public Task(String description) throws InvalidCommandFormatException {
        if (description == null || description.isBlank()) {
            throw new InvalidCommandFormatException(
                    "Nani?! You can't give me an empty task! I need... a description!! (╥﹏╥)\n"
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

    public String getFileDescription() {
        return this.description;
    }

    public Task mark() {
        this.isDone = true;
        return this;
    }

    public Task unmark() {
        this.isDone = false;
        return this;
    }

    public boolean isDone() {
        return this.isDone;
    }
}
