class Solution {
    int n;
    public int[] twoSum(int[] nums, int target) {
        this.n = nums.length;
        Map<Integer, Integer> hash = new HashMap<>();

        for(int i = 0; i < n; i++){
            hash.put(nums[i], i);
        }

        for(int i = 0; i < n; i++){
            int key = target - nums[i];
            
            if(hash.containsKey(key) && hash.get(key) != i){
                return new int[]{i, hash.get(target-nums[i])};
            }
        }

        return new int[]{};
    }
}