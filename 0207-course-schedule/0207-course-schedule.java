class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        int[] indegree = new int[numCourses];

        for(int[] prerequisite: prerequisites){
            graph.putIfAbsent(prerequisite[1], new ArrayList<>());
            graph.get(prerequisite[1]).add(prerequisite[0]);
            indegree[prerequisite[0]] += 1;
        }

        Queue<Integer> queue = new ArrayDeque<>();

        int count = 0;

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