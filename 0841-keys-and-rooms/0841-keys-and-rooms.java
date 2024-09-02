import java.util.*;

class Solution {
	public boolean canVisitAllRooms(List<List<Integer>> rooms) {
		
		Queue<Integer> queue = new ArrayDeque<>();
		boolean[] visited = new boolean[rooms.size()];
		
		queue.add(0);
		visited[0] = true;
		
		while(!queue.isEmpty()){
			int newVertex = queue.poll();
			List<Integer> keys = rooms.get(newVertex);
			for(Integer key : keys){
				if(!visited[key]){
					visited[key] = true;
					queue.add(key);
				}
			}
		}
		
		for(int i = 0; i < visited.length; i++){
			if(!visited[i]){
				return false;
			}
		}
		
		return true;
	}
}
