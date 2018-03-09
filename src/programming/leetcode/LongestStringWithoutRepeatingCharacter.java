package programming.leetcode;

import java.util.HashMap;
import java.util.Map;

import static java.lang.Math.max;


/**
 * Created by quuynh on 26/05/17.
 */
public class LongestStringWithoutRepeatingCharacter {
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> countMap = new HashMap<>();
        int n = s.length();
        if (n == 0) return 0;
        for (Character character : s.toCharArray()) {
            countMap.put(character, 0);
        }
        countMap.put(s.charAt(0), 1);
        int first = 0, last = 0, result = 1;
        while (last < n - 1) {
            while (last < n - 1 && countMap.get(s.charAt(last + 1)) == 0) {
                last++;
                countMap.put(s.charAt(last), 1);
            }
            result = max(result, last - first + 1);
            countMap.put(s.charAt(first), countMap.get(s.charAt(first)) - 1);
            first++;
        }
        return result;
    }

    public static void main(String[] args) {
        LongestStringWithoutRepeatingCharacter solution = new LongestStringWithoutRepeatingCharacter();
        System.out.println(solution.lengthOfLongestSubstring("pwwkew"));
    }
}
