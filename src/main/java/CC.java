import java.util.Scanner;
public class CC {
    public static void main(String[] args) {
        String ChatBotName = "CC";
        String stop = "bye";
        System.out.println("Hello from " + ChatBotName);
        System.out.println("What can I do for you?");
        TaskList tasks = new TaskList();

        Scanner scanner = new Scanner(System.in);
        String temp = null;
        while(true) {
            temp = scanner.nextLine().trim();
            String[] parts = temp.split("\\s+", 2);

            if (!parts[0].equals(stop)
                    && !parts[0].equals("list")
                    && !parts[0].equals("mark")
                    && !parts[0].equals("unmark")
            ) {
                tasks.addTask(new Task(temp));
                System.out.println("added: " + temp);
                temp = null;

            }else if(parts[0].equals("list")){
                System.out.println(tasks.toString());

            }else if(parts[0].equals("mark")){
                int index = Integer.parseInt(parts[1]);
                tasks.MarkAsDone(index-1);
                System.out.println("Nice! You got it boss: \n" + tasks.getTask(index-1).toString());

            }else if(parts[0].equals("unmark")){
                int index = Integer.parseInt(parts[1]);
                tasks.MarkAsUndone(index-1);
                System.out.println("Fine get it done soon: \n" + tasks.getTask(index-1).toString());

            }else{
                break;

            }
        }
        System.out.println("Bye. Hope to see you again soon");
    }
}
