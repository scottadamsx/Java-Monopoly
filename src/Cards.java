// simple card implementations; keep in one file for now
class CollectCard implements Card {
    private final String text;
    private final int amount;
    public CollectCard(String text, int amount) { this.text = text; this.amount = amount; }
    public String getText() { return text; }
    public void apply(Player player) {
        player.addMoney(amount);
        System.out.println(player.getName() + " receives $" + amount + ": " + text);
    }
}

class PayCard implements Card {
    private final String text;
    private final int amount;
    public PayCard(String text, int amount) { this.text = text; this.amount = amount; }
    public String getText() { return text; }
    public void apply(Player player) {
        player.subtractMoney(amount);
        System.out.println(player.getName() + " pays $" + amount + ": " + text);
    }
}

class GoToSpaceCard implements Card {
    private final String text;
    private final int target;
    public GoToSpaceCard(String text, int target) { this.text = text; this.target = target; }
    public String getText() { return text; }
    public void apply(Player player) {
        System.out.println(text);
        Game g = CardManager.getGame();
        if (g != null) {
            g.movePlayerToIndex(player, target);
        }
    }
}

class GoToJailCard implements Card {
    private final String text;
    public GoToJailCard(String text) { this.text = text; }
    public String getText() { return text; }
    public void apply(Player player) {
        System.out.println(text);
        Game g = CardManager.getGame();
        if (g != null) {
            g.sendPlayerToJail(player);
        }
    }
}

