import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CardManager {
    private static Deck chanceDeck;
    private static Deck chestDeck;
    private static Game game;         // set once on init
    private static Scanner scanner;   // set from Game so cards that want input can use it

    public static void init(Game g, Scanner sc) {
        game = g;
        scanner = sc;

        List<Card> chance = new ArrayList<>();
        chance.add(new CollectCard("Bank pays you dividend", 50));
        chance.add(new PayCard("Pay poor tax", 15));
        chance.add(new GoToSpaceCard("Advance to GO", 0));
        chance.add(new GoToJailCard("Go to Jail. Go directly to jail."));
        chanceDeck = new Deck(chance);

        List<Card> chest = new ArrayList<>();
        chest.add(new CollectCard("You inherit $100", 100));
        chest.add(new PayCard("Hospital fees", 50));
        chestDeck = new Deck(chest);
    }

    public static Deck getChanceDeck() { return chanceDeck; }
    public static Deck getChestDeck() { return chestDeck; }

    public static Card drawChance() { return chanceDeck.draw(); }
    public static Card drawChest() { return chestDeck.draw(); }

    public static Game getGame() { return game; }
    public static Scanner getScanner() { return scanner; }
}
