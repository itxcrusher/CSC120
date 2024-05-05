import card as create_one_card
import random

SMALLEST_CARD_NUMBER = 2
BIGGEST_CARD_NUMBER = 10


def create_deck():
    """
    :return: a list of 52 shuffled cards and each card is a dict with rank and suit
    """
    suits = ['C', 'D', 'H', 'S']
    rank = [str(i) for i in range(SMALLEST_CARD_NUMBER, BIGGEST_CARD_NUMBER + 1)]
    rank.extend(['J', 'Q', 'K', 'Ace'])
    my_deck_of_cards = []
    for suit in suits:
        for j in range(len(rank)):
            card = create_one_card.card(rank[j], suit)
            my_deck_of_cards.append(card)
    random.shuffle(my_deck_of_cards)

    return my_deck_of_cards


NUM_CARDS_ON_TWO_HANDS = 10


def deal_cards(deck):
    """
    :param: deck of 52 cards
    :return: a list of 10 cards as 2 hands
    """
    hands = []
    for i in range(NUM_CARDS_ON_TWO_HANDS):
        hands.append(deck[0])
        deck.pop(0)

    return hands
