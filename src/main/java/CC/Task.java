package CC;

public class Task {
    private boolean status;
    private String name;

    public Task(String name) {       //constructor for Task
        this.status = false;
        this.name = name;
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

    @Override
    public String toString() {
        String status = null;
        if(this.status == true) {
            status = "X";
        } else {
            status = " ";
        }
        return "[" + status + "] " + this.name;
    }
}
