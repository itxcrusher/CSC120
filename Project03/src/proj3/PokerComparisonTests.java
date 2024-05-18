/*
 * Author’s Name: Ali Hamza
 * Honor Code: I hereby affirm that I have carried out all my academic endeavours with full academic honesty.
 * */

package proj3;

import java.util.ArrayList;

public class PokerComparisonTests {

    public static void main(String[] args) {
        Testing.startTests();
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
        Testing.finishTests();
    }

    /**
     * Tests the addCard method of PokerHand class.
     */
    public static void testAddCard() {
        Testing.testSection("Test addCard");

        ArrayList<Card> handCards = new ArrayList<>();
        handCards.add(new Card(14, "Hearts"));
        handCards.add(new Card(13, "Diamonds"));
        handCards.add(new Card(12, "Clubs"));
        handCards.add(new Card(11, "Spades"));
        handCards.add(new Card(10, "Hearts"));

        PokerHand hand = new PokerHand(handCards);
        hand.addCard(new Card(10, "Hearts"));

        Testing.assertEquals("The fifth card should be added", true, hand.getCard(4) != null);
        Testing.assertEquals("There should not be a sixth card", true, hand.getCard(5) == null);
    }

    /**
     * Tests the getCard method of PokerHand class.
     */
    public static void testGetCard() {
        Testing.testSection("Test getCard");

        ArrayList<Card> handCards = new ArrayList<>();
        handCards.add(new Card(14, "Hearts"));
        handCards.add(new Card(13, "Diamonds"));
        handCards.add(new Card(12, "Clubs"));
        handCards.add(new Card(11, "Spades"));
        handCards.add(new Card(10, "Hearts"));

        PokerHand hand = new PokerHand(handCards);

        Testing.assertEquals("First card should be Ace", 14, hand.getCard(0).getRank());
        Testing.assertEquals("Second card should be Diamonds", "Diamonds", hand.getCard(1).getSuit());
        Testing.assertEquals("There should not be a sixth card", true, hand.getCard(5) == null);
    }

    /**
     * Tests the toString method of PokerHand class.
     */
    public static void testToString() {
        Testing.testSection("Test toString");

        ArrayList<Card> handCards = new ArrayList<>();
        handCards.add(new Card(14, "Hearts"));
        handCards.add(new Card(13, "Diamonds"));
        handCards.add(new Card(12, "Clubs"));
        handCards.add(new Card(11, "Spades"));
        handCards.add(new Card(10, "Hearts"));

        PokerHand hand = new PokerHand(handCards);
        String expectedString = "Ace of Hearts\nKing of Diamonds\nQueen of Clubs\nJack of Spades\n10 of Hearts\n";
        Testing.assertEquals("toString should return correct card representation", expectedString, hand.toString());
    }
    /**
     * Tests the compareTo method of PokerHand class.
     */
    public static void testCompareTo() {
        Testing.testSection("Two pairs vs one pair");
        ArrayList<Card> OnePairCards = new ArrayList<>();
        OnePairCards.add(new Card(7, "Spades"));
        OnePairCards.add(new Card(3, "Hearts"));
        OnePairCards.add(new Card(5, "Clubs"));
        OnePairCards.add(new Card(9, "Diamonds"));
        OnePairCards.add(new Card(7, "Clubs"));
        ArrayList<Card> TwoPairCards = new ArrayList<>();
        TwoPairCards.add(new Card(7, "Hearts"));
        TwoPairCards.add(new Card(4, "Spades"));
        TwoPairCards.add(new Card(7, "Diamonds"));
        TwoPairCards.add(new Card(4, "Clubs"));
        TwoPairCards.add(new Card(6, "Hearts"));
        PokerHand OnePair = new PokerHand(OnePairCards);
        PokerHand TwoPair = new PokerHand(TwoPairCards);
        Testing.assertEquals("Two pairs should beat one pair", true, TwoPair.compareTo(OnePair) > 0);

        Testing.testSection("high-card hand vs. straight");
        ArrayList<Card> HighCardHand = new ArrayList<>();
        HighCardHand.add(new Card(2, "Hearts"));
        HighCardHand.add(new Card(4, "Clubs"));
        HighCardHand.add(new Card(6, "Diamonds"));
        HighCardHand.add(new Card(9, "Spades"));
        HighCardHand.add(new Card(12, "Hearts"));
        ArrayList<Card> StraightHand = new ArrayList<>();
        StraightHand.add(new Card(5, "Hearts"));
        StraightHand.add(new Card(6, "Clubs"));
        StraightHand.add(new Card(7, "Diamonds"));
        StraightHand.add(new Card(8, "Spades"));
        StraightHand.add(new Card(9, "Hearts"));
        PokerHand HighCard = new PokerHand(HighCardHand);
        PokerHand Straight = new PokerHand(StraightHand);
        Testing.assertEquals("High Card should beat Straight Hand", true, HighCard.compareTo(Straight) > 0);
    }

