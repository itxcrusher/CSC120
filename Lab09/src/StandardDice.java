import java.util.Random;

/**
 * StandardDice represents a standard fair dice.
 */
public class StandardDice implements Dice
{
    private int numSides;
    private int value;

    public static final int DEFAULT_NUM_SIDES = 6;

    /**
     * Constructs a StandardDice with a specified number of sides.
     * @param numSides the number of sides of the dice.
     */
    public StandardDice(int numSides)
    {
        this.numSides = numSides;
        this.value = numSides;
    }

    /**
     * Constructs a StandardDice with the default number of sides.
     */
    public StandardDice()
    {
	this(DEFAULT_NUM_SIDES);
    }

    /**
     * Rolls the dice to get a random value between 1 and numSides.
     */
    public void roll()
    {
	value = new Random().nextInt(numSides) + 1;
    }

    /**
     * Gets the current value of the dice.
     * @return the value of the dice.
     */
    public int getValue()
    {
	return value;
    }

    /**
     * Gets the number of sides of the dice.
     * @return the number of sides.
     */
    public int getNumSides()
    {
	return numSides;
    }
}