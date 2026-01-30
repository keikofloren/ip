package koko.parser;

import koko.command.Command;
import koko.command.DeadlineCommand;
import koko.command.DeleteCommand;
import koko.command.EventCommand;
import koko.command.ExitCommand;
import koko.command.FindCommand;
import koko.command.ListCommand;
import koko.command.MarkCommand;
import koko.command.ToDoCommand;
import koko.command.UnknownCommand;
import koko.command.UnmarkCommand;
import koko.exception.InvalidCommandFormatException;
import koko.task.DeadlineTask;
import koko.task.EventTask;
import koko.task.ToDoTask;


/**
 * Parses user input into commands executable by the application.
 */
public class Parser {

    /**
     * Returns a command based on the user's full input string.
     *
     * @param fullCommand Full input entered by the user.
     * @return A Command representing the user's request.
     */
    public Command parse(String fullCommand) {
        String[] parsedInput = parseInput(fullCommand);
        // Default to UNKNOWN so invalid commands can be handled without crashing.
        CommandType commandType = CommandType.UNKNOWN;
        for (CommandType type : CommandType.values()) {
            if (type.name().equals(parsedInput[0])) {
                commandType = type;
            }
        }
        String arg = parsedInput[1];
        switch (commandType) {
        case BYE: return handleBye();
        case TODO: return handleToDo(arg);
        case DEADLINE: return handleDeadline(arg);
        case EVENT: return handleEvent(arg);
        case LIST: return handleList();
        case MARK: return handleMark(arg);
        case UNMARK: return handleUnmark(arg);
        case DELETE: return handleDelete(arg);
        case FIND: return handleFind(arg);
        default: return new UnknownCommand();
        }
    }

    /**
     * Returns the command word and argument extracted from the full input.
     *
     * @param fullCommand Full input entered by the user.
     * @return A 2-element array containing the command word and argument.
     */
    private String[] parseInput(String fullCommand) {
        String[] inputArray = fullCommand.split(" ", 2);
        String command = inputArray[0].toUpperCase();
        String arg = (inputArray.length == 2) ? inputArray[1] : "";
        return new String[]{command, arg};
    }

    /**
     * Returns the command that exits the application.
     *
     * @return An ExitCommand.
     */
    private Command handleBye() {
        return new ExitCommand();
    }

    /**
     * Returns a to-do command created from the given argument string.
     *
     * @param arg Description of the to-do task.
     * @return A ToDoCommand containing a ToDoTask.
     */
    private Command handleToDo(String arg) {
        ToDoTask task = new ToDoTask(arg);
        return new ToDoCommand(task);
    }

    /**
     * Returns a deadline command created from the given argument string.
     *
     * @param arg Argument string containing task description and deadline.
     * @return A DeadlineCommand containing a DeadlineTask.
     * @throws InvalidCommandFormatException If the deadline format is invalid.
     */
    private Command handleDeadline(String arg) {
        if (arg == null || !arg.contains(" /by ")) {
            throw new InvalidCommandFormatException(
                    "Hold it! Deadline magic requires: deadline <task> /by <dd/MM/yyyy HHmm>\n"
            );
        }
        String[] argArray = arg.split(" /by ");
        String taskDescription = argArray[0];
        String deadline = argArray[1];
        DeadlineTask task = new DeadlineTask(taskDescription, deadline);
        return new DeadlineCommand(task);
    }

    /**
     * Returns an event command created from the given argument string.
     *
     * @param arg Argument string containing task description and event duration.
     * @return An EventCommand containing an EventTask.
     * @throws InvalidCommandFormatException If the event format is invalid.
     */
    private Command handleEvent(String arg) {
        if (arg == null || !arg.contains(" /from ") || !arg.contains(" /to ")) {
            throw new InvalidCommandFormatException(
                    "Wait wait! Event summoning ritual is: event <task> /from <dd/MM/yyyy HHmm> /to <dd/MM/yyyy HHmm>\n"
            );
        }
        String[] argArray = arg.split(" /from ");
        String taskDescription = argArray[0];
        String[] argArray2 = argArray[1].split(" /to ");
        String startTime = argArray2[0];
        String endTime = argArray2[1];
        EventTask task = new EventTask(taskDescription, startTime, endTime);
        return new EventCommand(task);
    }

    /**
     * Returns the command that lists all tasks.
     *
     * @return A ListCommand.
     */
    private Command handleList() {
        return new ListCommand();
    }

    /**
     * Returns the command that marks a task as completed.
     *
     * @param arg Index of the task to mark.
     * @return A MarkCommand.
     */
    private Command handleMark(String arg) {
        return new MarkCommand(arg);
    }

    /**
     * Returns the command that unmarks a task as not completed.
     *
     * @param arg Index of the task to unmark.
     * @return An UnmarkCommand.
     */
    private Command handleUnmark(String arg) {
        return new UnmarkCommand(arg);
    }

    /**
     * Returns the command that deletes a task.
     *
     * @param arg Index of the task to delete.
     * @return A DeleteCommand.
     */
    private Command handleDelete(String arg) {
        return new DeleteCommand(arg);
    }

    /**
     * Returns the command that searches tasks by keyword.
     *
     * @param arg Keyword used to filter tasks.
     * @return A FindCommand.
     */
    private Command handleFind(String arg) {
        return new FindCommand(arg);
    }

    /**
     * Represents supported command keywords.
     */
    enum CommandType {
        BYE,
        TODO,
        DEADLINE,
        EVENT,
        LIST,
        MARK,
        UNMARK,
        DELETE,
        FIND,
        UNKNOWN
    }
}
