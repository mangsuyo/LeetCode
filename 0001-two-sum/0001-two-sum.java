import java.util.*;

class Solution {

	public int[] twoSum(int[] nums, int target) {
		int[][] numsAndIndexes = new int[nums.length][2];

		for(int i = 0; i < nums.length; i++) {
			numsAndIndexes[i][0] = nums[i];
			numsAndIndexes[i][1] = i;
		}

		Arrays.sort(numsAndIndexes, (a, b) -> Integer.compare(a[0], b[0]));

		return findTwoNumbers(numsAndIndexes, target);
	}

	private int[] findTwoNumbers(int[][] nums, int target) {
		int left = 0;
		int right = nums.length - 1;

		while (left < right) {
			int sum = nums[left][0] + nums[right][0];
			if (sum < target) {
				left += 1;
			}
			else if (sum > target) {
				right -= 1;
			}
			else{
				return new int[]{nums[left][1], nums[right][1]};
			}
		}
		return new int[0];
	}
}
