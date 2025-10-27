class Solution {
    int n;

    public boolean isBipartite(int[][] graph) {
        this.n = graph.length;
        int[] nodes = new int[n];
        Arrays.fill(nodes, -1);

        for(int i = 0; i < n; i++){
            if(nodes[i] == -1){
                Queue<Integer> queue = new ArrayDeque<>();
                queue.offer(i);
                nodes[i] = 0;
                while(!queue.isEmpty()){
                    int node = queue.poll();
                    int nextNum = nodes[node] == 0 ? 1 : 0;
                    for(int nextNode: graph[node]){
                        if(nodes[nextNode] == -1){
                            queue.offer(nextNode);
                            nodes[nextNode] = nextNum;
                        }
                        else{
                            if(nodes[nextNode] == nodes[node]) return false;
                        }
                    }
                }
            }
        }
        return true;
    }
}