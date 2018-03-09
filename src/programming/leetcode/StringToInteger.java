package programming.leetcode;

/**
 * Created by quuynh on 14/07/17.
 */
public class StringToInteger {
    public int myAtoi(String str) {
        str = str.trim();
        if ("".equals(str)) return 0;
        int sign = 1;
        if (str.charAt(0) == '+' || str.charAt(0) == '-') {
            if (str.charAt(0) == '-') sign = -1;
            str = str.substring(1);
        }
        if ("".equals(str.trim()) || str.charAt(0) > '9' || str.charAt(0) < '0') return 0;
        str = str.trim();
        long result = 0L;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) > '9' || str.charAt(i) < '0') return sign * (int) result;
            result = result * 10 + str.charAt(i) - '0';
            if (result * sign > Integer.MAX_VALUE || result * sign < Integer.MIN_VALUE) {
                return result * sign > Integer.MAX_VALUE ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
        }
        return sign * (int) result;
    }


}
