board_file = open("tictactoe_board.txt")
board = board_file.read()
board_file.close()

rows = board.split('\n')

print(rows)

# Starter Code End
# Solution Code start

'''
what kind of variable is 'rows' in the code?
'''
print("The kind of variable rows is:", type(rows))  # Finding the type of variable: (list)

'''
Add to or modify the code to so that it prints an error message if the number
of rows is not exactly 3.
'''
total_rows = len(rows)  # Store number of elements of list in a variable
if total_rows != 3:     # If not equal to 3
    print("Error: The tic-tac-toe board should have 3 rows!")   # Error message

'''
Make it so that an error message is printed if the number of columns is not exactly 3. (i.e.
if any row has fewer or more than 3 characters).
'''
for row in rows:    # Loop on each element of list
    total_cols = len(row)   # Store number of characters of each element
    if total_cols != 3:     # If characters of each element is not 3 (number of columns is not 3)
        print("Error: A row has an incorrect number of characters (should be 3)!")  # Error message

'''
Make it so that a message is printed if any of the rows is three-in-a-row (either X or O)
'''
for row in rows:    # Loop on each element of list
    if row == "XXX" or row == "OOO":  # Check for all Xs or all Os in a row
        print("Error: A row has three in a row!")   # Message is displayed

'''
Make it so that a message is printed if there is three in a row horizontally,
vertically, or diagonally.
'''
# Check rows (horizontally)
for row in rows:    # For each element of list
    if row == "XXX" or row == "OOO":  # If all 3 same X or O
        print("Error: Three in a row detected horizontally!")   # Print Message

# Check columns (vertically)
for col in range(3):    # Loop through each column index (0, 1, and 2)
    column = ""         # Initialize an empty string to store the column characters
    for row in rows:    # Loop through each row in the list 'rows'
        column += row[col]    # Append the character at index 'col' of the current row to the 'column' string
    if column == "XXX" or column == "OOO":    # If all 3 same
        print("Error: Three in a row detected vertically!")   # Print message

# Check diagonals
diagonal1 = rows[0][0] + rows[1][1] + rows[2][2]    # Concatenate left diagonal elements using their index
diagonal2 = rows[0][2] + rows[1][1] + rows[2][0]    # Concatenate right diagonal elements using their index
if diagonal1 == "XXX" or diagonal1 == "OOO" or diagonal2 == "XXX" or diagonal2 == "OOO":  # Check for all 3 same
    print("Error: Three in a row detected diagonally!")     # Print message
