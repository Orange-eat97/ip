package CC;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.System;
import java.util.Scanner;

public class Ui {
    private static final String ChatBotName = "CC";
    private static final String stop = "bye";
    private static final String[] commands = {"todo", "event", "deadline", "mark", "unmark", "list"};
    private static final String FILE_PATH = "data" + File.separator + "duke.txt";

    private static void saveTaskToFile(Task task) {
        try {
            FileWriter writer = new FileWriter(FILE_PATH, true);
            writer.write(task.toString() + System.lineSeparator());
            writer.close();
        } catch (IOException e) {
            System.out.println("Error: task not found" + e.getMessage());
        }
    }

    public void Start() {     //print greetings
        System.out.println("Hello from " + ChatBotName);
        System.out.println("What can I do for you?");
    }

    public String StartFxml() {     //print greetings
        return "Hello from " + ChatBotName + "\n" + "What can I do for you?";
    }

    public void waitForCommand() throws EmptyTimeException, WrongHeadingException {       //loop that waits for command
        Scanner scanner = new Scanner(System.in);
        String temp = null;
        TaskList tasks = new TaskList();
        Parser parser = new Parser();

        while (true) {
            temp = scanner.nextLine().trim();
            int actionCode = parser.getAction(temp);
            if (actionCode == -1) {
                throw new WrongHeadingException();
            }

            if (actionCode == 1 || actionCode == 2 || actionCode == 3) {
                if (actionCode == 1) {
                    String[] details = parser.handleTaskAction(1, temp);
                    ToDos todo = new ToDos(details[0]);
                    tasks.addTask(todo);
                    System.out.println("added: " + todo.toString() + "\n"
                            + tasks.getSize() + " task now");
                    saveTaskToFile(todo);
                    temp = null;

                } else if (actionCode == 2) {
                    String[] details = parser.handleTaskAction(2, temp);
                    Deadlines deadline = new Deadlines(details[0], details[1]);
                    tasks.addTask(deadline);
                    System.out.println("added: " + deadline.toString() + "\n"
                            + tasks.getSize() + " task now");
                    saveTaskToFile(deadline);
                    temp = null;

                } else if (actionCode == 3) {
                    String[] details = parser.handleTaskAction(3, temp);
                    Events event = new Events(details[0], details[1], details[2]);
                    tasks.addTask(event);
                    System.out.println("added: " + event.toString() + "\n"
                            + tasks.getSize() + " task now");
                    saveTaskToFile(event);
                    temp = null;
                }

            } else if (actionCode == 4) {
                System.out.println(tasks.toString());

            } else if (actionCode == 5) {
                int index = parser.handleMarkAndDelete(5, temp);
                tasks.MarkAsDone(index - 1);
                System.out.println("Nice! You got it boss: \n" + tasks.getTask(index - 1).toString());

            } else if (actionCode == 6) {
                int index = parser.handleMarkAndDelete(6, temp);
                tasks.MarkAsUndone(index - 1);
                System.out.println("Fine get it done soon: \n" + tasks.getTask(index - 1).toString());

            } else if (actionCode == 7) {
                int index = parser.handleMarkAndDelete(7, temp);
                System.out.println(
                        "magic magic it's gone: \n" + tasks.getTask(index - 1).toString());
                tasks.deleteTask(index - 1);
                System.out.println(
                        tasks.getSize() + " tasks left");

            } else if (actionCode == 8) {
                String name = parser.handleFind(8, temp);
                Task[] finds = tasks.findWord(name);
                for (int i = 0; i < finds.length; i++) {
                    System.out.println(finds[i].toString());
                }
            } else {
                break;
            }
        }
        System.out.println("Don't come back again");
    }

    public String waitForCommandFxml(String input, TaskList tasks, Parser parser) throws EmptyTimeException, WrongHeadingException {       //loop that waits for command
        String temp = input;

        int actionCode = parser.getAction(temp);
        if (actionCode == -1) {
            throw new WrongHeadingException();
        }

        if (actionCode == 1 || actionCode == 2 || actionCode == 3) {
            if (actionCode == 1) {
                String[] details = parser.handleTaskAction(1, temp);
                ToDos todo = new ToDos(details[0]);
                tasks.addTask(todo);
                saveTaskToFile(todo);
                return "added: " + todo.toString() + "\n"
                        + tasks.getSize() + " task now";


            } else if (actionCode == 2) {
                String[] details = parser.handleTaskAction(2, temp);
                Deadlines deadline = new Deadlines(details[0], details[1]);
                tasks.addTask(deadline);
                saveTaskToFile(deadline);
                return "added: " + deadline.toString() + "\n"
                        + tasks.getSize() + " task now";


            } else if (actionCode == 3) {
                String[] details = parser.handleTaskAction(3, temp);
                Events event = new Events(details[0], details[1], details[2]);
                tasks.addTask(event);
                saveTaskToFile(event);
                return "added: " + event.toString() + "\n"
                        + tasks.getSize() + " task now";

            }

        } else if (actionCode == 4) {
            return tasks.toString();

        } else if (actionCode == 5) {
            int index = parser.handleMarkAndDelete(5, temp);
            tasks.MarkAsDone(index - 1);
            return "Nice! You got it boss: \n" + tasks.getTask(index - 1).toString();

        } else if (actionCode == 6) {
            int index = parser.handleMarkAndDelete(6, temp);
            tasks.MarkAsUndone(index - 1);
            return "Fine get it done soon: \n" + tasks.getTask(index - 1).toString();

        } else if (actionCode == 7) {
            int index = parser.handleMarkAndDelete(7, temp);
            String deletedTask = tasks.getTask(index - 1).toString();
            tasks.deleteTask(index - 1);

            return "magic magic it's gone: \n"
                    + deletedTask + "\n"
                    + tasks.getSize() + " tasks left";

        } else if (actionCode == 8) {
            String name = parser.handleFind(8, temp);
            Task[] finds = tasks.findWord(name);
            String result = "";
            for (int i = 0; i < finds.length; i++) {
                result = result + finds[i].toString();
            }
            return result;
        }
            return "Don't come back again";
        }
    }
