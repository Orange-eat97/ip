package CC;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Events extends Deadlines {
    private String Task;
    private LocalDate Deadline;
    private LocalDate Start;

    public Events(String Tsk, String Strt, String Ddl) {
        super(Tsk, Ddl);
        this.Deadline = LocalDate.parse(Ddl.trim());
        this.Task = Tsk;
        this.Start = LocalDate.parse(Strt.trim());
    }

    @Override
    public String toString() {
        String deadline = this.Deadline.format(DateTimeFormatter.ofPattern("MMM dd yyyy"));
        String start = this.Start.format(DateTimeFormatter.ofPattern("MMM dd yyyy"));
        return "[E]" + "[] " + this.Task.toString() + "(" + start + " " + deadline + ")";
    }
}
