package programming.leetcode;

/**
 * Created by quuynh on 16/06/17.
 */
public class SpiralMatrixII {
    private void fillMatrix(int[][] matrix, int x, int y, int u, int v, int value, int direction) {
        if (x > u || y > v) return;
        switch (direction) {
            case 0:
                for (int i = y; i <= v; i++) matrix[x][i] = value++;
                fillMatrix(matrix, x + 1, y, u, v, value, 1);
                break;
            case 1:
                for (int i = x; i <= u; i++) matrix[i][v] = value++;
                fillMatrix(matrix, x, y, u, v - 1, value, 2);
                break;
            case 2:
                for (int i = v; i >= y; i--) matrix[u][i] = value++;
                fillMatrix(matrix, x, y, u - 1, v, value, 3);
                break;
            case 3:
                for (int i = u; i >= x; i--) matrix[i][y] = value++;
                fillMatrix(matrix, x, y + 1, u, v, value, 0);
                break;
        }
    }

    public int[][] generateMatrix(int n) {
        int[][] result = new int[n][n];
        fillMatrix(result, 0, 0, n - 1, n - 1, 1, 0);
        return result;
    }
}
