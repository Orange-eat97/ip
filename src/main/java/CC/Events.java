package CC;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Events extends Deadlines {
    private String Task;
    private LocalDate deadline;
    private LocalDate start;

    public Events(String Tsk, String Strt, String Ddl) {
        super(Tsk, Ddl);
        this.deadline = Parser.parseFlexibleDate(Ddl.trim());
        this.Task = Tsk;
        this.start = Parser.parseFlexibleDate(Strt.trim());
    }

    @Override
    public String toString() {
        String deadline = this.deadline.format(DateTimeFormatter.ofPattern("MMM dd yyyy"));
        String start = this.start.format(DateTimeFormatter.ofPattern("MMM dd yyyy"));
        return "[E][ ] " + this.Task.toString() + "(" + start + " " + deadline + ")";
    }
}
