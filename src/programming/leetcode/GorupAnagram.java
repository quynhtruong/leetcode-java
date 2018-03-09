package programming.leetcode;

import java.util.*;

/**
 * Created by quuynh on 15/06/17.
 */
public class GorupAnagram {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> anagramMap = new HashMap<>();
        for (String str : strs) {
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String key = String.valueOf(chars);
            if (anagramMap.get(key) == null) anagramMap.put(key, new ArrayList<>());
            anagramMap.get(key).add(str);
        }
        List<List<String>> result = new ArrayList<>();
        for (String key : anagramMap.keySet()) result.add(anagramMap.get(key));
        return result;
    }
}
