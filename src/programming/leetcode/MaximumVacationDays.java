package programming.leetcode;

import java.util.Arrays;

public class MaximumVacationDays {
    public int maxVacationDays(int[][] flights, int[][] days) {
        int  n  = flights.length;
        if (n == 0) return 0;
        int k = days[0].length;
        if (k == 0) return 0;
        int[][] f = new int[n][k+1];
        for(int i = 0; i < n; i++) Arrays.fill(f[i], -1);
        f[0][0] = 0;
        int result = 0;
        for(int j = 1; j <= k; j++) {
            for(int i = 0; i < n; i++) {
                if (f[i][j-1] >= 0) f[i][j] = f[i][j-1] + days[i][j];
                for(int u = 0; u < n; u++) {
                    if (flights[u][i] == 1 && f[u][j-1] >= 0) f[i][j] = Math.max(f[i][j], f[u][j-1] + days[i][j]);
                }
            }
        }//end for j
        for(int i = 0; i < n; i++) result = Math.max(result, f[i][k]);
        return result;
    }

}
