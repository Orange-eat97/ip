public class Events extends Deadlines{
    private String Task;
    private String Deadline;
    private String Start;

    public Events(String Task, String Start, String Deadline){
        super(Task, Deadline);
        this.Start= Start;
        this.Task = Task;
        this.Deadline = Deadline;
    }

    @Override
    public String toString(){
        return "[E]" + "[] " + this.Task.toString() + "(" + this.Start + " " + this.Deadline + ")";
    }
}
