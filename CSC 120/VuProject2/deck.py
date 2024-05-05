import card
import random

SMALLEST_CARD_NUMBER = 2
BIGGEST_CARD_NUMBER = 10
NUM_CARDS_ON_TWO_HANDS = 10


class Deck:

    def __init__(self):
        """
        create a deck of 52 cards as a list
        """
        self.__deck = []
        suits = ['C', 'D', 'H', 'S']
        rank = [str(i) for i in range(SMALLEST_CARD_NUMBER, BIGGEST_CARD_NUMBER + 1)]
        rank.extend(['J', 'Q', 'K', 'Ace'])

        for suit in suits:
            for j in range(len(rank)):
                my_card = card.Card(rank[j], suit, j + 2)

                self.__deck.append(my_card)

    def shuffle_deck(self):
        """

        :return: randomly shuffle the deck
        """

        random.shuffle(self.__deck)

    def deal_a_card(self):
        """

        :return: deal the first card
        """
        return self.__deck.pop(0)

    def get_length(self):
        """

        :return: the length of deck
        """
        return len(self.__deck)

    def __str__(self):
        """

        :return: print out deck of cards
        """
        return str(self.__deck)

    def __repr__(self):
        """

        :return: print out deck of cards with better representation
        """
        return str(self.__deck)
