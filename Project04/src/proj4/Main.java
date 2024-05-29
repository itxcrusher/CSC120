/*
 * Author’s Name: Ali Hamza
 * Honor Code: I hereby affirm that I have carried out all my academic endeavours with full academic honesty.
 * */

package proj4;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * This class contains the main method to run the poker game.
 */
public class Main {
    private static final int COMMUNITY_CARDS_COUNT = 5;
    private static final int HAND_CARDS_COUNT = 2;
    private static final int MINIMUM_CARDS_REQUIRED = 4;
    private static final int ZERO = 0;
    private static final int TIE = 0;
    private static final String CARD_SEPARATOR = " | ";

    /**
     * The main method to run the poker game.
     *
     * @param args command-line arguments (not used)
     */
    public static void main(String[] args) {
        Deck deck = new Deck();
        CommunityCardSet communityCards = new CommunityCardSet(new ArrayList<>());

        drawCommunityCards(deck, communityCards);

        Scanner scanner = new Scanner(System.in);
        int score = ZERO;

        while (deck.size() >= MINIMUM_CARDS_REQUIRED) {
            ArrayList<Card> holeCards1 = dealHoleCards(deck);
            ArrayList<Card> holeCards2 = dealHoleCards(deck);

            StudPokerHand hand1 = new StudPokerHand(communityCards, holeCards1);
            StudPokerHand hand2 = new StudPokerHand(communityCards, holeCards2);

            displayCommunityCards(communityCards);
            displayHands(holeCards1, holeCards2);

            String input = getInput(scanner);

            int comparison = hand1.compareTo(hand2);
            boolean isCorrect = checkAnswer(input, comparison);

            if (isCorrect) {
                System.out.println("CORRECT!!!");
                score++;
            } else {
                System.out.println("INCORRECT!!!");
                break;
            }

            System.out.println("-----------------------------------------------");
        }

        System.out.println("Game over! Your total points: " + score);
    }

    /**
     * Draws the community cards from the deck.
     *
     * @param deck           the deck to draw cards from.
     * @param communityCards the community card set to add cards to.
     */
    private static void drawCommunityCards(Deck deck, CommunityCardSet communityCards) {
        for (int i = ZERO; i < COMMUNITY_CARDS_COUNT; i++) {
            communityCards.addCard(deck.deal());
        }
    }

    /**
     * Deals a set of hole cards from the deck.
     *
     * @param deck the deck to deal cards from.
     * @return the list of hole cards.
     */
    private static ArrayList<Card> dealHoleCards(Deck deck) {
        ArrayList<Card> holeCards = new ArrayList<>();
        for (int i = ZERO; i < HAND_CARDS_COUNT; i++) {
            holeCards.add(deck.deal());
        }
        return holeCards;
    }

    /**
     * Displays the community cards.
     *
     * @param communityCards the community card set to display.
     */
    private static void displayCommunityCards(CommunityCardSet communityCards) {
        System.out.println("\nThe community cards are: ");
        for (Card card : communityCards.getCards()) {
            System.out.print(card.toString() + CARD_SEPARATOR);
        }
        System.out.println();
    }

    /**
     * Displays the hole cards for both hands.
     *
     * @param holeCards1 the hole cards for hand 1.
     * @param holeCards2 the hole cards for hand 2.
     */
    private static void displayHands(ArrayList<Card> holeCards1, ArrayList<Card> holeCards2) {
        System.out.println("\nWhich of the following hands is worth more?");
        System.out.print("Hand a: ");
        for (Card card : holeCards1) {
            System.out.print(card.toString() + ", ");
        }
        System.out.println();

        System.out.print("Hand b: ");
        for (Card card : holeCards2) {
            System.out.print(card.toString() + ", ");
        }
        System.out.println();
    }

    /**
     * Gets the user's input.
     *
     * @param scanner the scanner to read input from.
     * @return the user's input.
     */
    private static String getInput(Scanner scanner) {
        System.out.print("\nEnter a or b (or SPACE to indicate they are of equal value): ");
        return scanner.nextLine().trim();
    }

    /**
     * Checks if the user's answer is correct.
     *
     * @param input      the user's input.
     * @param comparison the result of comparing the two hands.
     * @return true if the user's answer is correct, false otherwise.
     */
    private static boolean checkAnswer(String input, int comparison) {
        return (comparison > ZERO && input.equalsIgnoreCase("a")) ||
                (comparison < ZERO && input.equalsIgnoreCase("b")) ||
                (comparison == TIE && input.equals(" "));
    }
}