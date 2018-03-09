package programming.leetcode;

import java.util.Arrays;

public class OutOfBoundaryPath {
    public int findPaths(int m, int n, int N, int s, int w) {
        int[][][] f = new int[m + 2][n + 2][N + 1];
        for (int i = 0; i < m + 2; i++) {
            for (int j = 0; j < n + 2; j++) {
                Arrays.fill(f[i][j], 0);
            }
        }
        f[s + 1][w + 1][0] = 1;
        int[] offsetX = new int[]{0, 0, -1, 1};
        int[] offsetY = new int[]{-1, 1, 0, 0};
        for (int u = 1; u <= N; u++) {
            for (int i = 0; i < m + 2; i++) {
                for (int j = 0; j < n + 2; j++) {
                    for (int t = 0; t < 4; t++) {
                        int xx = i + offsetX[t];
                        int yy = j + offsetY[t];
                        if (xx >= 1 && xx < m + 1 && yy > 0 && yy < n + 1) {
                            f[i][j][u] = (f[i][j][u] + f[xx][yy][u - 1]) % 1000000007;
                        }
                    }
                }
            }
        }
        int result = 0;
        for (int u = 0; u <= N; u++) {
            for (int i = 0; i < m + 2; i++) {
                for (int j = 0; j < n + 2; j++) {
                    if (i == 0 || i == m + 1 || j == 0 || j == n + 1) result = (result + f[i][j][u]) % 1000000007;
                }
            }
        }
        return result;
    }
}
