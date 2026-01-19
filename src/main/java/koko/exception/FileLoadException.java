package koko.exception;

/**
 * Represents an exception thrown when the application fails to load data from a file.
 */
public class FileLoadException extends KokoException {
    /**
     * Creates a FileLoadException with the specified error message.
     *
     * @param message Error message describing the file loading failure.
     */
    public FileLoadException(String message) {
        super(message);
    }
}
