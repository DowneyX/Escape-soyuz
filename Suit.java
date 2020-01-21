//

public class Suit 
{
    private String description;
    private boolean airtight;
    private Item material = null;

    public Suit(String description, boolean airtight)
    {
        this.description = description;
        this.airtight= airtight;
    }

    public String getDescription()
    {
        return description;
    }

    public boolean getAitight()
    {
        return airtight;
    }

    public Item getMaterial()
    {
        return material;
    }

    public void setMaterial(Item material)
    {
        this.material = material;
    }
}