import java.util.*;

class Solution {
	public int longestValidParentheses(String s) {
		int answer = 0;

		int[] result = new int[s.length()];

		int count = 0;
		Deque<List<String>> stack = new ArrayDeque<>();

		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == ')') {
				if (!stack.isEmpty() && stack.peek().get(1).equals(")")) {
					List<String> info = stack.pop();
					int index = Integer.parseInt(info.get(0));
					result[i] = 1;
					result[index] = 1;
				} else {
					result[i] = -1;
				}
			} else {
				stack.push(List.of(String.valueOf(i), ")"));
			}
		}

		while(!stack.isEmpty()) {
			List<String> info = stack.pop();
			int index = Integer.parseInt(info.get(0));
			result[index] = -1;
		}


		for(int i =0; i < result.length; i++){
			if(result[i] == -1){
				count = 0;
			}
			else{
				count += 1;
				if(answer < count) answer = count;
			}
		}

		return answer;
	}
}
