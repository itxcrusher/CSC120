import random

SMALLEST_CARD_NUMBER = 2
BIGGEST_CARD_NUMBER = 10
NUM_CARDS_IN_HAND = 5
NUM_ROUNDS = 10
TOTAL_HANDS_IN_ROUND = 10000

def create_deck():
    """
    Create a deck of cards.
    """
    # Club, Diamond, Heart, Spade represent Labor, Wealth, Emotion, War
    suits = ['C', 'D', 'H', 'S']    # List of suits
    ranks = [str(i) for i in range(SMALLEST_CARD_NUMBER, BIGGEST_CARD_NUMBER + 1)]  # List of 9 strings from 2 to 10
    ranks.extend(['J', 'Q', 'K', 'Ace'])    # Add Jack, Queen, King, Ace to List of ranks (9 + 4 = 13)
    # List of 52 dictionaries (4 * 13 = 52)
    deck = [{'Rank': rank, 'Suit': suit} for suit in suits for rank in ranks]   # [{'Rank': '2', 'Suit': 'C'}, ... ]
    return deck

def shuffle_deck(deck):
    """
    Shuffle the deck of cards.
    """
    random.shuffle(deck)    # Shuffle the deck randomly

def deal_hand(deck):
    """
    Deal a hand of cards from the deck.
    """
    hand = []   # List of dictionaries
    while len(deck) > 0 and len(hand) < NUM_CARDS_IN_HAND:  # While deck is not empty and hand < 5 cards
        hand.append(deck.pop())     # Move cards (dictionaries) from deck into the hand
        if len(deck) == 0:
            deck.extend(create_deck())  # Create new deck
            shuffle_deck(deck)  # Shuffle it
    return hand

def check_flush(hand):
    """
    Check if the hand is a flush.   # Same suit of all cards in hand = Flush
    """
    suits = {card['Suit'] for card in hand}     # Create a Set of suits of all cards in hand
    return len(suits) == 1      # Length of set will be 1 in case of flush (Duplicates in set are ignored)

def check_pair(hand):
    """
    Check if the hand contains a pair or two pairs.     # 2 Cards of same rank = 1 Pair
    """
    ranks = [card['Rank'] for card in hand]     # Create a List of ranks
    unique_ranks = set(ranks)   # Set of ranks will remove duplicate values
    num_pairs = 0
    # Count the unique ranks of set in list
    for rank in unique_ranks:
        if ranks.count(rank) >= 2:  # If unique rank of set is 2 or greater
            num_pairs += 1      # Number of pairs if increased
    return num_pairs

def play_rounds():
    """
    Simulate dealing hands and count the occurrences of different hand kinds.
    """
    # Create and Print output header
    header = ['# of hands', 'pairs', '%', '2 pairs', '%', 'flushes', '%', 'high card', '%']
    print('{:>10} {:>11} {:>3} {:>13} {:>3} {:>12} {:>3} {:>14} {:>3}'.format(*header))

    # Variables for all rounds
    total_pairs = 0
    total_two_pairs = 0
    total_flushes = 0
    total_high_cards = 0
    total_hands = 0

    # Loop for rounds (10)
    for i in range(1, NUM_ROUNDS + 1):
        # recreate and shuffle deck on start of each round
        deck = create_deck()
        shuffle_deck(deck)

        # variables for each round
        pairs = 0
        two_pairs = 0
        flushes = 0
        high_cards = 0

        # Loop for dealing hands in each round (10,000)
        for _ in range(TOTAL_HANDS_IN_ROUND):
            # create hand from deck
            hand = deal_hand(deck)
            # check if the hand is ...
            if check_flush(hand):               # Flush
                flushes += 1
            elif check_pair(hand):              # Pair
                if check_pair(hand) == 1:       # One Pair
                    pairs += 1
                elif check_pair(hand) == 2:     # Two Pair
                    two_pairs += 1
            else:
                high_cards += 1                 # High card

        # Add hand kinds of each round to the total
        total_pairs += pairs
        total_two_pairs += two_pairs
        total_flushes += flushes
        total_high_cards += high_cards
        total_hands += TOTAL_HANDS_IN_ROUND

        # Calculate percentage
        percent_pairs = (total_pairs / total_hands) * 100
        percent_two_pairs = (total_two_pairs / total_hands) * 100
        percent_flushes = (total_flushes / total_hands) * 100
        percent_high_cards = (total_high_cards / total_hands) * 100

        # Print calculated output
        print('{:>10,} {:>11d} {:>05.2f} {:>11d} {:>05.2f} {:>10d} {:>05.2f} {:>12d} {:>05.2f}'.format(
            total_hands, total_pairs, percent_pairs, total_two_pairs, percent_two_pairs,
            total_flushes, percent_flushes, total_high_cards, percent_high_cards))

if __name__ == "__main__":
    play_rounds()
