class Solution {
    int n;

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        this.n = numCourses;

        int[] indegree = new int[n];
        Map<Integer, List<Integer>> graph = new HashMap<>();

        for(int[] p: prerequisites){
            graph.putIfAbsent(p[1], new ArrayList<>());
            graph.get(p[1]).add(p[0]);
            indegree[p[0]] += 1;
        }
        List<Integer> list = new ArrayList<>();

        Queue<Integer> queue = new ArrayDeque<>();

        for(int i = 0; i < n; i++){
            if(indegree[i] == 0){
                queue.offer(i);
                list.add(i);
            }
        }

        while(!queue.isEmpty()){
            int curNode = queue.poll();
            if(graph.containsKey(curNode)){
                for(int nextNode: graph.get(curNode)){
                    indegree[nextNode]--;
                    if(indegree[nextNode] == 0){
                        queue.offer(nextNode);
                        list.add(nextNode);
                    }
                }
            }
        }
        if(list.size() != n) return new int[]{};

        int[] answer = new int[n];
        for(int i = 0; i < n; i++){
            answer[i] = list.get(i);
        }

        return answer;
    }
}