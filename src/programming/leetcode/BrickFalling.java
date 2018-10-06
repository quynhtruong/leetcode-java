package programming.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by truongq on 7/9/18.
 */
public class BrickFalling {
	class Point {
		public int x, y;

		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	public static int[][] offset = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

	public int[] hitBricks(int[][] grid, int[][] hits) {
		int m = grid.length;
		int n = grid[0].length;
		int[] result = new int[hits.length];
		boolean[][] connected = new boolean[m][n];
		for (int i = 0; i < n; i++) if (grid[0][i] == 1) connected[0][i] = true;
		for (int i = 0; i < hits.length; i++) {
			int u = hits[i][0], v = hits[i][1];
			int drop = 0;
			if (grid[u][v] == 1) {
				grid[u][v] = 0;
				connected[u][v] = false;
				for (int t = 0; t < offset.length; t++) {
					int x = u + offset[t][0], y = v + offset[t][1];
					if (x > 0 && x < m && y >= 0 && y < n && grid[x][y] == 1) {
						List<Point> queue = new ArrayList<>();
						boolean reach = bfs(grid, queue, connected, x, y, m, n);
						if (!reach) {
							drop += queue.size();
							for (Point p : queue) {
								grid[p.x][p.y] = 0;
							}
						} else {
							for (Point p : queue) connected[p.x][p.y] = true;
						}
					}
				}//end for t
			}
			result[i] = drop;
		}//end for i
		return result;
	}

	public boolean bfs(int[][] grid, List<Point> queue, boolean[][] connected, int startX, int startY, int m, int n) {
		boolean[][] visited = new boolean[m][n];
		visited[startX][startY] = true;
		queue.add(new Point(startX, startY));
		int first = 0;
		while (first < queue.size()) {
			Point p = queue.get(first++);
			for (int t = 0; t < offset.length; t++) {
				int x = p.x + offset[t][0], y = p.y + offset[t][1];
				if (x >= 0 && x < m && y >= 0 && y < n && grid[x][y] == 1 && !visited[x][y]) {
					visited[x][y] = true;
					if (connected[x][y]) return true;
					queue.add(new Point(x, y));
				}
			}
		}//end while
		return false;
	}
}
