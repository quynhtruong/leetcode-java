package programming.leetcode;

/**
 * Created by quuynh on 17/07/17.
 */
public class RotateFunction {
    public int maxRotateFunction(int[] A) {
        int n = A.length;
        if (n == 0) return 0;
        int[] B = new int[2 * n];
        for (int i = 0; i < 2 * n; i++) B[i] = A[i % n];
        int[] sum = new int[2 * n];
        sum[0] = B[0];
        for (int i = 1; i < 2 * n; i++) sum[i] = sum[i - 1] + B[i];
        int currentResult = 0;
        for (int i = 0; i < n; i++) currentResult += i * B[i];
        int result = currentResult;
        for (int i = n; i < 2 * n; i++) {
            currentResult = currentResult + (n - 1) * B[i] - sum[i - 1] + sum[i - n];
            result = Math.max(result, currentResult);
        }
        return result;
    }
}
