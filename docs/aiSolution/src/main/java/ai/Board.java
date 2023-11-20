package ai;

import java.util.ArrayList;

public class Board {
    private ArrayList<Pit> pits;
    private ArrayList<Store> stores;

    public Board() {
        setUpPits();
        setUpStores();
        initializeBoard();
    }

    public void setUpPits() {
        pits = new ArrayList<>();
        for (int i = 0; i < 12; i++) {
            pits.add(new Pit());
        }
    }

    public ArrayList<Pit> getPits() {
        return new ArrayList<>(pits.subList(0, 12));
    }

    public ArrayList<Store> getStores() {
        return new ArrayList<>(stores);
    }

    public void setUpStores() {
        stores = new ArrayList<>();
        for (int i = 0; i < 2; i++) {
            stores.add(new Store());
        }
    }

    public void initializeBoard() {
        // Implementation to distribute stones initially goes here
    }

    public void resetBoard() {
        initializeBoard();
    }

    public void registerPlayers(Player one, Player two) {
        stores.get(0).setOwner(one);
        stores.get(1).setOwner(two);
        one.setStore(stores.get(0));
        two.setStore(stores.get(1));
    }

    public int moveStones(int startPit, Player player) throws InvalidMoveException {
        // Implementation for moving stones goes here
        return 0; // Placeholder
    }

    public int distributeStones(int startingPoint) throws PitNotFoundException {
        // Implementation for distributing stones goes here
        return 0; // Placeholder
    }

    public int captureStones(int stoppingPoint) throws PitNotFoundException {
        // Implementation for capturing stones goes here
        return 0; // Placeholder
    }

    public int getNumStones(int pitNum) throws PitNotFoundException {
        // Implementation for getting the number of stones in a specific pit goes here
        return 0; // Placeholder
    }

    public boolean isSideEmpty(int pitNum) throws PitNotFoundException {
        // Implementation for checking if one side of the board is empty goes here
        return false; // Placeholder
    }

    @Override
    public String toString() {
        // Implementation for toString method goes here
        return "Board{" +
                "pits=" + pits +
                ", stores=" + stores +
                '}';
    }
}
