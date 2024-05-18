package proj3; // do not erase. Gradescope expects this.

/**
 * Represents a playing card with a rank and suit.
 */
public class Card {

    private static final int RANK_JACK = 11;
    private static final int RANK_QUEEN = 12;
    private static final int RANK_KING = 13;
    private static final int RANK_ACE = 14;

    /**
     * An array containing all valid card suits.
     */
    private static final String[] VALID_SUITS = {"Hearts", "Diamonds", "Clubs", "Spades"};

    /**
     * The rank of the card (e.g., 2, Jack, Queen).
     */
    private final int rank;

    /**
     * The suit of the card (e.g., Hearts, Diamonds).
     */
    private final String suit;

    /**
     * Constructs a new `Card` object with the specified rank and suit.
     *
     * @param rank The rank of the card (e.g., 2, Jack, Queen).
     * @param suit The suit of the card (e.g., Hearts, Diamonds).
     * @throws IllegalArgumentException if the provided suit is invalid.
     */
    public Card(int rank, String suit) {
        if (!isValidSuit(suit)) {
            throw new IllegalArgumentException("Invalid suit: " + suit);
        }
        this.rank = rank;
        this.suit = suit;
    }

    /**
     * Checks if the provided suit is valid.
     *
     * @param suit The suit to be validated.
     * @return True if the suit is valid, false otherwise.
     */
    private static boolean isValidSuit(String suit) {
        for (String validSuit : VALID_SUITS) {
            if (validSuit.equals(suit)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Returns the rank of the card.
     *
     * @return The rank of the card (e.g., 2, Jack, Queen).
     */
    public int getRank() {
        return rank;
    }

    /**
     * Returns the suit of the card.
     *
     * @return The suit of the card (e.g., Hearts, Diamonds).
     */
    public String getSuit() {
        return suit;
    }

    /**
     * Returns a string representation of the card in the format "rank of suit".
     * (e.g., "Ace of Spades", "Jack of Hearts").
     *
     * @return The string representation of the card.
     */
    @Override
    public String toString() {
        String rankString;
        switch (rank) {
            case RANK_JACK:
                rankString = "Jack";
                break;
            case RANK_QUEEN:
                rankString = "Queen";
                break;
            case RANK_KING:
                rankString = "King";
                break;
            case RANK_ACE:
                rankString = "Ace";
                break;
            default:
                rankString = String.valueOf(rank);
                break;
        }
        return rankString + " of " + suit;
    }
}