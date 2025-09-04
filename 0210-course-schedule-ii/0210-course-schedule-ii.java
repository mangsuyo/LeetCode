class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        int[] indegree = new int[numCourses + 1];

        for(int[] p: prerequisites){
            graph.putIfAbsent(p[1], new ArrayList<>());
            graph.get(p[1]).add(p[0]);
            indegree[p[0]] += 1;
        }

        int[] visited = new int[numCourses];
        Queue<Integer> queue = new ArrayDeque<>();
        int count = 0;

        for(int i = 0; i < numCourses; i++){
            if(indegree[i] == 0){
                queue.offer(i);
                visited[count++] = i;
            }
        }

        while(!queue.isEmpty()){
            int curNode = queue.poll();
            if(graph.containsKey(curNode)){
                for(int nextNode: graph.get(curNode)){
                    indegree[nextNode]--;
                    if(indegree[nextNode] == 0){
                        queue.offer(nextNode);
                        visited[count++] = nextNode;
                    }
                }
            }
        }

        return count == numCourses? visited : new int[]{};
    }
}