package CC;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Deadlines extends Task{
    private String Task;
    private LocalDate deadline;

    public Deadlines(String Task, String deadline){     //constructor for Deadline
        super(Task);
        this.deadline = LocalDate.parse(deadline.trim());
    }

    @Override
    public String toString(){
        String deadline = this.deadline.format(DateTimeFormatter.ofPattern("MMM dd yyyy"));
        return "[D]" + super.toString() + "(" + deadline + ")";
    }
}