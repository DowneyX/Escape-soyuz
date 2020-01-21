/**
 * RepairableObjects
 */
public class RepairableObject {

    private String description;
    private Item material;
    private Item tool;

    public RepairableObject (String description, Item material, Item tool )
    {
        this.description = description;
        this.material = material;
        this.tool = tool;
    }

    /**
     * @param material the material to set
     */
    public void setMaterial(Item material) 
    {
        this.material = material;
    }

    /**
     * @param tool the tool to set
     */
    public void setTool(Item tool) 
    {
        this.tool = tool;
    }

    /**
     * @return the description
     */
    public String getDescription() 
    {
        return description;
    }

    public Item getMaterial()
    {
        return material;
    }

	public Item getTool() {
		return tool;
	}
}