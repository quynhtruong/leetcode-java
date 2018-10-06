package programming.codility;

/**
 * Created by truongq on 5/5/18.
 */
public class NumberOfOneDigits {
    /*
    1 -> 10: 1
    10 -> 20: 11
    100 -> 200: 120
    1000 -> 2000: 1300
    10000 -> 20000: 14000
    100000 -> 200000: 150000
    1000000 -> 2000000: 1600000
    10000000 -> 20000000: 17000000
 */
//    public static int[] digits = new int[]{0, 1, 11, 120, 1300, 14000, 150000, 1600000, 17000000};

    public static int[] digitsWithLength = new int[]{0, 1, 19, 280, 3700, 46000, 550000, 6400000, 73000000};

    public int solution(int n) {
        int len = String.valueOf(n).length();
        int result = 0;
        for (int i = 0; i < len; i++) result += digitsWithLength[i];
        for (int i = (int) Math.pow(10, len - 1); i <= n; i++) {
            result += count(i);
        }
        return result;
    }

    public static int count(int n) {
        int result = 0;
        while (n != 0) {
            if (n % 10 == 1) result++;
            n /= 10;
        }
        return result;
    }

/*
    public int countDigit(int n) {
        if (n < 10) return n >= 1 ? 1 : 0;
        int len = String.valueOf(n).length();
        int firstDigit = n / ((int) Math.pow(10, len - 1));
        System.out.println("This is first digit " + firstDigit + " " + (n - ((int) Math.pow(10, len - 1))));
        if (firstDigit == 1) {
            return n - ((int) Math.pow(10, len - 1)) + 1 + countDigit(n - ((int) Math.pow(10, len - 1)));
        } else {
            return digits[len] + countDigit(n - firstDigit * ((int) Math.pow(10, len - 1)));
        }
    }

*/

    public static void main(String[] args) {

        NumberOfOneDigits solution = new NumberOfOneDigits();
        int n = 9999799;
        System.out.println(solution.solution(n));
        int result = 0;
        for (int i = 0; i <= n; i++) result += count(i);
        System.out.println(result);

        /*
            1 -> 10: 1
            10 -> 20: 11
            100 -> 200: 120
            1000 -> 2000: 1300
            10000 -> 20000: 14000
            100000 -> 200000: 150000
            1000000 -> 2000000: 1600000
            10000000 -> 20000000: 17000000

        int result = 0;
        for (int i = 1000000; i < 2000000; i++) result += count(i);
        System.out.println(result);
        */
    }

}
