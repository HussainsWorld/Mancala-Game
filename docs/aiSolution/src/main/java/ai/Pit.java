package ai;

public class Pit {
    private int stoneCount;

    public Pit() {
        // Default constructor
    }

    public int getStoneCount() {
        return stoneCount;
    }

    public void addStone() {
        stoneCount++;
    }

    public int removeStones() {
        int stonesRemoved = stoneCount;
        stoneCount = 0;
        return stonesRemoved;
    }

    @Override
    public String toString() {
        return "Pit{" +
                "stoneCount=" + stoneCount +
                '}';
    }
}
