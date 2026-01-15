import java.util.ArrayList;

public class TaskList {
    private ArrayList<Task> tasks;

    public TaskList() {
        this.tasks = new ArrayList<>();
    }

    public void addTask(Task task) {
        this.tasks.add(task);
        System.out.println("added: " + task.toString());
    }

    public void listTasks() {
        for (int i = 0; i < tasks.toArray().length; i++) {
            System.out.println((i + 1) + ". " + tasks.get(i).toString());
        }
    }
}
