class Solution {
    public double maxProbability(int n, int[][] edges, double[] succProb, int start_node, int end_node) {
        Map<Integer, List<double[]>> graph = new HashMap<>();

        for(int i = 0; i < edges.length; i++){
            graph.putIfAbsent(edges[i][0], new ArrayList<>());
            graph.putIfAbsent(edges[i][1], new ArrayList<>());
            graph.get(edges[i][0]).add(new double[]{edges[i][1], succProb[i]});
            graph.get(edges[i][1]).add(new double[]{edges[i][0], succProb[i]});

        }

        double[] dists = new double[n];
        Arrays.fill(dists, -1.0);

        Queue<double[]> queue = new PriorityQueue<>((a, b) -> Double.compare(b[1], a[1]));
        queue.offer(new double[]{start_node, 1.0});
        dists[start_node] = 1;

        int count = 1;


        while(!queue.isEmpty()){
            double[] cur = queue.poll();
            if(cur[1] < dists[(int)cur[0]]) continue;
            if(graph.containsKey((int) cur[0])){
                for(double[] nextNode: graph.get((int) cur[0])){
                    if(dists[(int) nextNode[0]] == -1.0) count += 1;
                    double nextDist = dists[(int) cur[0]] * nextNode[1];
                    if(nextDist <= dists[(int) nextNode[0]]) continue;
                    dists[(int) nextNode[0]] = nextDist;
                    queue.offer(new double[]{nextNode[0], nextDist});
                }
            }
        }

        for(int i = 0; i < n; i++){
            System.out.println(dists[i]);
        }

        return dists[end_node] == -1 ? 0 : dists[end_node];
    }
}