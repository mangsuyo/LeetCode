import java.util.*;

class Solution {
	public int longestConsecutive(int[] nums) {
		int longest = 0;
		Map<Integer, Boolean> hash = new HashMap<>();
		for (int i = 0; i < nums.length; i++) {
			hash.put(nums[i], true);
		}

		for (int num : hash.keySet()) {
			if (!hash.containsKey(num - 1)) {
				int cnt = 1;
				int target = num + 1;
				while (hash.containsKey(target)) {
					target += 1;
					cnt += 1;
				}
				longest = Math.max(longest, cnt);
			}
		}

		return longest;
	}
}
