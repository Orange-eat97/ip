package CC;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Deadlines extends Task {
    //private String Task; delete suggested by chatgpt4.1, as a part of deletion of unused information
    private LocalDate deadline;

    public Deadlines(String Task, String deadline) {     //constructor for Deadline
        super(Task);
        this.deadline = Parser.parseFlexibleDate(deadline.trim()); //suggested by chatgpt4.1 to handle more time formats
    }

    @Override
    public String toString() {
        String deadline = this.deadline.format(DateTimeFormatter.ofPattern("MMM dd yyyy"));
        return "[D]" + super.toString() + "(" + deadline + ")";
    }
}