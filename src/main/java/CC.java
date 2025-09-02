import java.io.File;
import java.util.Arrays;
import java.util.Scanner;

import static java.util.Arrays.stream;
import java.io.FileWriter;
import java.io.IOException;

public class CC {
    private static final String FILE_PATH = "data" + File.separator + "duke.txt";
    private static void saveTaskToFile(Task task){
        try{
            FileWriter writer = new FileWriter(FILE_PATH, true);
            writer.write(task.toString() + System.lineSeparator());
            writer.close();
        } catch (IOException e){
            System.out.println("Error: task not found" + e.getMessage());
        }
    }

    private static void ensureDataFileExists(){
        File folder = new File("data");
        if(!folder.exists()){
            folder.mkdir();
        }

        File file = new File(folder, "duke.txt");
        try{
            if(!file.exists()){
                file.createNewFile();
            }
        }catch (IOException e){
            System.out.println("Error: no such file");
        }
    }

    public static void main(String[] args) throws WrongHeadingException, EmptyTimeException{
        String ChatBotName = "CC";
        String stop = "bye";
        String[] commands = {"todo", "event", "deadline", "mark", "unmark", "list"};
        System.out.println("Hello from " + ChatBotName);
        System.out.println("What can I do for you?");
        TaskList tasks = new TaskList();
        ensureDataFileExists();


        Scanner scanner = new Scanner(System.in);
        String temp = null;

            while (true) {
                temp = scanner.nextLine().trim();
                if (!(temp.contains("todo") || temp.contains("deadline") || temp.contains("delete") || temp.contains("event")
                        || temp.contains("list") || temp.contains("bye") || temp.contains("mark")
                        || temp.contains("unmark"))) {
                    throw new WrongHeadingException();
                }

                if (!temp.startsWith(stop)
                        && !temp.startsWith("list")
                        && !temp.startsWith("mark")
                        && !temp.startsWith("unmark")
                        && !temp.startsWith("delete")
                ) {
                    if (temp.startsWith("todo")) {
                        //System.out.println("adding todo");
                        String details = temp.substring(4);

                        if (details.isEmpty()) {
                            throw new EmptyTimeException();
                        }

                        ToDos todo = new ToDos(details);
                        tasks.addTask(todo);
                        System.out.println("added: " + todo.toString() + "\n"
                                + tasks.getSize() + " task now");
                        saveTaskToFile(todo);
                        temp = null;

                    } else if (temp.startsWith("deadline")) {
                        String[] details = temp.substring(9).split("/");

                        if (details.length < 2) {
                            throw new EmptyTimeException();
                        }

                        Deadlines deadline = new Deadlines(details[0], details[1]);
                        tasks.addTask(deadline);
                        System.out.println("added: " + deadline.toString() + "\n"
                                + tasks.getSize() + " task now");
                        saveTaskToFile(deadline);
                        temp = null;

                    } else if (temp.startsWith("event")) {
                        String[] details = temp.substring(6).split("/");
                        if (details.length < 3) {
                            throw new EmptyTimeException();
                        }
                        Events event = new Events(details[0], details[1], details[2]);
                        tasks.addTask(event);
                        System.out.println("added: " + event.toString() + "\n"
                                + tasks.getSize() + " task now");
                        saveTaskToFile(event);
                        temp = null;
                    }

                } else if (temp.startsWith("list")) {
                    System.out.println(tasks.toString());

                } else if (temp.startsWith("mark")) {
                    int index = Integer.parseInt(temp.substring(5));
                    tasks.MarkAsDone(index - 1);
                    System.out.println("Nice! You got it boss: \n" + tasks.getTask(index - 1).toString());

                } else if (temp.startsWith("unmark")) {
                    int index = Integer.parseInt(temp.substring(7));
                    tasks.MarkAsUndone(index - 1);
                    System.out.println("Fine get it done soon: \n" + tasks.getTask(index - 1).toString());

                } else if (temp.startsWith("delete")) {
                    int index = Integer.parseInt(temp.substring(6).trim());
                    System.out.println(
                            "magic magic it's gone: \n" + tasks.getTask(index - 1).toString());
                    tasks.deleteTask(index - 1);
                    System.out.println(
                            tasks.getSize() + " tasks left");

                }else{
                    break;
                }
            }
            System.out.println("Don't come back again");
    }
}
