package proj4;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;

/**
 * This class represents a Poker Hand and provides methods to evaluate and compare hands.
 */
public class PokerHand implements Comparable<PokerHand> {

    private static final int START_INDEX = 0;
    private static final int HAND_SIZE = 5;
    private static final int RANK_HIGH_CARD = 0;
    private static final int RANK_ONE_PAIR = 1;
    private static final int RANK_TWO_PAIR = 2;
    private static final int RANK_THREE_OF_A_KIND = 3;
    private static final int RANK_STRAIGHT = 4;
    private static final int RANK_FLUSH = 5;

    private final ArrayList<Card> hand;

    /**
     * Constructs a PokerHand with the specified list of cards.
     *
     * @param cardList The list of cards to form the hand.
     * @throws IllegalArgumentException if the cardList does not contain exactly 5 cards.
     */
    public PokerHand(ArrayList<Card> cardList) {
        if (cardList.size() != HAND_SIZE) {
            throw new IllegalArgumentException("A poker hand must consist of exactly " + HAND_SIZE + " cards.");
        }
        this.hand = new ArrayList<>(cardList);
        this.hand.sort(Comparator.comparingInt(Card::getRank).reversed());
    }

    /**
     * Adds a card to the hand if it has less than 5 cards.
     *
     * @param card The card to add to the hand.
     */
    public void addCard(Card card) {
        if (hand.size() < HAND_SIZE) {
            hand.add(card);
        }
    }

    /**
     * Returns the card at the specified index in the hand.
     *
     * @param index The index of the card to return (0-based).
     * @return The card at the specified index, or null if the index is invalid.
     */
    public Card getIthCard(int index) {
        if (index >= START_INDEX && index < hand.size()) {
            return hand.get(index);
        }
        return null;
    }

    /**
     * Returns a string representation of the hand.
     *
     * @return A string representation of the hand.
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Card card : hand) {
            sb.append(card.toString()).append("\n");
        }
        return sb.toString();
    }

    /**
     * Compares this hand with another hand to determine which is better.
     *
     * @param other The hand to compare this hand to.
     * @return A negative number if this hand is worth less than the other hand,
     *         zero if they are worth the same, and a positive number if this hand is worth more than the other hand.
     */
    @Override
    public int compareTo(PokerHand other) {
        HandRank myRank = evaluateHand();
        HandRank theirRank = other.evaluateHand();
        if (myRank.rank == theirRank.rank) {
            return breakTie(myRank.highCards, theirRank.highCards);
        }
        return myRank.rank - theirRank.rank;
    }

    /**
     * Breaks ties between hands of the same rank by comparing individual card ranks.
     *
     * @param myHighCards The list of high cards from this hand.
     * @param theirHighCards The list of high cards from the other hand.
     * @return A negative number if this hand's high card is worth less than the other hand's high card,
     *         zero if they are worth the same, and a positive number if this hand's high card is worth more than the other hand's high card.
     */
    private int breakTie(ArrayList<Card> myHighCards, ArrayList<Card> theirHighCards) {
        for (int i = START_INDEX; i < myHighCards.size(); i++) {
            int comparison = myHighCards.get(i).getRank() - theirHighCards.get(i).getRank();
            if (comparison != START_INDEX) {
                return comparison;
            }
        }
        return 0;
    }

    /**
     * Evaluates the rank of the hand and returns a HandRank object representing the rank and high cards.
     *
     * @return A HandRank object representing the rank and high cards of the hand.
     */
    private HandRank evaluateHand() {
        HashMap<Integer, Integer> rankCount = new HashMap<>();
        for (Card card : hand) {
            rankCount.put(card.getRank(), rankCount.getOrDefault(card.getRank(), START_INDEX) + RANK_ONE_PAIR);
        }

        boolean flush = hand.stream().map(Card::getSuit).distinct().count() == RANK_ONE_PAIR;

        if (rankCount.containsValue(RANK_STRAIGHT)) {
            return new HandRank(RANK_TWO_PAIR, getCardsByFrequency(RANK_STRAIGHT, rankCount));
        }
        if (rankCount.containsValue(RANK_THREE_OF_A_KIND) && rankCount.containsValue(RANK_TWO_PAIR)) {
            return new HandRank(RANK_TWO_PAIR, getCardsByFrequency(RANK_THREE_OF_A_KIND, rankCount));
        }
        if (flush) {
            return new HandRank(RANK_FLUSH, new ArrayList<>(hand));
        }
        if (rankCount.containsValue(RANK_THREE_OF_A_KIND)) {
            return new HandRank(RANK_ONE_PAIR, getCardsByFrequency(RANK_THREE_OF_A_KIND, rankCount));
        }
        if (Collections.frequency(new ArrayList<>(rankCount.values()), RANK_TWO_PAIR) == RANK_TWO_PAIR) {
            return new HandRank(RANK_TWO_PAIR, getCardsByFrequency(RANK_TWO_PAIR, rankCount));
        }
        if (rankCount.containsValue(RANK_TWO_PAIR)) {
            return new HandRank(RANK_ONE_PAIR, getCardsByFrequency(RANK_TWO_PAIR, rankCount));
        }
        return new HandRank(RANK_HIGH_CARD, new ArrayList<>(hand));
    }

    /**
     * Returns a list of cards in the hand that have the specified frequency of occurrence.
     *
     * @param frequency The frequency of occurrence of the cards to return.
     * @param rankCount A map of card ranks to their frequency of occurrence in the hand.
     * @return A list of cards in the hand that have the specified frequency of occurrence.
     */
    private ArrayList<Card> getCardsByFrequency(int frequency, HashMap<Integer, Integer> rankCount) {
        ArrayList<Card> result = new ArrayList<>();
        ArrayList<Card> remainingCards = new ArrayList<>();
        for (Card card : hand) {
            if (rankCount.get(card.getRank()) == frequency) {
                result.add(card);
            } else {
                remainingCards.add(card);
            }
        }
        result.addAll(remainingCards);
        return result;
    }

    /**
     * This class represents the rank of a hand and the high cards used to break ties.
     */
    private static class HandRank {
        int rank;
        ArrayList<Card> highCards;

        /**
         * Constructs a HandRank with the specified rank and high cards.
         *
         * @param rank The rank of the hand.
         * @param highCards The high cards used to break ties.
         */
        HandRank(int rank, ArrayList<Card> highCards) {
            this.rank = rank;
            this.highCards = highCards;
        }
    }
}