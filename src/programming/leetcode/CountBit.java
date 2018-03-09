package programming.leetcode;

import java.util.Arrays;

/**
 * Created by quuynh on 29/06/17.
 */
public class CountBit {
    public int[] countBits(int num) {
        int[] result = new int[num + 1];
        Arrays.fill(result, 0);
        for (int i = 0; i <= num; i++) {
            int j = i;
            while (j != 0) {
                result[i]++;
                j = j & (j - 1);
            }
        }
        return result;
    }
}