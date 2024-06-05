import java.util.Random;

/**
 * LoadedDice represents a die that is weighted to roll a certain value more often.
 */
public class LoadedDice implements Dice {
    private static final int DEFAULT_MEAN_VALUE = 4;
    private static final int MAX_VALUE = 6;
    private static final double DEVIATION = 0.3;

    private int value;
    private int meanValue;

    /**
     * Constructs a LoadedDice weighted to roll a 4 more often.
     */
    public LoadedDice() {
        this.meanValue = DEFAULT_MEAN_VALUE;
        roll();
    }

    /**
     * Constructs a LoadedDice weighted to roll the specified mean value more often.
     * @param meanValue the value the dice should roll most often.
     */
    public LoadedDice(int meanValue) {
        if (meanValue < 1 || meanValue > MAX_VALUE) {
            throw new IllegalArgumentException("Mean value must be between 1 and " + MAX_VALUE);
        }
        this.meanValue = meanValue;
        roll();
    }

    /**
     * Rolls the dice to get a weighted random value.
     */
    public void roll() {
        value = (int) Math.round(new Random().nextGaussian() * DEVIATION + meanValue);
        if (value < 1) {
            value = 1;
        }
        if (value > MAX_VALUE) {
            value = MAX_VALUE;
        }
    }

    /**
     * Gets the current value of the dice.
     * @return the value of the dice.
     */
    public int getValue() {
        return value;
    }
}