import random


class Dice:

    def __init__(self, sides=6):
        """

        :param sides: the sides of the dice, in extra credit the default is 6
        """
        self.__sides = sides
        self.__random_num = random.randint(1, sides)

    def roll_dice(self):
        """

        :return: NoneType, operate by randomly rolling the dice to get certain  value
        """
        self.__random_num = random.randint(1, self.__sides)

    def get_current(self):
        """

        :return: the current value of rolled dice
        """
        return self.__random_num
