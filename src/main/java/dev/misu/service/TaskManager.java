package dev.misu.service;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import dev.misu.entities.Task;
import dev.misu.entities.enums.Status;
import dev.misu.log.TaskLogger;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class TaskManager {

    private static final String FILE_PATH = "dev/misu/data/database.json";
    private static final Logger logger = TaskLogger.getLogger();
    private Gson gson;
    private List<Task> tasks;

    public TaskManager() {
        this.gson = new GsonBuilder().setPrettyPrinting().create();
        this.tasks = readTasksFromFile();
    }

    public void add(Task task) {
        tasks.add(task);
        writeTasksToFile();
        logger.info("Added task with id: " + task.getId());
    }

    public void update(int id, String description) {
        boolean found = false;
        for (Task task : tasks) {
            if (task.getId() == id) {
                task.setDescription(description);
                writeTasksToFile();
                logger.info("Updated task with id: " + id);
                found = true;
                break;
            }
        }
        if (!found) {
            logger.warning("Task with id " + id + " not found.");
        }
        logger.info("Updated task with id: " + id);
    }

    public void deleteTask(int id) {
        boolean removed = tasks.removeIf(task -> task.getId() == id);
        if (removed) {
            writeTasksToFile();
            logger.info("Deleted task with id: " + id);
        } else {
            logger.warning("Task with id " + id + " not found for deletion.");
        }
    }

    private void writeTasksToFile() {
        try(FileWriter fileWriter = new FileWriter(FILE_PATH)) {
            gson.toJson(tasks, fileWriter);
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public List<Task> getAllTasks() {
        logger.info("Reading all tasks from file.");
        return tasks;
    }

    public List<Task> getTasksStatusDone() {
        logger.info("Reading all tasks from file with the status: DONE");
        return tasks.stream().filter(task -> task.getStatus() == Status.DONE).toList();
    }

    public List<Task> getTasksStatusInProgress() {
        logger.info("Reading all tasks from file with the status: IN_PROGRESS");
        return tasks.stream().filter(task -> task.getStatus() == Status.IN_PROGRESS).toList();
    }

    public List<Task> getTasksStatusToDo() {
        logger.info("Reading all tasks from file with the status: TODO");
        return tasks.stream().filter(task -> task.getStatus() == Status.DONE).toList();
    }

    private List<Task> readTasksFromFile() {
        try(FileReader fileReader = new FileReader(FILE_PATH)) {
            Type taskType = new TypeToken<ArrayList<Task>>(){}.getType();
            List<Task> tasks = gson.fromJson(fileReader, taskType);
            logger.info("Loaded tasks from file.");
            return tasks;
        } catch (IOException ex) {
            logger.severe("Error reading tasks from file: " + ex.getMessage());
            return new ArrayList<>();
        }
    }

}
