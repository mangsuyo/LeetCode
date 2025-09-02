class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        Map<Integer, List<int[]>> graph = new HashMap<>();
        for(int[] time: times){
            graph.putIfAbsent(time[0], new ArrayList<>());
            graph.get(time[0]).add(new int[]{time[1], time[2]});
        }

        int[] dists = new int[n + 1];
        Arrays.fill(dists, Integer.MAX_VALUE);
        dists[k] = 0;

        Queue<int[]> queue = new PriorityQueue<>((e1, e2) -> e1[1] - e2[1]);
        queue.offer(new int[]{k, 0});

        int count = 1;

        while(!queue.isEmpty()){
            int[] cur = queue.poll();
            int curNode = cur[0];
            int curDist = cur[1];

            if(dists[curNode] < curDist) continue;

            if(graph.containsKey(curNode)){
                for(int[] next: graph.get(curNode)){
                    if(dists[next[0]] == Integer.MAX_VALUE) count += 1;
                    int nextDist = dists[curNode] + next[1];
                    if(nextDist < dists[next[0]]){
                        queue.offer(new int[]{next[0], nextDist});
                        dists[next[0]] = nextDist;
                    }
                }
            }
        }

        if(count != n) return -1;
        
        int maxTime = 0;
        for(int i = 1; i < dists.length; i++){
            if(maxTime < dists[i]) maxTime = dists[i];
        }

        return maxTime;
    }
}