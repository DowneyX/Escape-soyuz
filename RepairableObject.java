/**
 * this class is responsible for the players information
 * 
 * @author Douwe Klip
 * @version 1.0
 */

public class RepairableObject {

    // fields
    private String description;
    private Item material;
    private Item tool;
    private String inspection;
    private Object replaceObject;

    // constructor

    /**
     * creates Repairabl object
     * 
     * @param description description of repairable object
     * @param material    material that is used to repair repairable object
     * @param tool        tool that will be used to repair object
     * @param inspection  the inspection of te object
     */
    public RepairableObject(String description, Item material, Item tool, String inspection) {
        this.description = description;
        this.material = material;
        this.tool = tool;
        this.inspection = inspection;
    }

    // methods

    /**
     * sets a replaceable object
     * 
     * @param object object that will replace repairable object when repaired
     */
    public void setReplaceObject(Object object) {
        this.replaceObject = object;
    }

    /**
     * gets te replacable object
     * 
     * @return returns replacebale object
     */
    public Object getReplaceObject() {
        return replaceObject;
    }

    /**
     * gets inspection of the RepairableObject
     * 
     * @return returns inspection of the RepairableObject
     */
    public String getInspection() {
        return inspection;
    }

    /**
     * gets description
     * 
     * @return returns the description of RepairableObject
     */
    public String getDescription() {
        return description;
    }

    /**
     * gets the material that is used to repair the RepairableObject
     * 
     * @return returns the material that will be use to repait the RepairableObject
     */
    public Item getMaterial() {
        return material;
    }

    /**
     * gets tool that will be use to repair the repairable object
     * 
     * @return returns tool that will be used to repair the RepairableObject
     */
    public Item getTool() {
        return tool;
    }
}