import java.util.*;

class Solution {
	public int trap(int[] height) {

		Deque<List<Integer>> stack = new ArrayDeque<>();
		int[] graph = new int[height.length];


		for(int i = 0; i < height.length; i++){
			graph[i] = height[i];
		}

		int water = 0;

		int firstIdx = 0;

		for (int i = 0; i < height.length; i++) {
			if (height[i] > 0) {
				firstIdx = i;
				break;
			}
		}

		for (int i = firstIdx; i < height.length; i++) {
			while (!stack.isEmpty() && height[i] >= stack.peek().get(1)) {
				List<Integer> info = stack.pop();
				for(int j = info.get(0) + 1; j < i; j++){
					graph[j] = info.get(1);
				}
			}
			stack.push(List.of(i, height[i]));
		}

		while(!stack.isEmpty()){
			List<Integer> wall1 = stack.pop();
			if(!stack.isEmpty()){
				for(int j = stack.peek().get(0) + 1; j < wall1.get(0); j++){
					graph[j] = wall1.get(1);
				}
			}

		}

		for(int i = firstIdx; i < height.length; i++){
			water += graph[i] - height[i];
		}

		return water;
	}
}
