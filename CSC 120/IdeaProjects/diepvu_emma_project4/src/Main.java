
import java.util.Scanner;

/**
 * This class to play the poker game: compare two random poker hands and decide the winner, ask the user who wins
 * if they answer correct, their score is incremented by 1, the maximum score is 5
 * if they answer wrong, game over and count their score
 * if after 5 times there is not enough cards left in the deck, game over and count their score
 */
public class Main {
    private static int NUM_CARDS_IN_TWO_HANDS = 10;
    private static int NUM_CARDS_IN_ONE_HAND = 5;

    /**
     * the poker game program and print out score out of 5
     */
    public void RunGame(){
        int score = 0;
        Deck theDeck = new Deck();
        int sizeDeck = theDeck.getSizeDeck();
        while(sizeDeck >= NUM_CARDS_IN_TWO_HANDS){

            PokerHand hand1 = ShowSortedPokerHand(theDeck, 1);
            PokerHand hand2 = ShowSortedPokerHand(theDeck, 2);

            sizeDeck = theDeck.getSizeDeck();

            int result = hand1.compareTo(hand2);

            int userInput = getUserInput();
            if(userInput == result){
                System.out.println("Correct");
                score++;

            } else{
                System.out.println("Wrong! Game over.");
                System.out.println("Your score is: " + score);
                return;
            } if(sizeDeck < NUM_CARDS_IN_TWO_HANDS){
                System.out.println("Out of cards to play, your score is: " + score);
                return;
            }

        }

    }


    /**
     *
     * @param getDeck the deck created
     */
    private void getSortedPokerHand(Deck getDeck, PokerHand poker){
        for(int i = 0; i < NUM_CARDS_IN_ONE_HAND; i++){
            poker.addCardInOrder(getDeck.dealCard());
        }

    }

    /**
     *
     * @return the user input as an integer: 1, -1 or 0 when they guess which hand wins
     * 1 means first hand wins; -1 means second hand wins; 0 means tie game
     * if the user input other values that are not integer, it will ask again to input valid type
     */

    private int getUserInput(){
        Scanner input = new Scanner(System.in);
        System.out.println("Type 1 if first hand wins, -1 if second hand wins, 0 if tie game: ");

        while (!input.hasNextInt()) {
            System.out.println("Invalid input. Please type a number again:");
            String InputAgain = input.next();
        }
        int user = input.nextInt();
        return user;

    }

    /**
     *
     * @param deck the deck to create poker hand
     * @param whatHand # of hand (hand 1, hand 2, hand 3, etc.)
     * @return create a sorted poker hand and print out the hand
     */

    private PokerHand ShowSortedPokerHand(Deck deck, int whatHand){
        PokerHand poker = new PokerHand();
        getSortedPokerHand(deck, poker);
        System.out.println("Hand " + whatHand + ": " + poker);
        return poker;
    }



    /**
     *
     * @param args
     * Run the class Main java
     */

    public static void main(String[] args) {
        Main myGame = new Main();
        myGame.RunGame();
    }



}






