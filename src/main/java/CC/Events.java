package CC;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Events extends Deadlines {
    private String Task;
    private LocalDate Deadline;
    private LocalDate Start;

    public Events(String Task, String Start, String Deadline) {
        super(Task, Deadline);
        this.Deadline = LocalDate.parse(Deadline.trim());
        this.Task = Task;
        this.Start = LocalDate.parse(Start.trim());
    }

    @Override
    public String toString() {
        String deadline = this.Deadline.format(DateTimeFormatter.ofPattern("MMM dd yyyy"));
        String start = this.Start.format(DateTimeFormatter.ofPattern("MMM dd yyyy"));
        return "[E]" + "[] " + this.Task.toString() + "(" + start + " " + deadline + ")";
    }
}
