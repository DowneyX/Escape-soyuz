//this class is responsible for suits

public class Suit 
{
    private String description;
    private boolean airtight;
    private Item material = null;
    private String inspection;

    public Suit(String description, boolean airtight, String inspection)
    {
        this.description = description;
        this.airtight = airtight;
        this.inspection = inspection;
    }

    public String getInspection(){
        return inspection;
    }

    public String getDescription(){
        return description;
    }

    public boolean getAitight(){
        return airtight;
    }

    public Item getMaterial(){
        return material;
    }

    public void setMaterial(Item material){
        this.material = material;
    }
}