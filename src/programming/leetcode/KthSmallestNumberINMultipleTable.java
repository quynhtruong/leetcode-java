package programming.leetcode;

public class KthSmallestNumberINMultipleTable {
    public long calculate(long value, int m, int n) {
        long result = 0;
        for (int i = 1; i <= m; i++) {
            result += Math.min(value / i, n);
        }
        return result;
    }

    public int findKthNumber(int m, int n, int k) {
        long limit = ((long) m) * n;
        long left = 0, right = limit + 1;
        while (left < right - 1) {
            long mid = (left + right) / 2;
            long totalDivisor = calculate(mid, m, n);
            if (totalDivisor < (long) k) {
                left = mid;
            } else {
                right = mid;
            }
        }
        return (int) right;
    }
}
