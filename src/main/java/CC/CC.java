package CC;


public class CC {
    private String FILE_PATH;
    private final Ui Ui;
    private final Storage storage;
    private final TaskList tasks = new TaskList();
    private final Parser parser = new Parser();

    public CC(String filePath) {    //constructor for CC
        this.storage = new Storage(filePath);
        this.Ui = new Ui();
    }

    public void run() throws EmptyTimeException, WrongHeadingException, NoTaskException {        //gets CC bot in action
        Storage.ensureDataFileExists();
        Ui.start();
        Ui.waitForCommand();
    }

    public String getResponse(String input) {
        try {
            storage.ensureDataFileExists();
            return Ui.waitForCommandFxml(input, tasks, parser);
        } catch (Exception e) {
            return e.getMessage();
        }
    }

    public String getGreeting() {
        return Ui.startFxml();
    }

    public static void main(String[] args) throws WrongHeadingException, EmptyTimeException, NoTaskException {    //main method
        new CC("data/tasks.txt").run();
    }
}
