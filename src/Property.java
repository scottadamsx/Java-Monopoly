import java.util.Scanner;
public class Property {
    private String name;
    private int rent;
    private int price;
    private ColorSet colorSet;
    private Player owner;
    private int houses;
    private int morgagePrice;

    public Property(String name, int price, ColorSet colorSet, int rent, int morgagePrice) {
        this.name = name;
        this.price = price;
        this.colorSet = colorSet;
        this.rent = rent;
        this.owner = null;
        this.houses = 0;
        this.morgagePrice = morgagePrice;
    }
    public void getAction(Scanner input, Player player) {
        if (owner == null) {
            owner = player;
            player.subtractMoney(price);
            System.out.println(player.getName() + " bought " + name + " for " + price);
        }
        else {
            System.out.println("this property is owned by" + owner);
            player.payRent(this);
        }
    }
    public int getRent() {
        return rent;
    }
    public Player getOwner() {
        return owner;
    }
    
    public int getPrice() {
        return this.price;
    }
    public String getName() {
        return name;
    }

    public void morgage() {
    // subtract morgage value from owner
    // sent rent to 0
    }

}
