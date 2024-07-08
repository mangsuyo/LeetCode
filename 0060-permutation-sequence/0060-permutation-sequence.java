import java.util.*;

class Solution {

	public String getPermutation(int n, int k) {
		List<List<String>> answer = new ArrayList<>();
		boolean[] visited = new boolean[n + 1];
		return backtracking(n, k, new ArrayList<>(), answer, visited);
	}

	private String backtracking(int n, int k, List<String> list, List<List<String>> answer, boolean[] visited) {
		if (list.size() == n) {
			answer.add(new ArrayList<>(list));
			if(answer.size() == k){
				return String.join("", answer.get(answer.size() - 1));
			}
			return null;
		}

		for (int i = 1; i <= n; i++) {
			if (!visited[i]) {
				list.add(String.valueOf(i));
				visited[i] = true;
				String result = backtracking(n, k, list, answer, visited);
				if(result != null){
					return result;
				}
				visited[i] = false;
				list.remove(list.size() - 1);
			}
		}
		
		return null;
	}
}