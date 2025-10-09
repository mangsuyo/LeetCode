class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> answer = new ArrayList<>();
        backtrack(nums, 0, new ArrayList<>(), answer);
        return answer;
    }

    void backtrack(int[] nums, int start, List<Integer> list, List<List<Integer>> answer){

        answer.add(new ArrayList<>(list));

        for(int i = start; i < nums.length; i++){
            list.add(nums[i]);
            backtrack(nums, i + 1, list, answer);
            list.remove(list.size() - 1);
        }
    }
}