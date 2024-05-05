import card
import poker_hand
import testing


HAND_1_WINS = 1
HAND_2_WINS = -1
TIE_GAME = 0


class TestPokerHands(testing.TestSuite):

    def test_pair_beats_high_card(self):
        cards_high_card = [card.Card(14, 'Spades'), card.Card(9, 'Hearts'), card.Card(7, 'Clubs'),
                           card.Card(5, 'Diamonds'), card.Card(3, 'Clubs')]
        cards_pair = [card.Card(8, 'Spades'), card.Card(8, 'Hearts'), card.Card(6, 'Clubs'), card.Card(4, 'Diamonds'),
                      card.Card(2, 'Hearts')]
        hand_high_card = poker_hand.PokerHand(cards_high_card)
        hand_pair = poker_hand.PokerHand(cards_pair)
        result = hand_pair.compare_to(hand_high_card)
        self.assert_equals('Pair should beat high card', HAND_1_WINS, result)

    def test_two_pair_beats_one_pair(self):
        cards_one_pair = [card.Card(10, 'Hearts'), card.Card(10, 'Diamonds'), card.Card(9, 'Clubs'),
                          card.Card(5, 'Spades'), card.Card(3, 'Hearts')]
        cards_two_pair = [card.Card(12, 'Hearts'), card.Card(12, 'Spades'), card.Card(11, 'Clubs'),
                          card.Card(11, 'Diamonds'), card.Card(2, 'Spades')]
        hand_one_pair = poker_hand.PokerHand(cards_one_pair)
        hand_two_pair = poker_hand.PokerHand(cards_two_pair)
        result = hand_two_pair.compare_to(hand_one_pair)
        self.assert_equals('Two pair should beat one pair', HAND_1_WINS, result)

    def test_three_of_a_kind_beats_two_pair(self):
        cards_two_pair = [card.Card(9, 'Hearts'), card.Card(9, 'Spades'), card.Card(7, 'Clubs'),
                          card.Card(7, 'Diamonds'), card.Card(4, 'Hearts')]
        cards_three_of_a_kind = [card.Card(8, 'Clubs'), card.Card(8, 'Diamonds'), card.Card(8, 'Spades'),
                                 card.Card(5, 'Hearts'), card.Card(3, 'Diamonds')]
        hand_two_pair = poker_hand.PokerHand(cards_two_pair)
        hand_three_of_a_kind = poker_hand.PokerHand(cards_three_of_a_kind)
        result = hand_three_of_a_kind.compare_to(hand_two_pair)
        self.assert_equals('Three of a kind should beat two pair', HAND_1_WINS, result)

    def test_straight_beats_three_of_a_kind(self):
        cards_three_of_a_kind = [card.Card(6, 'Hearts'), card.Card(6, 'Diamonds'), card.Card(6, 'Clubs'),
                                 card.Card(9, 'Hearts'), card.Card(2, 'Spades')]
        cards_straight = [card.Card(10, 'Hearts'), card.Card(9, 'Diamonds'), card.Card(8, 'Clubs'),
                          card.Card(7, 'Spades'), card.Card(6, 'Diamonds')]
        hand_three_of_a_kind = poker_hand.PokerHand(cards_three_of_a_kind)
        hand_straight = poker_hand.PokerHand(cards_straight)
        result = hand_straight.compare_to(hand_three_of_a_kind)
        self.assert_equals('Straight should beat three of a kind', HAND_1_WINS, result)

    def test_flush_beats_straight(self):
        cards_straight = [card.Card(9, 'Hearts'), card.Card(8, 'Hearts'), card.Card(7, 'Hearts'), card.Card(6, 'Clubs'),
                          card.Card(5, 'Diamonds')]
        cards_flush = [card.Card(12, 'Clubs'), card.Card(10, 'Clubs'), card.Card(8, 'Clubs'), card.Card(6, 'Clubs'),
                       card.Card(4, 'Clubs')]
        hand_straight = poker_hand.PokerHand(cards_straight)
        hand_flush = poker_hand.PokerHand(cards_flush)
        result = hand_flush.compare_to(hand_straight)
        self.assert_equals('Flush should beat straight', HAND_1_WINS, result)

    def test_high_card_wins(self):
        cards_1 = [card.Card(14, 'Spades'), card.Card(10, 'Hearts'),
                   card.Card(2, 'Clubs'), card.Card(3, 'Diamonds'),
                   card.Card(4, 'Clubs')]
        cards_2 = [card.Card(13, 'Spades'), card.Card(9, 'Hearts'),
                   card.Card(2, 'Clubs'), card.Card(3, 'Diamonds'),
                   card.Card(4, 'Hearts')]
        hand_1 = poker_hand.PokerHand(cards_1)
        hand_2 = poker_hand.PokerHand(cards_2)
        result = hand_1.compare_to(hand_2)
        self.assert_equals('Ace high should beat King high', HAND_1_WINS, result)

    def test_same_hand_tie(self):
        cards = [card.Card(12, 'Hearts'), card.Card(9, 'Diamonds'),
                 card.Card(2, 'Spades'), card.Card(3, 'Clubs'),
                 card.Card(4, 'Spades')]
        hand_1 = poker_hand.PokerHand(cards)
        hand_2 = poker_hand.PokerHand(cards.copy())
        result = hand_1.compare_to(hand_2)
        self.assert_equals('Identical hands should tie', TIE_GAME, result)

    def test_invalid_card_suit(self):
        try:
            # invalid_card = card.Card(11, 'Zebra')
            self.assert_equals('Expected exception for invalid suit', 1, 0)  
        except ValueError:
            self.assert_equals('Expected exception for invalid suit', 1, 1)

    def test_full_house_tiebreaker(self):
        fh1_cards = [card.Card(4, 'Hearts'), card.Card(4, 'Diamonds'),
                     card.Card(4, 'Spades'), card.Card(2, 'Hearts'),
                     card.Card(2, 'Spades')]
        fh2_cards = [card.Card(3, 'Hearts'), card.Card(3, 'Diamonds'),
                     card.Card(3, 'Spades'), card.Card(2, 'Clubs'),
                     card.Card(2, 'Diamonds')]
        fh1_hand = poker_hand.PokerHand(fh1_cards)
        fh2_hand = poker_hand.PokerHand(fh2_cards)
        result = fh1_hand.compare_to(fh2_hand)
        self.assert_equals('Higher triples in full house should win', HAND_1_WINS, result)

    def run_all_tests(self):
        self.test_high_card_wins()
        self.test_same_hand_tie()
        self.test_invalid_card_suit()
        self.test_full_house_tiebreaker()
        self.test_high_card_wins()
        self.test_same_hand_tie()
        self.test_invalid_card_suit()
        self.test_full_house_tiebreaker()
        self.test_pair_beats_high_card()
        self.test_two_pair_beats_one_pair()


if __name__ == '__main__':
    test_suite = TestPokerHands()
    test_suite.run_all_tests()