    public static void testHighCardVsStraight() {
        Testing.testSection("High-card hand vs. Straight");

        ArrayList<Card> HighCardHand = new ArrayList<>();
        HighCardHand.add(new Card(2, "Hearts"));
        HighCardHand.add(new Card(4, "Clubs"));
        HighCardHand.add(new Card(6, "Diamonds"));
        HighCardHand.add(new Card(9, "Spades"));
        HighCardHand.add(new Card(12, "Hearts"));
        PokerHand HighCard = new PokerHand(HighCardHand);

        ArrayList<Card> StraightHand = new ArrayList<>();
        StraightHand.add(new Card(5, "Hearts"));
        StraightHand.add(new Card(6, "Clubs"));
        StraightHand.add(new Card(7, "Diamonds"));
        StraightHand.add(new Card(8, "Spades"));
        StraightHand.add(new Card(9, "Hearts"));
        PokerHand Straight = new PokerHand(StraightHand);

        Testing.assertEquals("High Card should beat Straight Hand", true, HighCard.compareTo(Straight) > 0);
    }

    public static void testPairVsHighCard() {
        Testing.testSection("Pair vs. High-card hand");

        ArrayList<Card> PairHand = new ArrayList<>();
        PairHand.add(new Card(2, "Hearts"));
        PairHand.add(new Card(2, "Clubs"));
        PairHand.add(new Card(6, "Diamonds"));
        PairHand.add(new Card(9, "Spades"));
        PairHand.add(new Card(12, "Hearts"));
        PokerHand Pair = new PokerHand(PairHand);

        ArrayList<Card> HighCardHand = new ArrayList<>();
        HighCardHand.add(new Card(3, "Hearts"));
        HighCardHand.add(new Card(5, "Clubs"));
        HighCardHand.add(new Card(7, "Diamonds"));
        HighCardHand.add(new Card(10, "Spades"));
        HighCardHand.add(new Card(13, "Hearts"));
        PokerHand HighCard = new PokerHand(HighCardHand);

        Testing.assertEquals("Pair should beat High Card", true, Pair.compareTo(HighCard) > 0);
    }

    public static void testFullHouseVsFlush() {
        Testing.testSection("Full house vs. Flush");

        ArrayList<Card> FullHouseHand = new ArrayList<>();
        FullHouseHand.add(new Card(3, "Hearts"));
        FullHouseHand.add(new Card(3, "Clubs"));
        FullHouseHand.add(new Card(3, "Diamonds"));
        FullHouseHand.add(new Card(6, "Spades"));
        FullHouseHand.add(new Card(6, "Hearts"));
        PokerHand FullHouse = new PokerHand(FullHouseHand);

        ArrayList<Card> FlushHand = new ArrayList<>();
        FlushHand.add(new Card(2, "Hearts"));
        FlushHand.add(new Card(4, "Hearts"));
        FlushHand.add(new Card(6, "Hearts"));
        FlushHand.add(new Card(8, "Hearts"));
        FlushHand.add(new Card(10, "Hearts"));
        PokerHand Flush = new PokerHand(FlushHand);

        Testing.assertEquals("Full House should beat Flush", true, FullHouse.compareTo(Flush) > 0);
    }

    public static void testFourOfAKindVsStraight() {
        Testing.testSection("Four of a kind vs. Straight");

        ArrayList<Card> FourOfAKindHand = new ArrayList<>();
        FourOfAKindHand.add(new Card(8, "Hearts"));
        FourOfAKindHand.add(new Card(8, "Clubs"));
        FourOfAKindHand.add(new Card(8, "Diamonds"));
        FourOfAKindHand.add(new Card(8, "Spades"));
        FourOfAKindHand.add(new Card(10, "Hearts"));
        PokerHand FourOfAKind = new PokerHand(FourOfAKindHand);

        ArrayList<Card> StraightHand = new ArrayList<>();
        StraightHand.add(new Card(5, "Hearts"));
        StraightHand.add(new Card(6, "Clubs"));
        StraightHand.add(new Card(7, "Diamonds"));
        StraightHand.add(new Card(8, "Spades"));
        StraightHand.add(new Card(9, "Hearts"));
        PokerHand Straight = new PokerHand(StraightHand);

        Testing.assertEquals("Four of a Kind should beat Straight", true, FourOfAKind.compareTo(Straight) > 0);
    }

    public static void testThreeOfAKindVsTwoPair() {
        Testing.testSection("Three of a kind vs. Two pairs");

        ArrayList<Card> ThreeOfAKindHand = new ArrayList<>();
        ThreeOfAKindHand.add(new Card(5, "Hearts"));
        ThreeOfAKindHand.add(new Card(5, "Clubs"));
        ThreeOfAKindHand.add(new Card(5, "Diamonds"));
        ThreeOfAKindHand.add(new Card(9, "Spades"));
        ThreeOfAKindHand.add(new Card(11, "Hearts"));
        PokerHand ThreeOfAKind = new PokerHand(ThreeOfAKindHand);

        ArrayList<Card> TwoPairHand = new ArrayList<>();
        TwoPairHand.add(new Card(3, "Hearts"));
        TwoPairHand.add(new Card(3, "Clubs"));
        TwoPairHand.add(new Card(7, "Diamonds"));
        TwoPairHand.add(new Card(7, "Spades"));
        TwoPairHand.add(new Card(12, "Hearts"));
        PokerHand TwoPair = new PokerHand(TwoPairHand);

        Testing.assertEquals("Three of a Kind should beat Two Pairs", true, ThreeOfAKind.compareTo(TwoPair) > 0);
    }

