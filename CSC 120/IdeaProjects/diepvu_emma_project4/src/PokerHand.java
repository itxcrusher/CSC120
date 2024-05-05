import java.util.ArrayList;

public class PokerHand {

    private static final int FIRST_HAND_WINS = 1;
    private static final int SECOND_HAND_WINS = -1;
    private static final int TIE_GAME = 0;
    private static final int MAX_INDEX_OF_PAIR = 2;
    private static final int INITIAL_VALUE_TO_PASS_CONDITION = -5;
    private static final int EXIST_TWO_EQUAL_PAIRS = 2;
    private static final int IS_FLUSH = 3;
    private static final int IS_TWO_PAIRS = 2;
    private static final int IS_PAIR = 1;
    private static final int IS_HIGH_CARD = 0;
    private static final int MAX_NUM_TWO_PAIRS_INDEXES = 2;


    private static final int MAKE_SURE_METHOD_RETURNED_VALUE = 120;
    private static final int NUM_CARDS_IN_ONE_HAND = 5;



    private ArrayList<Card> oneHand;

    /**
     * Create a poker hand as an array list of cards
     */
    public PokerHand() {
        oneHand = new ArrayList<Card>();
    }

    /**
     *
     * @return the number of cards in a poker hand
     */
    private int handSize() {
        return this.oneHand.size();
    }

    /**
     *
     * @param addedCard a card that has been dealt from the deck to add in the hand
     */
    public void addCardInOrder(Card addedCard){
        boolean stat = true;
        int addedCardIndex = 0;
        while(stat && addedCardIndex < handSize()){
            if(addedCard.getValue() < oneHand.get(addedCardIndex).getValue()){
                addedCardIndex++;
            }
            else{
                stat = false;
            }

        }
        oneHand.add(addedCardIndex, addedCard);


    }


    /**
     *
     * @return true if the hand is flush; other wise false
     */
    private boolean isFlush() {
        boolean stat = true;
        for (int i = 0; i < handSize() - 1; i++) {
            Card thisCard = (Card) oneHand.get(i);
            Card nextCard = (Card) oneHand.get(i + 1);
            if (!thisCard.getSuit().equals(nextCard.getSuit())) {
                stat = false;

            }

        }
        return stat;
    }

    /**
     *
     * @return the poker hand as an array list with cards represented as strings for better view for users
     */
    public String toString() {
        return this.oneHand.toString();
    }

    /**
     * check whether a hand has one pair
     * @return the index of the first occurrence of one-pair card in the hand if exist
     */
    public int getIndexOfOnePair() {
        int res = INITIAL_VALUE_TO_PASS_CONDITION;
        int i = 0;
        while (i < handSize() - 1 && res == INITIAL_VALUE_TO_PASS_CONDITION){
            Card thisCard = (Card) oneHand.get(i);
            Card nextCard = (Card) oneHand.get(i + 1);
            if (thisCard.getValue() == nextCard.getValue()) {
                res = i;

            }
            i++;
        }
        return res;
    }

    /**
     * check whether a hand has two-pair cards
     * @return the array list of indexes of first occurrence of two-pairs cards in the hand if exist
     */

    public ArrayList<Integer> getIndexesOfTwoPairs() {
        int onePairIndex = getIndexOfOnePair();
        ArrayList<Integer> listTwoPairsIndex = new ArrayList<Integer>();
        listTwoPairsIndex.add(onePairIndex);
        if (0 <= onePairIndex && onePairIndex < MAX_INDEX_OF_PAIR) {
            int pairIndex = onePairIndex + MAX_INDEX_OF_PAIR;
            int i = pairIndex;
            while (i < handSize() - 1 && listTwoPairsIndex.size() < MAX_NUM_TWO_PAIRS_INDEXES){
                Card thisCard = (Card) oneHand.get(i);
                Card nextCard = (Card) oneHand.get(i + 1);
                if (thisCard.getValue() == nextCard.getValue()) {
                    listTwoPairsIndex.add(i);
                }
                i++;
            }

        }
        return listTwoPairsIndex;
    }

    /**
     *
     * @return get the value of the remaining card of a hand when the four cards are two-pairs
     * Use when two hands has two equal two-pairs so we need compare the remaining cards of both hands
     */

