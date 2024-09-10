import java.util.*;

class Solution {
	public boolean canVisitAllRooms(List<List<Integer>> rooms) {
		Set<Integer> visited = new HashSet<>();
		visited.add(0);
		dfs(rooms, 0, visited);

		System.out.println(visited.size());

		return visited.size() == rooms.size();
	}

	void dfs(List<List<Integer>> rooms, int vertex, Set<Integer> visited){
		List<Integer> room = rooms.get(vertex);

		for(Integer key: room){
			if(!visited.contains(key)){
				visited.add(key);
				dfs(rooms, key, visited);
			}
		}

	}
}
