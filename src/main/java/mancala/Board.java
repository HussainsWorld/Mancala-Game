package mancala;

import java.util.ArrayList;

public class Board {

    private ArrayList<Pit> pits;
    private ArrayList<Store> stores;   
    private boolean extraTurnTriggered = false;

    public Board() {
        setUpPits();
        setUpStores();
    }

    void setUpPits() {
        pits = new ArrayList<>();
        for (int i = 0; i < 12; i++) {
            pits.add(new Pit());
        }
    }

    void countUpStones() {
        int counter = 0;
        for (Pit pit: pits) {
            counter += pit.getStoneCount();
            pit.removeStones();
        }
        try {
            if (isSideEmpty(1)) {
                stores.get(1).addStones(counter);
                
            } else if (isSideEmpty(7)) {
                stores.get(0).addStones(counter);
            }
        } catch (PitNotFoundException e){
            e.getMessage();
        }
    }

    void setUpStores() {
        stores = new ArrayList<>();
        for (int i = 0; i < 2; i++) {
            stores.add(new Store());
        }
    }

    public boolean getExtraTurnTriggered() {
        return extraTurnTriggered;
    }

    void setExtraTurnTriggered(boolean value) {
        extraTurnTriggered = value;
    }

    int captureStones(int stoppingPoint) throws PitNotFoundException {
        int captureStones = 0;
        int oppositeIndex = 12 - stoppingPoint + 1;
        if (stoppingPoint < 1 || stoppingPoint > pits.size()) {
            throw new PitNotFoundException();
        }
        if (pits.get(stoppingPoint - 1).getStoneCount() == 1 && pits.get(oppositeIndex - 1).getStoneCount() > 0) {
            captureStones = pits.get(stoppingPoint - 1).removeStones();
            captureStones += pits.get(oppositeIndex - 1).removeStones();
        }
        return captureStones;
    }

    int distributeStones(int startingPoint) throws PitNotFoundException {
        boolean lastStoneCheck = false;
        int playerCheck = 1;
        if (startingPoint < 1 || startingPoint > pits.size()) {
            throw new PitNotFoundException();
        }
        if (startingPoint > 6) {
            playerCheck = 2;
        }
        int stonesToDistribute = pits.get(startingPoint - 1).removeStones();
        int returnValue = stonesToDistribute;
        int currentIndex = startingPoint;
        while (stonesToDistribute > 0) {
            currentIndex = (currentIndex % pits.size()) + 1;
            if (currentIndex == 7 && playerCheck == 1) {
                stores.get(0).addStones(1);
                stonesToDistribute--;
                lastStoneCheck = true;
            } else if (currentIndex == 1 && playerCheck == 2) {
                stores.get(1).addStones(1);
                stonesToDistribute--;
                lastStoneCheck = true;
            }
            if (stonesToDistribute!= 0) {
                pits.get(currentIndex - 1).addStone();
                stonesToDistribute--;
                lastStoneCheck = false;
            }
        }
        if (pits.get(currentIndex - 1).getStoneCount() == 1 && !lastStoneCheck) {
            if ((playerCheck == 2 && currentIndex > 6 && currentIndex < 13) 
            || (playerCheck == 1 && currentIndex > 0 && currentIndex < 7)) {
                try {
                    int stonesCapped = captureStones(currentIndex);
                    stores.get(playerCheck-1).addStones(stonesCapped);
                } catch (PitNotFoundException e){
                    e.getMessage();
                }
            }
        }
        if (lastStoneCheck) {
            setExtraTurnTriggered(true);
        } else {
            setExtraTurnTriggered(false);
        }
        return returnValue;
    }

    int getNumStones(int pitNum) throws PitNotFoundException {
        if (pitNum < 1 || pitNum > pits.size()) {
            throw new PitNotFoundException();
        }
        return pits.get(pitNum - 1).getStoneCount();
    }

    public ArrayList<Pit> getPits() {
        return pits;
    }

    public ArrayList<Store> getStores() {
        return stores;
    }

    void initializeBoard() {
        for (Pit pit: pits) {
            for (int i = 0; i < 4; i++) {
                pit.addStone();
            }
        }
    }

    void resetBoard() {
        for (Pit pit: pits) {
            pit.removeStones();
        }
        for(Store store: stores) {
            store.emptyStore();
        }
        initializeBoard();
    }

    public boolean isSideEmpty(int pitNum) throws PitNotFoundException {
        if (pitNum < 1 || pitNum > pits.size()) {
            throw new PitNotFoundException();
        }
        int startIndex = 1;
        int endIndex = 6;
        if (pitNum > 6) {
            startIndex = 7;
            endIndex = 12;
        }
        for (int i = startIndex; i <= endIndex; i++) {
            if (pits.get(i - 1).getStoneCount() > 0) {
                return false;
            }
        }
        return true;
    }

    int moveStones(int startPit, Player player) throws InvalidMoveException {        
        if (startPit < 1 || startPit > pits.size()) {
            throw new InvalidMoveException();
        }
        if (pits.get(startPit - 1).getStoneCount() == 0) {
            throw new InvalidMoveException();
        }
        int playerIndex;
        if (startPit > 6) {
            playerIndex = 1;
        } else {
            playerIndex = 0;
        }
        if (!player.equals(stores.get(playerIndex).getOwner())) {
            throw new InvalidMoveException();
        }

        int totalStonesAdded = 0;
        int totalStonesBefore = 0;
        int totalStonesAfter = 0;    
        int storeCheck = 0;    
        if (startPit > 6) {
            storeCheck = 1;
        }
        totalStonesBefore += stores.get(storeCheck).getTotalStones();
        try {
            distributeStones(startPit);
        } catch (PitNotFoundException ex){
            ex.getMessage();
        }
        totalStonesAfter += stores.get(storeCheck).getTotalStones();

        totalStonesAdded = totalStonesAfter - totalStonesBefore;
        return totalStonesAdded;
    }

    public void registerPlayers(Player one, Player two) {
        stores.get(0).setOwner(one);
        stores.get(1).setOwner(two);
        one.setStore(stores.get(0));
        two.setStore(stores.get(1));
    }
    
    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();

        result.append("P2\n");
        for (int i = 12; i > 6; i--) {
            result.append(pits.get(i - 1).getStoneCount()).append(" ");
        }
        result.append("\n");

        for (int i = 0; i < 6; i++) {
            result.append(pits.get(i).getStoneCount()).append(" ");
        }
        result.append("\n");
        result.append("P1\n");

        return result.toString();
    }

}