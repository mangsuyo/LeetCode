import java.util.*;

class Solution {

	public int[] dailyTemperatures(int[] temperatures) {
		Deque<List<Integer>> stack = new ArrayDeque<>();

		int[] answer = new int[temperatures.length];

		for(int i = 0; i < temperatures.length; i++){
			int temperature = temperatures[i];
			while(!stack.isEmpty() && stack.peek().get(0) < temperature){
				List<Integer> temperatureInfo = stack.pop();
				answer[temperatureInfo.get(1)] = i - temperatureInfo.get(1);
			}
			stack.push(Arrays.asList(temperature, i));
		}
		return answer;
	}
}
