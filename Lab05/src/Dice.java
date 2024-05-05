import java.util.Random;

/**
 * This class models a die with a specified number of sides.
 */
public class Dice {

    /**
     * The number of sides the dice has.
     */
    private int numSides;

    /**
     * The current value showing on the dice.
     */
    private int currentValue;

    /**
     * Constructor that takes the number of sides the dice should have.
     * Initializes the number of sides and sets the current value to 1.
     *
     * @param numSides The number of sides for the dice.
     */
    public Dice(int numSides) {
        this.numSides = numSides;
        this.currentValue = 1;
    }

    /**
     * Default constructor that creates a D6 (6-sided dice).
     */
    public Dice() {
        this(6);
    }

    /**
     * Rolls the dice (sets the current value to a new random number from 1 to the number of sides).
     */
    public void roll() {
        Random random = new Random();
        currentValue = random.nextInt(numSides) + 1;
    }

    /**
     * Returns the current value showing on the dice.
     *
     * @return The current value (1 to number of sides).
     */
    public int getValue() {
        return currentValue;
    }
}
