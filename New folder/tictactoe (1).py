'''
Created on Jan 31, 2021

@author: Aaron Cass
'''

BLANK = ' '
BOARD_SIZE = 3

def create_board(list_of_rows):
    """
    Creates a TicTacToeBoard initialized with given rows.

    :param list_of_rows: a list of the rows (as strings) that make
    up the initial contents of board. Extra rows and columns
    beyond the standard board size are ignored.
    :return: a tic tac toe board representation
    """
    result = list()
    for row in range(BOARD_SIZE):
        result.append(list())
        for column in range(BOARD_SIZE):
            result[row].append(BLANK)

        input_row = list_of_rows[row]
        for column in range(len(input_row)):
            result[row][column] = input_row[column]

    return result

def get_piece(board, row, column):
    """
    Finds and returns the piece that appears at a give row and column.

    :param board: A tic tac toe board
    :param row: The given row
    :param column: The given column
    :return: The piece that appears at the given row and column.
    """
    return board[row][column]
        
def __three_in_row(board, player, start_x, start_y, dx, dy):
    """
    Determines if a player has three in a row, starting
    from a starting position (start_x, start_y) and going
    in the direction indicated by (dx, dy).
    """
    x = start_x; y = start_y
    for i in range(BOARD_SIZE):
        if get_piece(board, y, x) != player:
            return False
        x += dx; y += dy

    return True
    
def __is_winner(board, player):
    """
    :return: True if and only if the given player has won on the given board
    """
    for i in range(BOARD_SIZE):
        if (__three_in_row(board, player, 0, i, 1, 0) 
            or __three_in_row(board, player, i, 0, 0, 1)):
            return True

    return (__three_in_row(board, player, 0, 0, 1, 1)
            or __three_in_row(board, player, 0, BOARD_SIZE - 1, 1, -1)
            )

def get_winner(board):
    """
    Determines, and returns, the winner of the given board. This is
    intended to be called in the course of a normal game, in which
    case there can be only one winner (or no winner).

    :param board: The tic tac toe board.
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
    str = ""
    for row_num in range(BOARD_SIZE - 1):
        str += __row_string(board, row_num) +"\n"
        str += "----------\n"

    str += __row_string(board, BOARD_SIZE - 1)
    return str

def __row_string(board, row_num):
    result = ''
    for col_num in range(BOARD_SIZE - 1):
        result += get_piece(board, row_num, col_num) + ' | '
    result += get_piece(board, row_num, BOARD_SIZE - 1)
    return result
    
