package programming.leetcode;

import java.util.Arrays;

public class DeleteOperationForTwoStrings {
    public int minDistance(String word1, String word2) {
        word1 = "$" + word1;
        word2 = "$" + word2;
        int m = word1.length();
        int n = word2.length();
        int[][] f = new int[m][n];
        for (int i = 0; i < m; i++) {
            Arrays.fill(f[i], m + n);
        }
        for (int i = 0; i < m; i++) {
            f[i][0] = i;
        }
        for (int i = 0; i < n; i++) {
            f[0][i] = 0;
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                f[i][j] = Math.min(f[i][j], f[i - 1][j] + 1);
                f[i][j] = Math.min(f[i][j], f[i][j - 1] + 1);
                if (word1.charAt(i) == word2.charAt(j)) {
                    f[i][j] = Math.min(f[i][j], f[i - 1][j - 1]);
                }
            }
        }
        return f[m - 1][n - 1];
    }
}
