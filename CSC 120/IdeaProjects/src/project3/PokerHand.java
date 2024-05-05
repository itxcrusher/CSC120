import java.util.ArrayList;

public class PokerHand {

    private final int FIRST_HAND_WINS = 1;
    private final int SECOND_HAND_WINS = -1;
    private final int TIE_GAME = 0;
    private final int MAX_INDEX_OF_PAIR = 2;
    private final int INITIAL_VALUE_TO_PASS_CONDITION = -5;
    private final int EXIST_TWO_EQUAL_PAIRS = 2;
    private final int IS_FLUSH = 3;
    private final int IS_TWO_PAIRS = 2;
    private final int IS_PAIR = 1;
    private final int IS_HIGH_CARD = 0;

    private final int MAKE_SURE_METHOD_RETURNED_VALUE = 120;
    private final int NUM_CARDS_IN_ONE_HAND = 5;



    private ArrayList<Card> OneHand;

    /**
     * Create a poker hand as an array list of cards
     */
    public PokerHand() {
        OneHand = new ArrayList<Card>();
    }

    /**
     *
     * @return the number of cards in a poker hand
     */
    private int handSize() {
        return this.OneHand.size();
    }

    /**
     *
     * @param addedCard a card that has been dealt from the deck to add in the hand
     */
    public void addCardInOrder(Card addedCard){

        int addedCardIndex = 0;
        while(addedCardIndex < handSize()){
            if(addedCard.getValue() < OneHand.get(addedCardIndex).getValue()){
                addedCardIndex++;
            } else{
                break;
            }

        }
        OneHand.add(addedCardIndex, addedCard);


    }

    /**
     *
     * @param getDeck the deck created
     */
    public void getSortedHand(Deck getDeck){
        for(int i = 0; i < NUM_CARDS_IN_ONE_HAND; i++){
            addCardInOrder(getDeck.dealCard());
        }

    }

    /**
     *
     * @return true if the hand is flush; other wise false
     */
    private boolean checkFlush() {
        boolean stat = true;
        for (int i = 0; i < handSize() - 1; i++) {
            Card thisCard = (Card) OneHand.get(i);
            Card nextCard = (Card) OneHand.get(i + 1);
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
        return this.OneHand.toString();
    }

    /**
     * check whether a hand has one pair
     * @return the index of the one-pair card in the hand if exist
     */
    private int checkOnePair() {
        int res = INITIAL_VALUE_TO_PASS_CONDITION;

        for (int i = 0; i < handSize() - 1; i++) {
            Card thisCard = (Card) OneHand.get(i);
            Card nextCard = (Card) OneHand.get(i + 1);
            if (thisCard.getValue() == nextCard.getValue()) {
                res = i;

                break;
            }

        }

        return res;

    }

    /**
     * check whether a hand has two-pair cards
     * @return the array list of indexes of two-pairs cards in the hand if exist
     */

    private ArrayList<Integer> checkTwoPairs() {
        int isOnePair = checkOnePair();
        ArrayList<Integer> listTwoPairs = new ArrayList<Integer>();
        listTwoPairs.add(isOnePair);
        if (0 <= isOnePair && isOnePair < MAX_INDEX_OF_PAIR) {
            int pairIndex = isOnePair + MAX_INDEX_OF_PAIR;
            for (int i = pairIndex; i < handSize() - 1; i++) {
                Card thisCard = (Card) OneHand.get(i);
                Card nextCard = (Card) OneHand.get(i + 1);
                if (thisCard.getValue() == nextCard.getValue()) {
                    listTwoPairs.add(i);

                    break;

                }
            }
        }
        return listTwoPairs;

    }

    /**
     *
     * @return get the value of the remaining card of a hand when the four cards are two-pairs
     * Use when two hands has two equal two-pairs so we need compare the remaining cards of both hands
     */

    private int getLoneCard() {
        ArrayList<Integer> possibleTwoPairs = checkTwoPairs();
        ArrayList<Card> tempHand = new ArrayList<Card>(this.OneHand);

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
        if (checkFlush()){
            score = IS_FLUSH;

        } else if (checkTwoPairs().size() == EXIST_TWO_EQUAL_PAIRS){
            score = IS_TWO_PAIRS;

        } else if (checkOnePair() >= 0 ){
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
        while (this.OneHand.get(i).getValue() == other.OneHand.get(i).getValue() && i < handSize() - 1){
            i++;

        }
        if(i == this.OneHand.size() - 1 && this.OneHand.get(i).getValue() == other.OneHand.get(i).getValue()){
            return TIE_GAME;
        }
        else {
            if(this.OneHand.get(i).getValue() > other.OneHand.get(i).getValue()){
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
        if (compareDifferentKind(other) != TIE_GAME) {
            return compareDifferentKind(other);


        } else {
            if (getScore() == IS_FLUSH) {
                return compareRemain(other);
            }
            else if (getScore() == IS_TWO_PAIRS) {
                if (compareTwoPairsValue(other) != TIE_GAME) {
                    return compareTwoPairsValue(other);

                } else {
                    return compareRemainOfTwoPairsEqual(other);
                }
            }
            else if (getScore() == IS_PAIR) {
                int indexOnePairHand = checkOnePair();
                int indexOnePairOther = checkOnePair();
                if (compareOnePairValue(other, indexOnePairHand, indexOnePairOther) != TIE_GAME) {
                    return compareOnePairValue(other, indexOnePairHand, indexOnePairOther);


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
        ArrayList<Integer> indexTwoPairsHand =  checkTwoPairs();
        ArrayList<Integer> indexTwoPairsOther = checkTwoPairs();
        for(int i = 0; i < indexTwoPairsHand.size(); i++) {
            int indexHand = indexTwoPairsHand.get(i);
            int indexOther = indexTwoPairsOther.get(i);

            if (this.OneHand.get(indexHand).getValue() > other.OneHand.get(indexOther).getValue()) {

                return FIRST_HAND_WINS;
            } else if (this.OneHand.get(indexHand).getValue() < other.OneHand.get(indexOther).getValue()) {
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
        while (this.OneHand.get(possibleIndex).getValue() == other.OneHand.get(possibleIndex).getValue() && possibleIndex <= 1) {
            possibleIndex++;

        }
        if (possibleIndex == EXIST_TWO_EQUAL_PAIRS) {
            if (getLoneCard() > other.getLoneCard()) {

                return FIRST_HAND_WINS;

            } else if (getLoneCard() < other.getLoneCard()) {
                return SECOND_HAND_WINS;
            } else {
                return TIE_GAME;
            }
        }
        return MAKE_SURE_METHOD_RETURNED_VALUE;
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

        if (this.OneHand.get(indexOnePairHand).getValue() > other.OneHand.get(indexOnePairOther).getValue()) {
            return FIRST_HAND_WINS;
        } else if (this.OneHand.get(indexOnePairHand).getValue() < other.OneHand.get(indexOnePairOther).getValue()) {
            return SECOND_HAND_WINS;
        }
        return TIE_GAME;
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
        ArrayList<Card> tempHand = new ArrayList<Card>(this.OneHand);
        ArrayList<Card> tempOther = new ArrayList<Card>(other.OneHand);
        tempHand.remove(tempHand.get(indexHand));
        tempHand.remove(tempHand.get(indexHand));
        tempOther.remove(tempOther.get(indexOther));
        tempOther.remove(tempOther.get(indexOther));


        return compareRemain(other);
    }



}

