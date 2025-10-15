class Solution {

    List<List<String>> answer; 
    public List<List<String>> solveNQueens(int n) {
        char[][] board = new char[n][n];
        answer = new ArrayList<>();
        for(int i = 0; i < n; i++){
            Arrays.fill(board[i], '.');
        }
        backtrack(board, n, 0);
        return answer;
    }

    void backtrack(char[][] board, int n, int row){
        if(row == n){
            List<String> list = new ArrayList<>();
            for(int i = 0; i < n; i++){
                list.add(new String(board[i]));
            }
            answer.add(new ArrayList<>(list));
        }

        for(int col = 0; col < n; col++){
            if(isValid(board, n, row, col)){
                board[row][col] = 'Q';
                backtrack(board, n, row + 1);
                board[row][col] = '.';
            }
        }
    }

    boolean isValid(char[][] board, int n, int row, int col){
        for(int i = 0; i < row; i++){
            if(board[i][col] == 'Q') return false;
        }

        int r = row;
        int c = col;
        while(r > 0 && c > 0){
            r--;
            c--;
            if(board[r][c] == 'Q') return false;
        }

        r = row;
        c = col;
        while(r > 0 && c < n - 1){
            r--;
            c++;
            if(board[r][c] == 'Q') return false;
        }

        return true;
    }


}