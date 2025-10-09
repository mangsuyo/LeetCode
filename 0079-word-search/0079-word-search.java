import java.util.*;

class Solution {

    int m;
    int n;
    int[] dr = new int[]{-1, 1, 0, 0};
    int[] dc = new int[]{0, 0, -1, 1};

    boolean[][] visited;

    public boolean exist(char[][] board, String word) {
        m = board.length;
        n = board[0].length;
        visited = new boolean[m][n];
        
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(board[i][j] == word.charAt(0)){
                    visited[i][j] = true;
                    if(dfs(i, j, board, word, 1)) return true;
                    visited[i][j] = false;
                }
            }
        }
        
        return false;
    }

    boolean dfs(int x, int y, char[][] board, String word, int count){
        if(count == word.length()) return true;

        for(int i = 0; i < 4; i++){
            int nextR = dr[i] + x;
            int nextC = dc[i] + y;

            if(0 <= nextR && nextR < m && 0 <= nextC && nextC < n){
                if(!visited[nextR][nextC] && board[nextR][nextC] == word.charAt(count)){
                    visited[nextR][nextC] = true;
                    if(dfs(nextR, nextC, board, word, count + 1)) return true;;
                    visited[nextR][nextC] = false;
                }
            }
        }

        return false;
    }
}