package arviarya;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * Problem
 * 
 * Tic-Tac-Toe-Tomek is a game played on a 4 x 4 square board. The board starts
 * empty, except that a single 'T' symbol may appear in one of the 16 squares.
 * There are two players: X and O. They take turns to make moves, with X
 * starting. In each move a player puts her symbol in one of the empty squares.
 * Player X's symbol is 'X', and player O's symbol is 'O'.
 * 
 * After a player's move, if there is a row, column or a diagonal containing 4
 * of that player's symbols, or containing 3 of her symbols and the 'T' symbol,
 * she wins and the game ends. Otherwise the game continues with the other
 * player's move. If all of the fields are filled with symbols and nobody won,
 * the game ends in a draw. See the sample input for examples of various winning
 * positions.
 * 
 * Given a 4 x 4 board description containing 'X', 'O', 'T' and '.' characters
 * (where '.' represents an empty square), describing the current state of a
 * game, determine the status of the Tic-Tac-Toe-Tomek game going on. The
 * statuses to choose from are:
 * 
 * "X won" (the game is over, and X won) "O won" (the game is over, and O won)
 * "Draw" (the game is over, and it ended in a draw) "Game has not completed"
 * (the game is not over yet) If there are empty cells, and the game is not
 * over, you should output "Game has not completed", even if the outcome of the
 * game is inevitable.
 * 
 * 
 * 
 * @author arvindkumar
 * 
 */
public class TicTacToeTomek {

	final static String PATH = "/Users/arvindkumar/QuantumDB/workspace_trunk_new/CodeTest/src/arviarya";

	public static void main(String[] args) throws Exception {

		final Scanner sc = new Scanner(new FileReader(PATH + "/in.txt"));
		final PrintWriter pw = new PrintWriter(
				new FileWriter(PATH + "/out.txt"));
		final int datasetNumber = sc.nextInt();

		final char[][] play = new char[4][4];

		for (int i = 0; i < datasetNumber; i++) {
			sc.nextLine();
			String playLine = null;

			for (int p = 0; p < 4; p++) {
				playLine = sc.nextLine();
				for (int j = 0; j < 4; j++) {
					play[p][j] = playLine.charAt(j);
				}
			}

			pw.print("Case #" + (i + 1) + ": ");
			if (checkWin(play, 'X')) {
				pw.print("X won");
			} else if (checkWin(play, 'O')) {
				pw.print("O won");
			} else if (inProcessGame(play)) {
				pw.print("Game has not completed");
			} else {
				pw.print("Draw");
			}

			pw.println();

		}
		pw.flush();
		pw.close();
		sc.close();
	}

	private static boolean checkWin(char[][] playData, char playerChar) {

		// Win cases
		int match = 0;
		final char[][] play = replaceT(playData, playerChar);

		// Check all 4 rows and cols
		for (int i = 0; i < 4; i++) {
			match = 0;
			for (int j = 0; j < 4; j++) {
				if (play[i][j] == playerChar) {
					match++;
				}
			}

			if (match == 4) {
				return true;
			}

			match = 0;
			for (int j = 0; j < 4; j++) {
				if (play[j][i] == playerChar) {
					match++;
				}
			}

			if (match == 4) {
				return true;
			}

		}

		// Check both diagonals
		match = 0;
		for (int i = 0; i < 4; i++) {
			if (play[i][i] == playerChar) {
				match++;
			}

		}

		if (match == 4) {
			return true;
		}

		match = 0;
		for (int i = 0; i < 4; i++) {
			if (play[3 - i][i] == playerChar) {
				match++;
			}
		}

		if (match == 4) {
			return true;

		}

		return false;

	}

	private static boolean inProcessGame(char[][] play) {
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++) {
				if (play[i][j] == '.') {
					return true;
				}
			}
		}
		return false;
	}

	private static char[][] replaceT(char[][] play, char replacementChar) {
		final char[][] newPlay = new char[4][4];
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++) {
				newPlay[i][j] = play[i][j] == 'T' ? replacementChar
						: play[i][j];
			}
		}

		return newPlay;
	}

}
