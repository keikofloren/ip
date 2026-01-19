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
import koko.command.UnmarkCommand;
import koko.command.UnknownCommand;
import koko.exception.InvalidCommandFormatException;
import koko.task.DeadlineTask;
import koko.task.EventTask;
import koko.task.ToDoTask;

public class Parser {

    public Command parse(String fullCommand) {
        String[] parsedInput = parseInput(fullCommand);
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

    private String[] parseInput(String fullCommand) {
        String[] inputArray = fullCommand.split(" ", 2);
        String command = inputArray[0].toUpperCase();
        String arg = (inputArray.length == 2) ? inputArray[1] : "";
        return new String[]{command, arg};
    }

    private Command handleBye() {
        return new ExitCommand();
    }

    private Command handleToDo(String arg) {
        ToDoTask task = new ToDoTask(arg);
        return new ToDoCommand(task);
    }

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

    private Command handleList() {
        return new ListCommand();
    }

    private Command handleMark(String arg) {
        return new MarkCommand(arg);
    }

    private Command handleUnmark(String arg) {
        return new UnmarkCommand(arg);
    }

    private Command handleDelete(String arg) {
        return new DeleteCommand(arg);
    }

    private Command handleFind(String arg) {
        return new FindCommand(arg);
    }

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
