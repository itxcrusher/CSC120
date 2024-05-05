def print_board(board):
    """
    :param: the board from input.txt whose length is 3, board is list of elements that each row is an element
    :return: print the board with borders
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


def row_all_same(board, row):
    """:param: the board from input.txt whose length is 3, board is list of elements that each row is an element; row is
    the index for the element
    :return: check if the characters of each element in row are the same """
    return board[row][0] == board[row][1] == board[row][2]


def column_all_same(column):
    """
    :param column: each column in the board
    :return: the column has the same 'X' or 'O'
    """
    return column[0] == column[1] == column[2]


def check_diagonal(board):
    """
    :param: the board from input.txt whose length is 3, board is list of elements that each row is an element
    :return: check if each characters of each element in diagonal are the same
    """
    check_forward_slash = True
    check_backward_slash = True
    for i in range(len(board) - 1):
        if board[i][i] != board[i + 1][i + 1]:
            check_forward_slash = False
        if board[len(board) - i - 1][i] != board[len(board) - i - 2][i + 1]:
            check_backward_slash = False
    if check_forward_slash:
        return board[0][0]
    if check_backward_slash:
        return board[-1][0]
    else:
        return


def columns(board):
    """
    :param:the board from input.txt whose length is 3,board is list of elements that each row is an element
    "return: check if the characters of each element in column are the same
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
    :param:the board from input.txt whose length is 3,board is list of elements that each row is an element
    :return: winner of the board, if winner is None, then it's tie
    """

    for row_num, row in enumerate(board):
        if row_all_same(board, row_num):
            winner = board[row_num][0]
            return winner

    for col in columns(board):
        if column_all_same(col):
            winner = col[0]
            return winner

    if check_diagonal(board) is not None:
        winner = check_diagonal(board)
        return winner


def main():
    """
    :return: run the main program to determine winner 'X', 'O' or tie when winner is None
    """
    file = open('input.txt')
    board = file.read().split('\n')
    file.close()
    print_board(board)

    winner = check_winner(board)
    if winner is not None:
        print(winner + ' WINS!!!!')
    else:
        print("TIE GAME!!!!")


if __name__ == '__main__':
    main()
