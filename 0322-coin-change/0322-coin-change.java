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
		List<Integer> answers = new ArrayList<>();
		queue.add(new Pair(amount, 0));
		boolean[] visited = new boolean[amount + 1];
		visited[amount] = true;

		while (!queue.isEmpty()) {
			Pair cur = queue.poll();
			if (cur.amount == 0) {
				return cur.count;
			}
			if (cur.amount < 0)
				continue;
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
