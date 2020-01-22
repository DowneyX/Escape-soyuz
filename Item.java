//this class is reponsible for the items

public class Item
{
    //fields
    private String description;
    private String inspection;
    private int volume;
    
    //constructor
    public Item(String description, int volume, String inspection){
        // initialise instance variables
        this.description = description;
        this.volume = volume;
        this.inspection = inspection;
    }
    
    //methods
    public String getDescription(){
        return description;
    }
    
    public int getVolume(){
        return volume;
    }

    public String getInspection(){
        return inspection;
    }
}
