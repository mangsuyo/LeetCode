class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        int[] indegree = new int[numCourses];

        for(int[] p: prerequisites){
            map.putIfAbsent(p[1], new ArrayList<>());
            map.get(p[1]).add(p[0]);
            indegree[p[0]]++;
        }

        Queue<Integer> queue = new ArrayDeque<>();
        int count = 0;

        for(int i = 0; i < numCourses; i++){
            if(indegree[i] == 0){
                queue.offer(i);
                count++;
            }
        }

        while(!queue.isEmpty()){
            int curNode = queue.poll();
            if(map.containsKey(curNode)){
                for(int nextNode: map.get(curNode)){
                    indegree[nextNode]--;
                    if(indegree[nextNode] == 0) {
                        count += 1;
                        queue.offer(nextNode);
                    }    
                }
            }
        }

        return count == numCourses;
    }
}