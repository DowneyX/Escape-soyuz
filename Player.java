import java.util.ArrayList;
import java.util.HashMap;

//this class stores and returns all information about the player

public class Player
{
    public int Suitoxygen = 7;
    public Suit currentsuit = null;
    public HashMap<String,Item> inventory = new HashMap<String,Item>();
    public Room currentRoom;
    public ArrayList<Room> roomHistory = new ArrayList<Room>();
    public int inventoryVolume = 6;

    //methods
    public int getInventoryVolume()
    {
        int totalvolume = 0;
        for (String key : inventory.keySet()){
            totalvolume += inventory.get(key).getVolume();
        }
        return totalvolume;
    }
    
    //removes an item
    public void removeItem(String itemDescription){
        inventory.remove(itemDescription);
    }
    
    //returns a given item
    public Item getItem(String itemDescription){
        return inventory.get(itemDescription);
    }
    public String GetInventoryItems(){
    String output = "";
        for (String key : inventory.keySet()) {
            output += inventory.get(key).getDescription() +"["+inventory.get(key).getVolume()+"]" + ", ";
            
        }
        return output;
    }
	public Suit getSuit(String secondword) {
        String des = currentsuit.getDescription();
        if (des == secondword){
            return currentsuit;
        }else{
            return null;
        }
	}
}
