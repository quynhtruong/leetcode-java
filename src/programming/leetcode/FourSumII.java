package programming.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by quuynh on 01/07/17.
 */
public class FourSumII {
    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        Map<Integer, Integer> sideAMap = new HashMap<>();
        Map<Integer, Integer> sideBMap = new HashMap<>();
        for (int a : A)
            for (int b : B) {
                if (sideAMap.get(a + b) == null) sideAMap.put(a + b, 0);
                sideAMap.put(a + b, sideAMap.get(a + b) + 1);
            }
        for (int c : C)
            for (int d : D) {
                if (sideBMap.get(c + d) == null) sideBMap.put(c + d, 0);
                sideBMap.put(c + d, sideBMap.get(c + d) + 1);
            }
        int result = 0;
        for (Integer key : sideAMap.keySet()) {
            if (sideBMap.get(-key) != null) result += sideAMap.get(key) * sideBMap.get(-key);
        }
        return result;
    }
}
