class Solution {

	public boolean exist(char[][] board, String word) {
		int n = board.length;
		int m = board[0].length;
		int index = 0;

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (board[i][j] == word.charAt(0)) {
					char buffer = board[i][j];
					board[i][j] = '.';
					if (backtrack(board, word, i, j, index + 1))
						return true;
					board[i][j] = buffer;
				}
			}
		}

		return false;
	}

	private boolean backtrack(char[][] board, String word, int x, int y, int index) {
		if (index == word.length()) {
			return true;
		}

		int n = board.length;
		int m = board[0].length;

		int[] dr = {-1, 1, 0, 0};
		int[] dc = {0, 0, -1, 1};

		for (int i = 0; i < 4; i++) {
			int nextX = x + dr[i];
			int nextY = y + dc[i];
			if (nextX >= 0 && nextX < n && nextY >= 0 && nextY < m) {
				if (board[nextX][nextY] == word.charAt(index)) {
					char buffer = board[nextX][nextY];
					board[nextX][nextY] = '.';

					if (backtrack(board, word, nextX, nextY, index + 1)) {
						return true;
					}
					board[nextX][nextY] = buffer;
				}
			}
		}

		return false;
	}

}
