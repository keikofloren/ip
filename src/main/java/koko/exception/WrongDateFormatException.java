package koko.exception;

/**
 * Represents an exception thrown when a date or time is given in an invalid format.
 */
public class WrongDateFormatException extends KokoException {
    /**
     * Creates a WrongDateFormatException with the specified error message.
     *
     * @param message Error message describing the invalid date format.
     */
    public WrongDateFormatException(String message) {
        super(message);
    }
}
