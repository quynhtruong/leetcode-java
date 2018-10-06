package programming.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by truongq on 5/29/18.
 */
public class GeneralizedAbbreviation {
    public List<String> generateAbbreviations(String word) {
        int n = word.length();
        List<String> result = new ArrayList<>();
        if (n == 0) return result;
        StringBuilder sb = new StringBuilder();
        visit(sb, 0, word, n, result);
        return result;
    }

    private void visit(StringBuilder sb, int index, String word, int n, List<String> result) {
        if (index >= n) {
            result.add(sb.toString());
            return;
        }
        for (int i = index; i <= n; i++) {
            if (i == index) {
                sb.append(word.charAt(i));
                visit(sb, index + 1, word, n, result);
                sb.deleteCharAt(sb.length() - 1);
            } else {
                int len = sb.length();
                sb.append(i - index + 1);
                if (i == n) {
                    result.add(sb.toString());
                } else {
                    sb.append(word.charAt(i));
                    visit(sb, i + 1, word, n, result);
                }
                sb.delete(len, sb.length());
            }
        }
    }

}
