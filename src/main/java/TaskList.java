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
        for (int i = 0; i < tasks.toArray().length; i++) {
            System.out.println((i + 1) + ". " + tasks.get(i).toString());
        }
        System.out.println();
    }

    public String numberOfTasks() {
        return String.valueOf(tasks.size());
    }

    public Task markTask(int index) {
        return this.tasks.get(index - 1).mark();
    }

    public Task unmarkTask(int index) {
        return this.tasks.get(index - 1).unmark();
    }
}
