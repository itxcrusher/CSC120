import java.util.ArrayList;
import java.util.Arrays;

public class Main
{
    public static void main(String [] args)
    {
	String[] strs = 	{   "XXX",
				    "OXO",
				    "XOO"};
	ArrayList<String> rows = new ArrayList<String>(Arrays.asList(strs));
	TicTacToeBoard theBoard = new TicTacToeBoard(rows);
						      
	System.out.println(theBoard);

	System.out.println("The winner is " + theBoard.getWinner());

	theBoard.placePiece(0, 0, 'O');

	System.out.println(theBoard);
    }
}