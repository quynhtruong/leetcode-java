package programming.leetcode;

import java.util.HashSet;
import java.util.Set;

public class FirstUniqueCharacter {
    public int firstMissingPositive(int[] arr) {
        int n = arr.length;
        Set<Integer> numSet = new HashSet<>();
        for(int num: arr) numSet.add(num);
        for(int i = 1; i <= n; i++) {
            if (!numSet.contains(i)) {
                return i;
            }
        }
        return n + 1;
    }
}
