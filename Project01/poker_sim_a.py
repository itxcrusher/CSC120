import random

SMALLEST_CARD_NUMBER = 2
BIGGEST_CARD_NUMBER = 10
NUM_CARDS_ON_HAND = 5
NUM_ROUNDS = 10

def create_deck():
    """
    Create a deck of cards.
    """
    suits = ['C', 'D', 'H', 'S']
    ranks = [str(i) for i in range(SMALLEST_CARD_NUMBER, BIGGEST_CARD_NUMBER + 1)]
    ranks.extend(['J', 'Q', 'K', 'Ace'])
    deck = [{'Rank': rank, 'Suit': suit} for suit in suits for rank in ranks]
    return deck

def shuffle_deck(deck):
    """
    Shuffle the deck of cards.
    """
    random.shuffle(deck)

def deal_hand(deck):
    """
    Deal a hand of cards from the deck.
    """
    hand = []
    while len(deck) > 0 and len(hand) < NUM_CARDS_ON_HAND:
        hand.append(deck.pop())
        if len(deck) == 0:
            deck.extend(create_deck())
            shuffle_deck(deck)
    return hand

def check_flush(hand):
    """
    Check if the hand is a flush.
    """
    suits = {card['Suit'] for card in hand}
    return len(suits) == 1

def check_pair(hand):
    """
    Check if the hand contains a pair or two pairs.
    """
    ranks = [card['Rank'] for card in hand]
    unique_ranks = set(ranks)
    num_pairs = 0
    for rank in unique_ranks:
        if ranks.count(rank) >= 2:
            num_pairs += 1
    return num_pairs

def play_rounds():
    """
    Simulate dealing hands and count the occurrences of different hand kinds.
    """
    header = ['# of hands', 'pairs', '%', '2 pairs', '%', 'flushes', '%', 'high card', '%']
    print('{:>10} {:>11} {:>3} {:>13} {:>3} {:>12} {:>3} {:>14} {:>3}'.format(*header))

    total_pairs = 0
    total_two_pairs = 0
    total_flushes = 0
    total_high_cards = 0
    total_hands = 0

    for i in range(1, NUM_ROUNDS + 1):
        deck = create_deck()
        shuffle_deck(deck)

        pairs = 0
        two_pairs = 0
        flushes = 0
        high_cards = 0

        for _ in range(10000):
            hand = deal_hand(deck)
            if check_flush(hand):
                flushes += 1
            elif check_pair(hand):
                if check_pair(hand) == 1:
                    pairs += 1
                elif check_pair(hand) == 2:
                    two_pairs += 1
            else:
                high_cards += 1

        total_pairs += pairs
        total_two_pairs += two_pairs
        total_flushes += flushes
        total_high_cards += high_cards
        total_hands += 10000

        percent_pairs = (total_pairs / total_hands) * 100
        percent_two_pairs = (total_two_pairs / total_hands) * 100
        percent_flushes = (total_flushes / total_hands) * 100
        percent_high_cards = (total_high_cards / total_hands) * 100

        print('{:>10,} {:>11d} {:>05.2f} {:>11d} {:>05.2f} {:>10d} {:>05.2f} {:>12d} {:>05.2f}'.format(
            total_hands, total_pairs, percent_pairs, total_two_pairs, percent_two_pairs,
            total_flushes, percent_flushes, total_high_cards, percent_high_cards))

if __name__ == "__main__":
    play_rounds()
