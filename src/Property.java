public class Property {
    private String name;
    private int price;
    private ColorSet colorSet;
    private Player owner;
    private int houses;
    private int morgagePrice;

    public Property(String name, int price, ColorSet colorSet, int morgagePrice) {
        this.name = name;
        this.price = price;
        this.colorSet = colorSet;
        this.owner = null;
        this.houses = 0;
        this.morgagePrice = morgagePrice;
    }
    public int getPrice() {
        return this.price;
    }

    public void morgage() {
    // subtract morgage value from owner
    // sent rent to 0

    }

}
