import java.util.ArrayList;

public class TaskList {
    private static int counter = 0;
    private static ArrayList<Task> tasks;

    public TaskList() {
        tasks =new ArrayList<>(100);
    }

    public void addTask(Task task){
        tasks.add(task);
        counter += 1;

    }

    public void MarkAsDone(int index){
        tasks.get(index).MarkAsDone();
    }

    public void MarkAsUndone(int index){
        tasks.get(index).MarkAsUndone();
    }

    public int getSize(){
        return tasks.size();
    }

    public Task getTask(int index){
        return tasks.get(index);
    }

    public void deleteTask(int index){
        tasks.remove(index);
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
