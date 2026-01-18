import java.util.ArrayList;

public class TaskList {
    private ArrayList<Task> tasks;

    public TaskList() {
        this.tasks = new ArrayList<>();
    }

    public void addTask(Task task) {
        this.tasks.add(task);
    }

    public void listTasks() {
        System.out.println("Okay! Here is your quest list! ( •̀ᴗ•́ )و");
        for (int i = 0; i < tasks.toArray().length; i++) {
            System.out.println((i + 1) + ". " + tasks.get(i).toString());
        }
        System.out.println();
    }

    public int numberOfTasks() {
        return tasks.size();
    }

    private Task getTask(String index) {
        if (index == null || index.isBlank()) {
            throw new InvalidCommandFormatException(
                    "Oi, which task?! (＞﹏＜)\n"
                            + "Please state a task index!\n"
            );
        }
        int taskIndex;
        try {
            taskIndex = Integer.parseInt(index.trim());
        } catch (NumberFormatException e) {
            throw new InvalidCommandFormatException(
                    "That doesn't look like a number... (＠_＠;)\n"
                            + "Please state a task index!\n"
            );
        }
        int numTasks = this.numberOfTasks();
        if (taskIndex < 1 || taskIndex > numTasks) {
            throw new InvalidCommandInputException(
                    "Ehh?! That task number doesn't exist! Please use a number from 1 to "
                            + numTasks + "!\n"
            );
        }
        int i = Integer.parseInt(index);
        return this.tasks.get(i - 1);
    }

    public Task markTask(String index) {
        return this.getTask(index).mark();
    }

    public Task unmarkTask(String index) {
        return this.getTask(index).unmark();
    }

    public Task deleteTask(String index) {
        Task deletedTask = this.getTask(index);
        int i = Integer.parseInt(index);
        this.tasks.remove(i - 1);
        return deletedTask;
    }
}
