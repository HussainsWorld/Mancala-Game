package mancala;

public class Player {
    private String user;
    private Store userStore;

    public Player() {
        user = "";
        userStore = new Store();
    }

    public Player(String name) {
        setName(name);
        userStore = new Store();
    }

    public String getName() {
        return user;
    }

    public Store getStore() {
        return userStore;
    }

    public int getStoreCount() {
        return userStore.getTotalStones();
    }

    void setName(String name) {
        this.user = name;
    }
    void setStore(Store store) {
        this.userStore = store; 
    }

    public String toString() {
        return user;
    }
}