/**
 * this class is responsible for the creation of items
 * 
 * @author Douwe Klip
 * @version 1.0
 */

public class Item {
    // fields
    private String description;
    private String inspection;
    private int volume;

    // constructor

    /**
     * creates an item
     * 
     * @param description the items given description
     * @param volume      the items given volume it takes up
     * @param inspection  the items given inspection string
     */
    public Item(String description, int volume, String inspection) {
        this.description = description;
        this.volume = volume;
        this.inspection = inspection;
    }

    // methods

    /**
     * 
     * @return returns the description of an item
     */
    public String getDescription() {
        return description;
    }

    /**
     * 
     * @return returns the volume of an item
     */
    public int getVolume() {
        return volume;
    }

    /**
     * 
     * @return returns the inspection of an item
     */
    public String getInspection() {
        return inspection;
    }
}
