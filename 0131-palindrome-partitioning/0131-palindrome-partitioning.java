import java.util.*;

class Solution{

	public List<List<String>> partition(String s){
		List<List<String>> answer = new ArrayList<>();

		backtrack(0, answer, s, new ArrayList<>());

		return answer;
	}

	private void backtrack(int start, List<List<String>> answer, String s, List<String> list){

		if(start == s.length()){
			answer.add(new ArrayList<>(list));
			return;
		}

		for(int i = start + 1; i <= s.length(); i++){
			String subStr = s.substring(start, i);
			if(isPalindrome(subStr)) {
				list.add(subStr);
				backtrack(i, answer, s, list);
				list.remove(list.size() - 1);
			}
		}

	}

	private boolean isPalindrome(String s){
		return s.equals((new StringBuilder(s)).reverse().toString());
	}

}
