import java.util.ArrayList;
import java.util.HashMap;

/**
 * this class is responsible for the players information
 * 
 * @author Douwe Klip
 * @version 1.0
 */
public class Player {

    // fields
    private Suit currentSuit = null;
    private HashMap<String, Item> inventory = new HashMap<String, Item>();
    private Room currentRoom;
    private ArrayList<Room> roomHistory = new ArrayList<Room>();
    private int inventoryVolume = 6;

    // methods

    /**
     * adds the current room to the room history
     */
    public void addRoomHistory() {
        roomHistory.add(currentRoom);
    }

    /**
     * gets the maximum vulome you can store in your inventory
     * 
     * @return the maximum inventory volume
     */
    public int getInventoryVolume() {
        return inventoryVolume;
    }

    /**
     * puts a given item in inventory
     * 
     * @param item this is the item that will be put in the inventory
     */
    public void putInInventory(Item item) {
        inventory.put(item.getDescription(), item);
    }

    /**
     * gets the room history
     * 
     * @return returns the room history
     */
    public ArrayList<Room> getRoomHistory() {
        return roomHistory;
    }

    /**
     * returns how much space is left in the inventory
     * 
     * @return returns how much space is left in the inventory
     */
    public int getInventorySpace() {
        int totalvolume = 0;
        for (String key : inventory.keySet()) {
            totalvolume += inventory.get(key).getVolume();
        }
        return totalvolume;
    }

    /**
     * set current room to new room
     * 
     * @param newRoom this is the new room currentRoom will be set to
     */
    public void setCurrentRoom(Room newRoom) {
        currentRoom = newRoom;
    }

    /**
     * set a new currentSuit
     * 
     * @param newSuit this is the new suit that currentSuit wil be set to
     */
    public void setCurrentSuit(Suit newSuit) {
        currentSuit = newSuit;
    }

    /**
     * removes an item from the players inventory with the given item description
     * 
     * @param itemDescription this is the description that will be used to remove
     *                        the item form the inventory
     */
    public void removeItem(String itemDescription) {
        inventory.remove(itemDescription);
    }

    /**
     * gets an item from inventory with the given discription
     * 
     * @param itemDescription this is the item description that wil be used to get
     *                        the item from the inventory
     * @return the item with the given description
     */
    public Item getItem(String itemDescription) {
        return inventory.get(itemDescription);
    }

    /**
     * gets all inventory items
     * 
     * @return a String with all the items that are in the play his inventory
     */
    public String GetInventoryItems() {
        String output = "";
        for (String key : inventory.keySet()) {
            output += inventory.get(key).getDescription() + "[" + inventory.get(key).getVolume() + "]" + ", ";

        }
        return output;
    }

    /**
     * gets current room
     * 
     * @return returns current room
     */
    public Room getCurrentRoom() {
        return currentRoom;
    }

    /**
     * gets current suit
     * 
     * @return returns current suit
     */
    public Suit getCurrentSuit() {
        return currentSuit;
    }
}
