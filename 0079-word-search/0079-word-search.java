class Solution {

	int n;
	int m;
	String target;

	int[] dr = {-1, 1, 0, 0};
	int[] dc = {0, 0, -1, 1};

	public boolean exist(char[][] board, String word) {
		n = board.length;
		m = board[0].length;
		target = word;

		for(int i = 0; i < board.length; i++){
			for(int j = 0; j < board[0].length; j++){
				if(board[i][j] == word.charAt(0)){
					if(dfs(board, i, j, 0)){
						return true;
					};
				}
			}
		}

		return false;
	}

	boolean dfs(char[][] board, int i, int j, int count){
		if(count == target.length() - 1){
			return true;
		}

		for(int k = 0; k < 4; k++){
			int nextR = i + dr[k];
			int nextC = j + dc[k];
			if(nextR >= 0 && nextR < n && nextC >= 0 && nextC < m){
				if(board[nextR][nextC] == target.charAt(count + 1)){
					char ch = board[i][j];
					board[i][j] = '.';
					if(dfs(board, nextR, nextC, count + 1)){
						return true;
					};
					board[i][j] = ch;
				}
			}
		}

		return false;
	}
}
