package proj4;

import java.util.ArrayList;

/**
 * This class represents a set of community cards in a poker game.
 */
public class CommunityCardSet {
    private final ArrayList<Card> cards;

    private static final String CARD_SEPARATOR = " | ";

    /**
     * Constructs a CommunityCardSet with the specified list of cards.
     *
     * @param cards the list of cards to form the community card set.
     */
    public CommunityCardSet(ArrayList<Card> cards) {
        this.cards = new ArrayList<>(cards);
    }

    /**
     * Adds a card to the community card set.
     *
     * @param card the card to add to the set.
     */
    public void addCard(Card card) {
        cards.add(card);
    }

    /**
     * Returns the card at the specified index in the set.
     *
     * @param index the index of the card to return (0-based).
     * @return the card at the specified index.
     */
    public Card getIthCard(int index) {
        return cards.get(index);
    }

    /**
     * Returns a list of all cards in the community card set.
     *
     * @return a list of all cards in the community card set.
     */
    public ArrayList<Card> getCards() {
        return new ArrayList<>(cards);
    }

    /**
     * Returns a string representation of the community card set.
     *
     * @return a string representation of the community card set.
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Card card : cards) {
            sb.append(card.toString()).append(CARD_SEPARATOR);
        }
        return sb.toString();
    }
}