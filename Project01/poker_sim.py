import random

# Define constants for card ranks and suits
RANKS = ['2', '3', '4', '5', '6', '7', '8', '9', '10', 'J', 'Q', 'K', 'A']
SUITS = ['C', 'D', 'H', 'S']        # Clubs, Diamonds, Hearts, Spades

def create_deck():
    """Create a new deck of cards."""
    deck = [rank + suit for rank in RANKS for suit in SUITS]
    return deck

def shuffle_deck(deck):
    """Shuffle the given deck of cards."""
    random.shuffle(deck)

def deal_hand(deck, size=5):
    """Deal a hand of cards from the deck."""
    if len(deck) < size:
        # If there are not enough cards in the deck, recreate and shuffle the deck
        deck = create_deck()
        shuffle_deck(deck)
    hand = []
    for _ in range(size):
        hand.append(deck.pop())
    return hand

def count_hand_kinds(hands):
    """Count the occurrences of different hand kinds."""
    counts = {'pair': 0, 'two_pairs': 0, 'flush': 0, 'high_card': 0}
    for hand in hands:
        if is_flush(hand):
            counts['flush'] += 1
        elif is_two_pairs(hand):
            counts['two_pairs'] += 1
        elif is_pair(hand):
            counts['pair'] += 1
        else:
            counts['high_card'] += 1
    return counts

def is_flush(hand):
    """Check if the hand is a flush."""
    suits = [card[-1] for card in hand]
    return len(set(suits)) == 1

def is_two_pairs(hand):
    """Check if the hand contains two pairs."""
    ranks = [card[:-1] for card in hand]
    rank_counts = {rank: ranks.count(rank) for rank in set(ranks)}
    return len([count for count in rank_counts.values() if count == 2]) == 2

def is_pair(hand):
    """Check if the hand contains a pair."""
    ranks = [card[:-1] for card in hand]
    rank_counts = {rank: ranks.count(rank) for rank in set(ranks)}
    return 2 in rank_counts.values()

def play_rounds(num_rounds=10):
    """Simulate multiple rounds of poker and output the results."""
    #print("# of hands \t pairs % \t 2 pairs % \t flushes % \t high card %")
    print("# of hands \t pairs \t % \t\t 2 pairs  % \t flushes  % \t high card  %")
    for i in range(1, num_rounds + 1):
        deck = create_deck()
        shuffle_deck(deck)
        hands = [deal_hand(deck) for _ in range(10000)]
        counts = count_hand_kinds(hands)
        total_hands = i * 10000
        pairs_percent = (counts['pair'] / total_hands) * 100
        two_pairs_percent = (counts['two_pairs'] / total_hands) * 100
        flushes_percent = (counts['flush'] / total_hands) * 100
        high_card_percent = (counts['high_card'] / total_hands) * 100
        #print(f"{total_hands:,}\t {counts['pair']:>6} \t {pairs_percent} \t {counts['two_pairs']:>6} \t {two_pairs_percent} \t {counts['flush']:>6} \t {flushes_percent} \t {counts['high_card']:>6} \t {high_card_percent}")
        #print(f"{total_hands:10,} {counts['pair']:4} {pairs_percent:7.2f} {counts['two_pairs']:4} {two_pairs_percent:9.2f} {counts['flush']:4} {flushes_percent:9.2f} {counts['high_card']:4} {high_card_percent:9.2f}")
        #print(f"{total_hands:10,}  {counts['pair']:4} {pairs_percent:7.2f}  {counts['two_pairs']:4}{two_pairs_percent:9.2f}  {counts['flush']:4}{flushes_percent:9.2f}  {counts['high_card']:4} {high_card_percent:9.2f}")
        print(f"{total_hands:8,}\t{counts['pair']:5}\t{pairs_percent:5.2f}\t{counts['two_pairs']:5}\t{two_pairs_percent:5.2f}\t{counts['flush']:5}\t{flushes_percent:5.2f}\t{counts['high_card']:7}\t{high_card_percent:7.2f}")

if __name__ == "__main__":
    play_rounds()
