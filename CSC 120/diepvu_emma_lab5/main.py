import tictactoe_board as board

def main():
    the_board = board.TicTacToeBoard(['XXX', 'OXO', 'XOO'])
    print(the_board)

    print("The winner is %s" % the_board.get_winner())

    the_board.place_piece(0, 0, 'O')

    print(the_board)

if __name__ == "__main__":
    main()
