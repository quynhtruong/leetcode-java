package programming.leetcode;

public class Divide2Integers {
    public int divide(int dividend, int divisor) {
        int sign = 1;
        long a = dividend;
        long b = divisor;
        if (a < 0) {
            sign *= -1;
            a = -a;
        }
        if (b < 0) {
            sign *= -1;
            b = -b;
        }
        int count = 0;
        long result = 0;
        while ((b << count) < a) count++;
        for (int i = count; i >= 0; i--) {
            if (a >= (b << i)) {
                result += ((long) 1) << i;
                a -= (b << i);
            }
        }
        result = result * sign;
        return result > Integer.MAX_VALUE || result < Integer.MIN_VALUE ? Integer.MAX_VALUE : (int) result;
    }
}
