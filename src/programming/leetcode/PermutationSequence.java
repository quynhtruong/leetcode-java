package programming.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by quuynh on 16/06/17.
 */
public class PermutationSequence {
    public String getPermutation(int n, int k) {
        int[] factorial = new int[n + 1];
        factorial[0] = 1;
        for (int i = 1; i <= n; i++) factorial[i] = factorial[i - 1] * i;
        StringBuilder result = new StringBuilder();
        List<Integer> digits = new ArrayList<>();
        for (int i = 1; i < 10; i++) digits.add(i);
        for (int i = 1; i <= n; i++) {
            int next = k / factorial[n - i];
            if (k % factorial[n - i] != 0) next++;
            result.append(digits.get(next - 1));
            digits.remove(next - 1);
            //discard
            k -= (next - 1) * factorial[n - i];
        }
        return result.toString();
    }
}
