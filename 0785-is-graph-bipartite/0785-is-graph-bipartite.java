class Solution {
    int n;
    public boolean isBipartite(int[][] graph) {
        this.n = graph.length;
        char[] nodes = new char[n];

        Arrays.fill(nodes, '.');

        for(int i = 0; i < n; i++){
            if(nodes[i] == '.'){
                Queue<Integer> queue = new ArrayDeque<>();
                queue.offer(i);
                nodes[i] = 'A';
                while(!queue.isEmpty()){
                    int curNode = queue.poll();
                    char nextCh = nodes[curNode] == 'A' ? 'B' : 'A'; 
                    for(int nextNode: graph[curNode]){
                        if(nodes[nextNode] == '.'){
                            queue.offer(nextNode);
                            nodes[nextNode] = nextCh;
                        }
                        else if(nodes[nextNode] == nodes[curNode]) return false;
                    }
                }
            }
        }


        return true;
    }

    boolean dfs(int[][] graph, char[] nodes, char ch, int node){
        nodes[node] = ch;
        char nextCh = ch == 'A' ? 'B' : 'A';
        for(int nextNode: graph[node]){
            if(nodes[nextNode] == '.'){
                if(!dfs(graph, nodes, nextCh, nextNode)) return false;
            }
            else if(nodes[nextNode] == ch) return false;
        }

        return true;
    }
}