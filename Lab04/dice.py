import random


class Dice:
    """
    A class to represent a die.

    Attributes:
        __num_sides (int): The number of sides on the dice.
        __current_value (int): The current value showing on the dice.

    Methods:
        roll(): Rolls the dice to produce a new value.
        get_value(): Returns the current value of the dice.
    """

    def __init__(self, num_sides=6):
        """
        Constructs all the necessary attributes for the dice object.

        Parameters:
            num_sides (int): The number of sides on the dice, default is 6.
        """
        self.__num_sides = num_sides
        self.__current_value = self.roll()

    def roll(self):
        """
        Rolls the dice to generate a new value between 1 and the number of sides.

        Returns:
            int: The new value of the dice.
        """
        self.__current_value = random.randint(1, self.__num_sides)
        return self.__current_value

    def get_value(self):
        """
        Gets the current value showing on the dice.

        Returns:
            int: The current value of the dice.
        """
        return self.__current_value
