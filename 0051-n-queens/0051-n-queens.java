import java.util.*;

class Solution {

    int[] dr = new int[] {-1, -1, 1, 1};
    int[] dc = new int[] {-1, 1, -1, 1};

    public List<List<String>> solveNQueens(int n) {
        List<List<String>> answer = new ArrayList<>();
        char[][] graph = new char[n][n];

        for (int i = 0; i < n; i++) {
            Arrays.fill(graph[i], '.');
        }

        backtrack(n, 0, graph, answer);

        return answer;
    }

    boolean backtrack(int n, int row, char[][] graph, List<List<String>> answer) {

        // 모든 퀸을 배치했을 경우 답을 저장
        if (row == n) {
            List<String> temp = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                temp.add(new String(graph[i]));
            }
            answer.add(temp);
            return false; // 더 많은 답을 찾기 위해 false 반환
        }

        // 현재 row에 퀸을 배치할 열(column)을 탐색
        for (int col = 0; col < n; col++) {
            if (isValid(graph, row, col, n)) {
                graph[row][col] = 'Q';  // 퀸을 배치
                backtrack(n, row + 1, graph, answer);  // 다음 행으로 진행
                graph[row][col] = '.';  // 백트래킹: 퀸을 제거
            }
        }
        return false;
    }

    // 퀸이 row, col에 배치되는 것이 유효한지 확인
    boolean isValid(char[][] graph, int row, int col, int n) {
        // 같은 열에 있는 퀸을 검사
        for (int i = 0; i < row; i++) {
            if (graph[i][col] == 'Q') {
                return false;
            }
        }

        // 왼쪽 위 대각선 검사
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if (graph[i][j] == 'Q') {
                return false;
            }
        }

        // 오른쪽 위 대각선 검사
        for (int i = row - 1, j = col + 1; i >= 0 && j < n; i--, j++) {
            if (graph[i][j] == 'Q') {
                return false;
            }
        }

        return true;
    }
}
