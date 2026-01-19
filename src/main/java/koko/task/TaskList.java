package koko.task;

import java.util.ArrayList;

import koko.exception.InvalidCommandFormatException;
import koko.exception.InvalidCommandInputException;

/**
 * Represents a list of tasks managed by the application.
 */
public class TaskList {

    /** List of tasks currently stored by the application. */
    private ArrayList<Task> tasks;

    /**
     * Creates an empty TaskList.
     */
    public TaskList() {
        this.tasks = new ArrayList<>();
    }

    /**
     * Creates a TaskList with an initial list of tasks.
     *
     * @param tasks Initial list of tasks.
     */
    public TaskList(ArrayList<Task> tasks) {
        this.tasks = tasks;
    }

    /**
     * Adds the given task to the task list.
     *
     * @param task Task to be added.
     */
    public void addTask(Task task) {
        this.tasks.add(task);
    }

    /**
     * Prints all tasks in the task list.
     */
    public void listTasks() {
        System.out.println("Okay! Here is your quest list!");
        for (int i = 0; i < tasks.toArray().length; i++) {
            System.out.println((i + 1) + ". " + tasks.get(i).toString());
        }
        System.out.println();
    }

    /**
     * Returns the number of tasks in the task list.
     *
     * @return Number of tasks stored in the task list.
     */
    public int numberOfTasks() {
        return tasks.size();
    }

    /**
     * Returns the task at the specified zero-based index.
     *
     * @param index Zero-based index of the task.
     * @return Task at the specified index.
     * @throws InvalidCommandInputException If the index is out of range.
     */
    public Task getTask(int index) {
        int numTasks = this.numberOfTasks();
        if (index < 0 || index > numTasks) {
            throw new InvalidCommandInputException(
                    "Ehh?! That task number doesn't exist! Please use a number from 1 to "
                            + numTasks + "!\n"
            );
        }
        return this.tasks.get(index);
    }

    /**
     * Returns the task corresponding to the specified one-based index string.
     *
     * @param index One-based index of the task as a string.
     * @return Task corresponding to the specified index.
     * @throws InvalidCommandFormatException If the index is missing or not a valid number.
     * @throws InvalidCommandInputException If the index is out of range.
     */
    public Task getTask(String index) {
        if (index == null || index.isBlank()) {
            throw new InvalidCommandFormatException(
                    "Oi, which task?!\n"
                            + "Please state a task index!\n"
            );
        }
        int taskIndex;
        try {
            taskIndex = Integer.parseInt(index.trim());
        } catch (NumberFormatException e) {
            throw new InvalidCommandFormatException(
                    "That doesn't look like a number...\n"
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

    /**
     * Marks the specified task as completed.
     *
     * @param index One-based index of the task as a string.
     * @return Task that was marked as completed.
     */
    public Task markTask(String index) {
        return this.getTask(index).mark();
    }

    /**
     * Unmarks the specified task as not completed.
     *
     * @param index One-based index of the task as a string.
     * @return Task that was unmarked.
     */
    public Task unmarkTask(String index) {
        return this.getTask(index).unmark();
    }

    /**
     * Deletes the specified task from the task list.
     *
     * @param index One-based index of the task as a string.
     * @return Task that was deleted.
     */
    public Task deleteTask(String index) {
        Task deletedTask = this.getTask(index);
        int i = Integer.parseInt(index);
        this.tasks.remove(i - 1);
        return deletedTask;
    }

    /**
     * Prints tasks whose descriptions contain the given keyword.
     *
     * @param keyword Keyword to search for in task descriptions.
     */
    public void findTask(String keyword) {
        int taskCount = 1;
        System.out.println("Hai hai~! Here are the matching quests in your list!");
        for (int i = 0; i < this.numberOfTasks(); i++) {
            Task task = this.getTask(i);
            if (task.getDescription().contains(keyword)) {
                System.out.println(taskCount + ". " + task);
                taskCount++;
            }
        }
        System.out.println();
    }
}
