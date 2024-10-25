# Task Tracker CLI
### 🏷️ Tags: `Filesystem` `CLI` `Programming`

A simple command-line interface (CLI) application to help you track, manage, and organize tasks. This project uses Maven for dependency management and building the application.

## Table of Contents

1. [Features](#features)
2. [Requirements](#requirements)
3. [Getting Started](#getting-started)
4. [Build and Run](#build-and-run)
5. [Usage](#usage)
6. [Example Commands](#example-commands)
7. [Task Properties](#task-properties)
8. [Error Handling](#error-handling)
9. [Setting Up an Alias (Linux/macOS)](#setting-up-an-alias-linuxmacos)
10. [License](#license)

---

## Features

- **Add, Update, and Delete Tasks**
- **Mark Tasks as In Progress or Done**
- **List Tasks by Status**
- **Persist Tasks to JSON File**

## Requirements

- Java Development Kit (JDK)
- Apache Maven

---

## Getting Started

Clone this repository and navigate to the project directory:

```bash
git clone https://github.com/your-username/task-tracker-cli.git
cd task-tracker-cli
```

## Build and Run

### Build the Project

Use Maven to compile the project:

```bash
mvn clean package
```

This will generate a JAR file in the `target` directory.

### Run the Program

Execute the application with the following command:

```bash
java -jar target/task-tracker-cli-1.0-SNAPSHOT.jar <command> [options]
```

Replace `<command>` with one of the available commands (see [Usage](#usage)).

---

## Usage

The application accepts commands and options from the command line. Below is a list of available commands:

```bash
java -jar target/task-tracker-cli-1.0-SNAPSHOT.jar <command> [options]
```

| Command           | Description                                      |
|-------------------|--------------------------------------------------|
| `add`             | Adds a new task with a specified description     |
| `update <id>`     | Updates the task description by ID               |
| `delete <id>`     | Deletes a task by ID                             |
| `mark-in-progress <id>` | Marks a task as in progress by ID        |
| `mark-done <id>`  | Marks a task as done by ID                       |
| `list`            | Lists all tasks                                  |
| `list done`       | Lists all tasks marked as done                   |
| `list todo`       | Lists all tasks yet to be done                   |
| `list in-progress`| Lists all tasks in progress                      |

---

## Example Commands

### Adding a New Task

```bash
java -jar target/task-tracker-cli-1.0-SNAPSHOT.jar add "Buy groceries"
# Output: Task added successfully (ID: 1)
```

### Updating and Deleting Tasks

```bash
java -jar target/task-tracker-cli-1.0-SNAPSHOT.jar update 1 "Buy groceries and cook dinner"
java -jar target/task-tracker-cli-1.0-SNAPSHOT.jar delete 1
```

### Marking a Task as In Progress or Done

```bash
java -jar target/task-tracker-cli-1.0-SNAPSHOT.jar mark-in-progress 1
java -jar target/task-tracker-cli-1.0-SNAPSHOT.jar mark-done 1
```

### Listing Tasks by Status

```bash
java -jar target/task-tracker-cli-1.0-SNAPSHOT.jar list
java -jar target/task-tracker-cli-1.0-SNAPSHOT.jar list done
java -jar target/task-tracker-cli-1.0-SNAPSHOT.jar list todo
java -jar target/task-tracker-cli-1.0-SNAPSHOT.jar list in-progress
```

---

## Task Properties

Each task in the JSON file includes the following properties:

- **id**: Unique identifier for the task
- **description**: Short description of the task
- **status**: Task status (`todo`, `in-progress`, or `done`)
- **createdAt**: Timestamp when the task was created
- **updatedAt**: Timestamp when the task was last updated

### Sample JSON Structure

```json
[
  {
    "id": 1,
    "description": "Buy groceries",
    "status": "todo",
    "createdAt": "2024-10-26T12:00:00Z",
    "updatedAt": "2024-10-26T12:00:00Z"
  }
]
```

---

## Error Handling

The CLI handles various edge cases gracefully:

- Invalid task IDs
- Missing or incorrect arguments
- JSON file read/write issues (file will be created if not present)

### Example Errors

- **Invalid Command**:
  ```bash
  java -jar target/task-tracker-cli-1.0-SNAPSHOT.jar unknown-command
  # Output: Error - Unknown command
  ```
- **Missing Arguments**:
  ```bash
  java -jar target/task-tracker-cli-1.0-SNAPSHOT.jar update
  # Output: Error - Task ID is required for updating
  ```

---

## Setting Up an Alias (Linux/macOS)

To simplify running the application, you can create an alias in your shell configuration file. Follow these steps:

### 1. Open Your Shell Configuration File

Depending on your shell, open the appropriate configuration file:

- For **Bash** users:

  ```bash
  nano ~/.bashrc
  ```

- For **Zsh** users:

  ```bash
  nano ~/.zshrc
  ```

### 2. Add the Alias

Add the following line to the file:

```bash
alias task-cli='java -jar /path/to/your/project/target/task-tracker-cli-1.0-SNAPSHOT.jar'
```

> Replace `/path/to/your/project` with the actual path to your project directory.

### 3. Save the File and Reload Your Shell Configuration

After adding the alias, save the file and reload your shell configuration with:

- For **Bash** users:

  ```bash
  source ~/.bashrc
  ```

- For **Zsh** users:

  ```bash
  source ~/.zshrc
  ```

### 4. Running the Application

You can now run your application using the following command:

```bash
task-cli <command> [options]
```

---

## License

This project is open-source and available under the MIT License.

---

Enjoy organizing your tasks with **Task Tracker CLI**!
