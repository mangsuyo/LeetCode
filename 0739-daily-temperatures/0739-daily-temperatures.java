import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;

class Solution {
	public int[] dailyTemperatures(int[] temperatures) {
		Deque<List<Integer>> stack = new ArrayDeque<>();
		int[] answer = new int[temperatures.length];

		for (int i = 0; i < temperatures.length; i++) {
			int temperature = temperatures[i];
			while((!stack.isEmpty()) && (stack.peek().get(1) < temperature)){
				List<Integer> item = stack.pop();
				answer[item.get(0)] = i - item.get(0);
			}
			stack.push(List.of(i, temperature));
		}
		
		return answer;
	}
}
