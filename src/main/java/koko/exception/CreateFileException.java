package koko.exception;

/**
 * Represents an exception thrown when the application fails to create a file.
 */
public class CreateFileException extends KokoException {
    /**
     * Creates a CreateFileException with the specified error message.
     *
     * @param message Error message describing the file creation failure.
     */
    public CreateFileException(String message) {
        super(message);
    }
}
