package ai;

public class NoSuchPlayerException extends Exception {
    public NoSuchPlayerException() {
        super("This player does not exist");
    }
}