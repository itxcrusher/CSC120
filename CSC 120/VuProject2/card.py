class Card:
    def __init__(self, rank, suit, value):
        """

        :param rank: rank of a card
        :param suit: suit of a card
        :param value: value of a card ranging from 2 to 14 inclusively
        """
        self.__rank = rank
        self.__suit = suit
        self.__value = value

    def get_rank(self):
        return self.__rank

    def get_suit(self):
        return self.__suit

    def get_value(self):
        return self.__value

    def __str__(self):
        """

        :return: print out a card with its rank and suit
        """
        return str(self.get_rank()) + ' | ' + str(self.get_suit())

    def __repr__(self):
        """

        :return: a card with its rank and suit and better representation
        """
        return str(self.get_rank()) + ' | ' + str(self.get_suit())
