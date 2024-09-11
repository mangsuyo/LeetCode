import java.util.*;

class Pair<T1, T2> {
    T1 first;
    T2 second;

    public Pair(T1 first, T2 second) {
        this.first = first;
        this.second = second;
    }

    @Override
    public String toString() {
        return "(" + first + ", " + second + ")";
    }
}

class Solution {
    public boolean isBipartite(int[][] graph) {
        char[] chars = new char[graph.length];
        Arrays.fill(chars, 'N'); // 초기화 ('N'는 아직 방문하지 않은 노드)

        for (int i = 0; i < graph.length; i++) {
            if (chars[i] == 'N') { // 아직 방문하지 않은 노드에 대해 BFS 수행
                if (!bfs(graph, i, 'A', chars)) {
                    return false;
                }
            }
        }
        return true;
    }

    boolean bfs(int[][] graph, int startVertex, char ch, char[] chars) {
        Queue<Pair<Integer, Character>> queue = new ArrayDeque<>();
        chars[startVertex] = ch;
        queue.add(new Pair<>(startVertex, ch));

        while (!queue.isEmpty()) {
            Pair<Integer, Character> cur = queue.poll();

            for (int neighbor : graph[cur.first]) {
                if (chars[neighbor] == 'N') { // 아직 방문하지 않은 경우
                    if (cur.second == 'A') {
                        queue.add(new Pair<>(neighbor, 'B'));
                        chars[neighbor] = 'B';
                    } else {
                        queue.add(new Pair<>(neighbor, 'A'));
                        chars[neighbor] = 'A';
                    }
                } else if (chars[neighbor] == cur.second) {
                    return false; // 현재 노드와 이웃 노드가 같은 그룹이면 이분 그래프가 아님
                }
            }
        }
        return true;
    }
}
