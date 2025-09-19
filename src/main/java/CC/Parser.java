package CC;

import java.util.Arrays;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class Parser {
    private static final String stop = "bye";
    private static final String[] commands = {"todo", "event", "deadline", "mark", "unmark", "list", "delete", "find", "priority"};



    public int getAction(String s) {    //controls how we parse the command
        if (Arrays.stream(commands).noneMatch(x->s.startsWith(x))) {
            return -1;
        } else if (s.startsWith("todo")) {
            return 1;
        } else if (s.startsWith("deadline")) {
            return 2;
        } else if (s.startsWith("event")) {
            return 3;
        } else if (s.startsWith("list")) {
            return 4;
        } else if (s.startsWith("mark")) {
            return 5;
        } else if (s.startsWith("unmark")) {
            return 6;
        } else if (s.startsWith("delete")) {
            return 7;
        } else if (s.startsWith("find")){
            return 8;
        } else if (s.startsWith(stop)) {
            return 9;
        } else if (s.startsWith("priority")){
            return 10;
        } else{
            return 0;
        }
    }

    public String[] handleTaskAction(int x, String s) throws EmptyTimeException {     //controls parsing tasks
        String[] details = new String[3];
        if (x == 1) {
            details[0] = s.substring(4);
            if (details[0].isEmpty()) {
                throw new EmptyTimeException();
            }
        } else if (x == 2) {
            String[] split = s.substring(9).split("(/by|,by| by)", 2);    //change suggested by GPT4.1
            if (split.length < 2) {
                throw new EmptyTimeException();
            }
            details[0] = split[0].trim();
            details[1] = split[1].trim();

        } else if (x == 3) {
            String eventArgs = s.substring(6);
            String[] split = eventArgs.split("(/from|,from| from)", 2);   //change suggested by GPT4.1
            if (split.length < 2) {
                throw new EmptyTimeException();
            }
            String[] split2 = split[1].split("(/to|,to| to)", 2);
            if(split2.length < 2){
                throw new EmptyTimeException();
            }
            details[0] = split[0].trim();
            details[1] = split2[0].trim();
            details[2] = split2[1].trim();
        }
        return details;
    }

    public int handleMarkAndDelete(int x, String s) {        //controls getting the index for the other three tasks
        int index = 0;
        if(x == 5) {
            index = Integer.parseInt(s.substring(5).trim());
        } else if(x == 6) {
            index = Integer.parseInt(s.substring(7).trim());
        } else if(x == 7) {
            index = Integer.parseInt(s.substring(6).trim());
        }
        assert index != 0: "index will not be 0";
        return index;
    }

    public String handleFind(int x, String s) {
        String temp = null;
        if(x == 8) {
            temp = s.substring(4).trim();
        }
        assert temp != null: "find only get called with valid string";
        return temp;
    }

    public String[] handlePriority(String s) throws EmptyTimeException {
        String[] details = s.substring(9).split(" ");
        if(details.length < 2 ){
            throw new EmptyTimeException();
        }
        return details;
    }

    public static LocalDate parseFlexibleDate(String dateStr) throws DateTimeParseException {   //suggested by GPT4.1 to handle more flexible time format
        String[] patterns = {
                "yyyy-MM-dd",
                "MMM d, yyyy",
                "dd/MM/yyyy",
                "d/M/yyyy",
                "MMM dd yyyy",
                "dd MMM yyyy"
        };
        for (String pattern : patterns) {
            try {
                return LocalDate.parse(dateStr.trim(), DateTimeFormatter.ofPattern(pattern));
            } catch (DateTimeParseException ignored) {}
        }
        throw new DateTimeParseException("Unrecognized date format: " + dateStr, dateStr, 0);
    }

    }
