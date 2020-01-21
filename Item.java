/**
 * this is the game class
 * this contains the entire game
 *
 * @author Douwe Klip
 * @version 08/01/2020
 */
public class Item
{
    //fields
    private String description;
    private int volume;
    
    //constructor
    public Item(String newDescription, int newVolume)
    {
        // initialise instance variables
        description = newDescription;
        volume = newVolume;
    }
    
    //methods
    public String getDescription()
    {
        return description;
    }
    
    public int getVolume()
    {
        return volume;
    }
}
