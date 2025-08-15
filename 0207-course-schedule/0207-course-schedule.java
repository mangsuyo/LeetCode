class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> edges = new HashMap<>();
        int[] indegree = new int[numCourses];

        for(int[] prerequisite: prerequisites){
            edges.putIfAbsent(prerequisite[1], new ArrayList<>());
            edges.get(prerequisite[1]).add(prerequisite[0]);
            indegree[prerequisite[0]]++;
        }

        Queue<Integer> queue = new ArrayDeque<>();
        int count = 0;

        for(int i = 0; i < numCourses; i++){
            if(indegree[i] == 0){
                queue.add(i);
                count++;
            }
        }

        while(!queue.isEmpty()){
            int curV = queue.poll();
            if(edges.containsKey(curV)){
                for(int next: edges.get(curV)){
                    indegree[next]--;
                    if(indegree[next] == 0){
                        count++;
                        queue.add(next);
                    }
                }
            }
        }
        
        return count == numCourses;


    }
}