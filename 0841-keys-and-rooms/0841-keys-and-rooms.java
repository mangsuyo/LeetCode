import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;

class Solution {
	public boolean canVisitAllRooms(List<List<Integer>> rooms) {
		Deque<Integer> queue = new ArrayDeque<>();
		boolean[] visited = new boolean[rooms.size()];

		queue.add(0);

		while(!queue.isEmpty()) {
			int cur = queue.poll();
			visited[cur] = true;
			List<Integer> room = rooms.get(cur);
			for(int i = 0; i < room.size(); i++){
				if(!visited[room.get(i)]){
					queue.add(room.get(i));
				}
			}
		}

		for(int i = 0; i < visited.length; i++){
			if(!visited[i]){return false;}
		}
		return true;
	}
}
