package programming.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * Created by truongq on 5/17/18.
 */
public class RussianDollEnvelop {
    public int maxEnvelopes(int[][] envelopes) {
        Arrays.sort(envelopes, new Comparator<int[]>() {
            public int compare(int[] a, int[] b) {
                int wCompare = Integer.compare(a[0], b[0]);
                if (wCompare != 0) return wCompare;
                return Integer.compare(b[1], a[1]);
            }
        });
        List<int[]> path = new ArrayList<>();
        path.add(new int[]{-1, -1});

        for (int[] envelop : envelopes) {
            int left = 0, right = path.size();
            while (right - left > 1) {
                int mid = (left + right) / 2;
                if (path.get(mid)[1] >= envelop[1]) {
                    right = mid;
                } else {
                    left = mid;
                }
            }
            if (left == path.size() - 1) {
                path.add(envelop);
            } else if (envelop[1] < path.get(left + 1)[1]) {
                path.set(left + 1, envelop);
            }
        }
        return path.size() - 1;
    }
}
