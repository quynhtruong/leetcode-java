package programming.leetcode;

/**
 * Created by truongq on 7/30/18.
 */
public class ProfitScheme {
	public int profitableSchemes(int G, int P, int[] group, int[] profit) {
		long maxN = 1000000007;
		int n = group.length;
		long[] f = new long[G+1];
		f[0] = 1;
		for(int i = 0; i < n; i++) {
			for(int j = G; j >= group[i]; j--) {
				f[j] = (f[j] + f[j - group[i]]) % maxN;
			}//end for j
		}//end for i
		long[][] ff = new long[G+1][P];
		ff[0][0] = 1;
		for(int i = 0; i < n; i++) {
			for(int j = G; j >= group[i]; j--) {
				for(int u = P - 1; u >= profit[i]; u--) {
					ff[j][u] = (ff[j][u] + ff[j - group[i]][u - profit[i]]) % maxN;
				}//end for u
			}//end for j
		}//end for i
		long result = 0;
		for(int i = 1; i <= G; i++) {
			long temp = f[i];
			for(int j = 0; j < P; j++) {
				temp -= ff[i][j];
				if (temp < 0) temp += maxN;
			}
			result = (result + temp) % maxN;
		}//end for i
		return (int) result;
	}

}
