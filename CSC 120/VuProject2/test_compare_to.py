import test_suite
import poker
import card

HAND_1_WINS = 1
HAND_2_WINS = -1
TIE_GAME = 0


def test_compare_to():
    """

    :return: test cases for compare_to() given each hand specific cards, Pass if expected is similar to actual result;
    otherwise, Fail
    """

    suite = test_suite.create()

    # card_1 = card.Card('Ace', 'S', 14)
    # card_2 = card.Card('Ace', 'H', 14)
    # card_3 = card.Card('10', 'H', 10)
    # card_4 = card.Card('7', 'H', 7)
    # card_5 = card.Card('2', 'D', 2)
    #
    # hand_1 = poker.PokerHand()
    # hand_1.add_card_to_hand(card_1)
    # hand_1.add_card_to_hand(card_2)
    # hand_1.add_card_to_hand(card_3)
    # hand_1.add_card_to_hand(card_4)
    # hand_1.add_card_to_hand(card_5)
    #
    # card_6 = card.Card('K', 'S', 13)
    # card_7 = card.Card('Q', 'H', 12)
    # card_8 = card.Card('J', 'D', 11)
    # card_9 = card.Card('4', 'C', 4)
    # card_10 = card.Card('3', 'H', 3)
    #
    # hand_2 = poker.PokerHand()
    # hand_2.add_card_to_hand(card_6)
    # hand_2.add_card_to_hand(card_7)
    # hand_2.add_card_to_hand(card_8)
    # hand_2.add_card_to_hand(card_9)
    # hand_2.add_card_to_hand(card_10)
    #
    # result = hand_1.compare_to(hand_2)
    # print('Result: ', result)
    # print('Score hand_1: ', hand_1.get_score())
    # print('Score hand_2: ', hand_2.get_score())

    # test_suite.assert_equals(suite, 'check compare_to', HAND_1_WINS, result)

    # card_11 = card.Card('J', 'S', 11)
    # card_12 = card.Card('J', 'C', 11)
    # card_13 = card.Card('4', 'S', 4)
    # card_14 = card.Card('4', 'D', 4)
    # card_15 = card.Card('3', 'D', 3)
    #
    # hand_3 = poker.PokerHand()
    # hand_3.add_card_to_hand(card_11)
    # hand_3.add_card_to_hand(card_12)
    # hand_3.add_card_to_hand(card_13)
    # hand_3.add_card_to_hand(card_14)
    # hand_3.add_card_to_hand(card_15)

    # card_16 = card.Card('Ace', 'C', 14)
    # card_17 = card.Card('K', 'C', 14)
    # card_18 = card.Card('5', 'C', 5)
    # card_19 = card.Card('7', 'C', 7)
    # card_20 = card.Card('2', 'C', 2)
    #
    # hand_4 = poker.PokerHand()
    # hand_4.add_card_to_hand(card_16)
    # hand_4.add_card_to_hand(card_17)
    # hand_4.add_card_to_hand(card_18)
    # hand_4.add_card_to_hand(card_19)
    # hand_4.add_card_to_hand(card_20)

    # result = hand_3.compare_to(hand_4)
    # print('Result: ', result)
    # print('Score hand_1: ', hand_3.get_score())
    # print('Score hand_2: ', hand_4.get_score())
    #
    # test_suite.assert_equals(suite, 'check compare_to', HAND_2_WINS, result)

    # card_21 = card.Card('J', 'H', 11)
    # card_22 = card.Card('9', 'H', 9)
    # card_23 = card.Card('6', 'H', 6)
    # card_24 = card.Card('4', 'H', 4)
    # card_25 = card.Card('2', 'H', 2)
    #
    # hand_5 = poker.PokerHand()
    # hand_5.add_card_to_hand(card_21)
    # hand_5.add_card_to_hand(card_22)
    # hand_5.add_card_to_hand(card_23)
    # hand_5.add_card_to_hand(card_24)
    # hand_5.add_card_to_hand(card_25)

    # result = hand_4.compare_to(hand_5)
    # print('Result: ', result)
    # print('Score hand_1: ', hand_4.get_score())
    # print('Score hand_2: ', hand_5.get_score())
    #
    # test_suite.assert_equals(suite, 'check compare_to', HAND_1_WINS, result)
    #
    # card_26 = card.Card('10', 'D', 10)
    # card_27 = card.Card('9', 'D', 9)
    # card_28 = card.Card('7', 'D', 7)
    # card_29 = card.Card('6', 'D', 6)
    # card_30 = card.Card('5', 'D', 5)
    #
    # hand_6 = poker.PokerHand()
    # hand_6.add_card_to_hand(card_26)
    # hand_6.add_card_to_hand(card_27)
    # hand_6.add_card_to_hand(card_28)
    # hand_6.add_card_to_hand(card_29)
    # hand_6.add_card_to_hand(card_30)

    # result = hand_6.compare_to(hand_5)
    # print('Result: ', result)
    # print('Score hand_1: ', hand_6.get_score())
    # print('Score hand_2: ', hand_5.get_score())
    #
    # test_suite.assert_equals(suite, 'check compare_to', HAND_2_WINS, result)

    # card_31 = card.Card('10', 'S', 10)
    # card_32 = card.Card('9', 'S', 9)
    # card_33 = card.Card('7', 'S', 7)
    # card_34 = card.Card('6', 'S', 6)
    # card_35 = card.Card('5', 'S', 5)
    #
    # hand_7 = poker.PokerHand()
    # hand_7.add_card_to_hand(card_31)
    # hand_7.add_card_to_hand(card_32)
    # hand_7.add_card_to_hand(card_33)
    # hand_7.add_card_to_hand(card_34)
    # hand_7.add_card_to_hand(card_35)
    #
    # result = hand_7.compare_to(hand_6)
    # print('Result: ', result)
    # print('Score hand_1: ', hand_7.get_score())
    # print('Score hand_2: ', hand_6.get_score())
    #
    # test_suite.assert_equals(suite, 'check compare_to', TIE_GAME, result)

    card_37 = card.Card('K', 'D', 13)
    card_38 = card.Card('K', 'H', 13)
    card_39 = card.Card('Q', 'D', 12)
    card_40 = card.Card('Q', 'H', 12)
    card_41 = card.Card('9', 'C', 9)

    hand_8 = poker.PokerHand()
    hand_8.add_card_to_hand(card_37)
    hand_8.add_card_to_hand(card_38)
    hand_8.add_card_to_hand(card_39)
    hand_8.add_card_to_hand(card_40)
    hand_8.add_card_to_hand(card_41)

    # result = hand_3.compare_to(hand_8)
    # print('Result: ', result)
    # print('Score hand_1: ', hand_3.get_score())
    # print('Score hand_2: ', hand_8.get_score())
    #
    # test_suite.assert_equals(suite, 'check compare_to', HAND_2_WINS, result)

    # result = hand_8.compare_to(hand_3)
    # print('Result: ', result)
    # print('Score hand_1: ', hand_8.get_score())
    # print('Score hand_2: ', hand_3.get_score())
    #
    # test_suite.assert_equals(suite, 'check compare_to', HAND_1_WINS, result)

    card_42 = card.Card('K', 'S', 13)
    card_43 = card.Card('K', 'C', 13)
    card_44 = card.Card('Q', 'S', 12)
    card_45 = card.Card('Q', 'C', 12)
    card_46 = card.Card('8', 'D', 8)

    hand_9 = poker.PokerHand()
    hand_9.add_card_to_hand(card_42)
    hand_9.add_card_to_hand(card_43)
    hand_9.add_card_to_hand(card_44)
    hand_9.add_card_to_hand(card_45)
    hand_9.add_card_to_hand(card_46)

    result = hand_8.compare_to(hand_9)
    print('Result: ', result)
    print('Score hand_1: ', hand_8.get_score())
    print('Score hand_2: ', hand_9.get_score())

    test_suite.assert_equals(suite, 'check compare_to', HAND_1_WINS, result)

    print(hand_9.get_lone_card())
    print(hand_8.get_lone_card())
test_compare_to()
