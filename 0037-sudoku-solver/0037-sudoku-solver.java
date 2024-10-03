class Solution {
	public void solveSudoku(char[][] board) {
		int n = board.length;
		int m = board[0].length;

		backtrack(board, 0);
	}

	boolean backtrack(char[][] board, int index) {
		if (index == 81)
			return true;

		int row = index / 9;
		int col = index % 9;

		if (board[row][col] != '.')
			return backtrack(board, index + 1);

		else {
			for (int i = 1; i <= 9; i++) {
				char number = (char)('0' + i);
				if (isValid(board, row, col, number)) {
					board[row][col] = number;
					if (backtrack(board, index + 1)) return true;
					board[row][col] = '.';
				}
			}
		}

		return false;

	}

	boolean isValid(char[][] board, int row, int col, char number) {

		int r = row / 3;
		int c = col / 3;

		for (int i = 0; i < 9; i++) {
			if (number == board[row][i])
				return false;
		}

		for (int i = 0; i < 9; i++) {
			if (number == board[i][col])
				return false;
		}

		for (int i = r * 3; i < r * 3 + 3; i++) {
			for (int j = c * 3; j < c * 3 + 3; j++) {
				if (number == board[i][j])
					return false;
			}
		}

		return true;
	}
}
