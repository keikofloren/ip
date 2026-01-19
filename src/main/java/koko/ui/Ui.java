package koko.ui;

import java.util.Scanner;

import koko.task.DeadlineTask;
import koko.task.EventTask;
import koko.task.Task;
import koko.task.TaskList;
import koko.task.ToDoTask;

/**
 * Handles all user interactions by reading input and displaying output messages.
 */
public class Ui {

    /** Scanner used to read user input from standard input. */
    private Scanner sc;

    /**
     * Creates a Ui instance that reads commands from standard input.
     */
    public Ui() {
        this.sc = new Scanner(System.in);
    }

    /**
     * Displays the welcome message to the user.
     */
    public void showWelcome() {
        System.out.println(
                "Konnichiwa!! I'm Koko\n"
                        + "What can I do for you today senpai?\n"
        );
    }

    /**
     * Returns the next command entered by the user.
     *
     * @return User input string.
     */
    public String readCommand() {
        return sc.nextLine();
    }

    /**
     * Displays the specified error message to the user.
     *
     * @param message Error message to display.
     */
    public void showError(String message) {
        System.out.println(message);
    }

    /**
     * Displays a message indicating the command was not recognised.
     */
    public void showCommandNotFound() {
        System.out.println("E-eh?! I don't understand that command...\n");
    }

    /**
     * Displays the exit message to the user.
     */
    public void showExit() {
        System.out.println("Ja ne~! Don't forget your quests, okay?\n");
    }

    /**
     * Displays a confirmation message after adding a to-do task.
     *
     * @param task To-do task that was added.
     * @param taskList Task list containing all current tasks.
     */
    public void showAddTodoTask(ToDoTask task, TaskList taskList) {
        System.out.println(
                "Hai!! Mission accepted!\n"
                        + task + "\n"
                        + "Now you have " + taskList.numberOfTasks() + " tasks in the list!\n"
        );
    }

    /**
     * Displays a confirmation message after adding a deadline task.
     *
     * @param task Deadline task that was added.
     * @param taskList Task list containing all current tasks.
     */
    public void showAddDeadlineTask(DeadlineTask task, TaskList taskList) {
        System.out.println(
                "Understood. I'll keep an eye on the clock.\n"
                        + task + "\n"
                        + "Now you have " + taskList.numberOfTasks() + " tasks in the list!\n"
        );
    }

    /**
     * Displays a confirmation message after adding an event task.
     *
     * @param task Event task that was added.
     * @param taskList Task list containing all current tasks.
     */
    public void showAddEventTask(EventTask task, TaskList taskList) {
        System.out.println(
                "Ooh, a schedule arc begins.\n"
                        + task + "\n"
                        + "Now you have " + taskList.numberOfTasks() + " tasks in the list.\n"
        );
    }

    /**
     * Displays a confirmation message after marking a task as completed.
     *
     * @param task Task that was marked as completed.
     */
    public void showMarkTask(Task task) {
        System.out.println(
                "Sugoi. Task complete!\n"
                        + task + "\n"
        );
    }

    /**
     * Displays a confirmation message after unmarking a task.
     *
     * @param task Task that was unmarked.
     */
    public void showUnmarkTask(Task task) {
        System.out.println(
                "O-okay... back to unfinished mode.\n"
                        + task + "\n"
        );
    }

    /**
     * Displays a confirmation message after deleting a task.
     *
     * @param task Task that was deleted.
     * @param taskList Task list containing all current tasks.
     */
    public void showDeleteTask(Task task, TaskList taskList) {
        System.out.println(
                "Poof! That task has been erased from existence!\n"
                        + task + "\n"
                        + "Now you have " + taskList.numberOfTasks() + " tasks in the list!\n"
        );
    }
}
