//this class is responsible for suits

public class Suit {
    // fields
    private int maxOxygen;
    private int suitOxygen;
    private String description;
    private boolean airtight;
    private Item material = null;
    private String inspection;

    // constructor
    public Suit(String description, boolean airtight, String inspection, int maxOxygen) {
        this.description = description;
        this.airtight = airtight;
        this.inspection = inspection;
        this.suitOxygen = maxOxygen;
        this.maxOxygen = maxOxygen;
    }

    public void refilOxygen() {
        suitOxygen = maxOxygen;
    }

    public void loweroxygen() {
        suitOxygen--;
    }

    public int getSuitOxygen() {
        return suitOxygen;
    }

    public int getMaxOxygen() {
        return maxOxygen;
    }

    // methods
    public String getInspection() {
        return inspection;
    }

    public String getDescription() {
        return description;
    }

    public boolean getAitight() {
        return airtight;
    }

    public Item getMaterial() {
        return material;
    }

    public void setMaterial(Item material) {
        this.material = material;
    }
}