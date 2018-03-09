package programming.leetcode;

import java.math.BigInteger;

public class AddictiveNumber {
    public boolean result = false;

    public boolean isAdditiveNumber(String s) {
        int n = s.length();
        if (n <= 2) return false;
        for (int j = 0; j < n - 1; j++) {
            for (int i = j; i > 0; i--) {
                BigInteger num1 = new BigInteger(s.substring(0, i));
                BigInteger num2 = new BigInteger(s.substring(i, j + 1));
                if (num1.toString().equals(s.substring(0, i)) && num2.toString().equals(s.substring(i, j + 1))) {
                    visit(i, j, num1, num2, s, n);
                }
            }
        }
        return result;
    }

    public void visit(int i, int j, BigInteger num1, BigInteger num2, String s, int n) {
        if (result == true) return;
        if (j == n - 1) {
            result = true;
            return;
        }
        BigInteger sum = num1.add(num2);
        String sumStr = sum.toString();
        int len = sumStr.length();
        int u = 0;
        while (u < len && j + u + 1 < n && s.charAt(j + u + 1) == sumStr.charAt(u)) u++;
        if (u == len) {
            visit(j, j + len, num2, sum, s, n);
        }
    }
}
