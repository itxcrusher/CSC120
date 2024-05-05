'''
:author: Aaron Cass
'''

class TicTacToeBoard:
    def __init__(self, rows = None):
        """
        Creates a tictactoe board with given cell values.  If no initial
        cell values are given, creates an empty tictactoe board.
        
        :param rows: A list of 3 3-character strings, where each character is either 'X', 'O', or ' '.  Each of the
        3-character strings represents a row of the tictactoe board.
        """
        self.__rows = []
        if rows is None:
            empty_row = [' ', ' ', ' ']
            for i in range(3):
                self.__rows.append(empty_row)
        else:
            for i in range(3):
                row = []
                for j in range(3):
                    row.append(rows[i][j])
                self.__rows.append(row)

    def place_piece(self, i, j, piece):
        """
        Places a piece (either 'X' or 'O') on the board.

        :param i: The row in which to place a piece (0, 1, or 2)
        :param j: The column in which to place a piece (0, 1, or 2)
        :param piece: The piece to place ('X' or 'O')
        """
        self.__rows[i][j] = piece

    def clear_cell(self, i, j):
        """
        Clears a cell on the tictactoe board.

        :param i: The row with the cell to clear
        :param j: The column with the cell to clear
        """
        self.place_piece(i, j, ' ')

    def __row_as_string(self, row):
        """

        :param row: rows in board
        :return: strings of tic_tac_toe pieces
        """
        str = ''
        for column in row[:-1]:
            str += column + ' | '
        str += row[-1]
        return str

    def __str__(self):
        """
        Produces a string representation of a board, returns it.

        :return: The string version of the board.
        """
        result = ''
        for row in self.__rows[:-1]:
            result += self.__row_as_string(row)
            result += '\n----------\n'
        result += self.__row_as_string(self.__rows[-1])
        result += '\n'
        return result

    def __three_in_row(self, player, start_x, start_y, dx, dy):
        """
        Determines if a player has three in a row, starting
        from a starting position (start_x, start_y) and going
        in the direction indicated by (dx, dy)
        """
        x = start_x; y = start_y
        for i in range(0,3):
            if self.__rows[y][x] != player:
                return False
            x += dx; y += dy
            
        return True

    def __is_winner(self, player):
        """
        Returns True if and only if the given player has won
        """
        for i in range(0, 3):
            if (self.__three_in_row(player, 0, i, 1, 0)
                or self.__three_in_row(player, i, 0, 0, 1)):
                return True

        return (self.__three_in_row(player, 0, 0, 1, 1)
                or self.__three_in_row(player, 0, 2, 1, -1))

    def get_winner(self):
        """
        Determines if there is a winner and returns the player who has won.

        :return: 'X' if player X is the winner; 'O' if player O is the
        winner; None if there is no winner.
        """
        if self.__is_winner('X'):
            return 'X'
        elif self.__is_winner('O'):
            return 'O'
        else:
            return None

