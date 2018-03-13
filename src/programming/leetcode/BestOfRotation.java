package programming.leetcode;

import com.sun.org.apache.bcel.internal.generic.RET;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BestOfRotation {

    class Point implements Comparable<Point> {
        public int x, type;

        public Point(int x, int type) {
            this.x = x;
            this.type = type;
        }

        public int compareTo(Point that) {
            int xCom = Integer.compare(this.x, that.x);
            if (xCom != 0) {
                return xCom;
            } else {
                return Integer.compare(this.type, that.type);
            }
        }
    }

    public int bestRotation(int[] A) {
        int n = A.length;
        List<Point> pointList = new ArrayList<>();
        for (int i = 0; i < n; i++)
            if (A[i] < n) {
                if (A[i] > i) {
                    pointList.add(new Point(i + 1, 1));
                    pointList.add(new Point(i + 1 + n - 1 - A[i], 2));
                } else {
                    pointList.add(new Point(0, 1));
                    pointList.add(new Point(i - A[i], 2));
                    pointList.add(new Point(i + 1, 1));
                    pointList.add(new Point(i + 1 + (n - 1 - i), 2));
                }
            }
        Collections.sort(pointList);
        int result = 0, count = 0, rotate = -1;
        for (Point p : pointList) {
            if (p.type == 1) count++;
            else count--;
            if (count > result) {
                result = count;
                rotate = p.x;
            }
        }
        return rotate;
    }

    public static void main(String[] args) {
        BestOfRotation bestOfRotation = new BestOfRotation();
        System.out.println(bestOfRotation.bestRotation(new int[]{2,3,1,4,0}));
    }
}
