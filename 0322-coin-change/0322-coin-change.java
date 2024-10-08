import java.util.*;

class Solution {

	int min = Integer.MAX_VALUE;
	int[] memo;


	public int coinChange(int[] coins, int amount) {
		memo = new int[amount + 1];
		Arrays.fill(memo, -1);
		dfs(coins, amount, 0);
		if(min == Integer.MAX_VALUE) return -1;
		return min;
	}

	void dfs(int[] coins, int amount, int count) {
		if (amount == 0)
		{
			if(min > count) min = count;
			return;
		}
		if (amount < 0)
			return;
		
		if(memo[amount] != -1 && memo[amount] <= count) return;
		memo[amount] = count;

		for (int coin : coins) {
			dfs(coins, amount - coin, count + 1);
		}
	}
}
