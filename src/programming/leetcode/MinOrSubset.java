package programming.leetcode;

/**
 * Created by truongq on 8/12/18.
 */
public class MinOrSubset {
	public static int minOrSize(int[] arr) {
		int n = arr.length;
		if (n == 0) return 0;
		int[] f = new int[n];
		int[] g = new int[n];
		int maxOr = 0;
		for(int i = 0; i < n; i++) {
			f[i] = arr[i];
			g[i] = 1;
			for(int j = 0; j < i; j++) {
				if (f[i] < (f[j] | arr[i]) || (f[i] == (f[j] | arr[i]) && g[i] > g[j] + 1)) {
					f[i] = f[j] | arr[i];
					g[i] = g[j] + 1;
				}
			}//end for j
			maxOr = Math.max(maxOr, f[i]);
		}
		int minSize = n;
		for(int i = 0; i < n; i++) {
			if (f[i] == maxOr) {
				minSize = Math.min(minSize, g[i]);
			}
		}
		//System.out.println(maxOr);
		return minSize;
	}

	public static void main(String[] args) {
		System.out.println(minOrSize(new int[]{1,2,3,4,5}));
	}

}