    private int getLoneCard() {
        ArrayList<Integer> possibleTwoPairs = getIndexesOfTwoPairs();
        ArrayList<Card> tempHand = new ArrayList<Card>(this.oneHand);

        if (possibleTwoPairs.size() == EXIST_TWO_EQUAL_PAIRS) {

            tempHand.remove(tempHand.get(possibleTwoPairs.get(1)));
            tempHand.remove(tempHand.get(possibleTwoPairs.get(1)));

            tempHand.remove(tempHand.get(possibleTwoPairs.get(0)));
            tempHand.remove(tempHand.get(possibleTwoPairs.get(0)));


        }
        return tempHand.get(0).getValue();
    }

    /**
     *
     * @return the score of each different kinds of hands;
     * score of: flush (3) > two-pairs (2) > pair (1) > high-card (0)
     */

    private int getScore(){
        int score = 0;
        if (isFlush()){
            score = IS_FLUSH;

        } else if (getIndexesOfTwoPairs().size() == EXIST_TWO_EQUAL_PAIRS){
            score = IS_TWO_PAIRS;

        } else if (getIndexOfOnePair() >= 0 ){
            score = IS_PAIR;
        }
        return score;
    }

    /**
     *
     * @param other the second poker hand
     * @return the result whether first or second poker hand wins
     * 1 means first hand wins; -1 means second hand wins; 0 means tie game
     * Use when both hands are flushes or have equal one pair and want to compare the remaining cards to decide winner
     */
    private int compareRemain(PokerHand other){
        int i = 0;
        while (this.oneHand.get(i).getValue() == other.oneHand.get(i).getValue() && i < handSize() - 1){
            i++;

        }
        if(i == handSize() - 1 && this.oneHand.get(i).getValue() == other.oneHand.get(i).getValue()){
            return TIE_GAME;
        }
        else {
            if(this.oneHand.get(i).getValue() > other.oneHand.get(i).getValue()){
                return FIRST_HAND_WINS;
            }
            else {
                return SECOND_HAND_WINS;
            }
        }
    }

    /**
     *
     * @param other second poker hand
     * @return the result whether first or second poker hand wins
     * 1 means first hand wins; -1 means second hand wins; 0 means tie game
     * Use to check different possibilities of two hands to compare:
     * if they are different kinds;
     * if they are same kinds: both flushes, both two-pairs (equal two-pairs of both hands or different two-pairs),
     * both pairs (equal pairs of both hands or different), both high-cards
     *
     * the statement if(compareTwoPairsValue(other) != TIE_GAME)
     * or if (compareOnePairValue(other, indexOnePairHand, indexOnePairOther) != TIE_GAME)
     * means if both hands have different two-pairs or one-pair values
     */

    public int compareTo(PokerHand other) {
        if (equals(other)){
            return TIE_GAME;
        }
        int differentKind = compareDifferentKind(other);
        if (differentKind != TIE_GAME) {
            return differentKind;


        } else {
            if (getScore() == IS_FLUSH) {
                return compareRemain(other);
            }
            else if (getScore() == IS_TWO_PAIRS) {
                int twoPairsValue = compareTwoPairsValue(other);
                if (twoPairsValue != TIE_GAME) {

                    return twoPairsValue;

                } else {

                    return compareRemainOfTwoPairsEqual(other);
                }
            }
            else if (getScore() == IS_PAIR) {
                int indexOnePairHand = getIndexOfOnePair();
                int indexOnePairOther = other.getIndexOfOnePair();
                int onePairValue = compareOnePairValue(other, indexOnePairHand, indexOnePairOther);
                if (onePairValue != TIE_GAME) {
                    return onePairValue;


                }else {
                    return compareRemainOfOnePairEqual(other, indexOnePairHand, indexOnePairOther);
                }
            }
            else {
                return compareRemain(other);
            }


        }

    }


    /**
     *
     * @param other second poker hand
     * @return decide whether which hand wins when two hands with two different kinds
     * 1 means first hand wins; -1 means second hand wins; 0 means tie game
     */


    private int compareDifferentKind(PokerHand other){
        if(getScore() > other.getScore()){
            return FIRST_HAND_WINS;
        }
        else if(getScore() < other.getScore()){
            return SECOND_HAND_WINS;
        }
        return TIE_GAME;

    }

    /**
     *
     * @param other second poker hand
     * @return decide which hand wins when compare the values of their two-pairs
     * 1 means first hand wins
     * -1 means second hand wins
     * return TIE_GAMES means two hands have equal two pairs, so we need to compare the value of remaining card
     */

