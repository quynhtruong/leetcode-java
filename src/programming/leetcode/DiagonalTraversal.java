package programming.leetcode;

public class DiagonalTraversal {
    public int[] findDiagonalOrder(int[][] matrix) {
        int m = matrix.length;
        if (m == 0) return new int[0];
        int n = matrix[0].length;
        int[] result = new int[m * n];
        int count = 0, u = 0, v = 0;
        result[count++] = matrix[u][v];
        int offsetX = -1, offsetY = 1;
        while (count < m * n) {
            if (offsetX == -1) { //going up
                if (v < n - 1) v++;
                else u++;
            } else {
                if (u < m - 1) u++;
                else v++;
            }
            result[count++] = matrix[u][v];
            offsetX = -offsetX;
            offsetY = -offsetY;
            while (inside(u + offsetX, v + offsetY, m, n)) {
                u += offsetX;
                v += offsetY;
                result[count++] = matrix[u][v];
            }
        }//end while count
        return result;
    }

    private boolean inside(int u, int v, int m, int n) {
        return u >= 0 && u < m && v >= 0 && v < n;
    }
}
