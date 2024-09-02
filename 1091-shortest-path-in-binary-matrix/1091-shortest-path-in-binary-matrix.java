import java.util.*;

class Solution {
	public int shortestPathBinaryMatrix(int[][] grid) {
		if (grid[0][0] == 1 || grid[grid.length - 1][grid[0].length - 1] == 1)
			return -1;

		Queue<List<Integer>> queue = new ArrayDeque<>();
		boolean[][] visited = new boolean[grid.length][grid[0].length];

		queue.add(List.of(0, 0, 1));
		visited[0][0] = true;

		int[] dr = new int[] {-1, -1, -1, 0, 1, 1, 1, 0};
		int[] dc = new int[] {-1, 0, 1, 1, 1, 0, -1, -1};

		while (!queue.isEmpty()) {
			List<Integer> cur = queue.poll();
			int curR = cur.get(0);
			int curC = cur.get(1);
			int count = cur.get(2);
			if (curR == grid.length - 1 && curC == grid[0].length - 1) {
				return count;
			}
			for (int i = 0; i < 8; i++) {
				int nextR = curR + dr[i];
				int nextC = curC + dc[i];
				if (0 <= nextR && nextR < grid.length && 0 <= nextC && nextC < grid[0].length) {
					if (!visited[nextR][nextC] && grid[nextR][nextC] == 0) {
						queue.add(List.of(nextR, nextC, count + 1));
						visited[nextR][nextC] = true;
					}
				}
			}
		}
		return -1;
	}

}
