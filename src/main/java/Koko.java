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
                "Konnichiwa!! I’m Koko (≧▽≦)\n"
                        + "What can I do for you today senpai? ( •̀ᴗ•́ )و\n"
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
                "E-eh?! I don't understand that command... (；ω；)\n"
        );
    }

    private static void HandleBye() {
        System.out.println("Ja ne~! Don’t forget your quests, okay? (｡•̀ᴗ•́｡)\n");
    }

    private static void HandleToDo(String arg) throws InvalidCommandFormatException {
        ToDoTask task = new ToDoTask(arg);
        taskList.addTask(task);
        System.out.println(
                "Hai!! Mission accepted! (ง •̀_•́)ง\n"
                        + task + "\n"
                        + "Now you have " + taskList.numberOfTasks() + " tasks in the list!\n"
        );
    }

    private static void HandleDeadline(String arg) throws InvalidCommandFormatException {
        if (arg == null || !arg.contains (" /by ")) {
            throw new InvalidCommandFormatException(
                    "Hold it! Deadline magic requires: deadline <desc> /by <deadline> ( •̀д•́ )\n"
            );
        }
        String[] argArray = arg.split(" /by ");
        String taskDescription = argArray[0];
        String deadline = argArray[1];
        DeadlineTask task = new DeadlineTask(taskDescription, deadline);
        taskList.addTask(task);
        System.out.println(
                "Understood. I'll keep an eye on the clock. ( •̀ᴗ•́ )ゞ\n"
                        + task + "\n"
                        + "Now you have " + taskList.numberOfTasks() + " tasks in the list!\n"
        );
    }

    private static void HandleEvent(String arg) throws InvalidCommandFormatException {
        if (arg == null || !arg.contains(" /from ") || !arg.contains(" /to ")) {
            throw new InvalidCommandFormatException(
                    "Wait wait! Event summoning ritual is: event <desc> /from <start> /to <end> (；ﾟДﾟ)\n"
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
                "Ooh, a schedule arc begins. (☆_☆)\n"
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
                    "Oi, which task?! (＞﹏＜)\n"
                            + "Please use: mark <task index>!\n"
            );
        }
        int taskIndex = Integer.parseInt(arg);
        Task markedTask = taskList.markTask(taskIndex);
        System.out.println(
                "Sugoi. Task complete! (≧▽≦)\n"
                        + markedTask.toString() + "\n"
        );
    }

    private static void HandleUnmark(String arg) throws InvalidCommandFormatException {
        if (arg == null || arg.isBlank()) {
            throw new InvalidCommandFormatException(
                    "Ehh?! Which one do I undo?! (＠_＠;)\n"
                            + "Please use: mark <task index>!\n"
            );
        }
        int taskIndex = Integer.parseInt(arg);
        Task unmarkedTask = taskList.unmarkTask(taskIndex);
        System.out.println(
                "O-okay… back to unfinished mode. (；﹏；)\n"
                        + unmarkedTask.toString() + "\n"
        );
    }

    private static void HandleDelete(String arg) throws InvalidCommandFormatException {
        if (arg == null || arg.isBlank()) {
            throw new InvalidCommandFormatException(
                    "W-wait! Delete WHICH one?! (；ﾟДﾟ)\n"
                            + "Please use: delete <task index>!\n"
            );
        }
        int taskIndex = Integer.parseInt(arg);
        Task deletedTask = taskList.deleteTask(taskIndex);
        System.out.println(
                "Poof! That task has been erased from existence! (∩_∩;)\n"
                        + deletedTask + "\n"
                        + "Now you have " + taskList.numberOfTasks() + " tasks in the list!\n"
        );
    }
}
