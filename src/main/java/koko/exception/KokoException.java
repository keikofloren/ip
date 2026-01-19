package koko.exception;

/**
 * Represents the base exception type for errors that occur in the Koko application.
 */
public class KokoException extends RuntimeException {
    /**
     * Creates a KokoException with the specified error message.
     *
     * @param message Error message describing the cause of the exception.
     */
    public KokoException(String message) {
        super(message);
    }
}
