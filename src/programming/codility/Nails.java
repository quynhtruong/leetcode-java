package programming.codility;

/**
 * Created by truongq on 7/12/18.
 */
public class Nails {

	int solution(int[] A, int K) {
		int n = A.length;
		int best = 0;
		//int count = 0;
		int count = 0;
		for (int i = 0; i < n - K - 1; i++) {
			if (A[i] == A[i + 1])
				count = count + 1;
			else
				count = 0;
			if (count > best)
				best = count;
		}
		int result = Math.min(n, best + 1 + K);

		return result;
	}
}
