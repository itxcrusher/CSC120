import card
import deck
import poker
NUM_CARDS_IN_HAND = 5
NUM_CARDS_IN_TWO_HANDS = 10


def get_a_hand(get_deck):
    """

    :param get_deck: the deck of card
    :return: a hand of 5 cards which has been sorted from highest to lowest rank
    """
    my_hand = poker.PokerHand()
    for i in range(NUM_CARDS_IN_HAND):
        my_hand.add_card_to_hand(get_deck.deal_a_card())

    return my_hand


def main():
    """

    :return: the player's score
    """
    score = 0
    get_deck = deck.Deck()
    get_deck.shuffle_deck()
    length_deck = get_deck.get_length()
    while length_deck >= NUM_CARDS_IN_TWO_HANDS:
        length_deck = get_deck.get_length() - NUM_CARDS_IN_TWO_HANDS
        my_first_hand = get_a_hand(get_deck)
        my_second_hand = get_a_hand(get_deck)
        print('First hand: ', my_first_hand)
        print('Second hand: ', my_second_hand)
        result = my_first_hand.compare_to(my_second_hand)
        user = int(input('Type 1 if first hand wins, -1 if second hand wins, 0 if tie game: '))
        if user == result:
            print('Correct')
            score += 1
        else:
            print('Wrong')
            print('Your score is: ', score)
            return
        if length_deck < NUM_CARDS_IN_TWO_HANDS:
            print('Out of cards to play, your score is: ', score)
            return


if __name__ == '__main__':
    main()
