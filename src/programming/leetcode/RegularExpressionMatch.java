package programming.leetcode;


import java.util.Arrays;

public class RegularExpressionMatch {


    public boolean isMatch(String s, String p) {
        s = "$" + s;
        p = "$" + p;
        int n = s.length();
        int m = p.length();
        boolean[][] f = new boolean[n][m];
        for (int i = 0; i < n; i++) Arrays.fill(f[i], false);
        f[0][0] = true;
        for (int i = 2; i < m; i++) {
            if (p.charAt(i) == '*' && f[0][i - 2]) f[0][i] = true; //zero time
        }
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                char sch = s.charAt(i);
                char pch = p.charAt(j);
                if (sch == pch) {
                    f[i][j] = f[i - 1][j - 1];
                } else if (pch == '.') {
                    f[i][j] = f[i - 1][j - 1];
                } else if (pch == '*') {
                    //zero time
                    if (j > 1 && f[i][j - 2]) f[i][j] = true;
                    //one time
                    if (j > 1 && (sch == p.charAt(j - 1) || p.charAt(j - 1) == '.') && f[i - 1][j - 2]) f[i][j] = true;
                    //more than one time
                    if (sch == p.charAt(j - 1)) { //first case: previous char is not .
                        int index = i - 1;
                        while (index >= 0 && s.charAt(index) == sch) {
                            if (index > 0 && j > 1 && f[index - 1][j - 2]) f[i][j] = true;
                            index--;
                        }//end while index
                    } else if (p.charAt(j - 1) == '.') {                    //second case
                        for (int index = i - 1; index >= 0; index--) if (f[index][j - 2]) f[i][j] = true;
                    }

                }
            } //end for j
        }//end for i
        return f[n - 1][m - 1];
    }


}
