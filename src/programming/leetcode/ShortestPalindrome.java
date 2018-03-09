package programming.leetcode;

public class ShortestPalindrome {
    public String shortestPalindrome(String s) {
        int n = s.length();
        String reverse = new StringBuilder(s).reverse().toString();
        StringBuilder sb = new StringBuilder(s).append("$").append(reverse);
        int[] next = new int[sb.length()];
        next[0] = -1;
        int j = -1;
        for (int i = 1; i < sb.length(); i++) {
            while (j > -1 && sb.charAt(i) != sb.charAt(j + 1)) j = next[j];
            if (sb.charAt(i) == sb.charAt(j + 1)) {
                next[i] = j + 1;
                j++;
            } else {
                next[i] = -1;
            }
        }//end for i
        return new StringBuilder(s.substring(next[sb.length() - 1] + 1)).reverse().append(s).toString();
    }
}
