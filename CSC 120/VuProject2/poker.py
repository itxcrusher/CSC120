import card

CARDS_IN_TWO_HAND = 10
FIRST_HAND_WINS = 1
SECOND_HAND_WINDS = -1
TIE_GAME = 0
MAX_INDEX_OF_PAIR = 2
INITIAL_VALUE_TO_PASS_CONDITION = -5
EXIST_TWO_PAIRS = 2
IS_FLUSH = 3
IS_TWO_PAIRS = 2
IS_PAIR = 1
IS_HIGH_CARD = 0
ANOTHER_POSSIBLE_INDEX_TWO_PAIRS = 1


class PokerHand:
    def __init__(self):
        """
        a list to contain 5 cards in a hand
        """
        self.__hand = []

    def add_card_to_hand(self, added_card):
        """

        :param added_card: the card
        :return: add each card dealt to a hand in order from highest to lowest rank
        """
        current_hand = self.__hand

        added_card_index = 0
        while added_card_index < len(current_hand):
            if added_card.get_value() < current_hand[added_card_index].get_value():
                added_card_index += 1
            else:
                break

        self.__hand.insert(added_card_index, added_card)

    def check_flush(self):
        """
        :param: hand of 5 cards
        :return: check status if it's flush, return True, otherwise False
        """

        switch = True

        for i in range(len(self.__hand) - 1):
            if self.__hand[i].get_suit() != self.__hand[i + 1].get_suit():
                switch = False

        return switch

    def __str__(self):
        """

        :return: print out a hand of 5 cards
        """
        return str(self.__hand)

    def __repr__(self):
        """

        :return: print out a hand of 5 cards with better representation
        """

        return str(self.__hand)

    def check_one_pair(self):
        """

        :return: the index of the pair in a hand if exist
        """
        res = INITIAL_VALUE_TO_PASS_CONDITION
        for i in range(len(self.__hand) - 1):

            if self.__hand[i].get_value() == self.__hand[i + 1].get_value():
                res = i
                break

        return res

    def check_two_pairs(self):
        """

        :return: the indexes of the two pairs in a hand if exist
        """
        is_one_pair = self.check_one_pair()
        list_two_pairs = [is_one_pair]
        if 0 <= is_one_pair < MAX_INDEX_OF_PAIR:
            pair_index_in_spot_3rd_or_4th = is_one_pair + MAX_INDEX_OF_PAIR

            for i in range(pair_index_in_spot_3rd_or_4th, len(self.__hand) - 1):
                if self.__hand[i].get_value() == self.__hand[i + 1].get_value():
                    list_two_pairs.append(i)
                    break
        return list_two_pairs

    def get_lone_card(self):
        """

        :return: the remaining card if 4 previous cards of each hand have same rank as the others in the other hand
        """
        possible_two_pairs = self.check_two_pairs()
        if len(possible_two_pairs) == EXIST_TWO_PAIRS:
            self.__hand.pop(possible_two_pairs[1])
            self.__hand.pop(possible_two_pairs[1])
            self.__hand.pop(possible_two_pairs[0])
            self.__hand.pop(possible_two_pairs[0])
        return self.__hand[0].get_value()

    def get_score(self):
        """

        :return: score of different kinds of hand, FLUSH = 3, TWO_PAIRS = 2, PAIR = 1, HIGH_CARD = 0
        """
        score = 0
        if self.check_flush():
            score = IS_FLUSH
        elif len(self.check_two_pairs()) == EXIST_TWO_PAIRS:
            score = IS_TWO_PAIRS
        elif self.check_one_pair() >= 0:
            score = IS_PAIR
        return score

    def compare_remain(self, other):
        """

        :param other: second hand
        :return: the winning hand by comparing the remaining card
        """
        i = 0
        while self.__hand[i].get_value() == other.__hand[i].get_value() and i < len(self.__hand) - 1:
            i += 1
        if i == len(self.__hand) - 1:

            return TIE_GAME
        else:
            if self.__hand[i].get_value() > other.__hand[i].get_value():
                return FIRST_HAND_WINS
            if self.__hand[i].get_value() < other.__hand[i].get_value():
                return SECOND_HAND_WINDS

    def compare_to(self, other):
        """
        Determines how this hand compares to another hand, returns
        positive, negative, or zero depending on the comparison.

        :param self: The first hand to compare
        :param other: The second hand to compare
        :return: a negative number if self is worth LESS than other, zero
        if they are worth the SAME, and a positive number if self is worth
        MORE than other
        """

        if self.get_score() > other.get_score():
            return FIRST_HAND_WINS
        if self.get_score() < other.get_score():
            return SECOND_HAND_WINDS
        if self.get_score() == other.get_score():
            if self.get_score() == IS_FLUSH:
                return self.compare_remain(other)
            if self.get_score() == IS_TWO_PAIRS:
                possible_index = 0
                while self.__hand[possible_index].get_value() == other.__hand[possible_index].get_value() \
                        and possible_index <= 1:
                    possible_index += 1

                if possible_index == EXIST_TWO_PAIRS:

                    if self.get_lone_card() > other.get_lone_card():

                        return FIRST_HAND_WINS
                    elif self.get_lone_card() < other.get_lone_card():

                        return SECOND_HAND_WINDS
                    else:

                        return TIE_GAME
            if self.get_score() == IS_PAIR:
                index_self = self.check_one_pair()
                index_other = other.check_one_pair()
                if self.__hand[index_self].get_value() > other.__hand[index_other].get_value():

                    return FIRST_HAND_WINS
                elif self.__hand[index_self].get_value() < other.__hand[index_other].get_value():

                    return SECOND_HAND_WINDS
                else:
                    self.__hand.pop(index_self)
                    self.__hand.pop(index_self)
                    other.__hand.pop(index_other)
                    other.__hand.pop(index_other)
                    return self.compare_remain(other)

            else:
                return self.compare_remain(other)

