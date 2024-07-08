import java.util.*;

class Solution {
	public List<List<Integer>> permute(int[] nums) {
		List<List<Integer>> answer = new ArrayList<>();
		backtracking(nums, new ArrayList<>(), answer);
		return answer;
	}

	private void backtracking(int[] nums, List<Integer> list, List<List<Integer>> answer){
		if(list.size() == nums.length){
			answer.add(new ArrayList<>(list));
			return;
		}

		for(int num : nums){
			if(!list.contains(num)) {
				list.add(num);
				backtracking(nums, list, answer);
				list.remove(list.size() - 1);
			}
		}
	}


}
