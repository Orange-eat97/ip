package CC;

import static java.util.Arrays.stream;


public class CC {
    private String FILE_PATH;
    private Ui Ui;
    private Storage Storage;

    public CC(String filePath) throws EmptyTimeException, WrongHeadingException {    //constructor for CC
        this.Storage = new Storage(filePath);
        this.Ui = new Ui();
    }

    public void run() throws EmptyTimeException, WrongHeadingException {        //gets CC bot in action
        Storage.ensureDataFileExists();
        Ui.Start();
        Ui.waitForCommand();
    }

    public static void main(String[] args) throws WrongHeadingException, EmptyTimeException {    //main method
        new CC("data/tasks.txt").run();
    }
}
