class Solution {

    int n;
    int m;
    boolean[][] visited;

    int[] dr = new int[]{-1, 1, 0, 0};
    int[] dc = new int[]{0, 0, -1, 1};

    public int numIslands(char[][] grid) {
        this.n = grid.length;
        this.m = grid[0].length;
        visited = new boolean[n][m];
        int count = 0;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                char c = grid[i][j];
                if(!visited[i][j] && c == '1'){
                    bfs(grid, i, j);
                    count += 1;
                }
            }
        }
        return count;
    }

    void bfs(char[][] grid, int r, int c){
        Queue<Pair> queue = new ArrayDeque<>();
        queue.offer(new Pair(r, c));
        visited[r][c] = true;

        while(!queue.isEmpty()){
            Pair cur = queue.poll();
            for(int i = 0; i < 4; i++){
                int nextR = cur.r + dr[i];
                int nextC = cur.c + dc[i];
                if(0 <= nextR && nextR < n && 0 <= nextC && nextC < m){
                    if(!visited[nextR][nextC] && grid[nextR][nextC] == '1'){
                        queue.offer(new Pair(nextR, nextC));
                        visited[nextR][nextC] = true;
                    }
                }
            }
        }
    }
}

class Pair{
    int r;
    int c;
    
    public Pair(int r, int c){
        this.r = r;
        this.c = c;
    }
}