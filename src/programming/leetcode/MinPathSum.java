package programming.leetcode;

import java.util.Arrays;

/**
 * Created by quuynh on 24/06/17.
 */
public class MinPathSum {
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        if (m == 0) return 0;
        int n = grid[0].length;
        long[][] f = new long[m][n];
        for (int i = 0; i < m; i++) Arrays.fill(f[i], Integer.MAX_VALUE);
        f[0][0] = grid[0][0];
        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++) {
                if (i > 0) f[i][j] = Math.min(f[i][j], f[i - 1][j] + grid[i][j]);
                if (j > 0) f[i][j] = Math.min(f[i][j], f[i][j - 1] + grid[i][j]);
            }
        return (int) f[m - 1][n - 1];
    }
}
