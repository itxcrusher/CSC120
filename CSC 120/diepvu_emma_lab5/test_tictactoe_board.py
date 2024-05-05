'''
:author: Emma
'''

import test_suite as testing
import tictactoe_board as board


def test_get_winner():
    """

    :return: the test cases for get_winner() given the manually inserted boards; either 'X', 'O' or no one (None) wins
    and see if the get_winner() produces the same result as expected (PASS); otherwise, FAIL
    """
    suite = testing.TestSuite()

    a_board = board.TicTacToeBoard(['XOO', 'XOX', 'XXO'])

    suite.assert_equals(str(a_board) + "Three Xs in a row vertically",
                        'X',
                        a_board.get_winner())

    a_board = board.TicTacToeBoard(['XOO', 'XOX', 'OXX'])
    suite.assert_equals(str(a_board) + "Three Os in a diagonal",
                        'O',
                        a_board.get_winner())

    a_board = board.TicTacToeBoard(['OXO', 'OOX', 'XOX'])
    suite.assert_equals(str(a_board) + "No winner, tie game",
                        None,
                        a_board.get_winner())

    suite.print_summary()


if __name__ == "__main__":
    test_get_winner()
