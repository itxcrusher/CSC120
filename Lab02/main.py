"""
    @author: ??????
"""

import tictactoe as ttt


def confirm_result(board, expected_winner):
    """
    This function tests the get_winner function and validates its output.

    Args:
      board: A representation of the tic_tac_toe board.
      expected_winner: The expected winner (string 'X' or 'O' or None for a tie).

    Returns:
      None
    """
    actual_winner = ttt.get_winner(board)
    print(f"Testing board: \n{ttt.board_string(board)}")
    print(f"Expected winner: {expected_winner}")
    if actual_winner == expected_winner:
        print("PASS")
    elif expected_winner == "Tie" and actual_winner is None:
        print("PASS")
    else:
        print(f"FAIL: Expected {expected_winner}, got {actual_winner}")


def main():
    """
    This function runs tests on the get_winner function using confirm_result.
    """

    # Test 1: Board from input.txt
    board1 = ttt.create_board(ttt.__read_board_from_file("input.txt"))
    confirm_result(board1, "X")

    # Test 2: Board from input2.txt
    board2 = ttt.create_board(ttt.__read_board_from_file("input2.txt"))
    confirm_result(board2, "O")

    # Hardcoded boards and additional tests
    board3 = [
        ['X', 'O', ' '],
        ['O', 'X', 'X'],
        [' ', ' ', 'O']
    ]
    confirm_result(board3, "Tie")

    board4 = [
        ['X', ' ', 'O'],
        [' ', 'O', 'X'],
        [' ', 'X', 'O']
    ]
    confirm_result(board4, "X")


if __name__ == "__main__":
    main()
