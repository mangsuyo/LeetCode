class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        Map<Integer, List<int[]>> graph = new HashMap<>();

        for(int[] t: times){
            graph.putIfAbsent(t[0], new ArrayList<>());
            graph.get(t[0]).add(new int[]{t[1], t[2]});
        }

        int[] dists = new int[n + 1];
        Arrays.fill(dists, Integer.MAX_VALUE);
        dists[k] = 0;

        Queue<int[]> queue = new PriorityQueue<>((n1, n2) -> n1[1] - n2[1]);
        queue.offer(new int[]{k, 0});

        int count = 1;

        while(!queue.isEmpty()){
            int[] cur = queue.poll();
            int curNode = cur[0];
            int curDist = cur[1];
            if(dists[curNode] < curDist) continue;
            
            if(graph.containsKey(curNode)){
                for(int[] next: graph.get(curNode)){
                    int nextNode = next[0];
                    int nextDist = curDist + next[1];
                    if(dists[nextNode] == Integer.MAX_VALUE) count++;
                    if(dists[nextNode] > nextDist){
                        queue.offer(new int[]{nextNode, nextDist});
                        dists[nextNode] = nextDist;
                    }
                }
            }
        }

        if(count != n) return -1;

        int answer = 0;
        for(int i = 1; i <= n; i++){
            answer = Math.max(answer, dists[i]);
        }
        return answer;
    }
}