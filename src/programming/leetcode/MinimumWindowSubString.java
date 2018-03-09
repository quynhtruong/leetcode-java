package programming.leetcode;

/**
 * Created by quuynh on 29/06/17.
 */
public class MinimumWindowSubString {
    public String minWindow(String s, String t) {
        if ("".equals(s) || "".equals(t))
            return "";
        int[] countChar = new int[256];
        int m = s.length();
        int n = t.length();

        int distinct = 0;
        for (int i = 0; i < n; i++) {
            countChar[t.charAt(i)]++;
            if (countChar[t.charAt(i)] == 1) distinct++;
        }

        int[] iteratorChar = new int[255];
        int countDistinct = 0;
        int first = 0, last = 0;
        iteratorChar[s.charAt(0)] = 1;
        if (countChar[s.charAt(0)] == 1) countDistinct++;
        if (countDistinct == distinct) return s.substring(0, 1);
        String result = "";
        while (first <= last) {
            while (countDistinct < distinct && last < m - 1) {
                last++;
                iteratorChar[s.charAt(last)]++;
                if (iteratorChar[s.charAt(last)] == countChar[s.charAt(last)]) countDistinct++;
            }
            if (countDistinct == distinct && ((result.equals("") || (!result.equals("") && result.length() > last - first + 1)))) {
                result = s.substring(first, last + 1);
            }
            iteratorChar[s.charAt(first)]--;
            if (iteratorChar[s.charAt(first)] == countChar[s.charAt(first)] - 1) countDistinct--;
            first++;
        }
        return result;
    }
}
