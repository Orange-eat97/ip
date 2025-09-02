package CC;

import java.util.ArrayList;

public class TaskList {
    private static int counter = 0;
    private static ArrayList<Task> tasks;

    public TaskList() {
        tasks =new ArrayList<>(100);
    }

    public void addTask(Task task) {     //adds a task into a tasklist
        tasks.add(task);
        counter += 1;

    }

    public void MarkAsDone(int index) {  //asks task to mark done
        tasks.get(index).MarkAsDone();
    }

    public void MarkAsUndone(int index) {    //asks task to mark undone
        tasks.get(index).MarkAsUndone();
    }

    public int getSize() {   //returns size of the list
        return tasks.size();
    }

    public Task getTask(int index) {     //returns a certain task at an index
        return tasks.get(index);
    }

    public void deleteTask(int index) {  //returns nth. removes a task
        tasks.remove(index);
    }

    @Override
    public String toString() {
        String temp = "";
        for(int i=0; i<tasks.size(); i++) {
            temp += i + 1 + ". " + tasks.get(i).toString() + "\n";
        }
        return temp;
    }
}
