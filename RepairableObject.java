// this class is responsible for repairable objects

public class RepairableObject {

    private String description;
    private Item material;
    private Item tool;
    private String inspection;
    private Object replaceObject;

    public RepairableObject(String description, Item material, Item tool, String inspection) {
        this.description = description;
        this.material = material;
        this.tool = tool;
        this.inspection = inspection;
    }

    public void setReplaceObject(Object object) {
        this.replaceObject = object;
    }

    public Object getReplaceObject() {
        return replaceObject;
    }

    public String getInspection() {
        return inspection;
    }

    public void setMaterial(Item material) {
        this.material = material;
    }

    public void setTool(Item tool) {
        this.tool = tool;
    }

    public String getDescription() {
        return description;
    }

    public Item getMaterial() {
        return material;
    }

    public Item getTool() {
        return tool;
    }
}