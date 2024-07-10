import java.util.*;

class Solution {

	String answer;
	int count = 0;
	boolean[] visitied;

	public String getPermutation(int n, int k) {
		visitied = new boolean[n + 1];
		backtracking(n, k, new ArrayList<>());
		return answer;
	}

	private void backtracking(int n, int k, List<String> list) {

		if(list.size() == n){
			count += 1;
			if(count == k){
				answer = String.join("", list);
			}
		}

		if(count > k){
			return;
		}

		for(int i = 1; i <= n; i++){
			if(!visitied[i]) {
				list.add(String.valueOf(i));
				visitied[i] = true;
				backtracking(n, k, list);
				visitied[i] = false;
				list.remove(list.size() - 1);
			}
		}
	}
}
