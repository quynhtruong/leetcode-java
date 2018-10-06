package programming.leetcode;

/**
 * Created by truongq on 8/5/18.
 */
public class ProjectionArea {
	public int projectionArea(int[][] grid) {
		int m = grid.length;
		if (m == 0) return 0;
		int n = grid[0].length;
		if (n == 0) return 0;
		int result = m * n;
		int[] maxR = new int[m];
		int[] maxC = new int[n];
		for(int i = 0; i < m; i++) {
			for(int j = 0; j < n; j++) {
				if (grid[i][j] == 0) result--;
				maxR[i] = Math.max(maxR[i], grid[i][j]);
				maxC[j] = Math.max(maxC[j], grid[i][j]);
			}
		}
		for(int i = 0; i < m; i++) result += maxR[i];
		for(int i = 0; i  < n; i++) result += maxC[i];
		return result;
	}

	public static void main(String[] args) {
	}
}
