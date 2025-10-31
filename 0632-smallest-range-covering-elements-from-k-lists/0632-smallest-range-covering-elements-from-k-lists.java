class Solution {
    public int[] smallestRange(List<List<Integer>> nums) {
        Queue<int[]> pq = new PriorityQueue<>((e1, e2) -> e1[0] - e2[0]);
        int maxVal = -100000;

        for(int i = 0; i < nums.size(); i++){
            int firstVal = nums.get(i).get(0);
            pq.add(new int[]{firstVal, i, 0});
            maxVal = Math.max(maxVal, firstVal);
        }

        int start = pq.peek()[0];
        int end = maxVal;
        int minRange = end - start;

        while(true){
            int[] min = pq.remove();
            int minVal = min[0];
            int listIdx = min[1];
            int idx = min[2];

            if(maxVal - minVal < minRange){
                minRange = maxVal - minVal;
                start = minVal;
                end = maxVal;
            }


            if(idx == nums.get(listIdx).size() - 1){
                break;
            }

            int nextIdx = idx + 1;
            int nextVal = nums.get(listIdx).get(nextIdx);

            pq.add(new int[]{nextVal, listIdx, nextIdx});
            maxVal = Math.max(maxVal, nextVal);
        }

        return new int[]{start, end};
    }
}