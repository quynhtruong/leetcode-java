package programming.hackerank;

import java.util.Arrays;

/**
 * Created by truongq on 6/15/18.
 */
public class EmmaSupperComputer {
	static int twoPluses(String[] grid) {
		int m = grid.length;
		int n = grid[0].length();
		int result = 0;
		boolean[][] visit = new boolean[m][n];
		for(int i = 0; i < m; i++) {
			for(int j = 0; j < n; j++) {
				if (grid[i].charAt(j) == 'G') {
					for(int u = 0; u < m; u++) Arrays.fill(visit[u], false);
					for(int u = 0; valid(grid, m, n, i, j, u, visit); u++) {
						visit[i+u][j] = true;
						visit[i-u][j] = true;
						visit[i][j+u] = true;
						visit[i][j-u] = true;
						result = Math.max(result, (4 *u + 1) * getMax(grid, m, n, visit));
					}
				}
			}
		}//end for i
		return result;
	}

	private static boolean valid(String[] grid, int m, int n, int i, int j, int u, boolean[][] visit) {
		return i + u < m && i - u >= 0 && j + u < n && j - u >= 0
			&& grid[i+u].charAt(j) == 'G' && grid[i-u].charAt(j) == 'G' && grid[i].charAt(j+u) == 'G' && grid[i].charAt(j-u) == 'G'
			&& !visit[i+u][j] && !visit[i-u][j] && !visit[i][j+u] && !visit[i][j-u];
	}

	private static int getMax(String[] grid, int m, int n, boolean[][] visit) {
		int result = 0;
		for(int i = 0; i < m; i++) {
			for(int j = 0; j < n; j++) {
				for(int u = 0; valid(grid, m, n, i, j, u, visit); u++) {
					result = Math.max(result, 4 * u + 1);
				}
			}
		}
		return result;
	}

}
