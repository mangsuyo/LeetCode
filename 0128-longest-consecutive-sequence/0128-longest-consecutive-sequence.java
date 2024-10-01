import java.util.*;

class Solution {
	public int longestConsecutive(int[] nums) {
		Map<Integer, Integer> map = new HashMap<>();

		for (int i = 0; i < nums.length; i++) {
			map.put(nums[i], i);
		}

		int maxLen = 0;
		int curLen = 0;

		for (int i = 0; i < nums.length; i++) {
			int frontNumber = nums[i] - 1;
			int backNumber = nums[i] + 1;
			if (!map.containsKey(frontNumber)) {
				curLen = 1;
				while (map.containsKey(backNumber)) {
					curLen += 1;
					backNumber += 1;
				}
				if (maxLen < curLen) {
					maxLen = curLen;
				}
			}
		}

		return maxLen;
	}
}
