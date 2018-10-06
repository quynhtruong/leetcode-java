package programming.leetcode;

import java.util.*;

/**
 * Created by truongq on 6/10/18.
 */
public class RectangleArea {
	class Point {
		public int x, type;
		public Point(int x, int type) {
			this.x = x;
			this.type = type;
		}
	}

	public int rectangleArea(int[][] rectangles) {
		List<Integer> yList = new ArrayList<>();
		for(int[] rectangle: rectangles) {
			yList.add(rectangle[1]);
			yList.add(rectangle[3]);
		}

		Collections.sort(yList);
		long result= 0;
		for (int i = 1; i < yList.size(); i++)
			if (yList.get(i) > yList.get(i - 1)) {
			//calculate y[i-1], y[i]
			List<Point> points = new ArrayList<>();
			for(int[] r: rectangles) {
				if (r[1] <= yList.get(i-1) && r[3] >= yList.get(i)) {
					points.add(new Point(r[0],1));
					points.add(new Point(r[2],2));
				}
			}
			Collections.sort(points, new Comparator<Point>() {
				@Override
				public int compare(Point o1, Point o2) {
					if (Integer.compare(o1.x, o2.x) != 0) return Integer.compare(o1.x, o2.x);
					return Integer.compare(o1.type, o2.type);
				}
			});
			int count =  0, start = 0;
			for(Point p: points) {
				if (p.type == 1) {
					count++;
					if (count == 1) start = p.x;
				}
				else {
					count--;
					if (count == 0) result = (result+ ((long)(p.x) - start) * (yList.get(i) - yList.get(i-1)))%1000000007;
				}
			}
		}
		return (int)(result % 1000000007);
	}
}
