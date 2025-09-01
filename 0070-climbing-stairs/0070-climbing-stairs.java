class Solution {

    int[] memo;

    public int climbStairs(int n) {
        memo = new int[n + 1];
        Arrays.fill(memo, -1);
        return dp(n);
    }

    int dp(int n){
        if(n == 1) return 1;
        if(n == 2) return 2;

        if(memo[n] == -1){
            memo[n] = dp(n - 1) + dp(n - 2);
        }

        return memo[n];
    }
}