import java.util.ArrayList;
import java.util.HashMap;

//this class stores and returns all information about the player

public class Player
{
    public Suit currentsuit = null;

    //stored items in inventory
    public HashMap<String,Item> inventory = new HashMap<String,Item>();

    //stores the player his current room
    public Room currentRoom;
    public ArrayList<Room> roomHistory = new ArrayList<Room>();

    //maximum amount of inventory space
    public int inventoryVolume = 6;

    // returns the total amount of space being taken up in the player his inventory
    public int getInventoryVolume()
    {
        int totalvolume = 0;
        for (String key : inventory.keySet())
        {
            totalvolume += inventory.get(key).getVolume();
        }
        return totalvolume;
    }
    
    //removes an item
    public void removeItem(String itemDescription)
    {
        inventory.remove(itemDescription);
    }
    
    //returns a given item
    public Item getItem(String itemDescription)
    {
        return inventory.get(itemDescription);
    }

	public Suit getSuit(String secondword) {
        String des = currentsuit.getDescription();
        if (des == secondword)
        {
            return currentsuit;
        }else
        {
            return null;
        }
	}
}
