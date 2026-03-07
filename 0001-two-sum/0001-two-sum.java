class Solution {
    int n;
    public int[] twoSum(int[] nums, int target) {
        this.n = nums.length;
        Map<Integer, Integer> hash = new HashMap<>();
        for(int i = 0; i < n; i++){
            int key = target - nums[i];
            
            if(hash.containsKey(key)){
                return new int[]{hash.get(target-nums[i]), i};
            }

            hash.put(nums[i], i);
        }

        return new int[]{};
    }
}