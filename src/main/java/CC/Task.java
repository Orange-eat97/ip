package CC;

public class Task {
    private boolean status;
    private String name;

    public Task(String name){
        this.status = false;
        this.name = name;
    }

    public void MarkAsDone(){
        this.status = true;
    }

    public void MarkAsUndone(){
        this.status = false;
    }

    @Override
    public String toString(){
        String status = null;
        if(this.status == true){
            status = "X";
        }else{
            status = " ";
        }
        return "[" + status + "] " + this.name;
    }
}
