public class Deadlines extends Task{
    private String Task;
    private String deadline;

    public Deadlines(String Task, String deadline){
        super(Task);
        this.deadline = deadline;
    }

    @Override
    public String toString(){
        return "[D]" + super.toString() + "(" + this.deadline + ")";
    }
}