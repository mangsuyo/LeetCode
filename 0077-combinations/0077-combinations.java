import java.util.*;

public class Solution {
	public List<List<Integer>> combine(int n, int k) {
		List<List<Integer>> answer = new ArrayList<>();
		backtracking(1, n, k, new ArrayList<>(), answer);
		return answer;
	}

	private void backtracking(int start, int n, int k, List<Integer> list, List<List<Integer>> answer) {
		if(list.size() == k){
			answer.add(new ArrayList<>(list));
			return;
		}

		for(int i = start; i <= n; i++){
			System.out.println(list);
			list.add(i);
			backtracking(i + 1, n, k, list, answer);
			list.remove(list.size() - 1);
		}
	}
}
