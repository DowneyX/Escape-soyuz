/**
 * Navigation
 */
public class Object {

    String inspection;
    String description;

    public Object(String description, String inspection){
        this.description = description;
        this.inspection = inspection;
    }

    public String getInspection(){
        return inspection;
    }

    public String getDescription(){
        return description;
    }
}