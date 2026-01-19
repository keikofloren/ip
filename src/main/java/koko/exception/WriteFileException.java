package koko.exception;

/**
 * Represents an exception thrown when the application fails to write data to a file.
 */
public class WriteFileException extends KokoException {
    /**
     * Creates a WriteFileException with the specified error message.
     *
     * @param message Error message describing the file writing failure.
     */
    public WriteFileException(String message) {
        super(message);
    }
}
