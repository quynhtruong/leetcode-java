package programming.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by quuynh on 14/06/17.
 */
public class SubStringWithConcatenationOfAllWords {
    private boolean checkExist(String s, Map<String, Integer> countMap, int len) {
        int i = 0;
        Map<String, Integer> sMap = new HashMap<>();
        while (i < s.length()) {
            String subS = s.substring(i, i + len);
            if (countMap.get(subS) == null) return false;

            if (sMap.get(subS) == null) sMap.put(subS, 0);
            sMap.put(subS, sMap.get(subS) + 1);
            if (sMap.get(subS)>countMap.get(subS)) return false;

            i += len;
        }
        return true;
    }

    public List<Integer> findSubstring(String s, String[] words) {
        int n = words.length;
        List<Integer> result = new ArrayList<>();
        if (n == 0) return result;
        int totalLen = 0;
        int len = 0;
        Map<String, Integer> countMap = new HashMap<>();
        for (String word : words) {
            totalLen += word.length();
            len = word.length();
            if (countMap.get(word) == null) countMap.put(word, 0);
            countMap.put(word, countMap.get(word) + 1);
        }
        for (int i = 0; i <= s.length() - totalLen; i++) {
            if (checkExist(s.substring(i, i + totalLen), countMap, len)) {
                result.add(i);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        SubStringWithConcatenationOfAllWords solution = new SubStringWithConcatenationOfAllWords();
        String[] words = {"word", "good", "best", "good"};
        List<Integer> result = solution.findSubstring("wordgoodgoodgoodbestword", words);
        for (Integer value : result) System.out.println(value);
    }
}
