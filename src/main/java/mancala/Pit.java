package mancala;

public class Pit {
    private int stoneCount; 

    public Pit() {
        stoneCount = 0; 
    }

    void addStone() {
        stoneCount++;
    }

    int getStoneCount() {
        return stoneCount;
    }

    int removeStones() {
        int stoneRemoved = stoneCount;
        stoneCount = 0;
        return stoneRemoved;
    }

    public String toString() {
        return String.valueOf(stoneCount);  
    }
}