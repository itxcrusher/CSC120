class Card:

    VALID_SUITS = ['Hearts', 'Diamonds', 'Clubs', 'Spades']

    def __init__(self, rank, suit):
        """
        :param rank: rank of a card
        :param suit: suit of a card
        """
        if suit not in Card.VALID_SUITS:
            raise ValueError(f"Invalid suit: {suit}")
        self.__rank = rank
        self.__suit = suit

    def get_rank(self):
        """
        Return the rank of the card.
        """
        return self.__rank

    def get_suit(self):
        """
        Return the suit of the card.
        """
        return self.__suit

    def __repr__(self):     # Automatically called when print statement is used for object
        """Return a string representation of the card, e.g., 'Ace of Spades'."""
        rank_name = {11: 'Jack', 12: 'Queen', 13: 'King', 14: 'Ace'}.get(self.__rank, str(self.__rank))
        return f"{rank_name} of {self.__suit}"
