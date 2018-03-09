package programming.leetcode;

import com.sun.xml.internal.messaging.saaj.packaging.mime.util.QPEncoderStream;

import java.util.HashMap;
import java.util.Map;

public class MaxPointOnLine {

    class Point {
        int x;
        int y;

        Point() {
            x = 0;
            y = 0;
        }

        Point(int a, int b) {
            x = a;
            y = b;
        }
    }

    public static long gcd(long x, long y) {
        while (x != 0) {
            long temp = y % x;
            x = y;
            y = temp;
        }
        return y;
    }

    public class QPoint {
        public long x, y;

        public QPoint(long x, long y) {
            this.x = x;
            this.y = y;
        }

        public boolean equals(Object that) {
            if (!(that instanceof QPoint)) return false;
            QPoint point = (QPoint) that;
            return point.x * this.y == point.y * this.x;
        }

        public int hashCode() {
            long result = this.x * this.y;
            result %= Integer.MAX_VALUE;
            return (int) result;
        }
    }

    public int maxPoints(Point[] points) {
        int n = points.length;
        if (n == 0) return 0;
        int result = 0;
        for (int i = 0; i < n; i++) {
            Map<QPoint, Integer> countMap = new HashMap<>();
            int equal = 0;
            for (int j = 0; j < n; j++) {
                if (points[i].x == points[j].x && points[i].y == points[j].y) {
                    equal++;
                } else {
                    long x = (long) points[j].x - points[i].x;
                    long y = (long) points[j].y - points[i].y;
                    long gcd = gcd(Math.abs(x), Math.abs(y));
                    x /= gcd;
                    y /= gcd;
                    QPoint qPoint = new QPoint(x, y);
                    countMap.put(qPoint, countMap.get(qPoint) == null ? 1 : countMap.get(qPoint) + 1);
                }
            }
            int max = 0;
            for(QPoint key: countMap.keySet()){
                max = Math.max(max, countMap.get(key));
            }
            result = Math.max(result, max + equal);
        }
        return result;
    }
}
