package CC;

public class Task {
    private boolean status;
    private String name;
    private int priority;

    public Task(String name) {       //constructor for Task
        this.status = false;
        this.name = name;
        this.priority = 0;
    }

    public void MarkAsDone() {       //toggles task status to done
        this.status = true;
    }

    public void MarkAsUndone() {          //toggles task status to undone
        this.status = false;
    }

    public String getName(){
        return this.name;
    }

    public void addPriority(int x){
        this.priority = x;
    }

    @Override
    public String toString() {
        String status = null;
        String msg = null;
        if(this.status == true) {
            status = "X";
        } else {
            status = " ";
        }

        if(this.priority == 0){
            return "[" + status + "] " + "" + this.name;
        }
        return "[" + status + "]" + "[P=" + this.priority + "] " + this.name;
    }
}
