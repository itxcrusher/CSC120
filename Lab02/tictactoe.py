"""
Created on Jan 31, 2021

@author: Aaron Cass
"""

BLANK = ' '
BOARD_SIZE = 3


def __read_board_from_file(filename):
    board_file = open(filename)             # Open the file
    board_lines = board_file.read()         # Read the entire content of file
    board_file.close()                      # Close the file

    return board_lines.split('\n')          # Split and return the list of lines


def create_board(list_of_rows):
    """
    Creates a TicTacToeBoard initialized with given rows.

    :param list_of_rows: a list of the rows (as strings) that make
    up the initial contents of board. Extra rows and columns
    beyond the standard board size are ignored.
    :return: a tic_tac_toe board representation
    """
    result = list()                                     # Initialize an empty list
    for row in range(BOARD_SIZE):                       # Iterate over the range of BOARD_SIZE
        result.append(list())                           # Append a new empty list for each row
        for column in range(BOARD_SIZE):                # Iterate over each column in the row
            result[row].append(BLANK)                   # Initialize each cell to Blank

        input_row = list_of_rows[row]                   # Get the current row from the list_of_rows
        for column in range(len(input_row)):            # Iterate over each character in the input row
            result[row][column] = input_row[column]     # Update the corresponding cell in the board with the character

    return result                                      # Return the resulting 2D list


def get_piece(board, row, column):
    """
    Finds and returns the piece that appears at a give row and column.

    :param board: A tic_tac_toe board
    :param row: The given row
    :param column: The given column
    :return: The piece that appears at the given row and column.
    """
    return board[row][column]                           # Access and return the element at the specified place


def __three_in_row(board, player, start_x, start_y, dx, dy):
    """
    Determines if a player has three in a row, starting
    from a starting position (start_x, start_y) and going
    in the direction indicated by (dx, dy).
    """
    x = start_x                                   # Initialize variables to store current position
    y = start_y
    for i in range(BOARD_SIZE):                   # Iterate over a range of BOARD_SIZE
        if get_piece(board, y, x) != player:      # Check if the piece at position is not equal to the player's piece
            return False
        x += dx                                   # Move to the next position in the specified direction
        y += dy

    return True              # If the loop completes without returning False, it means there are three in a row


def __is_winner(board, player):
    """
    :return: True if and only if the given player has won on the given board
    """
    # Check rows and columns for three in a row
    for i in range(BOARD_SIZE):
        if (__three_in_row(board, player, 0, i, 1, 0)
                or __three_in_row(board, player, i, 0, 0, 1)):
            return True

    # Check diagonals for three in a row
    return (__three_in_row(board, player, 0, 0, 1, 1)
            or __three_in_row(board, player, 0, BOARD_SIZE - 1, 1, -1)
            )


def get_winner(board):
    """
    Determines, and returns, the winner of the given board. This is
    intended to be called in the course of a normal game, in which
    case there can be only one winner (or no winner).

    :param board: The tic_tac_toe board.
    :return: the name of the winner, or None if there is no winner
    """
    if __is_winner(board, 'X'):
        return 'X'
    elif __is_winner(board, 'O'):
        return 'O'
    else:
        return None


def board_string(board):
    """
    :param board:
    :return: a pretty string version of the board for printing.
    """
    string = ""
    for row_num in range(BOARD_SIZE - 1):               # Iterate over each row of the board
        string += __row_string(board, row_num) + "\n"      # Append the string representation of the current row
        string += "----------\n"

    string += __row_string(board, BOARD_SIZE - 1)          # Add a horizontal line to separate rows
    return string


def __row_string(board, row_num):
    result = ''
    for col_num in range(BOARD_SIZE - 1):                       # Iterate over each column of the row
        result += get_piece(board, row_num, col_num) + ' | '    # Append the string representation of the piece
    result += get_piece(board, row_num, BOARD_SIZE - 1)         # Append the piece at the last column
    return result
