import random

SMALLEST_CARD_NUMBER = 2
BIGGEST_CARD_NUMBER = 10
NUM_CARDS_IN_HAND = 5
NUM_ROUNDS = 10


class CardDeck:
    def __init__(self):
        """
        Initializes a new deck of cards, consisting of ranks 2 to Ace across four suits.
        The deck is immediately shuffled after creation.
        """
        self.suits = ['C', 'D', 'H', 'S']
        self.ranks = [str(i) for i in range(SMALLEST_CARD_NUMBER, BIGGEST_CARD_NUMBER + 1)]
        self.ranks.extend(['J', 'Q', 'K', 'Ace'])
        self.deck = self.create_deck()
        self.shuffle_deck()

    def create_deck(self):
        """
        Generates a list of card dictionaries where each card is represented by a dictionary
        with 'Rank' and 'Suit' as keys.

        Returns:
            list of dicts: The list of cards forming a complete deck.
        """
        return [{'Rank': rank, 'Suit': suit} for suit in self.suits for rank in self.ranks]

    def shuffle_deck(self):
        """
        Shuffles the deck in place using Python's random.shuffle method.
        """
        random.shuffle(self.deck)

    def deal_hand(self):
        """
        Deals a hand of 5 cards from the current deck. If the deck runs out of cards,
        it is re-created and re-shuffled.

        Returns:
            list of dicts: A list of card dictionaries representing a hand.
        """
        hand = []
        while len(self.deck) > 0 and len(hand) < NUM_CARDS_IN_HAND:
            hand.append(self.deck.pop())
            if not self.deck:
                self.deck = self.create_deck()
                self.shuffle_deck()
        return hand


def check_flush(hand):
    """
    Determines if a hand of cards is a flush (all cards of the same suit).

    Args:
        hand (list of dicts): The hand to check.

    Returns:
        bool: True if the hand is a flush, False otherwise.
    """
    return len(set(card['Suit'] for card in hand)) == 1


def check_pair(hand):
    """
    Counts the number of pairs in a hand. A pair is two cards of the same rank.

    Args:
        hand (list of dicts): The hand to check.

    Returns:
        int: The number of pairs in the hand.
    """
    ranks = [card['Rank'] for card in hand]
    count = {}
    for rank in ranks:
        count[rank] = count.get(rank, 0) + 1
    pairs = sum(1 for v in count.values() if v >= 2)
    return pairs


def play_rounds():
    """
    Simulates the dealing of hands and counts the occurrences of different hand kinds
    over a number of rounds. Results are printed in a formatted table.
    """
    print('{:>10} {:>11} {:>3} {:>13} {:>3} {:>12} {:>3} {:>14} {:>3}'.format(
        '# of hands', 'pairs', '%', '2 pairs', '%', 'flushes', '%', 'high card', '%'))

    card_deck = CardDeck()
    total_hands = 0
    results = {"pairs": 0, "two_pairs": 0, "flushes": 0, "high_cards": 0}

    for _ in range(NUM_ROUNDS):
        for _ in range(10000):
            hand = card_deck.deal_hand()
            num_pairs = check_pair(hand)
            if check_flush(hand):
                results["flushes"] += 1
            elif num_pairs == 1:
                results["pairs"] += 1
            elif num_pairs == 2:
                results["two_pairs"] += 1
            else:
                results["high_cards"] += 1

        total_hands += 10000
        output_results(total_hands, results)


def output_results(total_hands, results):
    """
    Prints a formatted row of results for the current total of hands and their outcomes.

    Args:
        total_hands (int): Total number of hands dealt so far.
        results (dict): Dictionary containing the counts of each hand type.
    """
    print('{:>10,} {:>11d} {:>05.2f} {:>11d} {:>05.2f} {:>10d} {:>05.2f} {:>12d} {:>05.2f}'.format(
        total_hands,
        results["pairs"], (results["pairs"] / total_hands * 100),
        results["two_pairs"], (results["two_pairs"] / total_hands * 100),
        results["flushes"], (results["flushes"] / total_hands * 100),
        results["high_cards"], (results["high_cards"] / total_hands * 100)))


if __name__ == "__main__":
    play_rounds()
