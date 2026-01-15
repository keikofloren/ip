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
                    case TODO: {
                        ToDoTask task = new ToDoTask(arg);
                        taskList.addTask(task);
                        System.out.println(
                                "Got it. I've added this task:\n"
                                        + task.toString() + "\n"
                                        + "Now you have " + taskList.numberOfTasks() + " tasks in the list.\n"
                        );
                        break;
                    }
                    case DEADLINE: {
                        String[] argArray = arg.split(" /by ");
                        String taskDescription = argArray[0];
                        String deadline = argArray[1];
                        DeadlineTask task = new DeadlineTask(taskDescription, deadline);
                        taskList.addTask(task);
                        System.out.println(
                                "Got it. I've added this task:\n"
                                        + task.toString() + "\n"
                                        + "Now you have " + taskList.numberOfTasks() + " tasks in the list.\n"
                        );
                        break;
                    }
                    case EVENT: {
                        String[] argArray =  arg.split(" /from ");
                        String taskDescription = argArray[0];
                        String[] argArray2 = argArray[1].split(" /to ");
                        String startTime = argArray2[0];
                        String endTime = argArray2[1];
                        EventTask task = new EventTask(taskDescription, startTime, endTime);
                        taskList.addTask(task);
                        System.out.println(
                                "Got it. I've added this task:\n"
                                        + task.toString() + "\n"
                                        + "Now you have " + taskList.numberOfTasks() + " tasks in the list.\n"
                        );
                        break;
                    }
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
