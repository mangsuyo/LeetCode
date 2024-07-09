import java.nio.MappedByteBuffer;

class Solution {

	int n;
	int m;
	int[] dr = new int[] {-1, 1, 0, 0};
	int[] dc = new int[] {0, 0, -1, 1};

	public boolean exist(char[][] board, String word) {
		this.n = board.length;
		this.m = board[0].length;

		StringBuilder answer = new StringBuilder();
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (board[i][j] == word.charAt(0)) {
					char value = board[i][j];
					board[i][j] = '.';
					if (backtrack(i, j, board, word, answer, 1)) {
						return true;
					}
					board[i][j] = value;
					;
				}
			}
		}
		return false;
	}

	private boolean backtrack(int r, int c, char[][] board, String word, StringBuilder sb, int index) {

		if (index == word.length()) {
			return true;
		}

		for (int i = 0; i < 4; i++) {
			int nextR = r + dr[i];
			int nextC = c + dc[i];
			if (nextR >= 0 && nextR < n && nextC >= 0 && nextC < m) {
				if(board[nextR][nextC] != '.') {
					if (board[nextR][nextC] == word.charAt(index)) {
						char value = board[nextR][nextC];
						board[nextR][nextC] = '.';
						if (backtrack(nextR, nextC, board, word, sb, index + 1)) {
							return true;
						}
						board[nextR][nextC] = value;
					}
				}
			}
		}

		return false;
	}
}
