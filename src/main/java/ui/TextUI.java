package ui;
import java.util.ArrayList;
import java.util.Scanner;
import mancala.MancalaGame;
import mancala.Player;
import mancala.Board;
import mancala.GameNotOverException;
import mancala.InvalidMoveException;

public class TextUI {
    private MancalaGame mancalaGame;
    private Scanner scanner;
    
    public TextUI() {
        mancalaGame = new MancalaGame();
        scanner = new Scanner(System.in);
    }

    public Scanner getScanner() {
        return scanner;
    }

    public MancalaGame getMancalaGame() {
        return mancalaGame;
    }
    
    public static void main(String[] args) {
        TextUI textUI = new TextUI();
        Scanner scan = textUI.getScanner();
        String userInput;
        System.out.println("Welcome to Mancala game.\nWe need information for the 2 players.");
        System.out.println("Player 1, enter your name:");
        userInput = scan.nextLine();
        Player p1 = new Player(userInput);
        System.out.println("\nPlayer 2, enter your name:");
        userInput = scan.nextLine();
        Player p2 = new Player(userInput);
        MancalaGame mancala = new MancalaGame();
        mancala.setPlayers(p1, p2);
        Board board = mancala.getBoard();
        board.registerPlayers(p1, p2);
        mancala.startNewGame();
        do {
            System.out.println("\n" + mancala.getCurrentPlayer().getName() + ", it is your turn!");
            textUI.printPits(mancala.getCurrentPlayer(), mancala.getPlayers());
            boolean invalidMove = false;
            int remaining = -1; 
            do {
                try {
                    int startPit = textUI.intCheck(scan);
                    remaining = mancala.move(startPit);
                    invalidMove = false;
                } catch(InvalidMoveException e) {
                    System.out.println("\n" + e.getMessage());
                    System.out.println("Enter a new value.");
                    invalidMove = true;
                }
            } while(invalidMove);
            if (mancala.getExtraTurnTriggered()) {
                System.out.println("Extra turn! " + mancala.getCurrentPlayer().getName() + " gets another turn.");
            } else {
                if (mancala.getCurrentPlayer().equals(mancala.getPlayers().get(0))) {
                    mancala.setCurrentPlayer(mancala.getPlayers().get(1));
                } else {
                    mancala.setCurrentPlayer(mancala.getPlayers().get(0));
                }
            }
            System.out.println(mancala.toString());  
        } while(!mancala.isGameOver());
        Player winner = textUI.determineWinner(mancala);
        System.out.println("Congratulations!\n" + winner.getName() + " won the game!");
        System.out.println(mancala.toString());
        System.out.println("Exiting game.");
        scan.close();
    }

    private int intCheck(Scanner scan) {
        boolean inputCheck = false;
        int movePit = -1;

        do {
            try {
                movePit = scan.nextInt();
                inputCheck = false;
            } catch(Exception ex) {
                System.out.println("Please enter an integer.");
                scan.nextLine();
                inputCheck = true;
            }
        } while(inputCheck);

        return movePit;
    }

    private Player determineWinner(MancalaGame mancala) {
        Player winner = null;

        try {
            winner = mancala.getWinner();
        } catch(GameNotOverException e) {
            System.out.println(e.getMessage());
        }

        return winner;
    }

    private void printPits(Player player, ArrayList<Player> players) {
        if(players.indexOf(player) == 0) {
            System.out.println("Choose from pits 1-6.");
        }
        if(players.indexOf(player) == 1) {
            System.out.println("Choose from pits 7-12.");
        }
    }
}