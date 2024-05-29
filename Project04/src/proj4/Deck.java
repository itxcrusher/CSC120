package proj4;

import java.util.ArrayList;
import java.util.Collections;

/**
 * This class represents a deck of playing cards.
 */
public class Deck {
    private final ArrayList<Card> cards;

    private static final int START_RANK = 2;
    private static final int END_RANK = 14;
    private static final int NUM_SUITS = 4;

    /**
     * Default constructor that initializes a standard deck of 52 playing cards and shuffles it.
     */
    public Deck() {
        cards = new ArrayList<>();
        initializeDeck();
        shuffle();
    }

    /**
     * Shuffles the deck.
     */
    public void shuffle() {
        Collections.shuffle(cards);
    }

    /**
     * Deals a card from the deck.
     *
     * @return the dealt card, or null if the deck is empty.
     */
    public Card deal() {
        if (!cards.isEmpty()) {
            return cards.remove(cards.size() - 1);
        } else {
            return null;
        }
    }

    /**
     * Gathers all cards back into the deck and shuffles it.
     */
    public void gather() {
        cards.clear();
        initializeDeck();
        shuffle();
    }

    /**
     * Returns the number of cards in the deck.
     *
     * @return the number of cards in the deck.
     */
    public int size() {
        return cards.size();
    }

    /**
     * Checks if the deck is empty.
     *
     * @return true if the deck is empty, false otherwise.
     */
    public boolean isEmpty() {
        return cards.isEmpty();
    }

    /**
     * Returns a string representation of the deck.
     *
     * @return a string representation of the deck.
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Card card : cards) {
            sb.append(card.toString()).append("\n");
        }
        return sb.toString();
    }

    /**
     * Initializes the deck with a standard set of 52 playing cards.
     */
    private void initializeDeck() {
        for (int rank = START_RANK; rank <= END_RANK; rank++) {
            for (int suit = 0; suit < NUM_SUITS; suit++) {
                cards.add(new Card(rank, suit));
            }
        }
    }
}