package programming.leetcode;

public class DesignTicTacToe {

    private int[][] matrix;

    public DesignTicTacToe(int n) {
        matrix = new int[n][n];
    }

    public int move(int row, int col, int player) {
        int n = matrix.length;
        matrix[row][col] = player;
        if (check(row, col, matrix, -1, 0) + check(row, col, matrix, 1, 0) == n + 1) return player;
        if (check(row, col, matrix, 0, -1) + check(row, col, matrix, 0, 1) == n + 1) return player;
        if (check(row, col, matrix, -1, -1) + check(row, col, matrix, 1, 1) == n + 1) return player;
        if (check(row, col, matrix, -1, 1) + check(row, col, matrix, 1, -1) == n + 1) return player;
        return 0;
    }

    private int check(int i, int j, int[][] matrix, int offsetX, int offsetY) {
        int n = matrix.length;
        int result = 0;
        int x = i, y = j;
        while (x >= 0 && x < n && y >= 0 && y < n && matrix[x][y] == matrix[i][j]) {
            x += offsetX;
            y += offsetY;
            result++;
        }
        return result;
    }
}
