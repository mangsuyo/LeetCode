class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        Map<Integer, List<int[]>> edges = new HashMap<>();
        for (int[] time : times) {
            edges.putIfAbsent(time[0], new ArrayList<>());
            edges.get(time[0]).add(new int[]{time[1], time[2]});
        }

        int[] dist = new int[n + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[k] = 0;

        Queue<int[]> pq = new PriorityQueue<>((e1, e2) -> e1[1] - e2[1]);
        pq.add(new int[]{k, 0});

        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            int cur_v = cur[0];
            int cur_t = cur[1];

            if (cur_t > dist[cur_v]) continue;
            if (!edges.containsKey(cur_v)) continue;

            for (int[] edge : edges.get(cur_v)) {
                int next_v = edge[0];
                int next_t = edge[1];

                if (next_t + dist[cur_v] < dist[next_v]) {
                    dist[next_v] = next_t + dist[cur_v];
                    pq.add(new int[]{next_v, dist[next_v]});
                }
            }
        }

        int maxTime = 0;
        for (int i = 1; i <= n; i++) {
            if (dist[i] == Integer.MAX_VALUE) {
                return -1; 
            }
            maxTime = Math.max(maxTime, dist[i]);
        }
        
        return maxTime;
    }
}