package programming.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by quuynh on 16/06/17.
 */
public class SpiralMatrix {
    private List<Integer> result = new ArrayList<>();

    private void visit(int[][] matrix, int x, int y, int u, int v, int direction) {
        if (x > u || y > v) return;
        switch (direction) {
            case 0:
                for (int i = y; i <= v; i++) result.add(matrix[x][i]);
                visit(matrix, x + 1, y, u, v, 1);
                break;
            case 1:
                for (int i = x; i <= u; i++) result.add(matrix[i][v]);
                visit(matrix, x, y, u, v - 1, 2);
                break;
            case 2:
                for (int i = v; i >= y; i--) result.add(matrix[u][i]);
                visit(matrix, x, y, u - 1, v, 3);
                break;
            case 3:
                for (int i = u; i >= x; i--) result.add(matrix[i][y]);
                visit(matrix, x, y + 1, u, v, 0);
                break;
        }
    }

    public List<Integer> spiralOrder(int[][] matrix) {
        int m = matrix.length;
        if (m == 0) return result;
        int n = matrix[0].length;
        visit(matrix, 0, 0, m - 1, n - 1, 0);
        return result;
    }

}
