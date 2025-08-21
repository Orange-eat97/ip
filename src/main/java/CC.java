import java.util.Scanner;
public class CC {
    public static void main(String[] args) {
        String ChatBotName = "CC";
        String stop = "bye";
        System.out.println("Hello from " + ChatBotName);
        System.out.println("What can I do for you?");

        Scanner scanner = new Scanner(System.in);
        String temp = null;
        while(true){
            temp = scanner.nextLine();
            if(!temp.equals(stop)) {
                System.out.println(temp);
                temp = null;
            }else{
                break;
            }
        }
        System.out.println("Bye. Hope to see you again soon");
    }
}
