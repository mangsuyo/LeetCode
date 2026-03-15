class Solution {
    int n;
    public boolean isBipartite(int[][] graph) {
        Queue<Node> queue = new ArrayDeque<>();
        this.n = graph.length;
        int[] flags = new int[n + 1];
        boolean[] visited = new boolean[n + 1];

        
        for(int i = 0; i < n ; i++){
            if(!visited[i]){
                queue.offer(new Node(i, 1));
                visited[i] = true;
                while(!queue.isEmpty()){
                    Node cur = queue.poll();
                    for(int next: graph[cur.number]){
                        if(flags[next] == cur.flag){
                            return false;
                        }
                        if(!visited[next]){
                            if(cur.flag == 1){
                                queue.offer(new Node(next, 2));
                                visited[next] = true;
                                flags[next] = 2;
                            }
                            else{
                                queue.offer(new Node(next, 1));
                                visited[next] = true;
                                flags[next] = 1;
                            }
                        }
                    }
                }
            }
        }


        return true;
    }

    class Node{
        int number;
        int flag;

        Node(int number, int flag){
            this.number = number;
            this.flag = flag;
        }
        
    }
}