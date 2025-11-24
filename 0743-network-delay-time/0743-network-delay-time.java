class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        Map<Integer, List<int[]>> graph = new HashMap<>();
        for(int[] time: times){
            graph.putIfAbsent(time[0], new ArrayList<>());
            graph.get(time[0]).add(new int[]{time[1], time[2]});
        }

        int[] dists = new int[n + 1];
        Arrays.fill(dists, Integer.MAX_VALUE);

        Queue<int[]> queue = new PriorityQueue<>((p1, p2) -> p1[1] - p2[1]);
        queue.offer(new int[]{k, 0});
        dists[k] = 0;

        int count = 1;

        while(!queue.isEmpty()){
            int[] cur = queue.poll();
            int curNode = cur[0];
            int curDist = cur[1];
            if(curDist > dists[curNode]) continue;

            if(graph.containsKey(curNode)){
                for(int[] next: graph.get(curNode)){
                    int nextNode = next[0];
                    int nextDist = next[1] + curDist;
                    if(dists[nextNode] == Integer.MAX_VALUE){
                        count += 1;
                    }
                    if(nextDist < dists[nextNode]){
                        dists[nextNode] = nextDist;
                        queue.offer(new int[]{nextNode, nextDist});
                    }
                }
            }
        }   

        int answer = 0;
        for(int i = 1; i <= n; i++){
            answer = Math.max(answer, dists[i]);
        }

        return count == n ? answer : -1;
    }
}