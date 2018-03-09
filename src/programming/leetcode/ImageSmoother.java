package programming.leetcode;

public class ImageSmoother {
    public static final int[] offsetX = new int[]{ 0,0,-1,-1,-1, 1,1,1};
    public static final int[] offsetY = new int[]{-1,1,-1, 0, 1,-1,0,1};

    public int[][] imageSmoother(int[][] arr) {
        int m = arr.length;
        if (m == 0) return new int[0][0];
        int n = arr[0].length;
        int[][] result = new int[m][n];
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                int count = 1, sum = arr[i][j];
                for(int t = 0; t < offsetX.length; t++) {
                    int u = i + offsetX[t];
                    int v = j + offsetY[t];
                    if (u >=0 && u < m && v >= 0 && v < n) {
                        count++;
                        sum += arr[u][v];
                    }
                }
                result[i][j] = sum / count;
            }
        }//end for i
        return result;
    }

}
