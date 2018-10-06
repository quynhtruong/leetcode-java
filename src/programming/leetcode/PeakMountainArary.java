package programming.leetcode;

/**
 * Created by truongq on 6/17/18.
 */
public class PeakMountainArary {
	public int peakIndexInMountainArray(int[] A) {
		int n  = A.length;
		for(int i = 1; i < n - 1; i++) {
			if (A[i] > A[i + 1]) return i;
		}
		return -1;
	}
}
