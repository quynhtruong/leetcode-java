package programming.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by quuynh on 16/07/17.
 */
public class GenerateParenthesis {
    private List<String> result = new ArrayList<>();

    private void generate(int pos, char[] currentResult, int countOpen, int countClose, int n) {
        if (pos == 2 * n) {
            if (countOpen == countClose) result.add(String.valueOf(currentResult));
        } else {
            currentResult[pos] = '(';
            generate(pos + 1, currentResult, countOpen + 1, countClose, n);
            if (countOpen > countClose) {
                currentResult[pos] = ')';
                generate(pos + 1, currentResult, countOpen, countClose + 1, n);
            }
        }
    }

    public List<String> generateParenthesis(int n) {
        if (n == 0) return result;
        char[] currentResult = new char[2 * n];
        generate(0, currentResult, 0, 0, n);
        return result;
    }

}
