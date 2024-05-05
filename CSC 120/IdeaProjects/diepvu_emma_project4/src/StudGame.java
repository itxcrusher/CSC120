import java.util.Scanner;

/**
 * This class to play the stud game: create a community set of 5 random cards from a deck
 * and repeatedly draws two new stud poker hands
 * Get the best 5 cards to get a stud hands and compare two stud poker hands and decide the winner, ask the user who wins
 * if they answer correct, their score is incremented by 1, the maximum score is 11
 * if they answer wrong, game over and count their score
 * if after 11 times there is not enough cards left in the deck, game over and count their score
 */


public class StudGame {
    private static int NUM_CARDS_IN_TWO_STUD_HANDS = 4;
    private static int NUM_CARDS_IN_ONE_STUD_HAND = 2;
    private static int NUM_CARDS_IN_COMMUNITY_SET = 5;

    /**
     *
     * @param deck the deck to deal 5 cards to create one community set
     * @param community the empty community set created
     * Add 5 random cards dealt from the deck to get a community set that is no longer empty
     */
    private void getOneCommunity(Deck deck, CommunityCardSet community){

        for (int i = 0; i < NUM_CARDS_IN_COMMUNITY_SET; i++){
            community.addCardToCommunity(deck.dealCard());
        }
    }

    /**
     * Add 2 random hole cards dealt from the deck to get a stud poker hand that is no longer empty
     * @param deck the deck to deal 2 hole cards to add in stud poker hand
     * @param stud the empty stud poker hand to get added 2 hole cards
     */
    private void getTwoHoleCards(Deck deck, StudPokerHand stud){
        for (int i = 0; i < NUM_CARDS_IN_ONE_STUD_HAND; i++){
            stud.addCardToStud(deck.dealCard());
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
     * Print out the community set and stud poker hands and ask user which hand worths more
     * @param deck the deck to be dealt to get community set and stud poker hands
     * @param community the community set created from 5 random cards in the deck
     * @return the result of which hand worths more
     * if hand 1 wins then return 1; hand 2 wins then return -1; tie game then return 0
     */

    private int ShowCommunityAndStudToGetResult(Deck deck, CommunityCardSet community){
        System.out.println("The community cards are: " + community);

        StudPokerHand myStud = new StudPokerHand(community);
        getTwoHoleCards(deck, myStud);
        System.out.println("Which worth more?");

        System.out.println("Hand 1: " + myStud);

        StudPokerHand otherStud = new StudPokerHand(community);
        getTwoHoleCards(deck, otherStud);
        System.out.println("Hand 2: " + otherStud);
        return myStud.compareTo(otherStud);
    }

    /**
     * Run the stud game and print out user's score out of 11
     */

    private void runGame(){
        int score = 0;
        Deck theDeck = new Deck();
        CommunityCardSet theCommunity = new CommunityCardSet();
        getOneCommunity(theDeck, theCommunity);
        int sizeDeck = theDeck.getSizeDeck();
        while(sizeDeck >= NUM_CARDS_IN_TWO_STUD_HANDS) {

            int result = ShowCommunityAndStudToGetResult(theDeck, theCommunity);

            sizeDeck = theDeck.getSizeDeck();


            int userInput = getUserInput();
            if(userInput == result){
                System.out.println("Correct");
                score++;

            } else{
                System.out.println("Wrong! Game over.");
                System.out.println("Your score is: " + score);
                return;
            } if(sizeDeck < NUM_CARDS_IN_TWO_STUD_HANDS){
                System.out.println("Out of cards to play, your score is: " + score);
                return;
            }

        }
    }

    /**
     * Run the class StudGame java
     * @param args
     */
    public static void main(String[] args) {
        StudGame game = new StudGame();
        game.runGame();
    }
}
