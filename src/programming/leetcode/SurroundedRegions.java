package programming.leetcode;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class SurroundedRegions {

    public final static int[] offsetX = new int[] {0, 0, -1, 1};
    public final static int[] offsetY = new int[] {-1, 1, 0, 0};

    public void solve(char[][] board) {
        int m = board.length;
        if (m == 0) return;
        int n = board[0].length;
        if (n == 0) return;
        boolean[][] visited = new boolean[m][n];
        for(int i = 0; i < m; i++) {
            if (!visited[i][0] && board[i][0] =='O') bfs(i, 0, visited, board);
            if (!visited[i][n-1] && board[i][n-1] == 'O') bfs(i, n - 1, visited, board);
        }
        for(int i = 0; i < n; i++) {
            if (!visited[0][i] && board[0][i] == 'O') bfs(0,i, visited, board);
            if (!visited[m-1][i] && board[m-1][i] == 'O') bfs(m - 1, i, visited, board);
        }
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if (!visited[i][j] && board[i][j] =='O') board[i][j] = 'X';
            }
        }//end for i
    }

    private void bfs(int startX, int startY, boolean[][] visited, char[][] board) {
        int m = board.length;
        int n = board[0].length;
        Deque<Integer> queueX = new LinkedList<>();
        Deque<Integer> queueY = new LinkedList<>();
        visited[startX][startY] = true;
        queueX.addLast(startX);
        queueY.addLast(startY);
        while(!queueX.isEmpty()) {
            int  i = queueX.removeFirst(); int j = queueY.removeFirst();
            for(int t = 0; i < offsetX.length; t++) {
                int u = i + offsetX[t];
                int v = j + offsetY[t];
                if (u >=0 && u < m && v >=0 && v < n && !visited[u][v] && board[u][v] == 'O') {
                    visited[u][v] = true;
                    queueX.addLast(u);
                    queueY.addLast(v);
                }
            }
        }//end queue
    }

}
