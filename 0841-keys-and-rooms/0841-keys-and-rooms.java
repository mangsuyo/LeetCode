import java.util.*;

class Solution {
	public boolean canVisitAllRooms(List<List<Integer>> rooms) {
		Queue<Integer> queue = new ArrayDeque<>();
		Set<Integer> visited = new HashSet<>();

		queue.add(0);
		visited.add(0);

		while (!queue.isEmpty()) {
			int cur = queue.poll();
			for (Integer key : rooms.get(cur)) {
				if (!visited.contains(key)) {
					queue.add(key);
					visited.add(key);
				}
			}
		}
		
		return visited.size() == rooms.size();
	}
}
