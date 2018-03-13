package programming.leetcode;

import java.util.*;

public class ShortestDistanceFromBuilding {

    public final static int[] offsetX = new int[]{0, 0, -1, 1};
    public final static int[] offsetY = new int[]{-1, 1, 0, 0};

    public int shortestDistance(int[][] grid) {
        int m = grid.length;
        if (m == 0) return 0;
        int n = grid[0].length;
        int[][] count = new int[m][n];
        int[][] distance = new int[m][n];
        int countBuilding = 0;
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) if (grid[i][j] == 1) {
                countBuilding++;
                Deque<Integer> queueX = new LinkedList<>();
                Deque<Integer> queueY = new LinkedList<>();
                int[][] f = new int[m][n];
                for(int u = 0; u < m; u++) Arrays.fill(f[u], -1);
                queueX.addLast(i); queueY.addLast(j);
                count[i][j]++;
                f[i][j] = 0;
                while(!queueX.isEmpty()) {
                    int x = queueX.removeFirst(), y = queueY.removeFirst();
                    for(int t = 0; t < offsetX.length; t++) {
                        int u = x + offsetX[t], v = y + offsetY[t];
                        if (u < m && u >= 0 && v < n && v >= 0 && grid[u][v] == 0) {
                            if (f[u][v] == -1) {
                                f[u][v] = f[x][y] + 1;
                                count[u][v]++;
                                if (count[u][v] == countBuilding) {
                                    queueX.addLast(u);
                                    queueY.addLast(v);
                                    distance[u][v] += f[u][v];
                                }
                            }
                        }
                    }
                }//end while queue
            }//end for j
        }//end for i
        int result = Integer.MAX_VALUE;
        for(int i = 0; i < m; i++) {
            for(int j =0; j < n; j++) if (grid[i][j] == 0 && count[i][j] == countBuilding) {
                result = Math.min(result, distance[i][j]);
            }
        }
        return result == Integer.MAX_VALUE ? -1: result;
    }

}
