package programming.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by quuynh on 21/07/17.
 */
public class BurstBalloons {
    public int maxCoins(int[] nums) {
        List<Integer> coins = new ArrayList<>();
        coins.add(1);
        for (int num : nums) coins.add(num);
        coins.add(1);
        int n = coins.size();
        int[][] f = new int[n + 1][n + 1];
        for (int i = 0; i < n; i++) {
            Arrays.fill(f[i], 0);
        }
        for(int j = 1; j < n; j++){
            for(int i = j-2; i >=0; i--) {
                for(int u = i+1; u < j; u++) f[i][j] = Math.max(f[i][j],f[i][u]+f[u][j]+coins.get(i) * coins.get(u) * coins.get(j));
            }
        }
        return f[0][n - 1];
    }
}
