/**
 * This class form test cases to test whether compareTo method runs correctly with the given cards and poker hands
 */
public class PokerComparisonTests {
    /**
     *
     * @param args
     * Run the different test cases
     */
    public static void main(String[] args)
    {
        Tester t = new Tester(true);

        testDifferentHandKinds(t);
        testBothFlush(t);
        testBothTwoPairs(t);
        testOnePair(t);
        testHighCard(t);








        t.finishTests();









    }

    /**
     *
     * @param t create test case from tester class
     * Use to check compareTo method given two different kinds of hands
     */
    public static void testDifferentHandKinds(Tester t){
        Card card1 = new Card("3", "S", 3);
        Card card2 = new Card("2", "S", 2);
        Card card3 = new Card("7","S",7);
        Card card4 = new Card("J","S",11);
        Card card5 = new Card("Ace", "S", 14);
        PokerHand hand1 = new PokerHand();
        hand1.addCardInOrder(card1);
        hand1.addCardInOrder(card2);
        hand1.addCardInOrder(card3);
        hand1.addCardInOrder(card4);
        hand1.addCardInOrder(card5);

        Card card6 = new Card("Ace","C",14);
        Card card7 = new Card("K","D",13);
        Card card8 = new Card("K","C",13);
        Card card9 = new Card("10","H",10);
        Card card10 = new Card("4","S",4);
        PokerHand hand2 = new PokerHand();
        hand2.addCardInOrder(card6);
        hand2.addCardInOrder(card7);
        hand2.addCardInOrder(card8);
        hand2.addCardInOrder(card9);
        hand2.addCardInOrder(card10);


        t.assertEquals("Compare two hands of different kinds",1,hand1.compareTo(hand2));



    }

    /**
     *
     * @param t create test case from tester class
     * Use to check compareTo method given two hands both flushes
     */
    public static void testBothFlush(Tester t){
        Card card1 = new Card("3", "S", 3);
        Card card2 = new Card("2", "S", 2);
        Card card3 = new Card("7","S",7);
        Card card4 = new Card("J","S",11);
        Card card5 = new Card("Ace", "S", 14);
        PokerHand hand1 = new PokerHand();
        hand1.addCardInOrder(card1);
        hand1.addCardInOrder(card2);
        hand1.addCardInOrder(card3);
        hand1.addCardInOrder(card4);
        hand1.addCardInOrder(card5);

        Card card6 = new Card("Ace","C",14);
        Card card7 = new Card("K","C",13);
        Card card8 = new Card("Q","C",12);
        Card card9 = new Card("10","C",10);
        Card card10 = new Card("4","C",4);
        PokerHand hand2 = new PokerHand();
        hand2.addCardInOrder(card6);
        hand2.addCardInOrder(card7);
        hand2.addCardInOrder(card8);
        hand2.addCardInOrder(card9);
        hand2.addCardInOrder(card10);

        t.assertEquals("Compare two hands of same kind, both are flushes",-1,hand1.compareTo(hand2));


    }

    /**
     *
     * @param t create test case from tester class
     * Use to check compareTo method given two hands both two pairs
     */
    public static void testBothTwoPairs(Tester t){
        Card card1 = new Card("3", "S", 3);
        Card card2 = new Card("3", "C", 3);
        Card card3 = new Card("7","S",7);
        Card card4 = new Card("7","H",7);
        Card card5 = new Card("Ace", "S", 14);
        PokerHand hand1 = new PokerHand();
        hand1.addCardInOrder(card1);
        hand1.addCardInOrder(card2);
        hand1.addCardInOrder(card3);
        hand1.addCardInOrder(card4);
        hand1.addCardInOrder(card5);

        Card card6 = new Card("Ace","C",14);
        Card card7 = new Card("Ace","D",14);
        Card card8 = new Card("Q","C",12);
        Card card9 = new Card("10","C",10);
        Card card10 = new Card("10","H",10);
        PokerHand hand2 = new PokerHand();
        hand2.addCardInOrder(card6);
        hand2.addCardInOrder(card7);
        hand2.addCardInOrder(card8);
        hand2.addCardInOrder(card9);
        hand2.addCardInOrder(card10);

        Card card11 = new Card("Ace","S",14);
        Card card12 = new Card("Ace","H",14);
        Card card13 = new Card("9","D",9);
        Card card14 = new Card("10","D",10);
        Card card15 = new Card("10","S",10);
        PokerHand hand3 = new PokerHand();
        hand3.addCardInOrder(card11);
        hand3.addCardInOrder(card12);
        hand3.addCardInOrder(card13);
        hand3.addCardInOrder(card14);
        hand3.addCardInOrder(card15);



        t.assertEquals("Compare two hands of same kind, both are two pairs with different values of two-pairs",-1,hand1.compareTo(hand2));

        t.assertEquals("Compare two hands of same kind, both are two pairs with same values of two-pairs",1,hand2.compareTo(hand3));



    }

