package koko.ui;

import koko.task.*;

import java.util.Scanner;

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
                "Konnichiwa!! I’m koko.Koko (≧▽≦)\n"
                        + "What can I do for you today senpai? ( •̀ᴗ•́ )و\n"
        );
    }

    public String readCommand() {
        return sc.nextLine();
    }

    public void showError(String message) {
        System.out.println(message);
    }

    public void showCommandNotFound() {
        System.out.println("E-eh?! I don't understand that koko.command... (；ω；)\n");
    }

    public void showExit() {
        System.out.println("Ja ne~! Don’t forget your quests, okay? (｡•̀ᴗ•́｡)\n");
    }

    public void showAddTodoTask(ToDoTask task, TaskList taskList) {
        System.out.println(
                "Hai!! Mission accepted! (ง •̀_•́)ง\n"
                        + task + "\n"
                        + "Now you have " + taskList.numberOfTasks() + " tasks in the list!\n"
        );
    }

    public void showAddDeadlineTask(DeadlineTask task, TaskList taskList) {
        System.out.println(
                "Understood. I'll keep an eye on the clock. ( •̀ᴗ•́ )ゞ\n"
                        + task + "\n"
                        + "Now you have " + taskList.numberOfTasks() + " tasks in the list!\n"
        );
    }

    public void showAddEventTask(EventTask task, TaskList taskList) {
        System.out.println(
                "Ooh, a schedule arc begins. (☆_☆)\n"
                        + task + "\n"
                        + "Now you have " + taskList.numberOfTasks() + " tasks in the list.\n"
        );
    }

    public void showMarkTask(Task task) {
        System.out.println(
                "Sugoi. koko.task.Task complete! (≧▽≦)\n"
                        + task + "\n"
        );
    }

    public void showUnmarkTask(Task task) {
        System.out.println(
                "O-okay… back to unfinished mode. (；﹏；)\n"
                        + task + "\n"
        );
    }

    public void showDeleteTask(Task task, TaskList taskList) {
        System.out.println(
                "Poof! That koko.task has been erased from existence! (∩_∩;)\n"
                        + task + "\n"
                        + "Now you have " + taskList.numberOfTasks() + " tasks in the list!\n"
        );
    }
}
