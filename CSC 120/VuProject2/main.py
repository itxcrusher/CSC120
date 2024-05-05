import deck as d
import poker_hand

NUM_OF_HANDS_IN_TABLE = 10000
CARDS_IN_ONE_HAND = 5
IS_PAIR = 1
IS_TWO_PAIRS = 2


def main_program():
    """
    :return: the table output
    """

    res = {
        'Pair': 0,
        'Two-pairs': 0,
        'Flush': 0,
        'High-card': 0,

    }

    header = ['# of hands', 'pairs', '%', '2 pairs', '%', 'flushes', '%', 'high card', '%']
    print('%10s %11s %3s %13s %3s %12s %3s %14s %3s' % (tuple(header)))

    for i in range(NUM_OF_HANDS_IN_TABLE):
        create_deck = d.Deck()
        shuffled_deck = create_deck.shuffle_deck()

        for k in range(CARDS_IN_ONE_HAND):
            hand = create_deck.deal_a_card()
            # Replicate to make cards in both hands
            for j in range(2):
                hands = hand[5 * j:5 * j + 5]

                if poker_hand.check_pair(hands) == IS_PAIR:
                    res['Pair'] += 1
                elif poker_hand.check_pair(hands) == IS_TWO_PAIRS:
                    res['Two-pairs'] += 1
                else:
                    if poker_hand.check_flush(hands):
                        res['Flush'] += 1
                    else:
                        res['High-card'] += 1

        if (i + 1) % 1000 == 0:
            # only consider when the number of hands less than or equal to 100000
            # and divisible by 1000 (10,000; 20,000; ... ;100,000)
            percent = {}

            for key in res.keys():
                percent[key] = res[key] / i / 10 * 100
                # Calculate the percent of kinds of cards

                num_hands = (i + 1) * 10
                # the number of hands run from 10,000 to 100,000 and distance is 10,000

            print('{:>10,} {:>11d} {:>05.2f} {:>11d} {:>05.2f} {:>10d} {:>05.2f} {:>12d} {:>05.2f}'
                  .format(num_hands, res['Pair'], percent['Pair'],
                          res['Two-pairs'], percent['Two-pairs'], res['Flush'],
                          percent['Flush'], res['High-card'], percent['High-card']))


if __name__ == '__main__':
    main_program()
