package proj4;

import java.util.ArrayList;

/**
 * This class represents a stud poker hand that includes community cards and hole cards.
 */
public class StudPokerHand {
    private final CommunityCardSet communityCards;
    private final ArrayList<Card> holeCards;

    private static final int HAND_SIZE = 5;
    private static final int START_INDEX = 0;
    private static final int INITIAL_BEST_HAND_INDEX = 0;
    private static final int NEXT_INDEX_OFFSET = 1;
    private static final int INITIAL_CURRENT_SIZE = 0;
    private static final String CARD_SEPARATOR = " | ";

    /**
     * Constructs a StudPokerHand with the specified community cards and hole cards.
     *
     * @param cc       the community card set.
     * @param cardList the list of hole cards.
     */
    public StudPokerHand(CommunityCardSet cc, ArrayList<Card> cardList) {
        this.communityCards = cc;
        this.holeCards = new ArrayList<>(cardList);
    }

    /**
     * Adds a card to the 2-card hand.
     *
     * @param card the card to add.
     */
    public void addCard(Card card) {
        holeCards.add(card);
    }

    /**
     * Returns the card at the specified index from the 2-card hand.
     *
     * @param index the index of the card to return (0-based).
     * @return the card at the specified index.
     */
    public Card getIthCard(int index) {
        return holeCards.get(index);
    }

    /**
     * Returns a string representation of the stud poker hand, including community cards.
     *
     * @return a string representation of the stud poker hand.
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Hole cards: ");
        for (Card card : holeCards) {
            sb.append(card.toString()).append(CARD_SEPARATOR);
        }
        sb.append("Community cards: ").append(communityCards.toString());
        return sb.toString();
    }

    /**
     * Compares this stud poker hand with another to determine which is better.
     *
     * @param other the stud poker hand to compare with.
     * @return a negative number if this hand is worth less than the other hand,
     *         zero if they are worth the same, and a positive number if this hand is worth more than the other hand.
     */
    public int compareTo(StudPokerHand other) {
        PokerHand thisBestHand = getBestFiveCardHand();
        PokerHand otherBestHand = other.getBestFiveCardHand();
        return thisBestHand.compareTo(otherBestHand);
    }

    /**
     * Generates all possible 5-card hands from the 7 available cards (community + hole cards).
     *
     * @return a list of all possible 5-card hands.
     */
    private ArrayList<PokerHand> getAllFiveCardHands() {
        ArrayList<PokerHand> hands = new ArrayList<>();
        ArrayList<Card> combinedCards = new ArrayList<>(holeCards);
        combinedCards.addAll(communityCards.getCards());

        generateCombinations(combinedCards, hands, START_INDEX, new ArrayList<>());

        return hands;
    }

    /**
     * Finds the best 5-card hand from all possible 5-card hands.
     *
     * @return the best 5-card hand.
     */
    private PokerHand getBestFiveCardHand() {
        ArrayList<PokerHand> hands = getAllFiveCardHands();
        PokerHand bestSoFar = hands.get(INITIAL_BEST_HAND_INDEX);
        for (int i = NEXT_INDEX_OFFSET; i < hands.size(); i++) {
            if (hands.get(i).compareTo(bestSoFar) > INITIAL_CURRENT_SIZE) {
                bestSoFar = hands.get(i);
            }
        }
        return bestSoFar;
    }

    /**
     * Recursively generates all 5-card combinations from the given list of cards.
     *
     * @param cards   the list of cards to generate combinations from.
     * @param hands   the list to store the generated 5-card hands.
     * @param start   the starting index for the combination generation.
     * @param current the current combination being generated.
     */
    private void generateCombinations(ArrayList<Card> cards, ArrayList<PokerHand> hands, int start, ArrayList<Card> current) {
        if (current.size() == HAND_SIZE) {
            hands.add(new PokerHand(current));
            return;
        }
        for (int i = start; i < cards.size(); i++) {
            current.add(cards.get(i));
            generateCombinations(cards, hands, i + NEXT_INDEX_OFFSET, new ArrayList<>(current));
            current.remove(current.size() - NEXT_INDEX_OFFSET);
        }
    }
}