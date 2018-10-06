package programming.leetcode;

import java.util.*;

public class SkyLineProblem {
    /*
    class Range implements Comparable<Range> {
        public int x, y, type;

        public Range(int x, int y, int type) {
            this.x = x;
            this.y = y;
            this.type = type;
        }

        public int compareTo(Range that) {
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
        List<Range> intervalList = new ArrayList<>();
        for (int[] rectangle: buildings) {
            intervalList.add(new Range(rectangle[0], rectangle[2], 1));
            intervalList.add(new Range(rectangle[1], rectangle[2], 2));
        }
        Collections.sort(intervalList);
        TreeMap<Integer, Integer> topMap = new TreeMap<>();
        for (Range interval : intervalList) {
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
    */

    class Interval {
        public int x,y,type;
        public Interval(int x, int y, int type) {
            this.x = x; this.y = y; this.type = type;
        }
    }
    public void add(List<int[]> result, int[] element) {
        while(!result.isEmpty() && result.get(result.size() - 1)[0] == element[0]) {
            result.remove(result.size() - 1);
        }
        result.add(element);
    }
    public List<int[]> getSkyline(int[][] buildings) {
        List<Interval> intervals = new ArrayList<>();
        for(int[] building: buildings) {
            intervals.add(new Interval(building[0], building[2], 1));
            intervals.add(new Interval(building[1], building[2], 2));
        }
        Collections.sort(intervals, new Comparator<Interval>(){
            public int compare(Interval i1, Interval i2) {
                if (Integer.compare(i1.x, i2.x) != 0) return Integer.compare(i1.x, i2.x);
                if (Integer.compare(i1.type, i2.type) != 0) return Integer.compare(i1.type, i2.type);
                return Integer.compare(i2.y, i1.y);
            }
        });
        TreeMap<Integer, Integer> countMap  = new TreeMap<>();
        countMap.put(0, 1);
        List<int[]> result = new ArrayList<>();
        for(Interval interval: intervals) {
            int x = interval.x;
            int y = interval.y;
            if (interval.type == 1) {
                if (y > countMap.lastKey()) {
                    add(result, new int[]{x, y});
                }
                countMap.put(y, countMap.get(y) == null ? 1: countMap.get(y) + 1);
            } else {
                int count = countMap.get(y);
                if (count > 1) countMap.put(y, count - 1);
                else countMap.remove(y);
                if (y > countMap.lastKey()) {
                    add(result, new int[]{x, countMap.lastKey()});
                }
            }
        }//end for i
        return result;
    }

}

