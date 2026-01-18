public class EventTask extends Task {

    private String startTime;
    private String endTime;

    public EventTask(String description, String startTime, String endTime) {
        super(description);
        if (startTime.isBlank() || endTime.isBlank()) {
            throw new InvalidCommandFormatException(
                    "OOPS!!! The start/end time of an event task cannot be empty.\n"
            );
        }
        this.startTime = startTime;
        this.endTime = endTime;
    }

    @Override
    public String toString() {
        return "[E]" + super.toString() + " (from: " + startTime + " to: " + endTime + ")";
    }

    @Override
    public String getFileDescription() {
        return super.getFileDescription() + " | from " + this.startTime + " to " + this.endTime;
    }
}
