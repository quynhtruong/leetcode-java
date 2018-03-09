package programming.leetcode;

import java.util.Arrays;

public class LongestPalindromicSubsequence {
    public int longestPalindromeSubseq(String s) {
        int n = s.length();
        if (n == 0) return 0;
        int[][] f = new int[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(f[i], 0);
            f[i][i] = 1;
        }
        for (int j = 1; j < n; j++) {
            for (int i = j - 1; i >= 0; i--) {
                f[i][j] = Math.max(f[i][j - 1], f[i + 1][j]);
                if (s.charAt(i) == s.charAt(j)) {
                    f[i][j] = Math.max(f[i][j], f[i + 1][j - 1] + 2);
                }
            }
        }
        return f[0][n - 1];
    }
}
