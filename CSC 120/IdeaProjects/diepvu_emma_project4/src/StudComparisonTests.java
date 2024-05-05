
/**
 * This class form test cases to test whether compareTo method runs correctly with the given community and stud hands
 */
public class StudComparisonTests {
    /**
     * @param args
     * Run the different test cases
     */
    public static void main(String[] args) {
        Tester t = new Tester(true);
        testDifferentStudHandKinds(t);
        testBothEqualFlushes(t);
        testDifferentFlushes(t);
        testBothEqualTwoPairs(t);
        testDifferentTwoPairs(t);
        testBothEqualOnePair(t);
        testDifferentOnePair(t);
        testBothEqualHighCards(t);
        testDifferentHighCards(t);
        testIdenticalStuds(t);







        t.finishTests();
    }

    /**
     *
     * @param t create test case from tester class
     * Use to check compareTo method given two different kinds of hands
     */

    private static void testDifferentStudHandKinds(Tester t){
        Card c1 = new Card("Ace","D",14);
        Card c2 = new Card("3","D",3);
        Card c3 = new Card("4","D",4);
        Card c4 = new Card("5","C",5);
        Card c5 = new Card("6","C",6);
        Card c6 = new Card("K","D",13);
        Card c7 = new Card("Q","D",12);
        Card c8 = new Card("Ace","S",14);
        Card c9 = new Card("6","S",6);
        CommunityCardSet community = new CommunityCardSet();
        community.addCardToCommunity(c1);
        community.addCardToCommunity(c2);
        community.addCardToCommunity(c3);
        community.addCardToCommunity(c4);
        community.addCardToCommunity(c5);

        StudPokerHand thisStud = new StudPokerHand(community);
        thisStud.addCardToStud(c6);
        thisStud.addCardToStud(c7);



        StudPokerHand otherStud = new StudPokerHand(community);
        otherStud.addCardToStud(c8);
        otherStud.addCardToStud(c9);



        t.assertEquals("Compare two different kinds, one stud has flush, the other has two pairs",1,thisStud.compareTo(otherStud));

    }

    /**
     *
     * @param t create test case from tester class
     * Use to check compareTo method given two hands same value flushes
     */

    private static void testBothEqualFlushes(Tester t){
        Card c1 = new Card("Ace","H",14);
        Card c2 = new Card("K","H",13);
        Card c3 = new Card("Q","H",12);
        Card c4 = new Card("J","H",11);
        Card c5 = new Card("9","H",9);
        Card c6 = new Card("2","H",2);
        Card c7 = new Card("5","H",5);
        Card c8 = new Card("3","H",3);
        Card c9 = new Card("4","H",4);

        CommunityCardSet community = new CommunityCardSet();
        community.addCardToCommunity(c1);
        community.addCardToCommunity(c2);
        community.addCardToCommunity(c3);
        community.addCardToCommunity(c4);
        community.addCardToCommunity(c5);

        StudPokerHand thisStud = new StudPokerHand(community);
        thisStud.addCardToStud(c6);
        thisStud.addCardToStud(c7);

        StudPokerHand otherStud = new StudPokerHand(community);
        otherStud.addCardToStud(c8);
        otherStud.addCardToStud(c9);

        t.assertEquals("Test both equal flushes",0,thisStud.compareTo(otherStud));

    }

    /**
     *
     * @param t create test case from tester class
     * Use to check compareTo method given two hands both different flushes
     */
    private static void testDifferentFlushes(Tester t){
        Card c1 = new Card("10","D",10);
        Card c2 = new Card("K","D",13);
        Card c3 = new Card("J","D",11);
        Card c4 = new Card("9","D",9);
        Card c5 = new Card("Q","D",12);
        Card c6 = new Card("2","D",2);
        Card c7 = new Card("Ace","D",14);
        Card c8 = new Card("4","D",4);
        Card c9 = new Card("3","D",3);

        CommunityCardSet community = new CommunityCardSet();
        community.addCardToCommunity(c1);
        community.addCardToCommunity(c2);
        community.addCardToCommunity(c3);
        community.addCardToCommunity(c4);
        community.addCardToCommunity(c5);

        StudPokerHand stud = new StudPokerHand(community);
        stud.addCardToStud(c6);
        stud.addCardToStud(c7);

        StudPokerHand otherStud = new StudPokerHand(community);
        otherStud.addCardToStud(c8);
        otherStud.addCardToStud(c9);

        t.assertEquals("Compare stud hands with one hand's flush stronger than the other's",1,stud.compareTo(otherStud));

    }

