package programming.leetcode;


import java.util.Arrays;

public class RegularExpressionMatch {


    public boolean isMatch2(String s, String p) {
        s = "$" + s;
        p = "$" + p;
        int n = s.length();
        int m = p.length();
        boolean[][] f = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            Arrays.fill(f[i], false);
        }
        f[0][0] = true;
        for (int i = 2; i < m; i += 2) {
            if (p.charAt(i) == '*' && p.charAt(i - 1) != '*' && f[0][i - 2]) f[0][i] = true; // "" and "c*c*"
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
                    int index = j;
                    while (index >= 0 && p.charAt(index) == '*') index--;
                    if (index >= 0) {
                        if (p.charAt(index) == '.') {
                            if (index == 1) f[i][j] = true; //match whatever
                            else if (index > 0) {
                                for (int u = 0; u <= i; u++) if (f[u][index - 1]) f[i][j] = true;
                            }
                        }
                        if (index > 0 && f[i][index - 1]) f[i][j] = true; //zero times
                        if (index > 0 && f[i - 1][index - 1] && p.charAt(index) == sch) f[i][j] = true;//one time
                        if (index > 0 && f[i - 1][index + 1] && s.charAt(i - 1) == sch && p.charAt(index) == sch)
                            f[i][j] = true; //one more time
                    }
                }
            }// end for j
        } // end for i
        return f[n - 1][m - 1];
    }

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
                    } else if (p.charAt(j - 1) == '.') {//second case
                        for (int index = i - 1; index >= 0; index--) if (f[index][j - 2]) f[i][j] = true;
                    }

                }
            } //end for j
        }//end for i
        return f[n - 1][m - 1];
    }

    public static void main(String[] args) {
        RegularExpressionMatch solution = new RegularExpressionMatch();

//        System.out.println(solution.isMatch("aa", "a"));
//        System.out.println(solution.isMatch("aa", "aa"));
//        System.out.println(solution.isMatch("aaa", "aa"));
//        System.out.println(solution.isMatch("aa", "a*"));
//        System.out.println(solution.isMatch("aa", ".*"));
//        System.out.println(solution.isMatch("ab", ".*"));
//        System.out.println(solution.isMatch("aab", "c*a*b"));
//        System.out.println(solution.isMatch("aaa", "ab*a"));
//        System.out.println(solution.isMatch("aab", "b.*"));
//        System.out.println(solution.isMatch("", "c*c*"));
        System.out.println(solution.isMatch("b", "b*"));

    }


}
