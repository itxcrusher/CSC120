import java.util.ArrayList;
import java.util.Collections;
import java.util.Arrays;
import java.util.List;

/**
 * This class is to make a deck of card
 * topIndex is the index of a card in the deck to be dealt
 */
public class Deck{

    private ArrayList<Card> listCards;
    private int topIndex = 0;

    /**
     * Create a shuffled deck as an array list of 52 cards
     */
    public Deck(){
        listCards = new ArrayList<Card>();
        ArrayList<String> suits = new ArrayList<String>();
        suits.add("S");
        suits.add("C");
        suits.add("D");
        suits.add("H");
        String[] ranks = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "Ace"};
        List<String> allRanks = Arrays.asList(ranks);
        for (Object suit : suits){
            for (Object rank : allRanks){
                int indexRank = allRanks.indexOf(rank);
                Card my_card = new Card((String) rank, (String) suit, indexRank+2);
                listCards.add(my_card);
            }
        }
        shuffleDeck();
    }

    /**
     *
     * @return a deck as a string list with better representation
     */
    public String toString(){

        ArrayList<Card> printedDeck = new ArrayList<Card>();
        for (int i = topIndex; i < getSizeDeck(); i++){
            printedDeck.add(listCards.get(i));
        }

        return printedDeck.toString();
    }

    /**
     * randomly reorganize the order of the cards in a deck
     */
    private void shuffleDeck(){
        Collections.shuffle(listCards);

    }

    /**
     *
     * @return get the size of deck after dealing a card
     * The size decrements by 1 as the topIndex of the card increments by 1
     * The current size = the initial size (52) - the topIndex as it += 1
     * The method doesn't affect the number of cards in the original deck (which is still 52)
     */
    public int getSizeDeck(){
        return listCards.size() - topIndex;
    }

    /**
     *
     * @return a card dealt at its topIndex and the topIndex is constantly updated (increments by 1)
     */
    public Card dealCard(){
        Card dealtCard = listCards.get(topIndex);
        topIndex = topIndex + 1;

        return dealtCard;

    }

    private ArrayList<Integer> getValueOfDeck(){
        ArrayList<Integer> res = new ArrayList<Integer>();
        for(Card c: this.listCards){
            res.add(c.getValue());
        }
        return res;
    }

    private ArrayList<String> getSuitDeck(){
        ArrayList<String> res = new ArrayList<String>();
        for(Card c: this.listCards){
            res.add(c.getSuit());
        }
        return res;
    }

    public boolean equals(Object other){
        if(other == null){
            return false;
        } else if(other == this){
            return true;
        } else if(!(other instanceof Deck)){
            return false;
        } else{
            Deck otherDeck = (Deck) other;
            return otherDeck.getValueOfDeck().equals(getValueOfDeck())
                    && otherDeck.getSuitDeck().equals(getSuitDeck())
                    && otherDeck.getSizeDeck() == getSizeDeck();
        }

    }




}