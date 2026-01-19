package koko.exception;

/**
 * Represents an exception thrown when a command is given in an invalid format.
 */
public class InvalidCommandFormatException extends KokoException {
    /**
     * Creates an InvalidCommandFormatException with the specified error message.
     *
     * @param message Error message describing the invalid command format.
     */
    public InvalidCommandFormatException(String message) {
        super(message);
    }
}
