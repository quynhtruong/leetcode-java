package programming.leetcode;

import java.util.*;

/**
 * Created by quuynh on 09/06/17.
 */
public class LetterCombinationPhoneNumbers {
    private static List<String> charList = Arrays.asList("", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz");
    private List<String> result = new ArrayList<>();

    private void visit(String s, StringBuilder sb, int pos) {
        String value = charList.get(Character.getNumericValue(s.charAt(pos)));
        for (int i = 0; i < value.length(); i++) {
            sb.append(value.charAt(i));
            if (pos == s.length() - 1) {
                result.add(sb.toString());
            } else visit(s, sb, pos + 1);
            sb.deleteCharAt(pos);
        }
    }

    public List<String> letterCombinations(String digits) {
        if (digits.length() == 0) {
            return result;
        }
        StringBuilder sb = new StringBuilder();
        visit(digits, sb, 0);
        return result;
    }

    public static void main(String[] args) {
        LetterCombinationPhoneNumbers solution = new LetterCombinationPhoneNumbers();
        System.out.println(solution.letterCombinations("23").size());
    }
}
