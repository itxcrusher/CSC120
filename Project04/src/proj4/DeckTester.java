package proj4;

/**
 * This class contains unit tests for the Deck class.
 */
public class DeckTester {
    private static final int FULL_DECK_SIZE = 52;
    private static final int CARDS_DEALT = 5;
    private static final int EXPECTED_DECK_SIZE_AFTER_DEALING = 47;

    /**
     * The main method to run the tests.
     *
     * @param args command-line arguments (not used)
     */
    public static void main(String[] args) {
        Testing.startTests();

        Deck deck = new Deck();

        Testing.assertEquals("Initial Deck Size", FULL_DECK_SIZE, deck.size());
        Testing.assertEquals("Is Deck Empty Initially", false, deck.isEmpty());

        deck.shuffle();
        Testing.assertEquals("Deck Size After Shuffling", FULL_DECK_SIZE, deck.size());

        for (int i = 0; i < CARDS_DEALT; i++) {
            deck.deal();
        }

        Testing.assertEquals("Deck Size After Dealing 5 Cards", EXPECTED_DECK_SIZE_AFTER_DEALING, deck.size());
        Testing.assertEquals("Is Deck Empty After Dealing", false, deck.isEmpty());

        deck.gather();
        Testing.assertEquals("Deck Size After Gathering", FULL_DECK_SIZE, deck.size());
        Testing.assertEquals("Is Deck Empty After Gathering", false, deck.isEmpty());

        Testing.finishTests();
    }
}