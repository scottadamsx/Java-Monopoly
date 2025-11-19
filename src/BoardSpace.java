import java.util.Scanner;
public class BoardSpace {
    private int location;
    private Property property;

    public BoardSpace(int location, Property property) {
        this.location = location;
        this.property = property;
    }
    public int getLocation() {
        return location;
    }
    public Property getProperty() {
        return property;
    }
    public String getName() {
        return property.getName();
    }
    public void getAction(Scanner input, Player player) {
        property.getAction(input, player);
    }

}
