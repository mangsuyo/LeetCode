import java.util.*;

class Solution {
	// class Fair {
	// 	int first;
	// 	char second;
	//
	// 	public Fair(int first, char second) {
	// 		this.first = first;
	// 		this.second = second;
	// 	}
	//
	// 	@Override
	// 	public String toString() {
	// 		return "Fair{" +
	// 			"first=" + first +
	// 			", second=" + second +
	// 			'}';
	// 	}
	// }

	public boolean isBipartite(int[][] graph) {
		char[] chars = new char[graph.length];
		Arrays.fill(chars, 'N');

		for(int i = 0 ; i < graph.length; i++){
			if(chars[i] == 'N') {
				if(!dfs(i, graph, chars, 'A')) return false;
			}
		}

		for(int i = 0; i < chars.length; i++){
			System.out.println(chars[i]);
		}

		return true;
	}

	boolean dfs(int index, int[][] graph, char[] chars, char ch) {
		chars[index] = ch;
		for (int key : graph[index]) {
			if (chars[key] == 'N') {
					if (!dfs(key, graph, chars, ch == 'A' ? 'B' : 'A'))
						return false;
			} else if(chars[key] == ch) {
				return false;
			}
		}
		return true;
	}

}
