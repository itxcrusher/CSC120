package proj4;

/**
 * This class represents a playing card with a rank and suit.
 */
public class Card {
    private final int rank;
    private final int suit;

    private static final int SPADES = 0;
    private static final int HEARTS = 1;
    private static final int CLUBS = 2;
    private static final int DIAMONDS = 3;

    private static final int TWO = 2;
    private static final int THREE = 3;
    private static final int FOUR = 4;
    private static final int FIVE = 5;
    private static final int SIX = 6;
    private static final int SEVEN = 7;
    private static final int EIGHT = 8;
    private static final int NINE = 9;
    private static final int TEN = 10;
    private static final int JACK = 11;
    private static final int QUEEN = 12;
    private static final int KING = 13;
    private static final int ACE = 14;

    /**
     * Constructs a Card with the specified rank and suit.
     *
     * @param rank the rank of the card, as a String.
     * @param suit the suit of the card, as a String.
     * @throws IllegalArgumentException if the rank or suit is invalid.
     */
    public Card(String rank, String suit) {
        this.rank = convertRank(rank);
        this.suit = convertSuit(suit);
    }

    /**
     * Constructs a Card with the specified rank and suit.
     *
     * @param rank the rank of the card, as an int.
     * @param suit the suit of the card, as an int.
     */
    public Card(int rank, int suit) {
        this.rank = rank;
        this.suit = suit;
    }

    /**
     * Constructs a Card with the specified rank and suit.
     *
     * @param rank the rank of the card, as an int.
     * @param suit the suit of the card, as a String.
     * @throws IllegalArgumentException if the suit is invalid.
     */
    public Card(int rank, String suit) {
        this.rank = rank;
        this.suit = convertSuit(suit);
    }

    /**
     * Constructs a Card with the specified rank and suit.
     *
     * @param rank the rank of the card, as a String.
     * @param suit the suit of the card, as an int.
     * @throws IllegalArgumentException if the rank is invalid.
     */
    public Card(String rank, int suit) {
        this.rank = convertRank(rank);
        this.suit = suit;
    }

    /**
     * Returns the rank of the card.
     *
     * @return the rank of the card.
     */
    public int getRank() {
        return rank;
    }

    /**
     * Returns the suit of the card.
     *
     * @return the suit of the card.
     */
    public int getSuit() {
        return suit;
    }

    /**
     * Returns a string representation of the card.
     *
     * @return a string representation of the card.
     */
    @Override
    public String toString() {
        return rankToString(rank) + " of " + suitToString(suit);
    }

    /**
     * Converts a rank from a String to an int.
     *
     * @param rank the rank of the card, as a String.
     * @return the rank of the card, as an int.
     * @throws IllegalArgumentException if the rank is invalid.
     */
    private int convertRank(String rank) {
        switch (rank.toLowerCase()) {
            case "2":
            case "two": return TWO;
            case "3":
            case "three": return THREE;
            case "4":
            case "four": return FOUR;
            case "5":
            case "five": return FIVE;
            case "6":
            case "six": return SIX;
            case "7":
            case "seven": return SEVEN;
            case "8":
            case "eight": return EIGHT;
            case "9":
            case "nine": return NINE;
            case "10":
            case "ten": return TEN;
            case "jack": return JACK;
            case "queen": return QUEEN;
            case "king": return KING;
            case "ace": return ACE;
            default: throw new IllegalArgumentException("Invalid rank: " + rank);
        }
    }

    /**
     * Converts a suit from a String to an int.
     *
     * @param suit the suit of the card, as a String.
     * @return the suit of the card, as an int.
     * @throws IllegalArgumentException if the suit is invalid.
     */
    private int convertSuit(String suit) {
        switch (suit.toLowerCase()) {
            case "spades": return SPADES;
            case "hearts": return HEARTS;
            case "clubs": return CLUBS;
            case "diamonds": return DIAMONDS;
            default: throw new IllegalArgumentException("Invalid suit: " + suit);
        }
    }

    /**
     * Converts a rank from an int to a String.
     *
     * @param rank the rank of the card, as an int.
     * @return the rank of the card, as a String.
     */
    private String rankToString(int rank) {
        switch (rank) {
            case JACK: return "Jack";
            case QUEEN: return "Queen";
            case KING: return "King";
            case ACE: return "Ace";
            default: return String.valueOf(rank);
        }
    }

    /**
     * Converts a suit from an int to a String.
     *
     * @param suit the suit of the card, as an int.
     * @return the suit of the card, as a String.
     * @throws IllegalArgumentException if the suit is invalid.
     */
    private String suitToString(int suit) {
        switch (suit) {
            case SPADES: return "Spades";
            case HEARTS: return "Hearts";
            case CLUBS: return "Clubs";
            case DIAMONDS: return "Diamonds";
            default: throw new IllegalArgumentException("Invalid suit: " + suit);
        }
    }
}