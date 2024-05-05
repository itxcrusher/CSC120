def break_tie(my_high_cards, their_high_cards):
    """
    Break ties between hands of the same rank by comparing individual card ranks.

    :param my_high_cards: Sorted list of the high cards from this hand.
    :param their_high_cards: Sorted list of the high cards from the other hand.
    :return: An integer result of the tie-break.
    """
    for my_card, their_card in zip(my_high_cards, their_high_cards):
        if my_card.get_rank() != their_card.get_rank():
            return my_card.get_rank() - their_card.get_rank()
    return 0


class PokerHand:
    """
    Represents a hand of poker cards, capable of evaluating its strength and comparing with other hands.

    :param card_list: List of Card objects. Each poker hand must consist of exactly 5 cards.
    :raises ValueError: If the input card list does not contain exactly 5 cards.
    """

    def __init__(self, card_list):
        """
        Initialize the poker hand with a list of cards.

        :param card_list: List of cards to initialize the hand.
        """
        if len(card_list) != 5:
            raise ValueError("A poker hand must consist of exactly 5 cards.")
        # Sort the card_list based on the rank of each card object, with higher ranks appearing first in the list
        self.__cards = sorted(card_list, key=lambda card: card.get_rank(), reverse=True)

    def compare_to(self, other):
        """
        Compare this hand against another hand to determine which is better.

        :param other: Another PokerHand object to compare against.
        :return: An integer indicating the result of the comparison.
        """
        # evaluate hands, returning a rank for each hand along with high cards for tie-breaking purposes
        my_rank, my_high_cards = self.evaluate_hand()
        their_rank, their_high_cards = other.evaluate_hand()
        if my_rank == their_rank:
            return break_tie(my_high_cards, their_high_cards)
        return my_rank - their_rank

    def evaluate_hand(self):
        """
        Evaluate and return the rank and high cards of the hand based on poker rules.

        :return: A tuple containing the rank of the hand and a sorted list of high cards.
        """
        # extract the ranks of all cards in the hand
        ranks = [card.get_rank() for card in self.__cards]
        # extract the suits of all cards in the hand
        suits = [card.get_suit() for card in self.__cards]
        # create a dictionary that counts the occurrences of each rank in the hand
        rank_histogram = {rank: ranks.count(rank) for rank in ranks}
        # check if all cards have the same suit
        flush = len(set(suits)) == 1
        # check if all ranks are consecutive, indicating a straight
        # straight = len(set(ranks)) == 5 and (max(ranks) - min(ranks) == 4)

        # return a tuple containing the rank of the hand (from 0 to 5) and a sorted list of high cards
        # The higher the rank, the stronger the hand according to traditional poker rules.
        # If multiple hands have the same rank, the high cards are used to break the tie.
        if 4 in rank_histogram.values():
            return 2, sorted(self.__cards, key=lambda x: -ranks.count(x.get_rank()))
        if 3 in rank_histogram.values() and 2 in rank_histogram.values():
            return 2, sorted(self.__cards, key=lambda x: -ranks.count(x.get_rank()))
        if flush:
            return 5, self.__cards
        if 3 in rank_histogram.values():
            return 1, sorted(self.__cards, key=lambda x: -ranks.count(x.get_rank()))
        if list(rank_histogram.values()).count(2) == 2:
            return 2, sorted(self.__cards, key=lambda x: -ranks.count(x.get_rank()))
        if 2 in rank_histogram.values():
            return 1, sorted(self.__cards, key=lambda x: -ranks.count(x.get_rank()))
        return 0, sorted(self.__cards, key=lambda x: -x.get_rank())

    def __repr__(self):
        """
        Return a human-readable string representation of the hand.

        :return: String representation of the poker hand.
        """
        return ', '.join(f'{card.get_rank()} of {card.get_suit()}' for card in self.__cards)
