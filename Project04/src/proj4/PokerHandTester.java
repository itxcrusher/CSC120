package proj4;

import java.util.ArrayList;

/**
 * This class contains unit tests for the PokerHand class.
 */
public class PokerHandTester {
    private static final int SPADES = 0;
    private static final int HEARTS = 1;
    private static final int CLUBS = 2;
    private static final int DIAMONDS = 3;

    private static final int TWO = 2;
    private static final int THREE = 3;
    private static final int FOUR = 4;
    private static final int FIVE = 5;
    private static final int SIX = 6;
    private static final int SEVEN = 7;
    private static final int EIGHT = 8;
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

        testInitialization();
        testAddCard();
        testGetCard();
        testToString();
        testCompareTo();
        testHighCardVsStraight();
        testPairVsHighCard();
        testFourOfAKindVsStraight();
        testFlushVsHighCard();
        testFullHouseVsFourOfAKind();
        testPairVsFlush();
        testHighCardVsFullHouse();
        testTwoPairVsOnePair();

        Testing.finishTests();
    }

    /**
     * Tests the Initialization of PokerHand class.
     */
    public static void testInitialization() {
        ArrayList<Card> hand1Cards = new ArrayList<>();
        hand1Cards.add(new Card(QUEEN, "Hearts"));
        hand1Cards.add(new Card(JACK, "Clubs"));
        hand1Cards.add(new Card(FIVE, "Diamonds"));
        hand1Cards.add(new Card(THREE, "Spades"));
        hand1Cards.add(new Card(TWO, "Hearts"));
        PokerHand hand1 = new PokerHand(hand1Cards);

        ArrayList<Card> hand2Cards = new ArrayList<>();
        hand2Cards.add(new Card(ACE, "Spades"));
        hand2Cards.add(new Card(KING, "Diamonds"));
        hand2Cards.add(new Card(FOUR, "Clubs"));
        hand2Cards.add(new Card(FOUR, "Spades"));
        hand2Cards.add(new Card(FOUR, "Hearts"));
        PokerHand hand2 = new PokerHand(hand2Cards);

        Testing.assertEquals("Hand 1 toString", "Queen of Hearts\nJack of Clubs\n5 of Diamonds\n3 of Spades\n2 of Hearts\n", hand1.toString());
        Testing.assertEquals("Hand 2 toString", "Ace of Spades\nKing of Diamonds\n4 of Clubs\n4 of Spades\n4 of Hearts\n", hand2.toString());

        hand1.addCard(new Card(ACE, "Hearts"));
        Testing.assertEquals("Hand 1 After Adding a Card", "Queen of Hearts\nJack of Clubs\n5 of Diamonds\n3 of Spades\n2 of Hearts\n", hand1.toString());
    }

    /**
     * Tests the addCard method of PokerHand class.
     */
    public static void testAddCard() {
        Testing.testSection("Test addCard");

        ArrayList<Card> handCards = new ArrayList<>();
        handCards.add(new Card(ACE, "Hearts"));
        handCards.add(new Card(KING, "Diamonds"));
        handCards.add(new Card(QUEEN, "Clubs"));
        handCards.add(new Card(JACK, "Spades"));
        handCards.add(new Card(TEN, "Hearts"));

        PokerHand hand = new PokerHand(handCards);
        hand.addCard(new Card(TEN, "Hearts"));

        Testing.assertEquals("The fifth card should be added", true, hand.getIthCard(FOUR) != null);
        Testing.assertEquals("There should not be a sixth card", true, hand.getIthCard(FIVE) == null);
    }

    /**
     * Tests the getCard method of PokerHand class.
     */
    public static void testGetCard() {
        Testing.testSection("Test getCard");

        ArrayList<Card> handCards = new ArrayList<>();
        handCards.add(new Card(ACE, "Hearts"));
        handCards.add(new Card(KING, "Diamonds"));
        handCards.add(new Card(QUEEN, "Clubs"));
        handCards.add(new Card(JACK, "Spades"));
        handCards.add(new Card(TEN, "Hearts"));

        PokerHand hand = new PokerHand(handCards);

        Testing.assertEquals("First card should be Ace", ACE, hand.getIthCard(ZERO).getRank());
        Testing.assertEquals("Second card should be Diamonds", DIAMONDS, hand.getIthCard(1).getSuit());
        Testing.assertEquals("There should not be a sixth card", true, hand.getIthCard(5) == null);
    }

    /**
     * Tests the toString method of PokerHand class.
     */
    public static void testToString() {
        Testing.testSection("Test toString");

        ArrayList<Card> handCards = new ArrayList<>();
        handCards.add(new Card(ACE, "Hearts"));
        handCards.add(new Card(KING, "Diamonds"));
        handCards.add(new Card(QUEEN, "Clubs"));
        handCards.add(new Card(JACK, "Spades"));
        handCards.add(new Card(TEN, "Hearts"));

        PokerHand hand = new PokerHand(handCards);
        String expectedString = "Ace of Hearts\nKing of Diamonds\nQueen of Clubs\nJack of Spades\n10 of Hearts\n";
        Testing.assertEquals("toString should return correct card representation", expectedString, hand.toString());
    }

    /**
     * Tests the compareTo method of PokerHand class.
     */
    public static void testCompareTo() {
        Testing.testSection("Two pairs vs one pair");
        ArrayList<Card> onePairCards = new ArrayList<>();
        onePairCards.add(new Card(SEVEN, "Spades"));
        onePairCards.add(new Card(THREE, "Hearts"));
        onePairCards.add(new Card(FIVE, "Clubs"));
        onePairCards.add(new Card(NINE, "Diamonds"));
        onePairCards.add(new Card(SEVEN, "Clubs"));
        ArrayList<Card> twoPairCards = new ArrayList<>();
        twoPairCards.add(new Card(SEVEN, "Hearts"));
        twoPairCards.add(new Card(FOUR, "Spades"));
        twoPairCards.add(new Card(SEVEN, "Diamonds"));
        twoPairCards.add(new Card(FOUR, "Clubs"));
        twoPairCards.add(new Card(SIX, "Hearts"));
        PokerHand onePair = new PokerHand(onePairCards);
        PokerHand twoPair = new PokerHand(twoPairCards);
        Testing.assertEquals("Two pairs should beat one pair", true, twoPair.compareTo(onePair) > ZERO);

        Testing.testSection("high-card hand vs. straight");
        ArrayList<Card> highCardHand = new ArrayList<>();
        highCardHand.add(new Card(TWO, "Hearts"));
        highCardHand.add(new Card(FOUR, "Clubs"));
        highCardHand.add(new Card(SIX, "Diamonds"));
        highCardHand.add(new Card(NINE, "Spades"));
        highCardHand.add(new Card(QUEEN, "Hearts"));
        ArrayList<Card> straightHand = new ArrayList<>();
        straightHand.add(new Card(FIVE, "Hearts"));
        straightHand.add(new Card(SIX, "Clubs"));
        straightHand.add(new Card(SEVEN, "Diamonds"));
        straightHand.add(new Card(EIGHT, "Spades"));
        straightHand.add(new Card(NINE, "Hearts"));
        PokerHand highCard = new PokerHand(highCardHand);
        PokerHand straight = new PokerHand(straightHand);
        Testing.assertEquals("High Card should beat Straight Hand", true, highCard.compareTo(straight) > ZERO);
    }

    /**
     * Tests High-card hand vs. Straight.
     */
    public static void testHighCardVsStraight() {
        Testing.testSection("High-card hand vs. Straight");

        ArrayList<Card> highCardHand = new ArrayList<>();
        highCardHand.add(new Card(TWO, "Hearts"));
        highCardHand.add(new Card(FOUR, "Clubs"));
        highCardHand.add(new Card(SIX, "Diamonds"));
        highCardHand.add(new Card(NINE, "Spades"));
        highCardHand.add(new Card(QUEEN, "Hearts"));
        PokerHand highCard = new PokerHand(highCardHand);

        ArrayList<Card> straightHand = new ArrayList<>();
        straightHand.add(new Card(FIVE, "Hearts"));
        straightHand.add(new Card(SIX, "Clubs"));
        straightHand.add(new Card(SEVEN, "Diamonds"));
        straightHand.add(new Card(EIGHT, "Spades"));
        straightHand.add(new Card(NINE, "Hearts"));
        PokerHand straight = new PokerHand(straightHand);

        Testing.assertEquals("High Card should beat Straight Hand", true, highCard.compareTo(straight) > ZERO);
    }

    /**
     * Tests Pair vs. High-card hand.
     */
    public static void testPairVsHighCard() {
        Testing.testSection("Pair vs. High-card hand");

        ArrayList<Card> pairHand = new ArrayList<>();
        pairHand.add(new Card(TWO, "Hearts"));
        pairHand.add(new Card(TWO, "Clubs"));
        pairHand.add(new Card(SIX, "Diamonds"));
        pairHand.add(new Card(NINE, "Spades"));
        pairHand.add(new Card(QUEEN, "Hearts"));
        PokerHand pair = new PokerHand(pairHand);

        ArrayList<Card> highCardHand = new ArrayList<>();
        highCardHand.add(new Card(THREE, "Hearts"));
        highCardHand.add(new Card(FIVE, "Clubs"));
        highCardHand.add(new Card(SEVEN, "Diamonds"));
        highCardHand.add(new Card(TEN, "Spades"));
        highCardHand.add(new Card(KING, "Hearts"));
        PokerHand highCard = new PokerHand(highCardHand);

        Testing.assertEquals("Pair should beat High Card", true, pair.compareTo(highCard) > ZERO);
    }

    /**
     * Tests Four of a kind vs. Straight.
     */
    public static void testFourOfAKindVsStraight() {
        Testing.testSection("Four of a kind vs. Straight");

        ArrayList<Card> fourOfAKindHand = new ArrayList<>();
        fourOfAKindHand.add(new Card(EIGHT, "Hearts"));
        fourOfAKindHand.add(new Card(EIGHT, "Clubs"));
        fourOfAKindHand.add(new Card(EIGHT, "Diamonds"));
        fourOfAKindHand.add(new Card(EIGHT, "Spades"));
        fourOfAKindHand.add(new Card(TEN, "Hearts"));
        PokerHand fourOfAKind = new PokerHand(fourOfAKindHand);

        ArrayList<Card> straightHand = new ArrayList<>();
        straightHand.add(new Card(FIVE, "Hearts"));
        straightHand.add(new Card(SIX, "Clubs"));
        straightHand.add(new Card(SEVEN, "Diamonds"));
        straightHand.add(new Card(EIGHT, "Spades"));
        straightHand.add(new Card(NINE, "Hearts"));
        PokerHand straight = new PokerHand(straightHand);

        Testing.assertEquals("Four of a Kind should beat Straight", true, fourOfAKind.compareTo(straight) > ZERO);
    }

    /**
     * Tests Flush vs. High-card hand.
     */
    public static void testFlushVsHighCard() {
        Testing.testSection("Flush vs. High-card hand");

        ArrayList<Card> flushHand = new ArrayList<>();
        flushHand.add(new Card(TWO, "Hearts"));
        flushHand.add(new Card(FOUR, "Hearts"));
        flushHand.add(new Card(SIX, "Hearts"));
        flushHand.add(new Card(EIGHT, "Hearts"));
        flushHand.add(new Card(TEN, "Hearts"));
        PokerHand flush = new PokerHand(flushHand);

        ArrayList<Card> highCardHand = new ArrayList<>();
        highCardHand.add(new Card(THREE, "Clubs"));
        highCardHand.add(new Card(FIVE, "Diamonds"));
        highCardHand.add(new Card(SEVEN, "Spades"));
        highCardHand.add(new Card(NINE, "Hearts"));
        highCardHand.add(new Card(QUEEN, "Clubs"));
        PokerHand highCard = new PokerHand(highCardHand);

        Testing.assertEquals("Flush should beat High Card", true, flush.compareTo(highCard) > ZERO);
    }

    /**
     * Tests Full house vs. Four of a kind.
     */
    public static void testFullHouseVsFourOfAKind() {
        Testing.testSection("Full house vs. Four of a kind");

        ArrayList<Card> fullHouseHand = new ArrayList<>();
        fullHouseHand.add(new Card(SIX, "Hearts"));
        fullHouseHand.add(new Card(SIX, "Clubs"));
        fullHouseHand.add(new Card(SIX, "Diamonds"));
        fullHouseHand.add(new Card(NINE, "Spades"));
        fullHouseHand.add(new Card(NINE, "Hearts"));
        PokerHand fullHouse = new PokerHand(fullHouseHand);

        ArrayList<Card> fourOfAKindHand = new ArrayList<>();
        fourOfAKindHand.add(new Card(EIGHT, "Hearts"));
        fourOfAKindHand.add(new Card(EIGHT, "Clubs"));
        fourOfAKindHand.add(new Card(EIGHT, "Diamonds"));
        fourOfAKindHand.add(new Card(EIGHT, "Spades"));
        fourOfAKindHand.add(new Card(TEN, "Hearts"));
        PokerHand fourOfAKind = new PokerHand(fourOfAKindHand);

        Testing.assertEquals("Four of a Kind should beat Full House", true, fourOfAKind.compareTo(fullHouse) > ZERO);
    }

    /**
     * Tests Pair vs. Flush.
     */
    public static void testPairVsFlush() {
        Testing.testSection("Pair vs. Flush");

        ArrayList<Card> pairHand = new ArrayList<>();
        pairHand.add(new Card(TWO, "Hearts"));
        pairHand.add(new Card(TWO, "Clubs"));
        pairHand.add(new Card(SIX, "Diamonds"));
        pairHand.add(new Card(NINE, "Spades"));
        pairHand.add(new Card(QUEEN, "Hearts"));
        PokerHand pair = new PokerHand(pairHand);

        ArrayList<Card> flushHand = new ArrayList<>();
        flushHand.add(new Card(TWO, "Hearts"));
        flushHand.add(new Card(FOUR, "Hearts"));
        flushHand.add(new Card(SIX, "Hearts"));
        flushHand.add(new Card(EIGHT, "Hearts"));
        flushHand.add(new Card(TEN, "Hearts"));
        PokerHand flush = new PokerHand(flushHand);

        Testing.assertEquals("Flush should beat Pair", true, flush.compareTo(pair) > ZERO);
    }

    /**
     * Tests High-card hand vs. Full house.
     */
    public static void testHighCardVsFullHouse() {
        Testing.testSection("High-card hand vs. Full house");

        ArrayList<Card> highCardHand = new ArrayList<>();
        highCardHand.add(new Card(THREE, "Hearts"));
        highCardHand.add(new Card(FIVE, "Clubs"));
        highCardHand.add(new Card(SEVEN, "Diamonds"));
        highCardHand.add(new Card(TEN, "Spades"));
        highCardHand.add(new Card(KING, "Hearts"));
        PokerHand highCard = new PokerHand(highCardHand);

        ArrayList<Card> fullHouseHand = new ArrayList<>();
        fullHouseHand.add(new Card(SIX, "Hearts"));
        fullHouseHand.add(new Card(SIX, "Clubs"));
        fullHouseHand.add(new Card(SIX, "Diamonds"));
        fullHouseHand.add(new Card(NINE, "Spades"));
        fullHouseHand.add(new Card(NINE, "Hearts"));
        PokerHand fullHouse = new PokerHand(fullHouseHand);

        Testing.assertEquals("Full House should beat High Card", true, fullHouse.compareTo(highCard) > ZERO);
    }

    /**
     * Tests Two pairs vs. One pair.
     */
    public static void testTwoPairVsOnePair() {
        Testing.testSection("Two pairs vs. One pair");

        ArrayList<Card> onePairCards = new ArrayList<>();
        onePairCards.add(new Card(SEVEN, "Spades"));
        onePairCards.add(new Card(THREE, "Hearts"));
        onePairCards.add(new Card(FIVE, "Clubs"));
        onePairCards.add(new Card(NINE, "Diamonds"));
        onePairCards.add(new Card(SEVEN, "Clubs"));
        PokerHand onePair = new PokerHand(onePairCards);

        ArrayList<Card> twoPairCards = new ArrayList<>();
        twoPairCards.add(new Card(SEVEN, "Hearts"));
        twoPairCards.add(new Card(FOUR, "Spades"));
        twoPairCards.add(new Card(SEVEN, "Diamonds"));
        twoPairCards.add(new Card(FOUR, "Clubs"));
        twoPairCards.add(new Card(SIX, "Hearts"));
        PokerHand twoPair = new PokerHand(twoPairCards);

        Testing.assertEquals("Two pairs should beat one pair", true, twoPair.compareTo(onePair) > ZERO);
    }
}