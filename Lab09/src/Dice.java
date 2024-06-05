/**
 * Dice interface representing a generic dice.
 */
public interface Dice {
    /**
     * Rolls the dice to get a new value.
     */
    public void roll();

    /**
     * Gets the current value of the dice.
     * @return the value of the dice.
     */
    public int getValue();
}