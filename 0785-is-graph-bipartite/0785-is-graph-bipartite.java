import java.util.Arrays;

class Solution {

	char[] colors;

	public boolean isBipartite(int[][] graph) {
		colors = new char[graph.length];
		Arrays.fill(colors, 'C');
		
		for(int i = 0; i < graph.length; i++){
			if(colors[i] == 'C'){
				if(!dfs(graph, i, 'A')) return false;
			}
		}
		
		return true;
	}

	boolean dfs(int[][] graph, int index, char color) {
		colors[index] = color;

		int[] nodes = graph[index];
		for (int node : nodes) {
			if (colors[node] == 'C') {
				if (color == 'A') {
					if (!dfs(graph, node, 'B'))
						return false;
				} else {
					if (!dfs(graph, node, 'A'))
						return false;
				}
			} else {
				if (colors[node] == color) {
					return false;
				}
			}
		}

		return true;
	}

}
