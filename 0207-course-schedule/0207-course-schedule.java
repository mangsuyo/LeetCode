class Solution {
    int n;
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        this.n = numCourses;
        Map<Integer, List<Integer>> graph = new HashMap<>();
        int[] indegree = new int[n];
        
        for(int[] p: prerequisites){
            graph.putIfAbsent(p[1], new ArrayList<>());
            graph.get(p[1]).add(p[0]);
            indegree[p[0]] += 1;
        }

        Queue<Integer> queue = new ArrayDeque<>();
        int count = 0;
        for(int i = 0; i < n; i++){
            if(indegree[i] == 0){
                queue.offer(i);
                count += 1;
            }
        }

        while(!queue.isEmpty()){
            int curNode = queue.poll();
            if(graph.containsKey(curNode)){
                for(int nextNode: graph.get(curNode)){
                    indegree[nextNode]--;
                    if(indegree[nextNode] == 0){
                        queue.offer(nextNode);
                        count += 1;
                    }
                }
            }
        }

        return count == n;
    }
}