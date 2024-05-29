package proj4;

import java.util.ArrayList;

/**
 * This class contains unit tests for the CommunityCardSet class.
 */
public class CommunityCardSetTester {
    private static final int TWO = 2;
    private static final int FIVE = 5;
    private static final int SEVEN = 7;
    private static final int NINE = 9;

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
        communityCards.add(new Card("Jack", "Clubs"));
        communityCards.add(new Card("Queen", "Hearts"));

        CommunityCardSet communityCardSet = new CommunityCardSet(communityCards);
        Testing.assertEquals("Community Cards toString", "2 of Hearts | 5 of Spades | 9 of Diamonds | Jack of Clubs | Queen of Hearts | ", communityCardSet.toString());

        communityCardSet.addCard(new Card(SEVEN, "Diamonds"));
        Testing.assertEquals("After Adding a Card", "2 of Hearts | 5 of Spades | 9 of Diamonds | Jack of Clubs | Queen of Hearts | 7 of Diamonds | ", communityCardSet.toString());

        Card card = communityCardSet.getIthCard(2);
        Testing.assertEquals("Third Card", "9 of Diamonds", card.toString());

        Testing.finishTests();
    }
}