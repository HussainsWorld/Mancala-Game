package ai;

public class Store {
    private Player owner;
    private int stoneCount;

    public Store() {
        // Default constructor
    }

    public void setOwner(Player player) {
        owner = player;
    }

    public Player getOwner() {
        return owner;
    }

    public void addStones(int amount) {
        stoneCount += amount;
    }

    public int getTotalStones() {
        return stoneCount;
    }

    public int emptyStore() {
        int stonesInStore = stoneCount;
        stoneCount = 0;
        return stonesInStore;
    }

    @Override
    public String toString() {
        return "Store{" +
                "owner=" + owner +
                ", stoneCount=" + stoneCount +
                '}';
    }
}