    private int compareTwoPairsValue(PokerHand other){
        ArrayList<Integer> indexTwoPairsHand =  getIndexesOfTwoPairs();
        ArrayList<Integer> indexTwoPairsOther = other.getIndexesOfTwoPairs();


        for(int i = 0; i < indexTwoPairsHand.size(); i++) {
            int indexHand = indexTwoPairsHand.get(i);
            int indexOther = indexTwoPairsOther.get(i);

            if (this.oneHand.get(indexHand).getValue() > other.oneHand.get(indexOther).getValue()) {


                return FIRST_HAND_WINS;
            } else if (this.oneHand.get(indexHand).getValue() < other.oneHand.get(indexOther).getValue()) {

                return SECOND_HAND_WINS;
            }

        }

        return TIE_GAME;
    }

    /**
     *
     * @param other other poker hand
     * @return compare the remaining card value of two hands when they have equal two-pairs
     * 1 means first hand wins
     * -1 means second hand wins
     * 0 means tie game
     */

    private int compareRemainOfTwoPairsEqual(PokerHand other){
        int possibleIndex = 0;
        while (this.oneHand.get(possibleIndex).getValue() == other.oneHand.get(possibleIndex).getValue() && possibleIndex <= 1) {
            possibleIndex++;

        }
        if (possibleIndex == EXIST_TWO_EQUAL_PAIRS) {
            if (this.getLoneCard() > other.getLoneCard()) {


                return FIRST_HAND_WINS;

            } else if (this.getLoneCard() < other.getLoneCard()) {

                return SECOND_HAND_WINS;
            } else {

                return TIE_GAME;
            }
        }
        else {

            return MAKE_SURE_METHOD_RETURNED_VALUE;
        }
    }

    /**
     *
     * @param other second poker hand
     * @param indexOnePairHand the index of the one-pair card in first hand
     * @param indexOnePairOther the index of the one-pair card in second hand
     * @return decide which hand wins by comparing the value of their one-pair
     * 1 means first hand wins
     * -1 means second hand wins
     * return TIE_GAME means they both have equal one-pair, so we need to compare the remaining cards
     */

    private int compareOnePairValue(PokerHand other, int indexOnePairHand, int indexOnePairOther){

        if (this.oneHand.get(indexOnePairHand).getValue() > other.oneHand.get(indexOnePairOther).getValue()) {
            return FIRST_HAND_WINS;
        } else if (this.oneHand.get(indexOnePairHand).getValue() < other.oneHand.get(indexOnePairOther).getValue()) {
            return SECOND_HAND_WINS;
        }
        return TIE_GAME;
    }

    private ArrayList<Integer> getValueOfPoker(){
        ArrayList<Integer> res = new ArrayList<Integer>();
        for(Card c: this.oneHand){
            res.add(c.getValue());
        }
        return res;
    }

    private ArrayList<String> getSuitOfPoker(){
        ArrayList<String> res = new ArrayList<String>();
        for(Card c: this.oneHand){
            res.add(c.getSuit());
        }
        return res;
    }

    /**
     *
     * @param other second poker hand
     * @param indexHand the index of one-pair card in first hand
     * @param indexOther the index of one-pair card in second hand
     * @return decide which hand wins when compare the remaining cards
     * in compareRemain method: 1 means first hand wins; -1 means second hand wins; 0 means tie game
     *
     *
     */

    private int compareRemainOfOnePairEqual(PokerHand other, int indexHand, int indexOther){
        ArrayList<Card> tempHand = new ArrayList<Card>(this.oneHand);
        ArrayList<Card> tempOther = new ArrayList<Card>(other.oneHand);
        tempHand.remove(tempHand.get(indexHand));
        tempHand.remove(tempHand.get(indexHand));
        tempOther.remove(tempOther.get(indexOther));
        tempOther.remove(tempOther.get(indexOther));


        return compareRemain(other);
    }

    /**
     * Check whether two hands are identical
     * @param other other poker hand
     * @return true if two hands are identical, else return false
     */

    public boolean equals(Object other){
        if(other == null){
            return false;
        } else if(other == this){
            return true;
        } else if(!(other instanceof PokerHand)){
            return false;
        } else{
            PokerHand otherPoker = (PokerHand) other;
            return otherPoker.getValueOfPoker().equals(getValueOfPoker())
                    && otherPoker.getSuitOfPoker().equals(getSuitOfPoker());
        }

    }

}

