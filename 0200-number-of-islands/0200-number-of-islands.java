import java.util.*;

class Solution {
	public int numIslands(char[][] grid) {

		boolean[][] visited = new boolean[grid.length][grid[0].length];
		int answer = 0;

		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[0].length; j++) {
				if (grid[i][j] == '1' && !visited[i][j]) {
					bfs(i, j, grid, visited);
					answer += 1;
				}
			}
		}

		return answer;
	}

	public void bfs(int i, int j, char[][] grid, boolean[][] visited) {

		visited[i][j] = true;
		Queue<List<Integer>> queue = new ArrayDeque<>();
		queue.add(List.of(i, j));

		int[] dr = {-1, 1, 0, 0};
		int[] dc = {0, 0, -1, 1};

		while(!queue.isEmpty()) {
			List<Integer> cur = queue.poll();
			int curR = cur.get(0);
			int curC = cur.get(1);

			for (int k = 0; k < 4; k++) {
				int nextR = curR + dr[k];
				int nextC = curC + dc[k];
				if (0 <= nextR && nextR < grid.length && 0 <= nextC && nextC < grid[0].length) {
					if (!visited[nextR][nextC] && grid[nextR][nextC] == '1') {
						queue.add(List.of(nextR, nextC));
						visited[nextR][nextC] = true;
					}
				}
			}
		}

	}
}
