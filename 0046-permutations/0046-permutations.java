class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> answer = new ArrayList<>();
        backtrack(nums, new ArrayList<>(), answer);
        return answer;
    }

    void backtrack(int[] nums, List<Integer> list, List<List<Integer>> answer){
        if(list.size() == nums.length){
            answer.add(new ArrayList<>(list));
        }

        for(int i = 0; i < nums.length; i++){
            if(!list.contains(nums[i])){
                list.add(nums[i]);
                backtrack(nums, list, answer);
                list.remove(list.size() - 1);
            }
        }
    }
}