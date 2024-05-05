def check_flush(hands):
    """
    :param: hands of cards
    :return: check status if it's flush
    """

    switch = True

    for i in range(len(hands) - 1):
        if hands[i]['Suit'] != hands[i + 1]['Suit']:
            switch = False

    return switch


def check_pair(hands):
    """
    :param: hands of cards
    :return: check if one pair or two pair and return the number of one pair or two pair
    """

    count_pair = 0
    copy_hands = []
    for hand in hands:
        copy_hands.append(hand)

    count_pair = __is_pair(copy_hands, count_pair)
    if count_pair > 0:
        count_pair = __is_pair(copy_hands, count_pair)

    return count_pair


def __is_pair(copy_hands, count_pair):
    """

    :param copy_hands: the copy of hand to check pair and two pairs
    :param count_pair: the number of pair and two pairs
    :return: private function to count the number of pair and two pairs
    """
    for i in range(len(copy_hands) - 1):
        for j in range(i + 1, len(copy_hands)):
            if copy_hands[i]['Rank'] == copy_hands[j]["Rank"]:
                count_pair += 1
                delete1 = copy_hands[i]
                delete2 = copy_hands[j]
                copy_hands.remove(delete1)
                copy_hands.remove(delete2)
                break
    return count_pair
