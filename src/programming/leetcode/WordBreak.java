package programming.leetcode;

import java.util.Arrays;
import java.util.List;

/**
 * Created by quuynh on 12/06/17.
 */
public class WordBreak {
    public static boolean wordBreak(String s, List<String> wordDict) {
        s = "$" + s;
        int n = s.length();
        boolean[] f = new boolean[n];
        f[0] = true;
        for (int i = 1; i < n; i++)
            for (String word : wordDict) {
                if (i >= word.length() && f[i - word.length()] && s.substring(i - word.length() + 1, i + 1).equals(word)) {
                    f[i] = true;
                }
            }
        return f[n - 1];
    }

    public static void main(String[] args) {
        List<String> wordDict = Arrays.asList("leet", "code");
        System.out.println(wordBreak("leetcode", wordDict));
    }
}
