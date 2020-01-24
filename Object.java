/**
 * this class is responsible for creating objects
 */
public class Object {

    // fields
    String inspection;
    String description;

    // constructor

    /**
     * creates objects
     * 
     * @param description
     * @param inspection
     */
    public Object(String description, String inspection) {
        this.description = description;
        this.inspection = inspection;
    }

    // methods

    /**
     * gets the object its inspection
     * 
     * @return returns the object inspection
     */
    public String getInspection() {
        return inspection;
    }

    /**
     * gets the object description
     * 
     * @return returns object description
     */
    public String getDescription() {
        return description;
    }
}