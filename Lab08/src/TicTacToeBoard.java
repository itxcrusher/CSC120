import java.util.ArrayList;

/**
 * @author Aaron Cass
 */

public class TicTacToeBoard
{

    private ArrayList<ArrayList<Character>> rows;

    /**
     * Creates a tic-tac-toe board with given cell values.  If no initial
     * cell values are given, creates an empty tic-tac-toe board.
     *        
     * @param rows A list of 3 3-character strings, where each
     *        character is either 'X', 'O', or ' '.  Each of the 3-character
     *        strings represents a row of the tic-tac-toe board.
     */
    public TicTacToeBoard(ArrayList<String> rows)
    {
	this.rows = new ArrayList<ArrayList<Character>>();
	for (int i = 0; i < 3; i++) {
	    ArrayList<Character> row = new ArrayList<Character>();
	    for (int j = 0; j < 3; j++) {
		row.add(rows.get(i).charAt(j));
	    }
	    this.rows.add(row);
	}
    }

    /**
     * Creates an empty tic-tac-toe board.
     */
    public TicTacToeBoard()
    {
	rows = new ArrayList<ArrayList<Character>>();
	for (int i = 0; i < 3; i++) {
	    ArrayList<Character> row = new ArrayList<Character>();
	    for (int j = 0; j < 3; j++) {
		row.add(Character.valueOf(' '));
	    }
	    this.rows.add(row);
	}
    }

			
    /**
     *  Places a piece (either 'X' or 'O') on the board.
     *
     *  @param i The row in which to place a piece (0, 1, or 2)
     *  @param j The column in which to place a piece (0, 1, or 2)
     *  @param piece The piece to place ('X' or 'O')
     */
    public void placePiece(int i, int j, char piece)
    {
	rows.get(i).set(j, piece);
    }

    /**
     *  Clears a cell on the board.
     *
     *  @param i The row with the cell to clear
     *  @param j The column with the cell to clear
     */
    public void clearCell(int i, int j)
    {
        placePiece(i, j, ' ');
    }

    private String rowAsString(ArrayList<Character> row)
    {
        String str = "";
        for (int column = 0; column < row.size() - 1; column++) {
            str += row.get(column) + " | ";
	}
        str += row.get(row.size() - 1);
        return str;
    }
    
    public String toString()
    {
        String result = "";
        for (int row = 0; row < rows.size() - 1; row++) {
            result += rowAsString(rows.get(row));
            result += "\n----------\n";
	}
        result += rowAsString(rows.get(rows.size() - 1));
        result += "\n";
        return result;
    }

    /**
     * Determines if a player has three in a row, starting
     * from a starting position (start_x, start_y) and going
     * in the direction indicated by (dx, dy)
     */
    private boolean threeInRow(char player,
			       int start_x, int start_y,
			       int dx, int dy)
    {
        int x = start_x;
	int y = start_y;
        for (int i = 0; i < 3; i++) {
            if (rows.get(y).get(x) != player) {
                return false;
	    }
            x += dx;
	    y += dy;
	}
            
        return true;
    }

    /**
     * Returns True if and only if the given player has won
     */
    private boolean isWinner(char player)
    {
        for (int i = 0; i < 3; i++) {
            if (threeInRow(player, 0, i, 1, 0)
                ||
		threeInRow(player, i, 0, 0, 1)) {
                return true;
	    }
	}

        return (threeInRow(player, 0, 0, 1, 1)
                ||
		threeInRow(player, 0, 2, 1, -1));
    }

    /**
     * Determines if there is a winner and returns the player who has won.
     *
     * @return 'X' if player X is the winner; 'O' if player O is the
     *   winner; ' ' if there is no winner.
     */
    public char getWinner()
    {
	if (isWinner('X')) {
	    return 'X';
	} else if (isWinner('O')) {
            return 'O';
	} else {
            return ' ';
	}
    }
}