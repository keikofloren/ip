package koko.exception;

/**
 * Represents an exception thrown when a command contains invalid user input.
 */
public class InvalidCommandInputException extends KokoException {
    /**
     * Creates an InvalidCommandInputException with the specified error message.
     *
     * @param message Error message describing the invalid command input.
     */
    public InvalidCommandInputException(String message) {
        super(message);
    }
}
