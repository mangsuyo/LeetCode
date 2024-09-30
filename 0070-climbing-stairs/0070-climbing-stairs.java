import java.util.*;

class Solution {
	public int climbStairs(int n) {
		int[] answer = new int[n + 1];
		Arrays.fill(answer, -1);
		return dp(answer, n);
	}

	public int dp(int[] answer, int stair) {
		if (stair == 1) {
			return 1;
		} else if (stair == 2) {
			return 2;
		}

		if (answer[stair] == -1) {
			answer[stair] = dp(answer, stair - 1) + dp(answer, stair - 2);
		}
		return answer[stair];
	}
}
