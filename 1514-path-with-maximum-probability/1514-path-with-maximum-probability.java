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
        Arrays.fill(dists, 0);
        dists[start_node] = 1;

        Queue<double[]> queue = new PriorityQueue<>((n1, n2) -> Double.compare(n2[1], n1[1]));
        queue.offer(new double[]{start_node, 1});

        while(!queue.isEmpty()){
            double[] cur = queue.poll();
            int curNode = (int)cur[0];
            double curDist = cur[1];

            if(curDist < dists[curNode]) continue;

            if(graph.containsKey(curNode)){
                for(double[] next: graph.get(curNode)){
                    int nextNode = (int)next[0];
                    double nextDist = next[1] * curDist;
                    if(dists[nextNode] < nextDist){
                        queue.offer(new double[]{nextNode, nextDist});
                        dists[nextNode] = nextDist;
                    }
                }
            }

        }
        return dists[end_node];
    }
}