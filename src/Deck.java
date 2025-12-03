import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Deck {
    private final List<Card> cards;
    private final List<Card> discard = new ArrayList<>();

    public Deck(List<Card> cards) {
        this.cards = new ArrayList<>(cards);
        shuffle();
    }

    public void shuffle() {
        Collections.shuffle(cards);
    }

    public Card draw() {
        if (cards.isEmpty()) {
            // recycle discard into deck and reshuffle
            cards.addAll(discard);
            discard.clear();
            shuffle();
        }
        Card c = cards.remove(0);
        discard.add(c);
        return c;
    }
}
