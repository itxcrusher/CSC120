"""
Author’s Name: Ali Hamza
Honor Code: I hereby affirm that I have carried out all my academic endeavours with full academic honesty.
"""

from deck import Deck
from poker_hand import PokerHand


def play_game():
    """
    Play a simple guessing game of poker hands.
    :return: the player's score
    """
    deck = Deck()
    score = 0

    try:
        while True:
            hand1 = PokerHand(deck.deal(5))
            hand2 = PokerHand(deck.deal(5))

            print("Hand 1:", hand1)
            print("Hand 2:", hand2)

            guess = input("Which hand is better? Type '1' or '2' (or 'exit' to quit): ")
            if guess.lower() == 'exit':
                break

            correct_answer = '1' if hand1.compare_to(hand2) > 0 else '2'

            if guess == correct_answer:
                print("Correct!")
                score += 1
            else:
                print("Incorrect! The correct answer was Hand", correct_answer)
                break

    except ValueError:
        print("No more cards available.")

    print(f"Game over. Your score was: {score}")


if __name__ == "__main__":
    play_game()
