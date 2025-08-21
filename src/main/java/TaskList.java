import java.util.ArrayList;

public class TaskList {
    private static int counter = 0;
    private static ArrayList<String> tasks;

    public TaskList() {
        tasks =new ArrayList<>(100);
    }

    public void addTask(String task){
        tasks.add(task);
        counter += 1;
    }

    public int getSize(){
        return tasks.size();
    }

    @Override
    public String toString(){
        String temp = "";
        for(int i=0; i<counter; i++){
            temp += i+1 +". " + tasks.get(i).toString() + "\n";
        }
        return temp;
    }
}
