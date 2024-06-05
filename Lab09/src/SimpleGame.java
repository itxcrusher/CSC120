/*
 * Author’s Name: Ali Hamza
 * Honor Code: I hereby affirm that I have carried out all my academic endeavours with full academic honesty.
 */

import java.util.Scanner;
import java.util.ArrayList;

public class SimpleGame
{
    private Scanner userInput;
    private static final int WINNING_VALUE = 21;
    
    public SimpleGame()
    {
	userInput = new Scanner(System.in);
    }
    
    public void go()
    {
	Dice d1 = new StandardDice();
	Dice d2 = new StandardDice(12);
	Dice d3 = new LoadedDice();
	Dice d4 = new LoadedDice(5);

	ArrayList<Dice> theDice = new ArrayList<Dice>();

	theDice.add(d1);
	theDice.add(d2);
	theDice.add(d3);
	theDice.add(d4);

	rollAll(theDice);
	showDice(theDice);

	while(! gameOver(theDice)) {
	    waitForInput();
	    rollAll(theDice);
	    showDice(theDice);
	}

	System.out.println("You WON!!!!");
    }

    private void waitForInput()
    {
	System.out.println("Press enter to continue");
	userInput.nextLine();
    }

    private boolean gameOver(ArrayList<Dice> list)
    {
	return (diceTotal(list) > WINNING_VALUE);
    }

    /**
     * @return total of the values on all the dice in a list
     */
    private int diceTotal(ArrayList<Dice> list) {
        int total = 0;
        for (Dice dice : list) {
            total += dice.getValue();
        }
        return total;
    }

    /**
     * rolls all the dice in a list
     */
    private void rollAll(ArrayList<Dice> list) {
        for (Dice dice : list) {
            dice.roll();
        }
    }

    /**
     * prints the dice in the list as well as their total value
     */
    private void showDice(ArrayList<Dice> list) {
        for (Dice dice : list) {
            System.out.print("[" + dice.getValue() + "] ");
        }
        System.out.println("---> " + diceTotal(list));
    }

    public static void main(String[] args)
    {
	new SimpleGame().go();
    }
    
}