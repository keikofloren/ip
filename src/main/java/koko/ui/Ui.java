package koko.ui;

import java.util.Scanner;

import koko.task.DeadlineTask;
import koko.task.EventTask;
import koko.task.Task;
import koko.task.TaskList;
import koko.task.ToDoTask;

public class Ui {

    private Scanner sc;

    public Ui() {
        this.sc = new Scanner(System.in);
    }

    public void showLoadingError() {
        return;
    }

    public void showWelcome() {
        System.out.println(
                "Konnichiwa!! I'm Koko\n"
                        + "What can I do for you today senpai?\n"
        );
    }

    public String readCommand() {
        return sc.nextLine();
    }

    public void showError(String message) {
        System.out.println(message);
    }

    public void showCommandNotFound() {
        System.out.println("E-eh?! I don't understand that command...\n");
    }

    public void showExit() {
        System.out.println("Ja ne~! Don't forget your quests, okay?\n");
    }

    public void showAddTodoTask(ToDoTask task, TaskList taskList) {
        System.out.println(
                "Hai!! Mission accepted!\n"
                        + task + "\n"
                        + "Now you have " + taskList.numberOfTasks() + " tasks in the list!\n"
        );
    }

    public void showAddDeadlineTask(DeadlineTask task, TaskList taskList) {
        System.out.println(
                "Understood. I'll keep an eye on the clock.\n"
                        + task + "\n"
                        + "Now you have " + taskList.numberOfTasks() + " tasks in the list!\n"
        );
    }

    public void showAddEventTask(EventTask task, TaskList taskList) {
        System.out.println(
                "Ooh, a schedule arc begins.\n"
                        + task + "\n"
                        + "Now you have " + taskList.numberOfTasks() + " tasks in the list.\n"
        );
    }

    public void showMarkTask(Task task) {
        System.out.println(
                "Sugoi. Task complete!\n"
                        + task + "\n"
        );
    }

    public void showUnmarkTask(Task task) {
        System.out.println(
                "O-okay... back to unfinished mode.\n"
                        + task + "\n"
        );
    }

    public void showDeleteTask(Task task, TaskList taskList) {
        System.out.println(
                "Poof! That task has been erased from existence!\n"
                        + task + "\n"
                        + "Now you have " + taskList.numberOfTasks() + " tasks in the list!\n"
        );
    }
}
