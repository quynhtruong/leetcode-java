package programming.leetcode;

import java.nio.charset.CharacterCodingException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class RemoveInvalidParenthese {
    public List<String> removeInvalidParentheses(String s) {
        s = "(" + s + ")";
        int n = s.length();
        int[][] f = new int[n][n];
        for (int j = 0; j < n; j++)
            if (s.charAt(j) == ')') {
                for (int i = j - 1; i >= 0; i--)
                    if (s.charAt(i) == '(') {
                        f[i][j] = 2;
                        for (int u = i + 1; u < j; u++)
                            for (int v = u + 1; v < j; v++) {
                                if (s.charAt(u) == '(' && s.charAt(v) == ')' )
                                    f[i][j] = Math.max(f[i][j], f[u][v] + 2);
                                if (i != 0 && j != n - 1 && s.charAt(u) == ')' && s.charAt(v) == '(')
                                    f[i][j] = Math.max(f[i][j], f[i][u] + f[v][j]);
                            }
                    }
            }
        Set<String> resultSet = buildResult(0, n - 1, f, s);
        List<String> result = new ArrayList<>();
        for (String value : resultSet)
            if (value.length() > 2)
                result.add(value.substring(1, value.length() - 1));
        if (result.isEmpty()) result.add("");
        return result;
    }

    private Set<String> buildResult(int i, int j, int[][] f, String s) {
        Set<String> result = new HashSet<>();
        if (f[i][j] == 2) {
            StringBuilder sb = new StringBuilder();
            sb.append(s.charAt(i));
            for (int u = i + 1; u < j; u++) if (Character.isLetter(s.charAt(u))) sb.append(s.charAt(u));
            sb.append(s.charAt(j));
            result.add(sb.toString());
        } else {
            for (int u = i + 1; u < j; u++)
                for (int v = u + 1; v < j; v++) {
                    if (f[i][j] == f[u][v] + 2) {
                        Set<String> midResult = buildResult(u, v, f, s);
                        StringBuilder left = new StringBuilder();
                        for (int t = i + 1; t < u; t++) if (Character.isLetter(s.charAt(t))) left.append(s.charAt(t));
                        StringBuilder right = new StringBuilder();
                        for (int t = v + 1; t < j; t++) if (Character.isLetter(s.charAt(t))) right.append(s.charAt(t));
                        for (String value : midResult)
                            result.add(s.charAt(i) + left.toString() + value + right.toString() + s.charAt(j));
                    }
                    if (i != 0 && j != s.length() - 1 && s.charAt(u) == ')' && s.charAt(v) == '(' && f[i][j] == f[i][u] + f[v][j] && f[i][u] > 0 && f[v][j] > 0) {
                        Set<String> left = buildResult(i, u, f, s);
                        StringBuilder middle = new StringBuilder();
                        for (int t = u + 1; t < v; t++) if (Character.isLetter(s.charAt(t))) middle.append(s.charAt(t));
                        Set<String> right = buildResult(v, j, f, s);
                        for (String leftValue : left)
                            for (String rightValue : right) result.add(leftValue + middle.toString() + rightValue);
                    }
                }
        }
        return result;
    }

    public static void main(String[] args) {
        RemoveInvalidParenthese solution = new RemoveInvalidParenthese();
        List<String> result = solution.removeInvalidParentheses("()())()");
        for (String value : result) System.out.println(value);
    }

}
