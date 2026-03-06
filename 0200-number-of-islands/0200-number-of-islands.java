class Solution {
    int n, m;
    boolean[][] visited;
    int[] dr = new int[]{-1, 1, 0, 0};
    int[] dc = new int[]{0, 0, -1, 1};

    public int numIslands(char[][] grid) {
        this.n = grid.length;
        this.m = grid[0].length;
        visited = new boolean[n][m];

        int answer = 0;

        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(grid[i][j] == '1' && !visited[i][j]){
                    dfs(grid, i, j);
                    answer += 1;
                }
            }
        }

        return answer;
    }

    void dfs(char[][] grid, int r, int c){
        if(r >= n || r < 0 || c >= m || c < 0) return;
        if(visited[r][c]) return;
        if(grid[r][c] == '0') return;

        visited[r][c] = true;
        for(int i = 0; i < 4; i++){
            int nextR = dr[i] + r;
            int nextC = dc[i] + c;
            dfs(grid, nextR, nextC);
        }
    }

    void bfs(char[][] grid, int r, int c){
        visited[r][c] = true;
        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[]{r, c});

        while(!queue.isEmpty()){
            int[] cur = queue.poll();
            for(int i = 0; i < 4; i++){
                int nextR = cur[0] + dr[i];
                int nextC = cur[1] + dc[i];
                if(0 <= nextR && nextR < n && 0 <= nextC && nextC < m){
                    if(!visited[nextR][nextC] && grid[nextR][nextC] == '1'){
                        queue.offer(new int[]{nextR, nextC});
                        visited[nextR][nextC] = true;
                    }
                }
            }
        }
    }
}