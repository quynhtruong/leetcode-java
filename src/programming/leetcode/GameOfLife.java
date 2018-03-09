package programming.leetcode;

public class GameOfLife {
    public final static int[] offsetX = new int[] {0, 0, -1,-1,-1,  1, 1, 1};
    public final static int[] offsetY = new int[] {1,-1, -1, 0 , 1, -1,0, 1};

    public void gameOfLife(int[][] board) {
        int m = board.length;
        if (m == 0) return;
        int n = board[0].length;
        for(int  i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                int count = 0;
                for(int k = 0; k < offsetX.length; k++) {
                    int u = i + offsetX[k];
                    int v = j + offsetY[k];
                    if (u >=0 && u < m && v >= 0 && v <n) count += (board[u][v] & 1);
                }
                if (board[i][j] == 1) {
                    if (count == 2 || count == 3) board[i][j] ^= (1 << 1);
                } else {
                    if (count == 3) board[i][j] ^= (1 << 1);
                }
            }//end for j
        }//end for i
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) board[i][j]>>=1;
        }
    }
}
