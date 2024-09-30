import java.util.*;

class Solution {
	public int minCostClimbingStairs(int[] cost) {
		int n = cost.length;
		int[] memo = new int[n + 1];
		int[] stairs = new int[n + 1];

		for (int i = 0; i < cost.length; i++) {
			stairs[i] = cost[i];
		}

		stairs[n] = 0;

		Arrays.fill(memo, -1);
		return dp(memo, stairs, n);
	}

	int dp(int[] memo, int[] cost, int stair) {
		if (stair == 0)
			return cost[0];
		if (stair == 1)
			return cost[1];

		if (memo[stair] == -1) {
			memo[stair] = cost[stair] + Math.min(dp(memo, cost, stair - 1), dp(memo, cost, stair - 2));
		}

		return memo[stair];
	}
}
