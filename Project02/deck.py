import random
from card import Card


class Deck:
    
    def __init__(self):
        """
        create a deck of 52 cards as a list
        """
        self.__cards = [Card(rank, suit) for suit in ['Clubs', 'Diamonds', 'Hearts', 'Spades']
                        for rank in range(2, 15)]
        self.shuffle()

    def shuffle(self):
        """
        :return: randomly shuffle the deck
        """
        random.shuffle(self.__cards)

    def deal(self, num_cards):
        """
        Deal a specified number of cards from the deck.
        :param: num_cards: The number of cards to deal.
        :return: list: A list of Card objects being dealt.
        """
        if len(self.__cards) < num_cards:
            raise ValueError("Not enough cards in the deck to deal the requested number.")
        return [self.__cards.pop() for _ in range(num_cards)]
