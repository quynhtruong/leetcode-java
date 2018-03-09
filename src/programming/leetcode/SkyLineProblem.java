package programming.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.TreeMap;

public class SkyLineProblem {
    class Interval implements Comparable<Interval> {
        public int x, y, type;

        public Interval(int x, int y, int type) {
            this.x = x;
            this.y = y;
            this.type = type;
        }

        public int compareTo(Interval that) {
            int xCompare = Integer.compare(this.x, that.x);
            if (xCompare != 0) return xCompare;
            return Integer.compare(this.type, that.type);
        }
    }

    public void add(List<int[]> result, int x, int y) {
        if (!result.isEmpty() && result.get(result.size() - 1)[0] == x) result.remove(result.size() - 1);
        result.add(new int[]{x,y});
    }

    public List<int[]> getSkyline(int[][] buildings) {
        List<int[]> result = new ArrayList<>();
        if (buildings.length == 0) return result;
        List<Interval> intervalList = new ArrayList<>();
        for (int[] rectangle: buildings) {
            intervalList.add(new Interval(rectangle[0], rectangle[2], 1));
            intervalList.add(new Interval(rectangle[1], rectangle[2], 2));
        }
        Collections.sort(intervalList);
        TreeMap<Integer, Integer> topMap = new TreeMap<>();
        for (Interval interval : intervalList) {
            if (interval.type == 1) {
                if (topMap.isEmpty()) {
                    result.add(new int[]{interval.x, interval.y});
                } else {
                    if (interval.y > topMap.lastKey()) {
                        add(result, interval.x, interval.y);
                    }
                }
                topMap.put(interval.y, topMap.get(interval.y) == null ? 1 : topMap.get(interval.y) + 1);
            } else { //type == 2
                int lastKey = topMap.lastKey();
                if (topMap.get(interval.y) == 1) topMap.remove(interval.y);
                else topMap.put(interval.y, topMap.get(interval.y) - 1);
                if (topMap.isEmpty()) {
                    add(result, interval.x, 0);
                } else if (topMap.get(lastKey) == null) {
                    add(result, interval.x, topMap.lastKey());
                }
            }
        }
        return result;
    }
}

