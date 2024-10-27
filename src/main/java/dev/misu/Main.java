package dev.misu;

import java.util.Objects;

public class Main {
    public static void main(String[] args) {

        String command = args[0];
        if (args.length < 2 && !Objects.equals(command, "list")) {
            System.out.println("Error - not supported input!");
            return;
        }

        switch (command) {
            case "list":
                break;
            case "add":
                break;
            case "update":
                break;
            case "delete":
                break;
            case "mark-done":
                break;
            case "mark-in-progress":
                break;
            default:
                System.out.println("Invalid command: " + command);
        }

    }
}