    /**
     *
     * @param t create test case from tester class
     * Use to check compareTo method given two hands same value two pairs
     */

    private static void testBothEqualTwoPairs(Tester t){
        Card c1 = new Card("Ace","H",14);
        Card c2 = new Card("K","C",13);
        Card c3 = new Card("Q","C",12);
        Card c4 = new Card("J","S",11);
        Card c5 = new Card("9","H",9);
        Card c6 = new Card("Ace","C",14);
        Card c7 = new Card("K","C",13);
        Card c8 = new Card("Ace","S",14);
        Card c9 = new Card("K","S",13);

        CommunityCardSet community = new CommunityCardSet();
        community.addCardToCommunity(c1);
        community.addCardToCommunity(c2);
        community.addCardToCommunity(c3);
        community.addCardToCommunity(c4);
        community.addCardToCommunity(c5);

        StudPokerHand thisStud = new StudPokerHand(community);
        thisStud.addCardToStud(c6);
        thisStud.addCardToStud(c7);

        StudPokerHand otherStud = new StudPokerHand(community);
        otherStud.addCardToStud(c8);
        otherStud.addCardToStud(c9);

        t.assertEquals("Test both equal two pairs",0,thisStud.compareTo(otherStud));

    }

    /**
     *
     * @param t create test case from tester class
     * Use to check compareTo method given two hands both different two pairs
     */

    private static void testDifferentTwoPairs(Tester t){
        Card c1 = new Card("Ace","H",14);
        Card c2 = new Card("K","C",13);
        Card c3 = new Card("Q","C",12);
        Card c4 = new Card("J","S",11);
        Card c5 = new Card("9","H",9);
        Card c6 = new Card("Q","C",12);
        Card c7 = new Card("K","C",13);
        Card c8 = new Card("Ace","S",14);
        Card c9 = new Card("K","S",13);

        CommunityCardSet community = new CommunityCardSet();
        community.addCardToCommunity(c1);
        community.addCardToCommunity(c2);
        community.addCardToCommunity(c3);
        community.addCardToCommunity(c4);
        community.addCardToCommunity(c5);

        StudPokerHand thisStud = new StudPokerHand(community);
        thisStud.addCardToStud(c6);
        thisStud.addCardToStud(c7);

        StudPokerHand otherStud = new StudPokerHand(community);
        otherStud.addCardToStud(c8);
        otherStud.addCardToStud(c9);

        t.assertEquals("Test both hands with different two-pair values, other hand has stronger two pairs",-1,thisStud.compareTo(otherStud));

    }

    /**
     *
     * @param t create test case from tester class
     * Use to check compareTo method given two hands same value one pair
     */
    private static void testBothEqualOnePair(Tester t){
        Card c1 = new Card("Ace","H",14);
        Card c2 = new Card("3","C",3);
        Card c3 = new Card("4","S",4);
        Card c4 = new Card("5","H",5);
        Card c5 = new Card("6","C",6);
        Card c6 = new Card("Ace","C",14);
        Card c7 = new Card("7","C",7);
        Card c8 = new Card("Ace","S",14);
        Card c9 = new Card("8","S",8);

        CommunityCardSet community = new CommunityCardSet();
        community.addCardToCommunity(c1);
        community.addCardToCommunity(c2);
        community.addCardToCommunity(c3);
        community.addCardToCommunity(c4);
        community.addCardToCommunity(c5);

        StudPokerHand thisStud = new StudPokerHand(community);
        thisStud.addCardToStud(c6);
        thisStud.addCardToStud(c7);

        StudPokerHand otherStud = new StudPokerHand(community);
        otherStud.addCardToStud(c8);
        otherStud.addCardToStud(c9);

        t.assertEquals("Test both equal pair, but the other's high card is stronger",-1,thisStud.compareTo(otherStud));

    }

    /**
     *
     * @param t create test case from tester class
     * Use to check compareTo method given two hands both different one pair
     */

