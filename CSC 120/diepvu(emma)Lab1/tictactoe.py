# '''
# Created on January 9, 2017
#
# @author: cassa
# '''

boardfile = open("tictactoe_board.txt")
board = boardfile.read()
boardfile.close()

rows = board.split('\n')

# # #1
if len(rows) != 3:
    print('Error')
# # #2
for i in rows:
    if len(i) != 3:
        print("Error")
#3:
for i in range(len(rows)-1):
    if rows[0][i] == rows[1][i] == rows[2][i]:
        print('Three in a row!')
# #4
# Horizontal
def check_horizontal(rows):
    for i in rows:
        countX = 0
        countO = 0
        for j in i:
            if j == 'X':
                countX += 1
                if countX == 3:
                    print('three in horizontal')
            elif j == 'O':
                countO += 1
                if countO == 3:
                    print('three in horizontal')
check_horizontal(rows)
#Vertical
for j in range(len(rows)-1):
    if rows[j][0] == rows[j][1] == rows[j][2]:
        print('three in vertical')
# Diagonal

if rows[0][0] == rows[1][1] == rows[2][2]:
     print('Diagonal down')
if rows[2][0] == rows[1][1] == rows[0][2]:
    print('Diagonal up')












