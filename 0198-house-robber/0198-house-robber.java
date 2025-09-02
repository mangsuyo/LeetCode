class Solution {

    int[] memo;

    public int rob(int[] nums) {
        memo = new int[nums.length + 1];
        Arrays.fill(memo, -1);
        return dp(nums, nums.length - 1);
    }

    int dp(int[] nums, int n){
        if(n < 0) return 0;

        if(memo[n] != -1) return memo[n];
        memo[n] = Math.max(dp(nums, n - 1), dp(nums, n - 2) + nums[n]);
        return memo[n];
    }
}