
import java.util.Scanner;

/**
 * This class to play the poker game: compare two random poker hands and decide the winner, ask the user who wins
 * if they answer correct, their score is incremented by 1, the maximum score is 5
 * if they answer wrong, game over and count their score
 * if after 5 times there is not enough cards left in the deck, game over and count their score
 */
public class Main {
    private final int NUM_CARDS_IN_TWO_HANDS = 10;

    /**
     * the poker game program
     */
    public void RunGame(){
        int score = 0;
        Deck theDeck = new Deck();
        int sizeDeck = theDeck.getSizeDeck();
        while(sizeDeck >= NUM_CARDS_IN_TWO_HANDS){

            PokerHand hand1 = getAPokerHand(theDeck, 1);
            PokerHand hand2 = getAPokerHand(theDeck, 2);

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
     * create a poker hand and print out the hand for the user to guess and play
     * @param theDeck deck of a card created
     * @param whatHand poker hand #number want to create
     * @return the poker hand created
     */

    private PokerHand getAPokerHand(Deck theDeck, int whatHand){
        PokerHand myPoker = new PokerHand();
        myPoker.getSortedHand(theDeck);

        System.out.println("Hand " + whatHand + " : " + myPoker);

        return myPoker;
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






