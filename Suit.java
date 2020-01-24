/**
 * this clas is responsible for creating rooms
 * 
 * @author Douwe Klip
 * @version 1.0
 */

public class Suit {
    // fields
    private int maxOxygen;
    private int suitOxygen;
    private String description;
    private boolean airtight;
    private Item material = null;
    private String inspection;

    // constructor

    /**
     * crates a suit
     * 
     * @param description description of the suit
     * @param airtight    true or false depending if suit is airtight
     * @param inspection  inspection of a suit
     * @param maxOxygen   maximum oxigen of the suit
     */
    public Suit(String description, boolean airtight, String inspection, int maxOxygen) {
        this.description = description;
        this.airtight = airtight;
        this.inspection = inspection;
        this.suitOxygen = maxOxygen;
        this.maxOxygen = maxOxygen;
    }

    // methods

    /**
     * set suitOxygen to maxOxygen
     */
    public void refilOxygen() {
        suitOxygen = maxOxygen;
    }

    /**
     * lowers the oxygen by 1
     */
    public void loweroxygen() {
        suitOxygen--;
    }

    /**
     * gets suitOxygen
     * 
     * @return returns suit oxygen
     */
    public int getSuitOxygen() {
        return suitOxygen;
    }

    /**
     * gets maxOxygen
     * 
     * @return returns max oxygen
     */
    public int getMaxOxygen() {
        return maxOxygen;
    }

    /**
     * gets inspection of the suit
     * 
     * @return returns the inspection of the suit
     */
    public String getInspection() {
        return inspection;
    }

    /**
     * gets description of the suit
     * 
     * @return returns the description of the suit
     */
    public String getDescription() {
        return description;
    }

    /**
     * checks if suit is airtight
     * 
     * @return returns true or false depending if suit is airtight
     */
    public boolean getAitight() {
        return airtight;
    }

    /**
     * gets the material used to repair the suit
     * 
     * @return ruterns the material used to repair the suit
     */
    public Item getMaterial() {
        return material;
    }

    /**
     * sets material used to repair the suit to given material
     * 
     * @param material given material used to repair the suit
     */
    public void setMaterial(Item material) {
        this.material = material;
    }
}