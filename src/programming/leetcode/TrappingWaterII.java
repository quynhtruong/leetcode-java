package programming.leetcode;

import javafx.scene.layout.Priority;

import java.util.*;

/**
 * Created by truongq on 6/17/18.
 */
public class TrappingWaterII {

	class Point {
		public int x, y, h;

		public Point(int x, int y, int h) {
			this.x = x;
			this.y = y;
			this.h = h;
		}
	}

	public static final int[] offsetX = new int[]{0, 0, -1, 1};
	public static final int[] offsetY = new int[]{-1, 1, 0, 0};

	public int trapRainWater(int[][] height) {
		int m = height.length;
		if (m == 0) return 0;
		int n = height[0].length;
		if (n == 0) return 0;
		boolean[][] visit = new boolean[m][n];
		PriorityQueue<Point> heap = new PriorityQueue<>(new Comparator<Point>() {
			@Override
			public int compare(Point o1, Point o2) {
				return Integer.compare(o1.h, o2.h);
			}
		});
		for (int i = 0; i < m; i++) {
			visit[i][0] = true;
			visit[i][n - 1] = true;
			heap.offer(new Point(i, 0, height[i][0]));
			heap.offer(new Point(i, n - 1, height[i][n - 1]));
		}
		for (int i = 0; i < n; i++) {
			visit[0][i] = true;
			visit[m - 1][i] = true;
			heap.offer(new Point(0, i, height[0][i]));
			heap.offer(new Point(m - 1, i, height[m - 1][i]));
		}
		int result = 0;
		while (!heap.isEmpty()) {
			Point p = heap.poll();
			for (int t = 0; t < offsetX.length; t++) {
				int u = p.x + offsetX[t], v = p.y + offsetY[t];
				if (!visit[u][v]) {
					visit[u][v] = true;
					if (height[u][v] < p.h) {
						result += p.h - height[u][v];
					}
					heap.offer(new Point(u, v, Math.max(height[u][v], p.h)));
				}
			}
		}
		return result;
	}
}
