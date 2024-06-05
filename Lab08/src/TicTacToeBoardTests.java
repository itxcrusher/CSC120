import java.util.ArrayList;
import java.util.Arrays;

/*
 * Author’s Name: Ali Hamza
 * Honor Code: I hereby affirm that I have carried out all my academic endeavours with full academic honesty.
 */

public class TicTacToeBoardTests {
	public static void main(String[] args) {
		Tester suite = new Tester();
		testGetWinner(suite);
		suite.finishTests();
	}

	public static void testGetWinner(Tester suite) {
		suite.testSection("Testing getWinner()");

		// horizontal, vertical, and diagonal wins
		String[] winningBoard = {"XXX", "XOX", "OXO"};
		ArrayList<String> rows = new ArrayList<>(Arrays.asList(winningBoard));
		TicTacToeBoard aBoard = new TicTacToeBoard(rows);

		suite.assertEquals(aBoard + " Three Xs in a row horizontally", 'X', aBoard.getWinner());

		aBoard.placePiece(2, 0, 'X');
		suite.assertEquals(aBoard + " Three Xs in a row vertically", 'X', aBoard.getWinner());

		aBoard.placePiece(0, 0, 'O');
		suite.assertEquals(aBoard + " Three Os diagonally", 'O', aBoard.getWinner());

		// Incomplete/Empty board (combined)
		aBoard = new TicTacToeBoard();
		suite.assertEquals(aBoard + " Empty board, no winner yet", ' ', aBoard.getWinner());

		// Tie
		String[] tie = {"XOX", "OXO", "OXO"};
		rows = new ArrayList<>(Arrays.asList(tie));
		aBoard = new TicTacToeBoard(rows);
		suite.assertEquals(aBoard + " Full board, no winner (tie)", ' ', aBoard.getWinner());
	}
}