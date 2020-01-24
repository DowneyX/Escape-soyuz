import java.util.ArrayList;
import java.util.HashMap;

//this class stores and returns all information about the player

public class Player {
    private Suit currentSuit = null;
    private HashMap<String, Item> inventory = new HashMap<String, Item>();
    private Room currentRoom;
    private ArrayList<Room> roomHistory = new ArrayList<Room>();
    private int inventoryVolume = 6;

    // methods
    public void addRoomHistory() {
        roomHistory.add(currentRoom);
    }

    public int getInventoryVolume() {
        return inventoryVolume;
    }

    public void putInInventory(Item item) {
        inventory.put(item.getDescription(), item);
    }

    public ArrayList<Room> getRoomHistory() {
        return roomHistory;
    }

    public int getInventorySpace() {
        int totalvolume = 0;
        for (String key : inventory.keySet()) {
            totalvolume += inventory.get(key).getVolume();
        }
        return totalvolume;
    }

    public void setCurrentRoom(Room newRoom) {
        currentRoom = newRoom;
    }

    public void setCurrentSuit(Suit newSuit) {
        currentSuit = newSuit;
    }

    // removes an item
    public void removeItem(String itemDescription) {
        inventory.remove(itemDescription);
    }

    // returns a given item
    public Item getItem(String itemDescription) {
        return inventory.get(itemDescription);
    }

    public String GetInventoryItems() {
        String output = "";
        for (String key : inventory.keySet()) {
            output += inventory.get(key).getDescription() + "[" + inventory.get(key).getVolume() + "]" + ", ";

        }
        return output;
    }

    public Suit getSuit(String secondword) {
        String des = currentSuit.getDescription();
        if (des == secondword) {
            return currentSuit;
        } else {
            return null;
        }
    }

    public Room getCurrentRoom() {
        return currentRoom;
    }

    public Suit getCurrentSuit() {
        return currentSuit;
    }
}
