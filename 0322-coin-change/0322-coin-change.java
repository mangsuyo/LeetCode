import java.util.*;

class Solution {

	static class Pair {
		int amount;
		int count;

		public Pair(int amount, int count) {
			this.amount = amount;
			this.count = count;
		}
	}


	public int coinChange(int[] coins, int amount) {
		return bfs(coins, amount);
	}

	int bfs(int[] coins, int amount) {
		Queue<Pair> queue = new ArrayDeque<>();
		boolean[] visited = new boolean[amount];

		queue.add(new Pair(amount, 0));

		while (!queue.isEmpty()) {
			Pair cur = queue.poll();
			if(cur.amount == 0) return cur.count;
			for (int coin : coins) {
				int diff = cur.amount - coin;
				if (diff >= 0 && !visited[diff]) {
					queue.add(new Pair(diff, cur.count + 1));
					visited[diff] = true;
				}
			}
		}

		return -1;
	}

}
