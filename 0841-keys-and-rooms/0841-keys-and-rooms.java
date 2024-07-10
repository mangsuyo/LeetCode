import java.util.*;

class Solution {

	public boolean canVisitAllRooms(List<List<Integer>> rooms) {
		int startVertex = 0;
		return bfs(startVertex, rooms, new HashSet<>()) == rooms.size();
	}

	private int bfs(int startVertex, List<List<Integer>> graph, Set<Integer> visited) {
		Queue<Integer> queue = new ArrayDeque<>();
		queue.add(startVertex);
		visited.add(startVertex);

		while (!queue.isEmpty()) {
			int currentVertex = queue.poll();
			for (int vertex : graph.get(currentVertex)) {
				if (!visited.contains(vertex)) {
					queue.add(vertex);
					visited.add(vertex);
				}
			}
		}

		return visited.size();
	}
}
