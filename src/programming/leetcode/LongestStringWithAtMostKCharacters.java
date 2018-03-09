package programming.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by quuynh on 07/06/17.
 */
public class LongestStringWithAtMostKCharacters {
    public int lengthOfLongestSubstringKDistinct2(String s, int k) {
        Map<Character, Integer> countMap = new HashMap<>();
        if (s.isEmpty() || k == 0) return 0;
        int result = 1, first = 0, last = 0, n = s.length();
        countMap.put(s.charAt(first), 1);
        while (last < n - 1) {
            while (last < n - 1 && (countMap.keySet().size() < k || (countMap.keySet().size() == k && countMap.containsKey(s.charAt(last + 1))))) {
                last++;
                if (!countMap.containsKey(s.charAt(last))) countMap.put(s.charAt(last), 0);
                countMap.put(s.charAt(last), countMap.get(s.charAt(last)) + 1);
            }
            result = Math.max(result, last - first + 1);
            countMap.put(s.charAt(first), countMap.get(s.charAt(first)) - 1);
            if (countMap.get(s.charAt(first)) == 0) countMap.remove(s.charAt(first));
            first++;
        }
        return result;
    }

    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        int countCharacters[] = new int[257];
        int n = s.length();
        if (n == 0 || k == 0) return 0;
        int result = 1, first = 0, last = 0, countDistinct = 1;
        countCharacters[s.charAt(first)] = 1;
        while (last < n - 1) {
            last++;
            countCharacters[s.charAt(last)]++;
            if (countCharacters[s.charAt(last)] == 1) countDistinct++;
            while (countDistinct > k) {
                countCharacters[s.charAt(first)]--;
                if (countCharacters[s.charAt(first)] == 0) countDistinct--;
                first++;
            }
            result = Math.max(result, last - first + 1);
        }
        return result;
    }

    public static void main(String args[]) {
        LongestStringWithAtMostKCharacters solution = new LongestStringWithAtMostKCharacters();
        System.out.println(solution.lengthOfLongestSubstringKDistinct("eceba", 2));
    }
}
