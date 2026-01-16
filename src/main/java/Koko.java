import java.util.Scanner;

public class Koko {

    private static TaskList taskList;

    enum CommandType {
        BYE,
        TODO,
        DEADLINE,
        EVENT,
        LIST,
        MARK,
        UNMARK,
        DELETE
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        taskList = new TaskList();
        System.out.println(
                "Hello! I'm Koko\n"
                        + "What can I do for you?\n"
        );
        handleInput(sc);
    }

    private static void handleInput(Scanner sc) {
        while (true) {
            try {
                String input = sc.nextLine();
                String[] parsedInput = parseInput(input);
                CommandType commandType = parseCommand(parsedInput[0]);
                String arg = parsedInput[1];
                switch (commandType) {
                    case BYE:
                        HandleBye();
                        return;
                    case TODO:
                        HandleToDo(arg);
                        break;
                    case DEADLINE:
                        HandleDeadline(arg);
                        break;
                    case EVENT:
                        HandleEvent(arg);
                        break;
                    case LIST:
                        HandleList();
                        break;
                    case MARK:
                        HandleMark(arg);
                        break;
                    case UNMARK:
                        HandleUnmark(arg);
                        break;
                    case DELETE:
                        HandleDelete(arg);
                        break;
                }
            } catch (KokoException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private static String[] parseInput(String input) {
        String[] inputArray = input.split(" ", 2);
        String command = inputArray[0].toUpperCase();
        String arg = (inputArray.length == 2) ? inputArray[1] : "";
        return new String[]{command, arg};
    }

    private static CommandType parseCommand(String command) throws CommandNotFoundException {
        for (CommandType type : CommandType.values()) {
            if (type.name().equals(command)) {
                return type;
            }
        }
        throw new CommandNotFoundException(
                "OOPS!!! I'm sorry, but I don't know what that means :-(\n"
        );
    }

    private static void HandleBye() {
        System.out.println("Bye. Hope to see you again soon!\n");
    }

    private static void HandleToDo(String arg) throws InvalidCommandFormatException {
        ToDoTask task = new ToDoTask(arg);
        taskList.addTask(task);
        System.out.println(
                "Got it. I've added this task:\n"
                        + task + "\n"
                        + "Now you have " + taskList.numberOfTasks() + " tasks in the list.\n"
        );
    }

    private static void HandleDeadline(String arg) throws InvalidCommandFormatException {
        if (arg == null || !arg.contains (" /by ")) {
            throw new InvalidCommandFormatException(
                    "OOPS!!! Please use: deadline <desc> /by <deadline>.\n"
            );
        }
        String[] argArray = arg.split(" /by ");
        String taskDescription = argArray[0];
        String deadline = argArray[1];
        DeadlineTask task = new DeadlineTask(taskDescription, deadline);
        taskList.addTask(task);
        System.out.println(
                "Got it. I've added this task:\n"
                        + task + "\n"
                        + "Now you have " + taskList.numberOfTasks() + " tasks in the list.\n"
        );
    }

    private static void HandleEvent(String arg) throws InvalidCommandFormatException {
        if (arg == null || !arg.contains(" /from ") || !arg.contains(" /to ")) {
            throw new InvalidCommandFormatException(
                    "OOPS!!! Please use: event <desc> /from <start> to <end>.\n"
            );
        }
        String[] argArray =  arg.split(" /from ");
        String taskDescription = argArray[0];
        String[] argArray2 = argArray[1].split(" /to ");
        String startTime = argArray2[0];
        String endTime = argArray2[1];
        EventTask task = new EventTask(taskDescription, startTime, endTime);
        taskList.addTask(task);
        System.out.println(
                "Got it. I've added this task:\n"
                        + task + "\n"
                        + "Now you have " + taskList.numberOfTasks() + " tasks in the list.\n"
        );
    }

    private static void HandleList() {
        taskList.listTasks();
    }

    private static void HandleMark(String arg) throws InvalidCommandFormatException{
        if (arg == null || arg.isBlank()) {
            throw new InvalidCommandFormatException(
                    "OOPS!!! Please use: mark <task index>.\n"
            );
        }
        int taskIndex = Integer.parseInt(arg);
        Task markedTask = taskList.markTask(taskIndex);
        System.out.println(
                "Nice! I've marked this task as done:\n"
                        + markedTask.toString() + "\n"
        );
    }

    private static void HandleUnmark(String arg) throws InvalidCommandFormatException {
        if (arg == null || arg.isBlank()) {
            throw new InvalidCommandFormatException(
                    "OOPS!!! Please use: unmark <task index>.\n"
            );
        }
        int taskIndex = Integer.parseInt(arg);
        Task unmarkedTask = taskList.unmarkTask(taskIndex);
        System.out.println(
                "OK, I've marked this task as not done yet:\n"
                        + unmarkedTask.toString() + "\n"
        );
    }

    private static void HandleDelete(String arg) throws InvalidCommandFormatException {
        if (arg == null || arg.isBlank()) {
            throw new InvalidCommandFormatException(
                    "OOPS!!! Please use: delete <task index>.\n"
            );
        }
        int taskIndex = Integer.parseInt(arg);
        Task deletedTask = taskList.deleteTask(taskIndex);
        System.out.println(
                "Noted. I've removed this task:\n"
                        + deletedTask + "\n"
                        + "Now you have " + taskList.numberOfTasks() + " tasks in the list.\n"
        );
    }
}
