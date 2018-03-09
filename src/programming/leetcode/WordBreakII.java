package programming.leetcode;

import java.util.*;

/**
 * Created by quuynh on 12/06/17.
 */
public class WordBreakII {
    private List<String> result = new ArrayList<>();

    private String buildString(List<String> currentResult) {
        StringBuilder sb = new StringBuilder();
        for (int i = currentResult.size() - 1; i >= 0; i--) sb.append(currentResult.get(i)).append(" ");
        return sb.toString().trim();
    }

    private void traceBack(String s, int pos, Map<Integer, List<Integer>> traceMap, List<String> currentResult) {
        if (pos == 0) {
            result.add(buildString(currentResult));
            return;
        }
        List<Integer> tracePosition = traceMap.get(pos);
        for (Integer prePos : tracePosition) {
            currentResult.add(s.substring(prePos + 1, pos + 1));
            traceBack(s, prePos, traceMap, currentResult);
            currentResult.remove(currentResult.size() - 1);
        }
    }

    public List<String> wordBreak(String s, List<String> wordDict) {
        s = "$" + s;
        int n = s.length();
        boolean[] f = new boolean[n];
        Map<Integer, List<Integer>> traceMap = new HashMap<>();
        f[0] = true;
        for (int i = 1; i < n; i++) {
            for (String word : wordDict)
                if (i >= word.length() && f[i - word.length()] && word.equals(s.substring(i - word.length() + 1, i + 1))) {
                    f[i] = true;
                    if (traceMap.get(i) == null) traceMap.put(i, new ArrayList<>());
                    traceMap.get(i).add(i - word.length());
                }
        }
        if (f[n - 1]) {
            traceBack(s, n - 1, traceMap, new ArrayList<String>());
        }
        return result;
    }

    public static void main(String[] args) {
        WordBreakII solution = new WordBreakII();
        List<String> input = Arrays.asList("cat", "cats", "and", "sand", "dog");
        List<String> result = solution.wordBreak("catsanddog", input);
        for (String str : result) System.out.println(str);
    }
}
