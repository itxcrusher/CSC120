/*
* Author’s Name: Ali Hamza
* Honor Code: I hereby affirm that I have carried out all my academic endeavours with full academic honesty.
* */

import java.util.Random;
import java.util.Scanner;

public class Main {

    /**
     * The main method that runs the dice game.
     *
     * @param args Command-line arguments (unused).
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Dice dice1 = new Dice();

        Dice dice2 = new Dice(12);

        while (true) {
            System.out.println("Press Enter to roll the dice...");
            scanner.nextLine();

            dice1.roll();
            dice2.roll();

            System.out.println("Dice 1: " + dice1.getValue());
            System.out.println("Dice 2: " + dice2.getValue());

            if (dice1.getValue() == dice2.getValue() * 2 || dice2.getValue() == dice1.getValue() * 2) {
                System.out.println("You won!");
                break;
            }
        }
    }
}
