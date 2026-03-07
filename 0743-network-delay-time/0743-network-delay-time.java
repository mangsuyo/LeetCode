class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {        
        Map<Integer, List<int[]>> graph = new HashMap<>();
        for(int i = 0; i < times.length; i++){
            int[] time = times[i];
            graph.putIfAbsent(time[0], new ArrayList<>());
            graph.get(time[0]).add(new int[]{time[1], time[2]});
        }

        int[] dists = new int[n + 1];
        Arrays.fill(dists, Integer.MAX_VALUE);
        dists[k] = 0;

        Queue<int[]> pq = new PriorityQueue<>((e1, e2) -> e1[1] - e2[1]);
        pq.offer(new int[]{k, 0});

        while(!pq.isEmpty()){
            int[] cur = pq.poll();
            if(dists[cur[0]] < cur[1]) continue;
            if(!graph.containsKey(cur[0])) continue;
            for(int[] next: graph.get(cur[0])){
                int nextNode = next[0];
                int nextDist = next[1] + cur[1];
                if(dists[nextNode] > nextDist){
                    pq.offer(new int[]{nextNode, nextDist});
                    dists[nextNode] = nextDist;
                }
            }
        }


        int answer = 0;
        for(int i = 1; i <= n; i++){
            if(dists[i] > answer) answer = dists[i];
        }  

        if(answer == Integer.MAX_VALUE) return -1;

        return answer; 
    }
}