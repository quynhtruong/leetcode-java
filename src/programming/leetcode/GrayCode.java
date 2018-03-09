package programming.leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by quuynh on 17/07/17.
 */
public class GrayCode {
    public List<Integer> grayCode(int n) {
        Set<Integer> visited = new HashSet<>();
        List<Integer> result = new ArrayList<>();
        result.add(0);
        visited.add(0);
        if (n == 0) return result;
        while (result.size() < (1 << n)) {
            int top = result.get(result.size() - 1);
            for (int i = 0; i < n; i++) {
                int newNum = top ^ (1 << i);
                if (!visited.contains(newNum)) {
                    visited.add(newNum);
                    result.add(newNum);
                    break;
                }
            }
        }
        return result;
    }

}
