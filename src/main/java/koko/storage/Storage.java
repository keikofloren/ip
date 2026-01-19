package koko.storage;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import koko.exception.CreateFileException;
import koko.exception.FileLoadException;
import koko.exception.KokoException;
import koko.exception.WriteFileException;
import koko.task.DeadlineTask;
import koko.task.EventTask;
import koko.task.Task;
import koko.task.TaskList;
import koko.task.ToDoTask;

/**
 * Handles loading tasks from disk and saving tasks back to disk.
 */
public class Storage {

    /** File used for persisting task data. */
    private File file;

    /**
     * Creates a Storage instance that reads from and writes to the specified file path.
     *
     * @param filePath File path used for saving and loading tasks.
     */
    public Storage(String filePath) {
        this.file = new File(filePath);
    }

    /**
     * Returns a list of tasks loaded from the storage file.
     *
     * @return List of tasks loaded from disk.
     * @throws KokoException If the storage file cannot be read.
     */
    public ArrayList<Task> load() throws KokoException {
        try {
            createFileIfMissing();
            ArrayList<Task> tasks = new ArrayList<>();
            Scanner sc = new Scanner(this.file);
            while (sc.hasNextLine()) {
                String line = sc.nextLine();
                Task task = parseLine(line);
                tasks.add(task);
            }
            return tasks;
        } catch (FileNotFoundException e) {
            throw new FileLoadException(
                    "N-nooo! I couldn't read my memory scroll...\n"
                            + "Your saved tasks might be hiding or damaged!\n"
            );
        }
    }

    /**
     * Writes the current task list into the storage file.
     *
     * @param taskList Task list to be saved.
     * @throws WriteFileException If the task list cannot be written to disk.
     */
    public void update(TaskList taskList) throws WriteFileException {
        createFileIfMissing();
        try {
            FileWriter fw = new FileWriter(this.file);
            for (int i = 0; i < taskList.numberOfTasks(); i++) {
                fw.write(formatTask(taskList.getTask(i)) + System.lineSeparator());
            }
            fw.close();
        } catch (IOException e) {
            throw new WriteFileException(
                    "Aaa!! I failed to write to the save crystal!\n"
                            + "Your tasks are safe for now, but I couldn't save them!\n"
            );
        }

    }

    /**
     * Returns a task parsed from a single line in the storage file.
     *
     * @param line A single line representing a task in storage format.
     * @return Task reconstructed from the storage line.
     */
    private Task parseLine(String line) {
        String[] lineArray = line.split(" \\| ");
        String type = lineArray[0];
        boolean isDone = lineArray[1].equals("1");
        String description = lineArray[2];
        Task task = null;
        if (type.equals("T")) {
            task = new ToDoTask(description);
        } else if (type.equals("D")) {
            String deadline = lineArray[3].split("by ")[1];
            task = new DeadlineTask(description, deadline);
        } else if (type.equals("E")) {
            String[] lineArray2 = lineArray[3].split(" to ");
            String startTime = lineArray2[1];
            String endTime = lineArray2[0].split("from ")[0];
            task = new EventTask(description, startTime, endTime);
        }
        if (isDone) {
            task.mark();
        }
        return task;
    }

    /**
     * Returns a storage-formatted string representing the given task.
     *
     * @param task Task to be formatted for storage.
     * @return String representation of the task in storage format.
     */
    private String formatTask(Task task) {
        String isDone = task.isDone() ? "1" : "0";
        if (task instanceof ToDoTask) {
            ToDoTask t = (ToDoTask) task;
            return "T | " + isDone + " | " + t.getFileDescription();
        } else if (task instanceof DeadlineTask) {
            DeadlineTask t = (DeadlineTask) task;
            return "D | " + isDone + " | " + t.getFileDescription();
        } else if (task instanceof EventTask) {
            EventTask t = (EventTask) task;
            return "E | " + isDone + " | " + t.getFileDescription();
        }
        return "T | " + isDone + " | " + task.getFileDescription();
    }

    /**
     * Creates the storage file and its parent directory if they do not exist.
     *
     * @throws KokoException If the file cannot be created.
     */
    private void createFileIfMissing() throws KokoException {
        try {
            File parent = file.getParentFile();
            if (parent != null && !parent.exists()) {
                parent.mkdir();
            }
            if (!file.exists()) {
                file.createNewFile();
            }
        } catch (IOException e) {
            throw new CreateFileException(
                    "Uwaaa! I tried to create the save cave but it wouldn’t open...\n"
            );
        }
    }
}
