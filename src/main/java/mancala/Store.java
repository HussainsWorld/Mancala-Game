package mancala;

public class Store {
    private int totalStones;
    private Player owner; 

    public Store() {
        totalStones = 0;
        owner = null;
    } 

    void addStones(int amount) {
        this.totalStones += amount;
    }

    int emptyStore() {
        int stones = this.totalStones;
        this.totalStones = 0;
        return stones; 
    }

    Player getOwner() {
        return owner;
    }

    int getTotalStones() {
        return totalStones;
    }

    void setOwner(Player player) {
        this.owner = player;
    }

    public String toString() {
        return String.valueOf(totalStones);
    }
}