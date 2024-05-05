"""
Created on Apr 3, 2017

@author: Emma
"""

import string


def remove_blank_lines(list_of_strings):
    """Removed blank strings from a list of strings"""
    result = list()
    for s in list_of_strings:
        if s != '':
            result.append(s)
    return result


def get_board_from_file(filename):
    """Reads board, returns a list of rows"""
    board_file = open(filename)
    board = board_file.read()
    board_file.close()

    board_list = board.split('\n')

    board_list = remove_blank_lines(board_list)

    return board_list


def print_row(row):
    """Nicely prints a row of the board"""
    str = ''
    for column in row[:-1]:
        str += column + ' | '
    str += row[-1]
    print(str)


def print_board(board):
    """prints the board"""
    for row in board[:-1]:
        print_row(row)
        print('----------')
    print_row(board[-1])


def three_in_row(board, player, start_x, start_y, dx, dy):
    """
    Determines if a player has three in a row, starting
    from a starting position (start_x, start_y) and going
    in the direction indicated by (dx, dy).
    """
    x = start_x
    y = start_y
    for i in range(0, 3):
        if board[y][x] != player:
            return False
        x += dx
        y += dy

    return True


def is_winner(board, player):
    """Returns True if and only if the given player has won"""

    for i in range(0, 3):
        if (three_in_row(board, player, 0, i, 1, 0)
                or three_in_row(board, player, i, 0, 0, 1)):
            return True

    return (three_in_row(board, player, 0, 0, 1, 1)
            or three_in_row(board, player, 0, 2, 1, -1)
            )


def get_winner(board):
    """Returns the name of the winner, or None if there is no winner (tie game)"""

    if is_winner(board, 'X'):
        return 'X'
    elif is_winner(board, 'O'):
        return 'O'
    else:
        return None


def main():
    """
    :return: call confirm_result function with parameters from input.txt, input2.txt and their correct winners
    """
    # extra credit: hard-code is make the board to a list
    first_board = ['XOO', 'OOX', 'XXX']
    second_board = ['XOX', 'OXO', 'OOO']
    the_board = ['OOX', 'XXO', 'OXX']

    # Part 1, 2, 3
    test_first_board = get_board_from_file("input.txt")
    test_second_board = get_board_from_file("input2.txt")
    first_winner = 'X'
    second_winner = 'O'
    confirm_result(test_first_board, first_winner)
    confirm_result(test_second_board, second_winner)

    confirm_result(first_board, first_winner)
    confirm_result(second_board, second_winner)
    confirm_result(the_board, None)


def confirm_result(board, correct_winner):
    """
    :param: board: the input.txt or input2.txt to check
    :return: test if get_winner() gives out correct winner, None is tie game
    """

    declared_winner = get_winner(board)
    print_board(board)

    if declared_winner == correct_winner:
        print("PASS")
        if declared_winner is not None:
            print("Result: %s wins" % (str(declared_winner)))
        else:
            print('Tie game')

    else:
        print("FAIL")
        if correct_winner is not None:
            print("Result: %s wins" % (str(correct_winner)))
        else:
            print('Tie game')


if __name__ == "__main__":
    main()
