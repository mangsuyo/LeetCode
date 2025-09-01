class Solution {

    Map<Integer, Integer> memo = new HashMap<>();
    public int minCostClimbingStairs(int[] cost) {
        return dp(cost, cost.length);
    }

    int dp(int[] cost, int n){
        if(n == 0) return 0;
        if(n == 1) return 0;

        if(!memo.containsKey(n)){
            memo.put(n, Math.min(cost[n - 1] + dp(cost, n - 1), cost[n - 2] + dp(cost, n - 2)));
        }

        return memo.get(n);

    }

        

}