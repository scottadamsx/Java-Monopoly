import java.util.Scanner;
public class Player {
    private String name;
    private int money;
    private Property[] properties;
    private BoardSpace location;
    private boolean inJail;
    private int jailTurns;

    public Player(String name) {
        this.name = name;
        this.money = 1500;
        this.properties = new Property[28];
        this.location = null;
    }
    public String getLocationName() {
        return location.getName();
    }
    public void getAction(Scanner input) {
        location.getAction(input, this);
    }
    public void payRent(Property property) {
        Player owner = property.getOwner();
        int rent = property.getRent();
        subtractMoney(rent);
        owner.addMoney(rent);
        System.out.println(getName() + " paid " + owner.getName() + " " + rent + " in rent!");
    }
    public void setInJail(boolean inJail) {
        this.inJail = inJail;
    }

    public boolean isInJail() {
        return this.inJail;
    }

    public void setJailTurns(int turns) {
        this.jailTurns = turns;
    }

    public int getJailTurns() {
        return this.jailTurns;
    }

    public int getLocation() {
        return location.getLocation();
    }
    public void setLocation(BoardSpace boardSpace) {
        location = boardSpace;
    }
    public void showProperties() {
        System.out.println("---- " + name + "'s Properties ----");

        boolean hasAny = false;
        for (int i = 0; i < properties.length; i++) {
            Property p = properties[i];
            if (p != null) {
                hasAny = true;
                String ownerName = (p.getOwner() == null) ? "None" : p.getOwner().getName();
                System.out.println((i + 1) + ". " + p.getName()
                        + " | Price: $" + p.getPrice()
                        + " | Rent: $" + p.getRent()
                        + " | Owner: " + ownerName);
            }
        }
        if (!hasAny) {
            System.out.println(name + " owns no properties.");
        }
        System.out.println("------------------------------");
    }

    
    
    public void buy(Property property) {
        if (this.money < property.getPrice()) {
            System.out.println("Not enough money to buy " + property.getName() + ".");
            return;
        }
        subtractMoney(property.getPrice());
        for (int i = 0; i < properties.length; i++) {
            if (properties[i] == null) {
                properties[i] = property;
                property.setOwner(this); // <-- keep ownership single-sourced
                return;
            }
        }
        System.out.println("Couldn't add property to inventory: array full.");
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
