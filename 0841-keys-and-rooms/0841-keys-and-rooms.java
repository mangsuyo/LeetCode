import java.util.*;

class Solution {

	public boolean canVisitAllRooms(List<List<Integer>> rooms) {
		Map<Integer, List<Integer>> graph = new HashMap<>();
		for (int i = 0; i < rooms.size(); i++) {
			graph.putIfAbsent(i, new ArrayList<>());
			graph.put(i, rooms.get(i));
		}
		int startVertex = 0;
		return bfs(startVertex, graph, new HashSet<>()) == rooms.size();
	}

	private int bfs(int startVertex, Map<Integer, List<Integer>> graph, Set<Integer> visited) {
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
