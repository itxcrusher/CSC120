def print_board(board):
    """
    Prints the tic-tac-toe board.

    :param board: List of strings representing the tic-tac-toe board.
    """
    num_rows = len(board)
    num_cols = len(board[0])
    for row_num, row in enumerate(board):
        row_str = ''
        for col_num, marker in enumerate(row):
            row_str += marker
            if col_num < num_cols - 1:
                row_str += ' | '
        print(row_str)
        if row_num < num_rows - 1:
            print('---------')


def all_same(items):
    """
    Checks if all elements in a list are the same.

    :param items: List of items to check.
    :return: True if all elements in the list are the same, False otherwise.
    """
    return all(x == items[0] for x in items)


def columns(board):
    """
    Transposes the tic-tac-toe board to get the columns.

    :param board: List of strings representing the tic-tac-toe board.
    :return: List of strings representing the columns of the board.
    """
    num_cols = len(board[0])
    num_rows = len(board)

    to_return = []

    for i in range(num_cols):
        col_str = ''
        for j in range(num_rows):
            col_str += board[j][i]
        to_return.append(col_str)
    return to_return


def check_winner(board):
    """
    Checks the winner of the tic-tac-toe game.

    :param board: List of strings representing the tic-tac-toe board.
    :return: The winning marker if there's a winner, otherwise an empty string.
    """
    for row_num, row in enumerate(board):
        if all_same(row):
            return row[0]

    for col in columns(board):
        if all_same(col):
            return col[0]

    if all_same([board[i][i] for i in range(len(board))]):  # Back slash
        return board[0][0]

    if all_same([board[len(board) - i - 1][i] for i in range(len(board))]):  # Forward slash
        return board[2][0]

    return ''


def main():
    inputfile = 'input.txt'
    file = open(inputfile)
    board = file.read().split('\n')
    file.close()

    print_board(board)
    winner = check_winner(board)

    if winner != '':
        print(winner + ' WINS!!!!')
    else:
        print("TIE GAME!!!!")


if __name__ == '__main__':
    main()
