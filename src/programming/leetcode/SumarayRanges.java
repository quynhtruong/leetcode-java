package programming.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by truongq on 5/23/18.
 */
public class SumarayRanges {
    class Interval {
        public int start, end;
        public Interval(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }
    public List<String> summaryRanges(int[] nums) {
        int n = nums.length;
        List<String> result = new ArrayList<>();
        if (n == 0) return result;
        List<Interval> intervals = new ArrayList<>();
        intervals.add(new Interval(nums[0], nums[0]));
        for(int i = 1; i< n; i++) {
            if (nums[i] > intervals.get(intervals.size() - 1).end + 1) {
                intervals.add(new Interval(nums[i], nums[i]));
            } else {
                intervals.get(intervals.size() - 1).end = nums[i];
            }
        }//end for i
        for(Interval interval: intervals) {
            if (interval.start == interval.end) {
                result.add(String.valueOf(interval.start));
            } else {
                result.add(interval.start + "->" + interval.end);
            }
        }
        return result;
    }

}
