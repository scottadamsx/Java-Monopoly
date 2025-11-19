public class Player {
    private String name;
    private int money;
    private Property[] properties;
    private BoardSpace location;

    public Player(String name) {
        this.name = name;
        this.money = 1500;
        this.properties = new Property[28];
        this.location = null;
    }
    public String getLocationName() {
        return location.getName();
    }

    public int getLocation() {
        return location.getLocation();
    }
    public void setLocation(BoardSpace boardSpace) {
        location = boardSpace;
    }

    
    
    public void buy(Property property) {
        this.properties[0]= property;
        this.subtractMoney(property.getPrice());
        //print("this.name added property.name to properties");
    }

    public void addMoney(int amount) {
        this.money += amount;
    }

    public void subtractMoney(int amount) {
        this.money -= amount;
    }
    public String getName() {
        return this.name;
    }

}