    /**
     *
     * @param t create test case from tester class
     * Use to check compareTo method given two hands both one pair
     */
    public static void testOnePair(Tester t){
        Card card1 = new Card("3", "S", 3);
        Card card2 = new Card("4", "C", 4);
        Card card3 = new Card("7","S",7);
        Card card4 = new Card("7","H",7);
        Card card5 = new Card("K", "S", 13);
        PokerHand hand1 = new PokerHand();
        hand1.addCardInOrder(card1);
        hand1.addCardInOrder(card2);
        hand1.addCardInOrder(card3);
        hand1.addCardInOrder(card4);
        hand1.addCardInOrder(card5);

        Card card6 = new Card("Ace","C",14);
        Card card7 = new Card("Ace","D",14);
        Card card8 = new Card("Q","C",12);
        Card card9 = new Card("10","C",10);
        Card card10 = new Card("5","H",5);
        PokerHand hand2 = new PokerHand();
        hand2.addCardInOrder(card6);
        hand2.addCardInOrder(card7);
        hand2.addCardInOrder(card8);
        hand2.addCardInOrder(card9);
        hand2.addCardInOrder(card10);

        Card card11 = new Card("Ace","H",14);
        Card card12 = new Card("Ace","S",14);
        Card card13 = new Card("Q","D",12);
        Card card14 = new Card("10","D",10);
        Card card15 = new Card("5","S",5);
        PokerHand hand3 = new PokerHand();
        hand3.addCardInOrder(card11);
        hand3.addCardInOrder(card12);
        hand3.addCardInOrder(card13);
        hand3.addCardInOrder(card14);
        hand3.addCardInOrder(card15);


        t.assertEquals("Compare two hands of same kind, both are one-pair with different values of one-pair",-1,hand1.compareTo(hand2));
        t.assertEquals("Compare two hands of same kind, both are one-pair with same values of one-pair",0,hand3.compareTo(hand2));


    }

    /**
     *
     * @param t create test case from tester class
     * Use to check compareTo method given two hands both high cards
     */
    public static void testHighCard(Tester t){
        Card card1 = new Card("3", "S", 3);
        Card card2 = new Card("4", "C", 4);
        Card card3 = new Card("7","S",7);
        Card card4 = new Card("8","H",8);
        Card card5 = new Card("K", "S", 13);
        PokerHand hand1 = new PokerHand();
        hand1.addCardInOrder(card1);
        hand1.addCardInOrder(card2);
        hand1.addCardInOrder(card3);
        hand1.addCardInOrder(card4);
        hand1.addCardInOrder(card5);

        Card card6 = new Card("Ace","C",14);
        Card card7 = new Card("J","D",11);
        Card card8 = new Card("Q","C",12);
        Card card9 = new Card("10","C",10);
        Card card10 = new Card("5","H",5);
        PokerHand hand2 = new PokerHand();
        hand2.addCardInOrder(card6);
        hand2.addCardInOrder(card7);
        hand2.addCardInOrder(card8);
        hand2.addCardInOrder(card9);
        hand2.addCardInOrder(card10);

        t.assertEquals("Compare values of two hands with same kind, both are high cards",-1,hand1.compareTo(hand2));

    }

}
