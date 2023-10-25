package Lab5;

public class TicTacToe {
	private static final char EMPTY = ' ';
	private char[][] board;

	public TicTacToe(char[][] board) {
		this.board = board;
	}

	/*
	 * This method checks all rows and returns true if any of them are marked with
	 * all of a single player's markers. Otherwise, returns false.
	 */
	public boolean checkRows(char symbol) {
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[i].length - 2; j++) {
				if (board[i][j] == symbol && board[i][j + 1] == symbol && board[i][j + 2] == symbol) {
					return true;
				}
			}
		}
		return false;
	}

	/*
	 * This method checks all columns and returns true if any of them are marked
	 * with all of a single player's. Otherwise, returns false.
	 */
	public boolean checkColumns(char symbol) {
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board.length - 2; j++) {
				if (board[j][i] == symbol && board[j + 1][i] == symbol && board[j + 2][i] == symbol) {
					return true;
				}
			}
		}
		return false;
	}

	/*
	 * This method checks both diagonals and returns true if any of them are marked
	 * with all of a single player's markers. Otherwise, returns false.
	 */
	public boolean checkDiagonals(char symbol) {
		// Check top-left to bottom-right
		for (int i = 0; i < board.length - 2; i++) {
			// Check top-left to bottom-right
			if (board[i][i] == symbol 
				&& board[i + 1][i + 1] == symbol 
				&& board[i + 2][i + 2] == symbol) {
				return true;
			}
			// Check bottom-left to top-right
			if (board[i][board.length - i - 1] == symbol 
				&& board[i + 1][board.length - i - 2] == symbol
				&& board[i + 2][board.length - i - 3] == symbol) {
				return true;
			}
		}
		return false;
	}

	public static void printMatrix(char[][] board) {
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[i].length; j++) {
				System.out.print(board[i][j] + "\t");
			}
			System.out.println("\n");
		}
	}

	public static void main(String[] args) {
		char[][] board = { { 'X', 'O', 'O' }, { 'X', 'X', 'X' }, { 'O', ' ', ' ' } };
		char[][] board1 = { { ' ', 'X', 'O' }, { 'X', 'X', 'O' }, { 'O', 'X', ' ' } };
		char[][] board2 = { { 'X', 'O', 'O' }, { ' ', 'X', 'O' }, { ' ', ' ', 'X' } };
		char[][] board3 = { { 'X', 'X', 'O' }, { 'X', 'O', ' ' }, { 'O', ' ', ' ' } };

		TicTacToe t = new TicTacToe(board);
		TicTacToe t1 = new TicTacToe(board1);
		TicTacToe t2 = new TicTacToe(board2);
		TicTacToe t3 = new TicTacToe(board3);

		char x = 'X';
		char o = 'O';

		System.out.println("Van 1:" + "\n");
		printMatrix(board);
		System.out.println("Player win? (Check rows)" + "\n" + t.checkRows(x));

		System.out.println();

		System.out.println("Van 2:" + "\n");
		printMatrix(board1);
		System.out.println("Player win? (Check columns)" + "\n" + t1.checkColumns(x));

		System.out.println();

		System.out.println("Van 3:" + "\n");
		printMatrix(board2);
		System.out.println("Player win? (Check diagonals)" + "\n" + t2.checkDiagonals(x));

		System.out.println();

		System.out.println("Van 4:" + "\n");
		printMatrix(board3);
		System.out.println("Player win? (Check diagonals)" + "\n" + t3.checkDiagonals(o));
	}
}
