package programming.leetcode;

import java.util.*;

/**
 * Created by quuynh on 03/07/17.
 */

class IntervalCompare implements Comparator<Interval> {
    public int compare(Interval i1, Interval i2) {
        return Integer.compare(i1.start, i2.start);
    }
}

public class FindRightInterval {
    public int[] findRightInterval(Interval[] intervals) {
        int n = intervals.length;
        int[] result = new int[n];
        Arrays.fill(result, -1);
        Map<Interval, Integer> indexMap = new HashMap<>();
        for (int i = 0; i < n; i++) indexMap.put(intervals[i], i);
        Arrays.sort(intervals, new IntervalCompare());

        for (int i = 0; i < n; i++) {
            if (i < n - 1 && Integer.compare(intervals[i].end, intervals[i + 1].start) <= 0) {
                result[indexMap.get(intervals[i])] = indexMap.get(intervals[i + 1]);
            } else {
                int left = i + 1, right = n;
                while (right - left > 1) {
                    int mid = (left + right) / 2;
                    if (Integer.compare(intervals[i].end, intervals[mid].start) <= 0)
                        right = mid;
                    else
                        left = mid;
                }
                if (right < n)
                    result[indexMap.get(intervals[i])] = indexMap.get(intervals[right]);
            }
        }
        return result;
    }
}
