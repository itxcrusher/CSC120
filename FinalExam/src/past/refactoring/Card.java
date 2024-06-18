package past.refactoring;

public class Card {

    private static final int RANK_JACK = 11;
    private static final int RANK_QUEEN = 12;
    private static final int RANK_KING = 13;
    private static final int RANK_ACE = 14;
    private static final String[] VALID_SUITS = {"Hearts", "Diamonds", "Clubs", "Spades"};
    private final int rank;
    private final String suit;

    public Card(int rank, String suit) {
        if (!isValidSuit(suit)) {
            throw new IllegalArgumentException("Invalid suit: " + suit);
        }
        this.rank = rank;
        this.suit = suit;
    }

    private static boolean isValidSuit(String suit) {
        for (String validSuit : VALID_SUITS) {
            if (validSuit.equals(suit)) {
                return true;
            }
        }
        return false;
    }

    public int getRank() {
        return rank;
    }

    public String getSuit() {
        return suit;
    }

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