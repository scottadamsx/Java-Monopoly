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
        String ln = name.toLowerCase().trim();

        if (ln.contains("chance")) {
            Card c = CardManager.drawChance();
            System.out.println("Chance: " + c.getText());
            c.apply(player);
            return;
        }
        if (ln.contains("community chest")) {
            Card c = CardManager.drawChest();
            System.out.println("Community Chest: " + c.getText());
            c.apply(player);
            return;
        }

        // Go To Jail
        if (ln.contains("go to jail")) {
            System.out.println(player.getName() + " landed on " + name + ". TODO: send player to jail.");
            return;
        }

        // Jail / Just Visiting
        if (ln.contains("jail")) {
            System.out.println(player.getName() + " landed on " + name + " (Just Visiting).");
            return;
        }

        // Taxes
        if (ln.contains("income tax")) {
            int tax = 200; // example flat tax
            player.subtractMoney(tax);
            System.out.println(player.getName() + " paid $" + tax + " in Income Tax.");
            return;
        }
        if (ln.contains("luxury tax")) {
            int tax = 100;
            player.subtractMoney(tax);
            System.out.println(player.getName() + " paid $" + tax + " in Luxury Tax.");
            return;
        }

        // Free Parking / GO (no purchase)
        if (ln.contains("free parking")) {
            System.out.println(player.getName() + " landed on Free Parking.");
            return;
        }
        if (ln.equals("go")) {
            System.out.println(player.getName() + " landed on GO.");
            return;
        }

        // Normal property logic: only attempt purchase/rent for real properties
        if (owner == null) {
            // defensive: if price is 0 treat as non-purchasable
            if (price <= 0) {
                System.out.println(player.getName() + " landed on " + name + ".");
                return;
            }

            System.out.println(player.getName() + ", do you want to buy " + name + " for $" + price + "? (y/n)");
            String choice = input.nextLine();
            if (choice != null && choice.trim().equalsIgnoreCase("y")) {
                // delegate purchase to player so player's buy() handles money + inventory
                player.buy(this);

                // ensure ownership is consistent (in case player.buy doesn't set owner)
                if (this.owner == null) {
                    this.owner = player;
                }

                System.out.println(player.getName() + " bought " + name + " for $" + price);
            } else {
                System.out.println(player.getName() + " chose not to buy " + name + ".");
            }
        } else {
            System.out.println("This property is owned by " + owner.getName());
            player.payRent(this);
        }
    }
    public void setOwner(Player p) {
        this.owner = p;
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
