import java.util.Arrays;

class Solution {

	int n;
	int m;

	public void solveSudoku(char[][] board) {
		this.n = board.length;
		this.m = board[0].length;

		char[][] clone = new char[n][m];

		for (int i = 0; i < n; i++) {
			clone[i] = board[i].clone();
		}

		backtrack(clone, 0);

		for (int i = 0; i < n; i++) {
			board[i] = clone[i].clone();
		}
	}

	public boolean backtrack(char[][] clone, int count) {

		if (count == 81)
			return true;

		int r = count / 9;
		int c = count % 9;

		if (clone[r][c] != '.')
			return backtrack(clone, count + 1);
		else {
			for (int i = 1; i <= 9; i++) {
				char nextValue = (char)('0' + i);
				if (isValid(clone, nextValue, r, c)) {
					clone[r][c] = nextValue;
					if (backtrack(clone, count + 1))
						return true;
					clone[r][c] = '.';
				}
			}
		}
		return false;
	}

	boolean isValid(char[][] board, char nextValue, int row, int col) {

		for (int i = 0; i < 9; i++) {
			if (board[row][i] == nextValue) {
				return false;
			}
		}

		for (int i = 0; i < 9; i++) {
			if (board[i][col] == nextValue) {
				return false;
			}
		}

		int r = row / 3;
		int c = col / 3;

		for (int i = r * 3; i < r * 3 + 3; i++) {
			for (int j = c * 3; j < c * 3 + 3; j++) {
				if (board[i][j] == nextValue) {
					return false;
				}
			}
		}

		return true;
	}
}
