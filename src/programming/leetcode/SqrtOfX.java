package programming.leetcode;

public class SqrtOfX {
    public int mySqrt(int x) {
        long left = 0, right = (long) x + 1;
        while (right - left > 1) {
            long mid = ((long) left + right) / 2;
            if (mid * mid > (long) x) right = mid; else left = mid;
        }//end while loop
        return (int) left;
    }

}
