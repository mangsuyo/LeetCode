import java.util.*;

class Solution {
	class Fair {
		int first;
		char second;

		public Fair(int first, char second) {
			this.first = first;
			this.second = second;
		}

		@Override
		public String toString() {
			return "Fair{" +
				"first=" + first +
				", second=" + second +
				'}';
		}
	}

	public boolean isBipartite(int[][] graph) {
		char[] chars = new char[graph.length];
		Arrays.fill(chars, 'N');

		for(int i = 0; i < graph.length; i++){
			if(chars[i] == 'N'){
				if(!bfs(graph, chars, i, 'A')){
					return false;
				}
			}
		}
		return true;
	}

	boolean bfs(int[][] graph, char[] chars, int start, char ch) {
		Queue<Fair> queue = new ArrayDeque<>();
		queue.add(new Fair(start, ch));

		while (!queue.isEmpty()) {
			Fair fair = queue.poll();
			for (Integer key : graph[fair.first]) {
				if (chars[key] == 'N') {
					if (fair.second == 'A') {
						queue.add(new Fair(key, 'B'));
						chars[key] = 'B';
					} else {
						queue.add(new Fair(key, 'A'));
						chars[key] = 'A';
					}
				} else if (chars[key] == fair.second) {
					return false;
				}
			}
		}
		return true;
	}
}
