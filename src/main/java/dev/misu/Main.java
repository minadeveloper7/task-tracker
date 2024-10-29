package dev.misu;

import dev.misu.entities.Task;
import dev.misu.service.TaskManager;

import java.util.List;
import java.util.Objects;

public class Main {
    public static void main(String[] args) {

        String command = args[0];
        if (args.length < 2 && !Objects.equals(command, "list")) {
            System.out.println("Error - not supported input!");
            return;
        }
        TaskManager taskManager = new TaskManager();

        switch (command) {
            case "list":
                if (args.length < 2) {
                    printTasks(taskManager.getAllTasks());
                    return;
                }
                String status = args[1];
                switch (status) {
                    case "todo":
                        List<Task> tasksToDo = taskManager.getTasksStatusToDo();
                        printTasks(tasksToDo);
                        break;
                    case "in-progress":
                        List<Task> tasksInProgress = taskManager.getTasksStatusInProgress();
                        printTasks(tasksInProgress);
                        break;
                    case "done":
                        List<Task> tasksDone = taskManager.getTasksStatusDone();
                        printTasks(tasksDone);
                        break;
                    default:
                        System.out.println(
                                "Invalid option! Options {todo, in-progress, done}"
                        );
                }
                break;
            case "add":
                if (!args[1].isEmpty()) {
                    Task task = new Task(args[1]);
                    taskManager.add(task);
                    System.out.println(task);
                } else {
                    System.out.println("Error - you forgot to input the task!");
                }
                break;
            case "update":
                if (isNumeric(args[1])) {

                    if (!args[2].isEmpty()) {
                        taskManager.update(Integer.parseInt(args[1]), args[2]);
                    }

                } else {
                    System.out.println("Please enter valid task id!");
                }
                break;
            case "delete":
                if (isNumeric(args[1])) {
                    taskManager.deleteTask(Integer.parseInt(args[1]));
                } else {
                    System.out.println("Enter valid task id!");
                }
                break;
            case "mark-done":
                if (isNumeric(args[1])) {
                    taskManager.markDone(Integer.parseInt(args[1]));
                } else {
                    System.out.println("Enter valid task id!");
                }
                break;
            case "mark-in-progress":
                if (isNumeric(args[1])) {
                    taskManager.markInProgress(Integer.parseInt(args[1]));
                } else {
                    System.out.println("Enter valid task id!");
                }
                break;
            default:
                System.out.println("Invalid command: " + command);
        }

    }

    private static void printTasks(List<Task> tasks) {
        for (Task task: tasks) {
            System.out.println(task.toString());
        }
    }

    public static boolean isNumeric(String strNum) {
        if (strNum == null) {
            return false;
        }
        try {
            double d = Double.parseDouble(strNum);
        } catch (NumberFormatException nfe) {
            return false;
        }
        return true;
    }

}