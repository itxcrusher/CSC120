package proj4;

import java.util.ArrayList;

/**
 * This class contains unit tests for the StudPokerHand class.
 */
public class StudPokerHandTester {
    private static final int TWO = 2;
    private static final int THREE = 3;
    private static final int FOUR = 4;
    private static final int FIVE = 5;
    private static final int SEVEN = 7;
    private static final int NINE = 9;
    private static final int TEN = 10;
    private static final int JACK = 11;
    private static final int QUEEN = 12;
    private static final int KING = 13;
    private static final int ACE = 14;
    private static final int ZERO = 0;

    /**
     * The main method to run the tests.
     *
     * @param args command-line arguments (not used)
     */
    public static void main(String[] args) {
        Testing.startTests();

        ArrayList<Card> communityCards = new ArrayList<>();
        communityCards.add(new Card(TWO, "Hearts"));
        communityCards.add(new Card(FIVE, "Spades"));
        communityCards.add(new Card(NINE, "Diamonds"));
        communityCards.add(new Card(JACK, "Clubs"));
        communityCards.add(new Card(QUEEN, "Hearts"));
        CommunityCardSet communityCardSet = new CommunityCardSet(communityCards);

        ArrayList<Card> holeCards1 = new ArrayList<>();
        holeCards1.add(new Card(SEVEN, "Diamonds"));
        holeCards1.add(new Card(ACE, "Spades"));
        StudPokerHand hand1 = new StudPokerHand(communityCardSet, holeCards1);

        ArrayList<Card> holeCards2 = new ArrayList<>();
        holeCards2.add(new Card(TEN, "Clubs"));
        holeCards2.add(new Card(KING, "Hearts"));
        StudPokerHand hand2 = new StudPokerHand(communityCardSet, holeCards2);

        Testing.assertEquals("Hand 1 toString", "Hole cards: 7 of Diamonds | Ace of Spades | Community cards: 2 of Hearts | 5 of Spades | 9 of Diamonds | Jack of Clubs | Queen of Hearts | ", hand1.toString());
        Testing.assertEquals("Hand 2 toString", "Hole cards: 10 of Clubs | King of Hearts | Community cards: 2 of Hearts | 5 of Spades | 9 of Diamonds | Jack of Clubs | Queen of Hearts | ", hand2.toString());

        int comparison = hand1.compareTo(hand2);
        Testing.assertEquals("Comparing Hand 1 to Hand 2", true, comparison > ZERO);

        ArrayList<Card> holeCards3 = new ArrayList<>();
        holeCards3.add(new Card(TWO, "Clubs"));
        holeCards3.add(new Card(THREE, "Hearts"));
        StudPokerHand hand3 = new StudPokerHand(communityCardSet, holeCards3);

        ArrayList<Card> holeCards4 = new ArrayList<>();
        holeCards4.add(new Card(JACK, "Hearts"));
        holeCards4.add(new Card(FOUR, "Spades"));
        StudPokerHand hand4 = new StudPokerHand(communityCardSet, holeCards4);

        Testing.assertEquals("Hand 3 toString", "Hole cards: 2 of Clubs | 3 of Hearts | Community cards: 2 of Hearts | 5 of Spades | 9 of Diamonds | Jack of Clubs | Queen of Hearts | ", hand3.toString());
        Testing.assertEquals("Hand 4 toString", "Hole cards: Jack of Hearts | 4 of Spades | Community cards: 2 of Hearts | 5 of Spades | 9 of Diamonds | Jack of Clubs | Queen of Hearts | ", hand4.toString());

        int comparison2 = hand3.compareTo(hand4);
        Testing.assertEquals("Comparing Hand 3 to Hand 4", true, comparison2 < ZERO);

        ArrayList<Card> holeCards5 = new ArrayList<>();
        holeCards5.add(new Card(FOUR, "Diamonds"));
        holeCards5.add(new Card(FIVE, "Clubs"));
        StudPokerHand hand5 = new StudPokerHand(communityCardSet, holeCards5);

        ArrayList<Card> holeCards6 = new ArrayList<>();
        holeCards6.add(new Card(FOUR, "Hearts"));
        holeCards6.add(new Card(FIVE, "Spades"));
        StudPokerHand hand6 = new StudPokerHand(communityCardSet, holeCards6);

        int comparison3 = hand5.compareTo(hand6);
        Testing.assertEquals("Comparing Hand 5 to Hand 6 (same rank, different suits)", true, comparison3 == ZERO);

        Testing.finishTests();
    }
}