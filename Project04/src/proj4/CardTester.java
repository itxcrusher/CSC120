package proj4;

/**
 * This class contains unit tests for the Card class.
 */
public class CardTester {
    private static final int SPADES = 0;
    private static final int HEARTS = 1;
    private static final int CLUBS = 2;

    private static final int TWO = 2;
    private static final int TEN = 10;
    private static final int QUEEN = 12;
    private static final int ACE = 14;

    /**
     * The main method to run the tests.
     *
     * @param args command-line arguments (not used)
     */
    public static void main(String[] args) {
        Testing.startTests();

        Card card1 = new Card("Ace", "Spades");
        Card card2 = new Card(ACE, SPADES);
        Card card3 = new Card("Queen", "Hearts");
        Card card4 = new Card(QUEEN, HEARTS);
        Card card5 = new Card(TWO, "Hearts");

        Testing.assertEquals("Card 1 toString", "Ace of Spades", card1.toString());
        Testing.assertEquals("Card 2 toString", "Ace of Spades", card2.toString());
        Testing.assertEquals("Card 3 toString", "Queen of Hearts", card3.toString());
        Testing.assertEquals("Card 4 toString", "Queen of Hearts", card4.toString());
        Testing.assertEquals("Card 5 toString", "2 of Hearts", card5.toString());

        Testing.assertEquals("Card 1 Rank", ACE, card1.getRank());
        Testing.assertEquals("Card 1 Suit", SPADES, card1.getSuit());
        Testing.assertEquals("Card 2 Rank", ACE, card2.getRank());
        Testing.assertEquals("Card 2 Suit", SPADES, card2.getSuit());
        Testing.assertEquals("Card 3 Rank", QUEEN, card3.getRank());
        Testing.assertEquals("Card 3 Suit", HEARTS, card3.getSuit());
        Testing.assertEquals("Card 4 Rank", QUEEN, card4.getRank());
        Testing.assertEquals("Card 4 Suit", HEARTS, card4.getSuit());
        Testing.assertEquals("Card 5 Rank", TWO, card5.getRank());
        Testing.assertEquals("Card 5 Suit", HEARTS, card5.getSuit());

        testCardInitializationWithStrings();

        Testing.finishTests();
    }

    /**
     * Test the initialization of a Card object using String parameters.
     */
    public static void testCardInitializationWithStrings() {
        Testing.testSection("Test Card Initialization with String Parameters");

        Card card = new Card("10", "Clubs");

        Testing.assertEquals("Rank should be 10", TEN, card.getRank());
        Testing.assertEquals("Suit should be Clubs", CLUBS, card.getSuit());

        Testing.assertEquals("String representation should be '10 of Clubs'", "10 of Clubs", card.toString());
    }
}
