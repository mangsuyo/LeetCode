class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> hash = new HashSet<>();
        int maxCount = 0;

        for(int i = 0; i < nums.length; i++){
            hash.add(nums[i]);
        }

        for(int num: hash){
            int nextNum = num + 1;
            int beforeNum = num - 1;
            int count = 1;

            if(!hash.contains(beforeNum)){
                while(hash.contains(nextNum)){
                    nextNum += 1;
                    count++;
                }
            }
            maxCount = Math.max(maxCount, count);
        }

        return maxCount;
    }
}