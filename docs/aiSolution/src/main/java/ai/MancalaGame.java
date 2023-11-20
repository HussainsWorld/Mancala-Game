package ai;

import java.util.ArrayList;

public class MancalaGame {
    private Board board;
    private ArrayList<Player> players;
    private Player currentPlayer;

    public MancalaGame() {
        // Default constructor
    }

    public void setPlayers(Player onePlayer, Player twoPlayer) {
        players = new ArrayList<>();
        players.add(onePlayer);
        players.add(twoPlayer);
    }

    public ArrayList<Player> getPlayers() {
        return new ArrayList<>(players);
    }

    public Player getCurrentPlayer() {
        return currentPlayer;
    }

    public void setCurrentPlayer(Player player) {
        currentPlayer = player;
    }

    public void setBoard(Board theBoard) {
        board = theBoard;
    }

    public Board getBoard() {
        return board;
    }

    public int getNumStones(int pitNum) throws PitNotFoundException {
        return board.getNumStones(pitNum);
    }

    public int move(int startPit) throws InvalidMoveException {
        // Implementation for making a move goes here
        return 0; // Placeholder
    }

    public int getStoreCount(Player player) throws NoSuchPlayerException {
        return player.getStoreCount();
    }

    public Player getWinner() throws GameNotOverException {
        // Implementation for getting the winner goes here
        return null; // Placeholder
    }

    public boolean isGameOver() {
        // Implementation for checking if the game is over goes here
        return false; // Placeholder
    }

    public void startNewGame() {
        board.resetBoard();
    }

    @Override
    public String toString() {
        // Implementation for generating a string representation goes here
        return "MancalaGame{" +
                "board=" + board +
                ", players=" + players +
                ", currentPlayer=" + currentPlayer +
                '}';
    }
}
