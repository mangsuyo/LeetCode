import java.util.*;

class Solution {
    public int minimumDifference(int[] nums) {
        int n = nums.length / 2;
        int totalSum = 0;
        for (int num : nums) totalSum += num;

        List<List<Integer>> left = new ArrayList<>();
        List<List<Integer>> right = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            left.add(new ArrayList<>());
            right.add(new ArrayList<>());
        }

        makeSums(nums, 0, n, 0, 0, left);
        makeSums(nums, n, nums.length, 0, 0, right);

        for (int i = 0; i <= n; i++) {
            Collections.sort(right.get(i));
        }

        int answer = Integer.MAX_VALUE;

        for (int leftCount = 0; leftCount <= n; leftCount++) {
            int rightCount = n - leftCount;

            List<Integer> leftList = left.get(leftCount);
            List<Integer> rightList = right.get(rightCount);

            for (int leftSum : leftList) {
                int target = totalSum / 2 - leftSum;

                int idx = Collections.binarySearch(rightList, target);
                if (idx < 0) idx = -idx - 1;  // lowerBound처럼 쓰기

                if (idx < rightList.size()) {
                    int picked = leftSum + rightList.get(idx);
                    answer = Math.min(answer, Math.abs(totalSum - 2 * picked));
                }

                if (idx > 0) {
                    int picked = leftSum + rightList.get(idx - 1);
                    answer = Math.min(answer, Math.abs(totalSum - 2 * picked));
                }
            }
        }

        return answer;
    }

    void makeSums(int[] nums, int idx, int end, int count, int sum, List<List<Integer>> result) {
        if (idx == end) {
            result.get(count).add(sum);
            return;
        }

        makeSums(nums, idx + 1, end, count, sum, result);
        makeSums(nums, idx + 1, end, count + 1, sum + nums[idx], result);
    }
}