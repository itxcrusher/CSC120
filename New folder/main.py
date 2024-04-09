'''
@author: ??????
'''

import tictactoe as ttt

def __read_board_from_file(filename):
    board_file = open(filename)
    board_lines = board_file.read()
    board_file.close()

    return board_lines.split('\n')

def main():
    list_of_rows = __read_board_from_file("input.txt")
    board = ttt.create_board(list_of_rows)
    print(ttt.board_string(board))
    
    winner = ttt.get_winner(board)

    print ("Result: %s wins" % (str(winner)))

if __name__ == "__main__":
    main()
