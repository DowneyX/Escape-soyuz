// this class is responsible for repairable objects

public class RepairableObject {

    private String description;
    private Item material;
    private Item tool;
    private String inspection;

    public RepairableObject (String description, Item material, Item tool, String inspection )
    {
        this.description = description;
        this.material = material;
        this.tool = tool;
        this.inspection = inspection;
    }

    public String getInspection(){
        return inspection;
    }

    public void setMaterial(Item material){
        this.material = material;
    }

    public void setTool(Item tool){
        this.tool = tool;
    }

    public String getDescription(){
        return description;
    }

    public Item getMaterial(){
        return material;
    }

	public Item getTool() {
		return tool;
	}
}