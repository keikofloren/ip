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
     * Returns the welcome message shown when the application starts.
     *
     * @return The welcome message.
     */
    public Ui() {
        this.sc = new Scanner(System.in);
        assert this.sc != null : "sc should not be null";
    }

    /**
     * Displays the welcome message to the user.
     */
    public String showWelcome() {
        return "Konnichiwa!! I'm Koko\n"
                        + "What can I do for you today senpai?\n";
    }

    /**
     * Returns an error message to be shown to the user.
     *
     * @param message The error message.
     * @return The error message.
     */
    public String showError(String message) {
        return message;
    }

    /**
     * Returns a message indicating that the entered command was not recognised.
     *
     * @return The command not found message.
     */
    public String showCommandNotFound() {
        return "E-eh?! I don't understand that command...\n";
    }

    /**
     * Returns the exit message shown when the application is about to close.
     *
     * @return The exit message.
     */
    public String showExit() {
        return "Ja ne~! Don't forget your quests, okay?\n";
    }

    /**
     * Returns a confirmation message after adding a to-do task.
     *
     * @param task The to-do task that was added.
     * @param taskList The updated task list.
     * @return The confirmation message.
     */
    public String showAddTodoTask(ToDoTask task, TaskList taskList) {
        return "Hai!! Mission accepted!\n"
                        + task + "\n"
                        + "Now you have " + taskList.numberOfTasks() + " tasks in the list!\n";
    }

    /**
     * Returns a confirmation message after adding a deadline task.
     *
     * @param task The deadline task that was added.
     * @param taskList The updated task list.
     * @return The confirmation message.
     */
    public String showAddDeadlineTask(DeadlineTask task, TaskList taskList) {
        return "Understood. I'll keep an eye on the clock.\n"
                        + task + "\n"
                        + "Now you have " + taskList.numberOfTasks() + " tasks in the list!\n";
    }

    /**
     * Returns a confirmation message after adding an event task.
     *
     * @param task The event task that was added.
     * @param taskList The updated task list.
     * @return The confirmation message.
     */
    public String showAddEventTask(EventTask task, TaskList taskList) {
        return "Ooh, a schedule arc begins.\n"
                    + task + "\n"
                    + "Now you have " + taskList.numberOfTasks() + " tasks in the list.\n";
    }

    /**
     * Returns a confirmation message after marking a task as completed.
     *
     * @param task The task that was marked as completed.
     * @return The confirmation message.
     */
    public String showMarkTask(Task task) {
        return "Sugoi. Task complete!\n"
                + task + "\n";
    }

    /**
     * Returns a confirmation message after unmarking a task.
     *
     * @param task The task that was unmarked.
     * @return The confirmation message.
     */
    public String showUnmarkTask(Task task) {
        return "O-okay... back to unfinished mode.\n"
                        + task + "\n";
    }

    /**
     * Returns a confirmation message after deleting a task.
     *
     * @param task The task that was deleted.
     * @param taskList The updated task list.
     * @return The confirmation message.
     */
    public String showDeleteTask(Task task, TaskList taskList) {
        return "Poof! That task has been erased from existence!\n"
                        + task + "\n"
                        + "Now you have " + taskList.numberOfTasks() + " tasks in the list!\n";
    }
}
