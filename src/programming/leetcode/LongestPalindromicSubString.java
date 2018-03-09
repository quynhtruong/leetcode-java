package programming.leetcode;

import static java.lang.Math.max;

/**
 * Created by quuynh on 26/05/17.
 */
public class LongestPalindromicSubString {


    public String longestPalindrome(String s) {
        int n = s.length();
        boolean[][] f = new boolean[1001][1001];
        int resultLen = 0;
        for (int i = 0; i < n; i++) {
            f[i][i] = true;
            f[i + 1][i] = true;
        }
        for (int j = 0; j < n; j++)
            for (int i = j - 1; i >= 0; i--)
                if (s.charAt(i) == s.charAt(j) && f[i + 1][j - 1]) {
                    f[i][j] = true;
                    resultLen = max(resultLen, j - i + 1);
                }
        for (int i = 0; i < n; i++)
            for (int j = i; j < n; j++)
                if (f[i][j] && resultLen == j - i + 1) {
                    return s.substring(i, j + 1);
                }
        return s.substring(0, 1);
    }

    public String longestPalindrome2(String s) {
        int n = s.length();
        if (n == 0) return "";
        int left = 0, right = 0;
        for (int i = 0; i < n; i++) {
            int l = i;
            int r = i;
            while (l > 0 && r < n - 1 && s.charAt(l - 1) == s.charAt(r + 1)) {
                l--;
                r++;
            }
            if (r - l > right - left) {
                right = r;
                left = l;
            }
            if (i < n - 1 && s.charAt(i) == s.charAt(i + 1)) {
                l = i;
                r = i + 1;
                while (l > 0 && r < n - 1 && s.charAt(l - 1) == s.charAt(r + 1)) {
                    l--;
                    r++;
                }
                if (r - l > right - left) {
                    right = r;
                    left = l;
                }
            }
        }
        return s.substring(left, right + 1);
    }

    public static void main(String[] args) {
        LongestPalindromicSubString solution = new LongestPalindromicSubString();
        System.out.println(solution.longestPalindrome("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaabcaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa"));
    }

}
