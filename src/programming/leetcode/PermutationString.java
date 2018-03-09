package programming.leetcode;

import java.util.Arrays;

public class PermutationString {
    public boolean checkInclusion(String s1, String s2) {
        int m = s1.length();
        int n = s2.length();
        if (m < n) return false;
        int[] countChar = new int[257];
        Arrays.fill(countChar, 0);
        for (int i = 0; i < n; i++) countChar[s2.charAt(i)]++;
        int[] count = new int[257];
        Arrays.fill(count, 0);

        for (int i = 0; i < n - 1; i++) {
            count[s1.charAt(i)]++;
        }

        for (int i = n - 1; i < m; i++) {
            count[s1.charAt(i)]++;
            boolean found = true;
            for (char j = 'a'; j <= 'z'; j++) {
                if (countChar[j] != count[j]) {
                    found = false;
                    break;
                }
            }
            if (found) return true;
            //prepare for next step
            count[s1.charAt(i - n + 1)]--;
        }
        return false;
    }
}
