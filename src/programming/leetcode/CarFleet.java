package programming.leetcode;

import java.util.*;

/**
 * Created by truongq on 6/17/18.
 */
public class CarFleet {
	class Point {
		public int x, s;
		public Point(int x, int s) {
			this.x = x;
			this.s = s;
		}
	}

	public int carFleet(int target, int[] position, int[] speed) {
		int n = position.length;
		List<Point> pointList = new ArrayList<>();

		for(int i = 0; i < n; i++) pointList.add(new Point(position[i], speed[i]));
		Collections.sort(pointList, new Comparator<Point>() {
			@Override
			public int compare(Point o1, Point o2) {
				return Integer.compare(o2.x, o1.x);
			}
		});

		Deque<Integer> stack = new LinkedList<>();
		int result = 0;
		double[] time = new double[n];
		for(int i = 0; i < n; i++) time[i] = ((double)target - pointList.get(i).x) / (pointList.get(i).s);
		for(int i = 0; i < n; i++) {
			while(!stack.isEmpty() && time[stack.peekLast()] < time[i]) stack.removeLast();
			if (stack.isEmpty()) {
				result++;
			}
			stack.addLast(i);
		}
		return result;
	}
}
