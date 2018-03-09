package programming.leetcode;

import java.util.*;

public class MinimumNumberOfArrowToBustBalloon {

    class Point implements Comparable<Point> {
        public int x, pos, type;

        public Point(int x, int pos, int type) {
            this.x = x;
            this.pos = pos;
            this.type = type;
        }

        public int compareTo(Point that) {
            if (Integer.compare(this.x, that.x) != 0) {
                return Integer.compare(this.x, that.x);
            }
            return Integer.compare(this.type, that.type);
        }
    }

    public int findMinArrowShots(int[][] points) {
        int n = points.length;
        List<Point> pointList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int[] point = points[i];
            pointList.add(new Point(point[0], i, 1));
            pointList.add(new Point(point[1], i, 2));
        }
        Collections.sort(pointList);
        int result = 0;
        boolean[] free = new boolean[n];
        Arrays.fill(free, true);
        Deque<Point> stack = new LinkedList<>();
        for (Point point : pointList) {
            if (free[point.pos]) {
                if (point.type == 1) { //open point
                    stack.addLast(point);
                } else {
                    result++;
                    while (!stack.isEmpty()) {
                        free[stack.removeLast().pos] = false;
                    }
                }
            }
        }
        return result;
    }
}