    public static void testFlushVsHighCard() {
        Testing.testSection("Flush vs. High-card hand");

        ArrayList<Card> FlushHand = new ArrayList<>();
        FlushHand.add(new Card(2, "Hearts"));
        FlushHand.add(new Card(4, "Hearts"));
        FlushHand.add(new Card(6, "Hearts"));
        FlushHand.add(new Card(8, "Hearts"));
        FlushHand.add(new Card(10, "Hearts"));
        PokerHand Flush = new PokerHand(FlushHand);

        ArrayList<Card> HighCardHand = new ArrayList<>();
        HighCardHand.add(new Card(3, "Clubs"));
        HighCardHand.add(new Card(5, "Diamonds"));
        HighCardHand.add(new Card(7, "Spades"));
        HighCardHand.add(new Card(9, "Hearts"));
        HighCardHand.add(new Card(12, "Clubs"));
        PokerHand HighCard = new PokerHand(HighCardHand);

        Testing.assertEquals("Flush should beat High Card", true, Flush.compareTo(HighCard) > 0);
    }

    public static void testFullHouseVsFourOfAKind() {
        Testing.testSection("Full house vs. Four of a kind");

        ArrayList<Card> FullHouseHand = new ArrayList<>();
        FullHouseHand.add(new Card(6, "Hearts"));
        FullHouseHand.add(new Card(6, "Clubs"));
        FullHouseHand.add(new Card(6, "Diamonds"));
        FullHouseHand.add(new Card(9, "Spades"));
        FullHouseHand.add(new Card(9, "Hearts"));
        PokerHand FullHouse = new PokerHand(FullHouseHand);

        ArrayList<Card> FourOfAKindHand = new ArrayList<>();
        FourOfAKindHand.add(new Card(8, "Hearts"));
        FourOfAKindHand.add(new Card(8, "Clubs"));
        FourOfAKindHand.add(new Card(8, "Diamonds"));
        FourOfAKindHand.add(new Card(8, "Spades"));
        FourOfAKindHand.add(new Card(10, "Hearts"));
        PokerHand FourOfAKind = new PokerHand(FourOfAKindHand);

        Testing.assertEquals("Four of a Kind should beat Full House", true, FourOfAKind.compareTo(FullHouse) > 0);
    }

    public static void testPairVsFlush() {
        Testing.testSection("Pair vs. Flush");

        ArrayList<Card> PairHand = new ArrayList<>();
        PairHand.add(new Card(2, "Hearts"));
        PairHand.add(new Card(2, "Clubs"));
        PairHand.add(new Card(6, "Diamonds"));
        PairHand.add(new Card(9, "Spades"));
        PairHand.add(new Card(12, "Hearts"));
        PokerHand Pair = new PokerHand(PairHand);

        ArrayList<Card> FlushHand = new ArrayList<>();
        FlushHand.add(new Card(2, "Hearts"));
        FlushHand.add(new Card(4, "Hearts"));
        FlushHand.add(new Card(6, "Hearts"));
        FlushHand.add(new Card(8, "Hearts"));
        FlushHand.add(new Card(10, "Hearts"));
        PokerHand Flush = new PokerHand(FlushHand);

        Testing.assertEquals("Flush should beat Pair", true, Flush.compareTo(Pair) > 0);
    }

    public static void testHighCardVsFullHouse() {
        Testing.testSection("High-card hand vs. Full house");

        ArrayList<Card> HighCardHand = new ArrayList<>();
        HighCardHand.add(new Card(3, "Hearts"));
        HighCardHand.add(new Card(5, "Clubs"));
        HighCardHand.add(new Card(7, "Diamonds"));
        HighCardHand.add(new Card(10, "Spades"));
        HighCardHand.add(new Card(13, "Hearts"));
        PokerHand HighCard = new PokerHand(HighCardHand);

        ArrayList<Card> FullHouseHand = new ArrayList<>();
        FullHouseHand.add(new Card(6, "Hearts"));
        FullHouseHand.add(new Card(6, "Clubs"));
        FullHouseHand.add(new Card(6, "Diamonds"));
        FullHouseHand.add(new Card(9, "Spades"));
        FullHouseHand.add(new Card(9, "Hearts"));
        PokerHand FullHouse = new PokerHand(FullHouseHand);

        Testing.assertEquals("Full House should beat High Card", true, FullHouse.compareTo(HighCard) > 0);
    }
}