import java.util.*;

class Solution {

	String answer;
	int count = 0;
	boolean[] visitied;

	public String getPermutation(int n, int k) {
		visitied = new boolean[n + 1];
		String result = backtracking(n, k, new ArrayList<>());
		if(!result.isEmpty()){
			return result;
		}
		return "NO";
	}

	private String backtracking(int n, int k, List<String> list) {

		if(list.size() == n){
			count += 1;
			if(count == k){
				return String.join("", list);
			}
		}

		if(count > k){
			return null;
		}



		for(int i = 1; i <= n; i++){
			if(!visitied[i]) {
				list.add(String.valueOf(i));
				visitied[i] = true;
				String result = backtracking(n, k, list);
				if(result != null){
					return result;
				}
				visitied[i] = false;
				list.remove(list.size() - 1);
			}
		}

		return null;
	}
}
