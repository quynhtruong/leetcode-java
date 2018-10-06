package programming.leetcode;

/**
 * Created by truongq on 5/29/18.
 */
public class RemoveDuplicateLetters {
    public String removeDuplicateLetters(String s) {
        int n = s.length();
        if (n == 0) return s;
        int[] last = new int[257];
        boolean[] free = new boolean[257];
        for (int i = 0; i < n; i++) {
            last[s.charAt(i)] = i;
            if (!free[s.charAt(i)]) {
                free[s.charAt(i)] = true;
            }
        }//end for i
        StringBuilder sb = new StringBuilder();
        int start = 0;
        for (int i = 0; i < n; i++) {
            if (last[s.charAt(i)] == i) {
                boolean stop = false;
                do {
                    stop = true;
                    int minVal = 258, index = -1;
                    for (int j = start; j <= i; j++) {
                        if (free[s.charAt(j)] && minVal < s.charAt(i)) {
                            minVal = s.charAt(i);
                            index = j;
                        }
                    }//end for j
                    if (index != -1) {
                        stop = false;
                        sb.append(s.charAt(index));
                        free[s.charAt(index)] = false;
                        start = index + 1;
                    }
                } while (stop == false);
            }
        }//end for i
        return sb.toString();
    }

}