    private static void testDifferentOnePair(Tester t){
        Card c1 = new Card("Ace","H",14);
        Card c2 = new Card("K","C",13);
        Card c3 = new Card("10","C",10);
        Card c4 = new Card("J","S",11);
        Card c5 = new Card("9","H",9);
        Card c6 = new Card("Ace","C",14);
        Card c7 = new Card("8","C",8);
        Card c8 = new Card("8","S",8);
        Card c9 = new Card("K","S",13);

        CommunityCardSet community = new CommunityCardSet();
        community.addCardToCommunity(c1);
        community.addCardToCommunity(c2);
        community.addCardToCommunity(c3);
        community.addCardToCommunity(c4);
        community.addCardToCommunity(c5);

        StudPokerHand thisStud = new StudPokerHand(community);
        thisStud.addCardToStud(c6);
        thisStud.addCardToStud(c7);

        StudPokerHand otherStud = new StudPokerHand(community);
        otherStud.addCardToStud(c8);
        otherStud.addCardToStud(c9);

        t.assertEquals("Test different one pair, one's hand has stronger one pair",1,thisStud.compareTo(otherStud));

    }

    /**
     *
     * @param t create test case from tester class
     * Use to check compareTo method given two hands same value high cards
     */

    private static void testBothEqualHighCards(Tester t){
        Card c1 = new Card("Ace","H",14);
        Card c2 = new Card("K","C",13);
        Card c3 = new Card("Q","C",12);
        Card c4 = new Card("3","S",3);
        Card c5 = new Card("9","H",9);
        Card c6 = new Card("J","S",11);
        Card c7 = new Card("10","D",10);
        Card c8 = new Card("J","H",11);
        Card c9 = new Card("10","C",10);

        CommunityCardSet community = new CommunityCardSet();
        community.addCardToCommunity(c1);
        community.addCardToCommunity(c2);
        community.addCardToCommunity(c3);
        community.addCardToCommunity(c4);
        community.addCardToCommunity(c5);

        StudPokerHand thisStud = new StudPokerHand(community);
        thisStud.addCardToStud(c6);
        thisStud.addCardToStud(c7);

        StudPokerHand otherStud = new StudPokerHand(community);
        otherStud.addCardToStud(c8);
        otherStud.addCardToStud(c9);

        t.assertEquals("Test both equal high cards",0,thisStud.compareTo(otherStud));

    }
    /**
     *
     * @param t create test case from tester class
     * Use to check compareTo method given two hands both different high cards
     */

    private static void testDifferentHighCards(Tester t){
        Card c1 = new Card("Ace","H",14);
        Card c2 = new Card("K","C",13);
        Card c3 = new Card("Q","C",12);
        Card c4 = new Card("3","S",3);
        Card c5 = new Card("9","H",9);
        Card c6 = new Card("10","C",10);
        Card c7 = new Card("J","D",11);
        Card c8 = new Card("7","D",7);
        Card c9 = new Card("8","S",8);

        CommunityCardSet community = new CommunityCardSet();
        community.addCardToCommunity(c1);
        community.addCardToCommunity(c2);
        community.addCardToCommunity(c3);
        community.addCardToCommunity(c4);
        community.addCardToCommunity(c5);

        StudPokerHand thisStud = new StudPokerHand(community);
        thisStud.addCardToStud(c6);
        thisStud.addCardToStud(c7);

        StudPokerHand otherStud = new StudPokerHand(community);
        otherStud.addCardToStud(c8);
        otherStud.addCardToStud(c9);

        t.assertEquals("Test different high cards, one's hand high cards are stronger than the other",1,thisStud.compareTo(otherStud));

    }

    private static void testIdenticalStuds(Tester t){
        Card c1 = new Card("Ace","H",14);
        Card c2 = new Card("K","C",13);
        Card c3 = new Card("Q","C",12);
        Card c4 = new Card("3","S",3);
        Card c5 = new Card("9","H",9);
        Card c6 = new Card("10","C",10);
        Card c7 = new Card("J","D",11);

        CommunityCardSet community = new CommunityCardSet();
        community.addCardToCommunity(c1);
        community.addCardToCommunity(c2);
        community.addCardToCommunity(c3);
        community.addCardToCommunity(c4);
        community.addCardToCommunity(c5);

        StudPokerHand thisStud = new StudPokerHand(community);
        thisStud.addCardToStud(c6);
        thisStud.addCardToStud(c7);

        StudPokerHand otherStud = new StudPokerHand(community);
        otherStud.addCardToStud(c6);
        otherStud.addCardToStud(c7);

        t.assertEquals("Test two identical studs",0,thisStud.compareTo(otherStud));

    }




}
