import java.util.ArrayList;

public class StudPokerHand {
    private ArrayList<Card> studHand;
    private CommunityCardSet community;

    private static final int TIE_GAME = 0;

    /**
     * create a stud poker hand as an array list of cards
     * @param ComCard: the community set so that can combine with two hole cards to get best stud poker hand possible
     */

    public StudPokerHand(CommunityCardSet ComCard){
        studHand = new ArrayList<Card>();
        community = ComCard;
    }

    /**
     * Combine 5 cards from community set and 2 cards from studHand to get total cards
     * @return an array list of 7 cards
     */
    private ArrayList<Card> getSevenCards(){
        ArrayList<Card> sevenCards = new ArrayList<Card>(studHand);
        sevenCards.addAll(community.getCommunityList());

        return sevenCards;
    }

    /**
     * @param toAdd add card to stud hand
     */
    public void addCardToStud(Card toAdd){
        studHand.add(toAdd);
    }

    /**
     * remove the first card of a stud poker hand
     */
    public void removeCardFromStud(){
        studHand.remove(0);
    }

    /**
     * @return print out stud poker hand as an array list of cards with better representation
     */
    public String toString(){
        return studHand.toString();
    }

    /**
     *
     * @return a best poker hand out of an array list of every possible 5-card poker hands
     */
    public PokerHand getBestFiveCardHand()
    {
        ArrayList<PokerHand> hands = getAllFiveCardHands();
        PokerHand bestSoFar = hands.get(0);

        for (int i = 1; i < hands.size(); i++) {
            if (hands.get(i).compareTo(bestSoFar) > 0) {
                bestSoFar = hands.get(i);
            }
        }
        return bestSoFar;
    }

    /**
     *  Determines how this hand compares to another hand, returns
     *  positive, negative, or zero depending on the comparison.
     *
     *  @param other The hand to compare this hand to
     *  @return a negative number if this is worth LESS than other, zero
     *  if they are worth the SAME, and a positive number if this is worth
     *  MORE than other
     */
    public int compareTo(StudPokerHand other){
        if(equals(other)){
            return TIE_GAME;
        }

        PokerHand myBest = this.getBestFiveCardHand();
        PokerHand otherBest = other.getBestFiveCardHand();

        return myBest.compareTo(otherBest);

    }

    /**
     * @return an array list of every possible poker hands choosing 5 cards out of 7 cards (21 items in the array list)
     */
    private ArrayList<PokerHand> getAllFiveCardHands (){
        return getCombos(getSevenCards(), 5);
    }

    /**
     *
     * @param CommunityAndHoleCards an array list of cards combine from community and hole cards
     * @param targetLen the number of cards to be chosen to make combos
     * @return every possible combos of choosing the number of targetLen cards out of the array list
     */
    private ArrayList<PokerHand> getCombos(ArrayList<Card> CommunityAndHoleCards, int targetLen){

        if (targetLen == CommunityAndHoleCards.size()){


            ArrayList<PokerHand> res = MakePokerHandFromEveryCards(CommunityAndHoleCards);
            return res;
        }
        else if(targetLen == 1){

            ArrayList<PokerHand> result = MakeEachCardAPokerHand(CommunityAndHoleCards);
            return result;

        }

        Card first = CommunityAndHoleCards.get(0);

        ArrayList<Card> rest = new ArrayList<Card>(CommunityAndHoleCards.subList(1, CommunityAndHoleCards.size()));
        ArrayList<PokerHand> CombosWithoutFirst = getCombos(rest, targetLen);

        ArrayList<PokerHand> CombosWithFirst = getCombosWithFirst(first, rest, targetLen);
        CombosWithoutFirst.addAll(CombosWithFirst);


        return CombosWithoutFirst;


    }

    /**
     * A part of base case
     * @param CommunityAndHoleCards the array list of cards from community and hole cards
     * @return an array list of poker hand that has only 1 poker hand made out of every cards from community and hole cards
     */
    private ArrayList<PokerHand> MakePokerHandFromEveryCards(ArrayList<Card> CommunityAndHoleCards){
        ArrayList<PokerHand> res = new ArrayList<PokerHand>();
        PokerHand lstPoker = new PokerHand();
        for(Card c : CommunityAndHoleCards){
            lstPoker.addCardInOrder(c);
        }
        res.add(lstPoker);

        return res;
    }

    /**
     *
     * @param CommunityAndHoleCards an array list of cards from community and hole cards
     * @return an array list of poker hands where each card from community and hole is a poker hand
     */
    private ArrayList<PokerHand> MakeEachCardAPokerHand(ArrayList<Card> CommunityAndHoleCards){
        ArrayList<PokerHand> res = new ArrayList<PokerHand>();
        for(Card eachCard : CommunityAndHoleCards){
            PokerHand lstEachPoker = new PokerHand();
            lstEachPoker.addCardInOrder(eachCard);
            res.add(lstEachPoker);
        }

        return res;

    }

    /**
     * @param first the first card to make combos
     * @param rest the rest of the cards to make combos
     * @param targetLen the number of cards to be chosen to make combos
     * @return an array list of poker hands where each poker hand contains the card first
     */
    private ArrayList<PokerHand> getCombosWithFirst(Card first, ArrayList<Card> rest, int targetLen){
        ArrayList<PokerHand> shortCombos = getCombos(rest, targetLen - 1);
        for (PokerHand eachCard : shortCombos){
            eachCard.addCardInOrder(first);
        }
        return shortCombos;

    }

    private ArrayList<Integer> getValueOfStud(){
        ArrayList<Integer> res = new ArrayList<Integer>();
        for(Card c: this.studHand){
            res.add(c.getValue());
        }
        return res;
    }

    private ArrayList<String> getSuitOfStud(){
        ArrayList<String> res = new ArrayList<String>();
        for(Card c: this.studHand){
            res.add(c.getSuit());
        }
        return res;
    }

    /**
     * Check two studs are identical
     * @param other other stud poker hand
     * @return true if they are identical, else return false
     */
    public boolean equals(Object other){
        if(other == null){
            return false;
        } else if(other == this){
            return true;
        } else if(!(other instanceof StudPokerHand)){
            return false;
        } else{
            StudPokerHand otherStud = (StudPokerHand) other;
            return otherStud.getValueOfStud().equals(getValueOfStud())
                    && otherStud.getSuitOfStud().equals(getSuitOfStud());
        }


    }

}
