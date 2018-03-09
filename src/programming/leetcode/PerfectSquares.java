package programming.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by quuynh on 15/06/17.
 */
public class PerfectSquares {
    int numSquares(int n) {
        int[] f = new int[n + 1];
        Arrays.fill(f, n + 1);
        f[0] = 0;
        for (int i = 0; i <= n; i++)
            for (int j = 0; j * j <= i; j++) f[i] = Math.min(f[i - j * j] + 1, f[i]);
        return f[n];
    }
}
