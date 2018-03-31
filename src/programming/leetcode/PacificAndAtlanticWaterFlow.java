package programming.leetcode;

import java.util.*;

public class PacificAndAtlanticWaterFlow {
    class Point {
        public int x, y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public int hashCode() {
            return x * 7 + y * 11;
        }

        public boolean equals(Object that) {
            return ((that instanceof Point) && (this.x == ((Point)that).x && this.y == ((Point)that).y));
        }
    }

    public static final int[] offsetX = new int[]{0, 0,-1, 1};
    public static final int[] offsetY = new int[]{-1,1, 0, 0};

    public List<int[]> pacificAtlantic(int[][] matrix) {
        List<int[]> result = new ArrayList<>();
        int m = matrix.length;
        if (m == 0) return result;
        int n = matrix[0].length;
        Deque<Point> queue = new LinkedList<>();
        Set<Point> pacificSet = new HashSet<>();
        //pacific
        for(int i = 0; i < m; i++) {
            Point p  = new Point(i, 0);
            queue.addLast(p);	pacificSet.add(p);
        }
        for(int i = 0; i < n; i++) {
            Point p = new Point(0, i);
            queue.addLast(p);pacificSet.add(p);
        }
        bfs(matrix, queue, pacificSet);
        //atlantic
        queue = new LinkedList<>();
        Set<Point> atlanticSet = new HashSet<>();
        for(int i = 0; i < m; i++) {
            Point p = new Point(i, n - 1);
            queue.addLast(p); atlanticSet.add(p);
        }
        for(int i = 0; i < n; i++) {
            Point p = new Point(m - 1, i);
            queue.addLast(p); atlanticSet.add(p);
        }
        bfs(matrix, queue, atlanticSet);
        for(Point p: atlanticSet) {
            if (pacificSet.contains(p)) {
                result.add(new int[]{p.x,p.y});
            }
        }//end for i
        return result;
    }

    private void bfs(int[][] matrix, Deque<Point> queue, Set<Point> set) {
        int m = matrix.length;
        int n = matrix[0].length;
        while(!queue.isEmpty()) {
            Point p = queue.removeFirst();
            for(int t = 0; t < offsetX.length;t++) {
                int x = p.x + offsetX[t];
                int y = p.y + offsetY[t];
                if (x >= 0 && x < m && y >= 0 && y < n && matrix[x][y] >= matrix[p.x][p.y] && !set.contains(new Point(x,y))) {
                    Point q = new Point(x,y);
                    queue.addLast(q);
                    set.add(q);
                }
            }
        }
    }
}
