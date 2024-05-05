/**
 * This class is to make a single card
 */

public class Card {

    private String rank;
    private String suit;
    private int value;

    /**
     *
     * @param rank the string rank of a card, from 2 to Ace
     * @param suit the string suit of a card, Clubs (C), Hearts (H), Spades (S), Diamonds (D)
     * @param value the integer value of a card, from 2 to 14
     * Cards with ranks from 2 to 10 have the values corresponding to the ranks
     * Value of: Jack is 11, Queen is 12, King is 13, Ace is 14
     */

    public Card(String rank, String suit, int value) {
        this.rank = rank;
        this.suit = suit;
        this.value = value;

    }

    /**
     *
     * @return the string rank of a card
     */
    public String getRank() {
        return this.rank;
    }

    /**
     *
     * @return the string suit of a card
     */

    public String getSuit() {
        return this.suit;
    }

    /**
     *
     * @return the integer value of a card
     */
    public int getValue() {
        return this.value;
    }

    /**
     *
     * @return representation of a card as a string concatenation
     */
    public String toString() {
        return getRank() + " | " + getSuit();

    }

}
