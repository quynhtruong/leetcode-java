package programming.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by quuynh on 16/06/17.
 */


public class MergeIntervals {
    public List<Interval> merge(List<Interval> intervals) {
        Collections.sort(intervals, new Comparator<Interval>() {
            public int compare(Interval i1, Interval i2) {
                return Integer.compare(i1.start, i2.start);
            }
        });
        List<Interval> result = new ArrayList<Interval>();
        if (intervals.isEmpty()) return result;
        result.add(intervals.get(0));
        for (int i = 1; i < intervals.size(); i++) {
            Interval interval = intervals.get(i);
            Interval lastMerged = result.get(result.size() - 1);
            if (interval.start <= lastMerged.end) lastMerged.end = Math.max(lastMerged.end, interval.end);
            else result.add(interval);
        }
        return result;
    }
}
