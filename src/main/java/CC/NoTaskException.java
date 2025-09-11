package CC;

public class NoTaskException extends Exception{
    public NoTaskException(){
        super("no such task boss. Check index or content please?");
    }
}
