import java.util.*;

class Solution {
	public int uniquePaths(int m, int n) {
		int[][] memo = new int[m][n];

		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				memo[i][j] = -1;
			}
		}

		return dp(memo, m - 1, n - 1);
	}

	int dp(int[][] memo, int row, int col) {
		if (row == 0 || col == 0) memo[row][col] = 1;

		if (memo[row][col] == -1) {
			memo[row][col] = dp(memo, row - 1, col) + dp(memo, row, col - 1);
		}

		return memo[row][col];
	}
}
