package programming.leetcode;

import java.util.Arrays;

public class StringPrinter {
    public int strangePrinter(String s) {
        if (s.length() == 0) return 0;
        StringBuilder sb = new StringBuilder();
        sb.append(s.charAt(0));
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) != s.charAt(i - 1)) {
                sb.append(s.charAt(i));
            }
        }
        s = sb.toString();
        int n = s.length();
        int[][] f = new int[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(f[i], n);
            f[i][i] = 1;
        }
        for (int j = 1; j < n; j++) {
            for (int i = j - 1; i >= 0; i--) {
                //first case
                for (int u = i; u < j; u++) f[i][j] = Math.min(f[i][j], f[i][u] + f[u + 1][j]);
                //second case
                if (s.charAt(i) == s.charAt(j)) {
                    int diffCount = 0;
                    for (int u = i + 1; u < j; u++) if (s.charAt(u) != s.charAt(i)) diffCount++;
                    f[i][j] = Math.min(f[i][j], diffCount + 1);
                    f[i][j] = Math.min(f[i][j], f[i + 1][j - 1] + 1);
                    for (int u = i + 1; u < j; u++)
                        if (s.charAt(u) == s.charAt(i)) {
                            f[i][j] = Math.min(f[i][j], f[i + 1][u - 1] + f[u + 1][j - 1] + 1);
                        }
                }
            }
        }
        return f[0][n - 1];
    }
}

