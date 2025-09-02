package CC;

import java.util.Arrays;

public class Parser {
    private static final String stop = "bye";
    private static final String[] commands = {"todo", "event", "deadline", "mark", "unmark", "list", "delete", "find"};

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
        } else {
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
            details = s.substring(9).split("/");
            if (details.length < 2) {
                throw new EmptyTimeException();
            }
        } else if (x == 3) {
            details = s.substring(6).split("/");
            if (details.length < 3) {
                throw new EmptyTimeException();
            }
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
        return index;
    }

    public String handleFind(int x, String s) {
        String temp = null;
        if(x == 8) {
            temp = s.substring(4).trim();
        }
        else {

        }
        return temp;
    }

    }
