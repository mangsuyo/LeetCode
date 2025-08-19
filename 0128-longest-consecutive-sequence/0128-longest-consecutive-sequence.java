class Solution {
    public int longestConsecutive(int[] nums) {
        Map<Integer, Boolean> hash = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            hash.put(nums[i], false);
        }
        
        int maxCount = 0;
            
        for(int num: hash.keySet()){
            int beforeNum = num - 1;
            int afterNum = num + 1;
            if(!hash.containsKey(beforeNum)){
                int count = 1;
                while(hash.containsKey(afterNum)){
                    afterNum += 1;
                    count += 1;
                }
                if(count > maxCount) maxCount = count;
            }
        }
            
        
        return maxCount;
    }
}
