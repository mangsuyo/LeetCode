class Solution {

    int[][] memo;

    public int uniquePaths(int m, int n) {
        memo = new int[m][n];
        for(int i = 0; i < m ; i++){
            Arrays.fill(memo[i], -1);
        }

        return dp(m - 1, n - 1);
    }

    int dp(int r, int c){
        if(r == 0 && c == 0) return 1;
        if(r < 0 || c < 0) return 0;

        if(memo[r][c] == -1){
            memo[r][c] = dp(r - 1, c) + dp(r, c - 1);
        }

        return memo[r][c];   
    }
}