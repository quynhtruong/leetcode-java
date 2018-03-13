package programming.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StrobogrammaticNumberII {
    public List<String> findStrobogrammatic(int n) {
        Map<Integer, Integer> symetricMap = new HashMap<>();
        symetricMap.put(0,0);
        symetricMap.put(1,1);
        symetricMap.put(6,9);
        symetricMap.put(8,8);
        symetricMap.put(9,6);
        int[] num = new int[n];
        List<String> result = new ArrayList<>();
        build(0, n - 1, num, result, symetricMap);
        return result;
    }

    private void build(int start, int end, int[] num, List<String> result,Map<Integer, Integer> symetricMap) {
        if (start == end) {
            for(Integer key: symetricMap.keySet()) {
                if (symetricMap.get(key) == key) {
                    num[start] = key;
                    addResult(num, result);
                }
            }
        } else {//start != end
            for(Integer key: symetricMap.keySet()) {
                num[start] = key;
                num[end] = symetricMap.get(key);
                if (start == end - 1) {
                    addResult(num, result);
                } else {
                    build(start+1, end - 1, num, result, symetricMap);
                }
            }//end for key
        }
    }

    private void addResult(int[] num, List<String> result) {
        if (num.length > 1 && num[0] == 0) return;
        StringBuilder sb = new StringBuilder();
        for(int value: num) sb.append(value);
        result.add(sb.toString());
    }
}
