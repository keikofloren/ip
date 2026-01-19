package koko.exception;

/**
 * Represents an exception thrown when the user enters an unknown command.
 */
public class CommandNotFoundException extends KokoException {

    /**
     * Creates a CommandNotFoundException with the specified error message.
     *
     * @param message Error message describing the invalid command.
     */
    public CommandNotFoundException(String message) { super(message); }
}
