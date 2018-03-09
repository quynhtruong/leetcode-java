package programming.leetcode;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

/**
 * Created by quuynh on 17/07/17.
 */
class QueueNode {
    public int x, y;

    public QueueNode(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class NumberOfIslands {
    public int numIslands(char[][] grid) {
        int m = grid.length;
        if (m == 0) return 0;
        int n = grid[0].length;
        boolean[][] free = new boolean[m][n];
        for (int i = 0; i < m; i++) Arrays.fill(free[i], false);
        int[] offsetX = {0, 0, -1, 1};
        int[] offsetY = {-1, 1, 0, 0};
        int result = 0;
        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++)
                if (free[i][j] && grid[i][j] == '1') {
                    result++;
                    Deque<QueueNode> nodeQueue = new LinkedList<>();
                    free[i][j] = false;
                    nodeQueue.addLast(new QueueNode(i, j));
                    while (!nodeQueue.isEmpty()) {
                        QueueNode node = nodeQueue.removeFirst();
                        for (int t = 0; t < 4; t++) {
                            int u = node.x + offsetX[t];
                            int v = node.y + offsetY[t];
                            if (u >= 0 && u < m && v >= 0 && v < n && grid[u][v] == '1' && free[u][v]) {
                                free[u][v] = false;
                                nodeQueue.addLast(new QueueNode(u, v));
                            }
                        }
                    }
                }
        return result;
    }
}
