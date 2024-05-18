package proj3; // do not erase. Gradescope expects this.

import java.util.ArrayList;
import java.util.Collections;
import java.util.concurrent.ThreadLocalRandom;
/**
 * Represents a deck of playing cards.
 */
public class Deck {
    private static final int START_INDEX = 0;
    /**
     * List of cards in the deck.
     */
    private final ArrayList<Card> cards;

    /**
     * Index of the next card to deal.
     */
    private int nextToDeal;

    /**
     * Constructs a new deck of 52 playing cards.
     */
    public Deck() {
        String[] suits = {"Spades", "Hearts", "Diamonds", "Clubs"};
        int[] ranks = {2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14};
        cards = new ArrayList<>();
        for (String suit : suits) {
            for (int rank : ranks) {
                cards.add(new Card(rank, suit));
            }
        }
        shuffle();
    }
    /**
     * Shuffles the deck of cards.
     */
    public void shuffle() {
        for (int i = nextToDeal; i < cards.size(); i++) {
            int randomIndex = ThreadLocalRandom.current().nextInt(nextToDeal, cards.size());
            Collections.swap(cards, i, randomIndex);
        }
        nextToDeal = START_INDEX;
    }
    /**
     * Deals the next un dealt card from the deck.
     *
     * @return The next un dealt card or null if the deck is empty.
     */
    public Card deal() {
        if (nextToDeal < cards.size()) {
            return cards.get(nextToDeal++);
        }
        return null;
    }
    /**
     * Returns the number of un dealt cards in the deck.
     *
     * @return The number of un dealt cards in the deck.
     */
    public int size() {
        return cards.size() - nextToDeal;
    }

    /**
     * Gathers all cards back to the deck, making them all un dealt.
     */
    public void gather() {
        nextToDeal = START_INDEX;
    }

    /**
     * Returns a string representation of all un dealt cards in the deck.
     *
     * @return A string representation of all un dealt cards in the deck.
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = nextToDeal; i < cards.size(); i++) {
            sb.append(cards.get(i).toString()).append("\n");
        }
        return sb.toString();
    }
}