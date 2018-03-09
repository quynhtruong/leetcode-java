package programming.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by quuynh on 16/06/17.
 */
public class InsertInterval {
    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        intervals.add(newInterval);
        int newIndex = intervals.size() - 1;
        while (newIndex > 0 && intervals.get(newIndex).start <= intervals.get(newIndex - 1).start) {
            Interval temp = intervals.get(newIndex);
            intervals.set(newIndex, intervals.get(newIndex - 1));
            intervals.set(newIndex - 1, temp);
            newIndex--;
        }
        List<Interval> result = new ArrayList<>();
        result.add(intervals.get(0));
        for (int i = 1; i < intervals.size(); i++) {
            Interval interval = intervals.get(i);
            Interval currentTop = result.get(result.size() - 1);
            if (interval.start <= currentTop.end)
                currentTop.end = Math.max(currentTop.end, interval.end);
            else result.add(interval);
        }
        return result;
    }

}
