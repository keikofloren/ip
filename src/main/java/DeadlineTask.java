public class DeadlineTask extends Task {

    private String deadline;

    public DeadlineTask(String description, String deadline) throws InvalidCommandFormatException {
        super(description);
        if (deadline.isBlank()) {
            throw new InvalidCommandFormatException(
                    "OOPS!!! The deadline of a deadline task cannot be empty.\n"
            );
        }
        this.deadline = deadline;
    }

    @Override
    public String toString() {
        return "[D]" + super.toString() + " (by: " + this.deadline + ")";
    }

    @Override
    public String getFileDescription() {
        return super.getFileDescription() + " | by " + this.deadline;
    }
}
