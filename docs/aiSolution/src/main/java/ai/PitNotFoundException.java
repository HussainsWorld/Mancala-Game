package ai;

public class PitNotFoundException extends Exception {
    public PitNotFoundException() {
        super("Invalid pit number");
    }
}