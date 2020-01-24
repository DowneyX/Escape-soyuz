import java.util.HashMap;

/**
 * this clas is responsible for creating rooms
 * 
 * @author Douwe Klip
 * @version 1.0
 */

public class Room {
    // fields
    private String inspection;
    private boolean oxygen;
    private String description;
    private HashMap<String, Object> objects;
    private HashMap<String, Room> exits;
    private HashMap<String, Item> items;
    private HashMap<String, RepairableObject> repairables;

    // contstructor

    /**
     * creates rooms
     * 
     * @param description description if the room
     * @param oxygen      oxygen of the room
     * @param inspection  inspection of the room
     */
    public Room(String description, boolean oxygen, String inspection) {
        this.description = description;
        this.oxygen = oxygen;
        this.inspection = inspection;
        exits = new HashMap<>();
        items = new HashMap<>();
        repairables = new HashMap<>();
        objects = new HashMap<>();
    }

    /**
     * sets the exit
     * 
     * @param direction dirction of the exit
     * @param neighbor  where the exit direction goes tho
     */
    public void setExit(String direction, Room neighbor) {
        exits.put(direction, neighbor);
    }

    /**
     * returns the description of the room
     * 
     * @return returns the description of the room
     */
    public String getShortDescription() {
        return description;
    }

    /**
     * returns inspection of a room
     * 
     * @return returns inspection of a room
     */
    public String getInpection() {
        return inspection;
    }

    /**
     * returns a string of all the exits in a room
     * 
     * @return returns a string of all the exits in a room
     */
    public String getRoomExit() {
        String output = "";
        for (String key : exits.keySet()) {
            output += key + ", ";
        }
        return output;
    }

    /**
     * gets a room from a given direction
     * 
     * @param direction direction of the room
     * @return the room with that exit
     */
    public Room getExit(String direction) {
        return exits.get(direction);
    }

    /**
     * gets an item with a given description
     * 
     * @param itemDescription the given description used to find the item we want
     * @return the item with that description
     */
    public Item getItem(String itemDescription) {
        return items.get(itemDescription);
    }

    /**
     * gets an object with a given description
     * 
     * @param description the given description
     * @return the object with the given description
     */
    public Object getObject(String description) {
        return objects.get(description);
    }

    /**
     * sets an object to the room
     * 
     * @param object the object to be set to the room
     */
    public void setObject(Object object) {
        objects.put(object.getDescription(), object);
    }

    /**
     * Sets an item to the room
     * 
     * @param newitem the item that should be set to the room
     */
    public void setItem(Item newitem) {
        items.put(newitem.getDescription(), newitem);
    }

    /**
     * sets repairable object to the room
     * 
     * @param newRepairable repairableObject to be set to the room
     */
    public void setRepairable(RepairableObject newRepairable) {
        repairables.put(newRepairable.getDescription(), newRepairable);

    }

    /**
     * romoves an item from the room with given description
     * 
     * @param itemDescription description of item that should be removed
     */
    public void removeItem(String itemDescription) {
        items.remove(itemDescription);
    }

    /**
     * gets a string of all the objects in the room
     * 
     * @return returns a string of all the objects in the room
     */
    public String getRoomObjects() {
        String output = "";
        for (String key : objects.keySet()) {
            output += objects.get(key).getDescription() + ", ";
        }
        return output;
    }

    /**
     * returns the description of all the items in the room
     * 
     * @return returns the description of all the items in the room
     */
    public String getRoomItems() {
        String output = "";
        for (String key : items.keySet()) {
            output += items.get(key).getDescription() + ", ";
        }
        return output;
    }

    /**
     * gets a string of all the repairableObjects in the room
     * 
     * @return returns a string of all the repairableObjects in the room
     */
    public String getRoomRepairableObjects() {
        String output = "";
        for (String key : repairables.keySet()) {
            output += repairables.get(key).getDescription() + ", ";
        }
        return output;
    }

    /**
     * gets a repairable object from the room with the given description
     * 
     * @param itemDescription description of the RepairableObject
     * @return returns the repairabl object
     */
    public RepairableObject getRepairableObject(String itemDescription) {
        return repairables.get(itemDescription);
    }

    /**
     * romoves a Repairableobject from the room with a given description
     * 
     * @param description the description of the Repairableobject to be removed
     */
    public void removeRepairableObject(String description) {
        repairables.remove(description);
    }

    /**
     * checks if room has oxygen
     * 
     * @return true if room has oxygen false if it doenst
     */
    public boolean getOxygen() {
        return oxygen;
    }
}
