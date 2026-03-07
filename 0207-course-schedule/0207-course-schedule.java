class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int n = numCourses;
        Map<Integer, List<Integer>> graph = new HashMap<>();
        int[] indegree = new int[n];

        for(int i = 0; i < prerequisites.length; i++){
            int[] cur = prerequisites[i];
            graph.putIfAbsent(cur[1], new ArrayList<>());
            graph.get(cur[1]).add(cur[0]);
            indegree[cur[0]] += 1;
        }

        int[] order = new int[n];
        int count = 0;
        Queue<Integer> queue = new ArrayDeque<>();
        for(int i = 0; i < n; i++){
            if(indegree[i] == 0){
                queue.offer(i);
                order[count++] = i;
            }
        }


        while(!queue.isEmpty()){
            int cur = queue.poll();
            if(graph.containsKey(cur)){
                for(int nextNode: graph.get(cur)){
                    indegree[nextNode]--;
                    if(indegree[nextNode] == 0){
                        queue.offer(nextNode);
                        order[count++] = nextNode;
                    }
                }
            }
        }

        return count == n;
    }
}