import java.util.Scanner;

public class Koko {

    private static TaskList taskList;

    enum CommandType {
        BYE,
        ADD,
        LIST,
        MARK,
        UNMARK
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
            String input = sc.nextLine();
            String[] inputArray = input.split(" ", 2);
            String command = inputArray[0].toUpperCase();
            String arg = (inputArray.length == 2) ? inputArray[1] : "";
            try {
                CommandType commandType = CommandType.valueOf(command);
                switch (commandType) {
                    case BYE:
                        System.out.println("Bye. Hope to see you again soon!\n");
                        return;
                    case ADD:
                        Task task = new Task(arg);
                        taskList.addTask(task);
                        System.out.println("added: " + task.toString());
                        break;
                    case LIST:
                        taskList.listTasks();
                        break;
                    case MARK: {
                        int taskIndex = Integer.parseInt(arg);
                        Task markedTask = taskList.markTask(taskIndex);
                        System.out.println(
                                "Nice! I've marked this task as done:\n"
                                        + markedTask.toString()
                        );
                        break;
                    }
                    case UNMARK: {
                        int taskIndex = Integer.parseInt(arg);
                        Task unmarkedTask = taskList.unmarkTask(taskIndex);
                        System.out.println(
                                "OK, I've marked this task as not done yet:\n"
                                        + unmarkedTask.toString()
                        );
                        break;
                    }
                }
            } catch (IllegalArgumentException e) {
                System.out.println("Unknown command!");
            }
        }
    }
}
