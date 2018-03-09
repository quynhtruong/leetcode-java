package programming.leetcode;

import java.util.Deque;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

class Pair {
    public int x, y;

    public Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int hashCode() {
        return this.x + this.y;
    }

    public boolean equals(Object o) {
        return (o instanceof Pair && ((Pair) o).x == this.x && ((Pair) o).y == this.y);
    }
}


public class WaterAndJugs {
    public boolean canMeasureWater(int x, int y, int z) {
        if (z == 0) return true;
        Set<Pair> pairSet = new HashSet<>();
        Deque<Pair> queue = new LinkedList<>();
        queue.addLast(new Pair(0, 0));
        pairSet.add(new Pair(0, 0));
        while (!queue.isEmpty()) {
            Pair pair = queue.removeFirst();
            if (pair.x == z || pair.y == z || pair.x + pair.y == z) return true;
            //empty x
            Pair p = new Pair(0, pair.y);
            if (!pairSet.contains(p)) {
                pairSet.add(p);
                queue.addLast(p);
            }
            //empty y
            p = new Pair(x, 0);
            if (!pairSet.contains(p)) {
                pairSet.add(p);
                queue.addLast(p);
            }
            //full x
            int minFull = Math.min(x - pair.x, pair.y);
            p = new Pair(pair.x + minFull, pair.y - minFull);
            if (!pairSet.contains(p)) {
                pairSet.add(p);
                queue.addLast(p);
            }
            //full y
            minFull = Math.min(pair.x, y - pair.y);
            p = new Pair(pair.x - minFull, pair.y + minFull);
            if (!pairSet.contains(p)) {
                pairSet.add(p);
                queue.addLast(p);
            }
        }
        return false;
    }

}
