class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        int[] indegree = new int[numCourses];
        int count = 0;

        for(int[] p: prerequisites){
            graph.putIfAbsent(p[1], new ArrayList<>());
            graph.get(p[1]).add(p[0]);
            indegree[p[0]] += 1;
        }

        Queue<Integer> queue = new ArrayDeque<>();
        for(int i = 0; i < numCourses; i++){
            if(indegree[i] == 0){
                queue.offer(i);
                count += 1;
            }
        }

        while(!queue.isEmpty()){
            int curNode = queue.poll();
            if(graph.containsKey(curNode)){
                for(int nextNode: graph.get(curNode)){
                    indegree[nextNode] -= 1;
                    if(indegree[nextNode] == 0){
                        queue.offer(nextNode);
                        count += 1;
                    }
                }
            }
        }

        return count == numCourses;
    }
}