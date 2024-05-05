import random

class CardDeck:
    """
    Represents a deck of playing cards ranging from 2 to Ace, across four suits.
    The deck is shuffled upon initialization.
    """

    _SMALLEST_CARD_NUMBER = 2
    _BIGGEST_CARD_NUMBER = 10
    _NUM_CARDS_IN_HAND = 5

    def __init__(self):
        """
        Initializes a new deck of cards and shuffles it.
        """
        self._suits = ['C', 'D', 'H', 'S']
        self._ranks = [str(i) for i in range(self._SMALLEST_CARD_NUMBER, self._BIGGEST_CARD_NUMBER + 1)]
        self._ranks.extend(['J', 'Q', 'K', 'Ace'])
        self._deck = self._create_deck()
        self._shuffle_deck()

    def _create_deck(self):
        """
        Creates a full deck of cards as a list of dictionaries where each card has a 'Rank' and 'Suit'.

        :return: List of dicts representing the full deck of cards.
        """
        return [{'Rank': rank, 'Suit': suit} for suit in self._suits for rank in self._ranks]

    def _shuffle_deck(self):
        """
        Shuffles the deck of cards in place.
        """
        random.shuffle(self._deck)

    def deal_hand(self):
        """
        Deals a hand of cards from the deck. If the deck is exhausted, it is recreated and reshuffled.

        :return: List of dicts representing a hand of cards.
        """
        hand = []
        while len(self._deck) > 0 and len(hand) < self._NUM_CARDS_IN_HAND:
            hand.append(self._deck.pop())
            if not self._deck:
                self._deck = self._create_deck()
                self._shuffle_deck()
        return hand

    def check_flush(self, hand):
        """
        Determines if a hand is a flush (all cards of the same suit).

        :param hand: List of dicts representing a hand of cards.
        :return: True if the hand is a flush, False otherwise.
        """
        return len(set(card['Suit'] for card in hand)) == 1

    def check_pair(self, hand):
        """
        Counts the number of pairs in a hand.

        :param hand: List of dicts representing a hand of cards.
        :return: The number of pairs in the hand.
        """
        ranks = [card['Rank'] for card in hand]
        count = {}
        # If the rank is not already a key in the dictionary,
        # it initializes its count to 0 using count.get(rank, 0).
        # Then, it increments the count for that rank by 1.
        for rank in ranks:
            count[rank] = count.get(rank, 0) + 1
        return sum(1 for v in count.values() if v >= 2)


class PokerGame:
    """
    Manages the gameplay for multiple rounds of a poker game, tallying occurrences of hand outcomes.
    """

    _NUM_ROUNDS = 10
    _TOTAL_HANDS_IN_ROUND = 10000

    def __init__(self):
        """
        Initializes a new poker game with a deck of cards.
        """
        self._card_deck = CardDeck()

    def play_rounds(self):
        """
        Plays a specified number of rounds, dealing hands and counting hand outcomes. Outputs results periodically.
        """
        print('{:>10} {:>11} {:>3} {:>13} {:>3} {:>12} {:>3} {:>14} {:>3}'.format(
            '# of hands', 'pairs', '%', '2 pairs', '%', 'flushes', '%', 'high card', '%'))
        results = {"pairs": 0, "two_pairs": 0, "flushes": 0, "high_cards": 0}
        total_hands = 0

        for _ in range(self._NUM_ROUNDS):
            for _ in range(self._TOTAL_HANDS_IN_ROUND):
                hand = self._card_deck.deal_hand()
                num_pairs = self._card_deck.check_pair(hand)
                if self._card_deck.check_flush(hand):
                    results["flushes"] += 1
                elif num_pairs == 1:
                    results["pairs"] += 1
                elif num_pairs == 2:
                    results["two_pairs"] += 1
                else:
                    results["high_cards"] += 1

            total_hands += self._TOTAL_HANDS_IN_ROUND
            self._output_results(total_hands, results)

    def _output_results(self, total_hands, results):
        """
        Outputs the accumulated results of the poker game in a formatted manner.

        :param total_hands: Integer representing the total number of hands dealt so far.
        :param results: Dictionary containing counts of various hand types.
        """
        print('{:>10,} {:>11d} {:>05.2f} {:>11d} {:>05.2f} {:>10d} {:>05.2f} {:>12d} {:>05.2f}'.format(
            total_hands,
            results["pairs"], (results["pairs"] / total_hands * 100),
            results["two_pairs"], (results["two_pairs"] / total_hands * 100),
            results["flushes"], (results["flushes"] / total_hands * 100),
            results["high_cards"], (results["high_cards"] / total_hands * 100)))


if __name__ == "__main__":
    game = PokerGame()
    game.play_rounds()
