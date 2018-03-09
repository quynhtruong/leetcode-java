package programming.leetcode;

public class RepeatedStringMatch {
    class Solution {
        public int repeatedStringMatch(String A, String B) {
            int m = A.length();
            int n = B.length();
            int[] next = new int[n];
            next[0] = -1;
            int j = -1;
            for(int i = 1; i < n; i++) {
                while(j > -1 && B.charAt(i) != B.charAt(j + 1)) j = next[j];
                if (B.charAt(i) == B.charAt(j + 1)) {
                    next[i] = j + 1;
                    j++;
                } else {
                    next[i] = -1;
                }
            }//end for i


            StringBuilder sb = new StringBuilder();
            int result = 0, maxMatch = -1, currentIndex = 0;
            j = -1;
            while(true) {
                sb.append(A);
                result++;
                boolean better = false;
                for(int i = currentIndex; i < sb.length(); i++) {
                    while(j > -1 && sb.charAt(i) != B.charAt(j + 1)) j = next[j];
                    if (sb.charAt(i) == B.charAt(j + 1)) {
                        j++;
                        if (j == n - 1) return result;
                        if (j > maxMatch) {
                            maxMatch = j;
                            better = true;
                        }
                    }
                }//end for i
                if (!better) return -1;
                currentIndex = sb.length();
            }//end while loop
        }
    }
}
