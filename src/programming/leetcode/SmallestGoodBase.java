package programming.leetcode;

import java.math.BigInteger;

/**
 * Created by quuynh on 01/07/17.
 */
public class SmallestGoodBase {
    public BigInteger checkFoundBase(int len, BigInteger num) {
        BigInteger left = BigInteger.valueOf(2);
        BigInteger right = num.subtract(BigInteger.valueOf(1));
        while (left.compareTo(right) <= 0) {
            BigInteger mid = left.add(right).divide(BigInteger.valueOf(2));
            BigInteger temp = BigInteger.valueOf(0);
            for (int i = 0; i < len; i++) {
                temp = temp.add(mid.pow(i));
                if (temp.compareTo(num) > 0) break;
            }
            if (temp.equals(num)) return mid;
            if (temp.compareTo(num) < 0) left = mid.add(BigInteger.valueOf(1));
            else right = mid.subtract(BigInteger.valueOf(1));
        }
        return BigInteger.valueOf(-1);
    }

    public String smallestGoodBase(String s) {
        BigInteger num = new BigInteger("0");
        for (int i = 0; i < s.length(); i++)
            num = num.multiply(BigInteger.valueOf(10)).add(BigInteger.valueOf(s.charAt(i) - '0'));
        for (int i = 64; i >= 2; i--) {
            BigInteger result = checkFoundBase(i, num);
            if (!result.equals(BigInteger.valueOf(-1))) {
                return result.toString();
            }
        }
        return "-1";
    }

    public static void main(String[] args) {
        SmallestGoodBase solution = new SmallestGoodBase();
        System.out.println(solution.smallestGoodBase("363007"));
    }
}
