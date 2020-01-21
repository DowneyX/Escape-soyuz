import java.util.HashMap;

//this class is responsible for all of the rooms

public class Room 
{
    //stores if a room has oxygen or not
    private boolean oxygen;

    //stores the description of this room
    private String description;

    //stores exits of this room.
    private HashMap<String, Room> exits;

    //stores items in this room
    private HashMap<String, Item> items;

    //stores repaireble items in this room
    private HashMap<String, RepairableObject> repairables;

    //sets the description as description and initialises the exits hashmap
    public Room(String description, boolean oxygen)
    {
            this.description = description;
            this.oxygen = oxygen;
            exits = new HashMap<>();
            items = new HashMap<>();
            repairables = new HashMap<>();
    }

    //sets the the exits
    public void setExit(String direction, Room neighbor) 
    {
        exits.put(direction, neighbor);
    }

    //returns the description of the room
    public String getShortDescription()
    {
        return description;
    }

    //returns all the exists of a room
    public String getExitString()
    {
        String output = "";
        for(String key : exits.keySet())
        {
            output += key + ", " ;
        }
        return output;
    }

    //returns the room wich would lead to the given exit
    public Room getExit(String direction) 
    {
        return exits.get(direction);
    }
    
    //gets an item from a given description
    public Item getItem(String itemDescription)
    {
        return items.get(itemDescription);
    }
        
    //adds an item to the room
    public void setItem(Item newitem)
    {
        items.put(newitem.getDescription(),newitem);
    }

    public void setRepairable(RepairableObject newRepairable)
    {
        repairables.put(newRepairable.getDescription(),newRepairable);

    }
    
    // removes item from a room
    public void removeItem(String itemDescription)
    {
        items.remove(itemDescription);
    }
    
    //returns the description of all the items in the room
    public String getRoomItems()
    {
        String output = "";
        for(String key : items.keySet())
        {
            output += items.get(key).getDescription() + ", ";
        }
        return output;
    }

    public RepairableObject getRepairableObject(String itemDescription) 
    {
		return repairables.get(itemDescription);
    }
    
    public void removeRepairableObject(String description)
    {
        repairables.remove(description);
    }

	public boolean getOxygen() {
		return oxygen;
	}
}

