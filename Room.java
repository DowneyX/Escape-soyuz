import java.util.HashMap;

//this class is responsible for all of the rooms

public class Room 
{
    private String inspection;
    private boolean oxygen;
    private String description;
    private HashMap<String, Object> objects;
    private HashMap<String, Room> exits;
    private HashMap<String, Item> items;
    private HashMap<String, RepairableObject> repairables;

    //contstructor
    public Room(String description, boolean oxygen, String inspection)
    {
            this.description = description;
            this.oxygen = oxygen;
            this.inspection = inspection;
            exits = new HashMap<>();
            items = new HashMap<>();
            repairables = new HashMap<>();
            objects = new HashMap<>();
    }

    //sets the the exits
    public void setExit(String direction, Room neighbor){
        exits.put(direction, neighbor);
    }

    //returns the description of the room
    public String getShortDescription(){
        return description;
    }

    public String getInpection(){
        return inspection;
    }

    //returns all the exists of a room
    public String getRoomExit(){
        String output = "";
        for(String key : exits.keySet())
        {
            output += key + ", " ;
        }
        return output;
    }

    //returns the room wich would lead to the given exit
    public Room getExit(String direction){
        return exits.get(direction);
    }
    
    //gets an item from a given description
    public Item getItem(String itemDescription){
        return items.get(itemDescription);
    }

    //gets the given usable objects
    public Object getObject(String description){
        return objects.get(description);
    }

    public void setObject(Object object){
        objects.put(object.getDescription(), object);
    }
        
    //adds an item to the room
    public void setItem(Item newitem){
        items.put(newitem.getDescription(),newitem);
    }

    public void setRepairable(RepairableObject newRepairable){
        repairables.put(newRepairable.getDescription(),newRepairable);

    }
    
    // removes item from a room
    public void removeItem(String itemDescription){
        items.remove(itemDescription);
    }

    public String getRoomObjects(){
        String output = "";
        for (String key : objects.keySet()){
            output += objects.get(key).getDescription() +", ";
        }
        return output;
    }
    
    //returns the description of all the items in the room
    public String getRoomItems(){
        String output = "";
        for(String key : items.keySet()){
            output += items.get(key).getDescription() + ", ";
        }
        return output;
    }

    public String getRoomRepairableObjects(){
        String output = "";
        for(String key : repairables.keySet()){
            output += repairables.get(key).getDescription() + ", ";
        }
        return output;
    }

    public RepairableObject getRepairableObject(String itemDescription){
		return repairables.get(itemDescription);
    }
    
    public void removeRepairableObject(String description){
        repairables.remove(description);
    }

	public boolean getOxygen() {
		return oxygen;
	}
}

