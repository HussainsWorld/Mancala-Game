package ai;

public class GameNotOverException extends Exception {
    public GameNotOverException() {
        super("This game is not over yet");
    }
}