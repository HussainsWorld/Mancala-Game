package mancala;

import java.util.ArrayList;

public class MancalaGame {
    private Board board;
    private Player currentPlayer;
    private ArrayList<Player> players;

    public MancalaGame() {
        board = new Board();
        players = new ArrayList<>();
    }

    public void setBoard(Board theBoard) {
        this.board = theBoard;
    }

    public Board getBoard() {
        return board;
    }

    public Player getCurrentPlayer() {
        return currentPlayer;
    }

    public void setCurrentPlayer(Player player) {
        this.currentPlayer = player;
    }

    public int getNumStones(int pitNum) throws PitNotFoundException {
        try {
            return board.getNumStones(pitNum);
        } catch (PitNotFoundException e){
            throw e;
        }
    }

    public boolean getExtraTurnTriggered() {
        return board.getExtraTurnTriggered();
    }

    public ArrayList<Player> getPlayers() {
        return players;
    }

    public void setPlayers(Player playerOne, Player playerTwo) {
        this.players.add(playerOne);
        this.players.add(playerTwo);
        setCurrentPlayer(playerOne);
    }

    public int move(int startPit) throws InvalidMoveException {
        try {
            return board.moveStones(startPit, currentPlayer);
        } catch (InvalidMoveException e) {
            throw e;
        }
    }

    public int getStoreCount(Player player) throws NoSuchPlayerException {
        boolean playerFound = false;
        for (Player playerCheck : players) {
            if (player.equals(playerCheck)) {
                playerFound = true;
                break;
            }
        }
        if (!playerFound) {
            throw new NoSuchPlayerException();
        }
        return player.getStoreCount();
    }

    public Player getWinner() throws GameNotOverException {
        if (!isGameOver()) {
            throw new GameNotOverException();
        }

        int playerCheck = -1;
        board.countUpStones();

        Player winner = null;
        int maxStones = 0;

        for (Player player : players) {
            int storeCount = player.getStoreCount();
            if (storeCount > maxStones) {
                maxStones = storeCount;
                winner = player;
            } else if (storeCount == maxStones) {
                winner = null;
            }
        }

        return winner;
    }    

    public boolean isGameOver() {
        try {
            return (board.isSideEmpty(1) || board.isSideEmpty(7));
        } catch (PitNotFoundException e) {
            e.getMessage();
        }
        return true;
    }

    public void startNewGame() {
        board.resetBoard();
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();

        result.append(board.toString());

        for (Player player : players) {
            result.append("Player ").append(player.getName())
                    .append(" Has ").append(player.getStore().getTotalStones())
                    .append(" Stones\n");
        }

    return result.toString();
}
}