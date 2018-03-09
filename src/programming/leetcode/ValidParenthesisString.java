package programming.leetcode;

import java.util.Arrays;

public class ValidParenthesisString {
    public boolean checkValidString(String s) {
        int n = s.length();
        if (n == 0) return true;
        Boolean[][] f = new Boolean[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(f[i], false);
        }
        //initialize
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '*') f[i][i] = true;
        }
        for (int i = 0; i < n - 1; i++) {
            char iChar = s.charAt(i);
            char nextChar = s.charAt(i + 1);
            if ((iChar == '(' || iChar == '*') && (nextChar == ')' || nextChar == '*')) {
                f[i][i + 1] = true;
            }
        }

        for (int j = 2; j < n; j++) {
            for (int i = j - 2; i >= 0; i--) {
                char iCh = s.charAt(i);
                char jCh = s.charAt(j);
                for (int u = i; u < j; u++) {
                    if (f[i][u] && f[u + 1][j]) f[i][j] = true;
                }
                if ((iCh == '(' || iCh == '*') && (jCh == ')' || (jCh == '*')) && f[i + 1][j - 1]) {
                    f[i][j] = true;
                }
                if (iCh == '*' && f[i + 1][j]) f[i][j] = true;
                if (jCh == '*' && f[i][j - 1]) f[i][j] = true;
            }//end for j
        }//end for i
        return f[0][n - 1];
    }

    public static void main(String[] args) {

    }
}
