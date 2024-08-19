import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;

class Solution {
	public int[] twoSum(int[] nums, int target) {

		int[][] indexAndNumber = new int[nums.length][2];
		for (int i = 0; i < nums.length; i++) {
				indexAndNumber[i][0] = nums[i];
				indexAndNumber[i][1] = i;
		}

		Arrays.sort(indexAndNumber, (a, b) -> Integer.compare(a[0], b[0]));

		int left = 0;
		int right = nums.length - 1;

		while (left < right) {
			int sum = indexAndNumber[left][0] + indexAndNumber[right][0];
			if (sum < target) {
				left += 1;
			} else if (sum > target) {
				right -= 1;
			} else {
				return new int[] {indexAndNumber[left][1], indexAndNumber[right][1]};
			}
		}

		return new int[0];
	}
}
