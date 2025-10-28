class Solution {
    int n;

    boolean[][] visited;
    int[] dr = new int[]{-1, -1, 0, 1, 1, 1, 0, -1};
    int[] dc = new int[]{0, 1, 1, 1, 0, -1, -1, -1};

    public int shortestPathBinaryMatrix(int[][] grid) {
        this.n = grid.length;
        if(grid[0][0] == 1 || grid[n - 1][n - 1] == 1) return -1;
        if(n == 1) return 1;

        visited = new boolean[n][n];
        Queue<Pair> queue = new ArrayDeque<>();
        
        queue.offer(new Pair(0, 0, 1));
        visited[0][0] = true;

        while(!queue.isEmpty()){
            Pair cur = queue.poll();
            for(int i = 0; i < 8; i++){
                int nextR = cur.r + dr[i];
                int nextC = cur.c + dc[i];
                if(nextR == n - 1 && nextC == n - 1 && grid[nextR][nextC] == 0) return cur.count + 1;
                if(0 <= nextR && nextR < n && 0 <= nextC && nextC < n){
                    if(!visited[nextR][nextC] && grid[nextR][nextC] == 0){
                        queue.offer(new Pair(nextR, nextC, cur.count + 1));
                        visited[nextR][nextC] = true;
                    }
                }
            }
        }

        return -1;
    }


    class Pair{
        int r;
        int c;
        int count;

        public Pair(int r, int c, int count){
            this.r = r;
            this.c = c;
            this.count = count;
        }
    }
}