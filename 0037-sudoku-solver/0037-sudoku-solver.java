class Solution {

	int n = 9;
	int m = 9;

	public void solveSudoku(char[][] board) {
		backtrack(board);
		System.out.println(board);
	}

	private boolean backtrack(char[][] board){


		for(int i = 0; i < n; i++){
			for(int j = 0; j < n; j++){
				if(board[i][j] == '.'){
					for(int k = 1; k <= n; k++){
						char value = Character.forDigit(k, 10);
						if(inspect(i, j, value, board)){
							board[i][j] = value;
							if(backtrack(board)){
								return true;
							}
							else{
								board[i][j] = '.';
							}
						}
					}
					return false;
				}
			}
		}
		return true;
	}

	private boolean inspect(int r, int c, char number, char[][] board){

		int startR = (r / 3) * 3;
		int startC = (c / 3) * 3;

		for(int i = 0; i < n; i++){
			if(board[r][i] == number) return false;
		}

		for(int i = 0; i < n; i++){
			if(board[i][c] == number) return false;
		}

		for(int i = startR; i < startR + 3; i++){
			for(int j = startC; j < startC + 3; j++){
				if(board[i][j] == number) return false;
			}
		}
		return true;
	}
}
