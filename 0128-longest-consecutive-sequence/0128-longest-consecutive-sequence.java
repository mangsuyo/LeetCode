class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for(int num: nums){
            set.add(num);
        }
        int answer = 0;
        for(int num: set){
            if(set.contains(num - 1)) continue;
            int count = 1;
            int curValue = num + 1;
            while(set.contains(curValue)){
                count++;
                curValue++;
            }
            answer = Math.max(answer, count);
        }

        return answer;
    }
}