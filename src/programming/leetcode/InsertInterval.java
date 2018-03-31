package programming.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by quuynh on 16/06/17.
 */
public class InsertInterval {
    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        intervals.add(newInterval);
        int n = intervals.size();
        int index = n - 1;
        while(index > 0 && intervals.get(index).start < intervals.get(index - 1).start) {
            Collections.swap(intervals, index - 1, index);
            index--;
        }
        List<Interval> result = new ArrayList<>();
        result.add(intervals.get(0));
        for(int i = 1; i < n; i++) {
            if (intervals.get(i).start > result.get(result.size() - 1).end) {
                result.add(intervals.get(i));
            } else {
                int maxEnd = Math.max(result.get(result.size() - 1).end, intervals.get(i).end);
                result.get(result.size() - 1).end = maxEnd;
            }
        }//end for i
        return result;
    }

}
