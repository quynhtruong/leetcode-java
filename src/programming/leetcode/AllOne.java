package programming.leetcode;

import java.util.*;

public class AllOne {
    Map<String, Integer> keyMap;
    TreeMap<Integer, Set<String>> valueMap;

    public AllOne() {
        keyMap = new HashMap<>();
        valueMap = new TreeMap<>();
    }

    /**
     * Inserts a new key <Key> with value 1. Or increments an existing key by 1.
     */
    public void inc(String key) {
        Integer value = keyMap.get(key);
        //remove the old value in value map
        if (value != null) {
            valueMap.get(value).remove(key);
            if (valueMap.get(value).isEmpty()) {
                valueMap.remove(value);
            }
        } else {
            value = 0;
        }
        value += 1;
        keyMap.put(key, value);
        if (valueMap.get(value) == null) valueMap.put(value, new HashSet<>());
        valueMap.get(value).add(key);
    }

    /**
     * Decrements an existing key by 1. If Key's value is 1, remove it from the data structure.
     */
    public void dec(String key) {
        Integer value = keyMap.get(key);
        if (value != null) {
            //remove old key
            valueMap.get(value).remove(key);
            if (valueMap.get(value).isEmpty()) {
                valueMap.remove(value);
            }
            if (value > 1) {
                value -= 1;
                keyMap.put(key, value);
                if (valueMap.get(value) == null) valueMap.put(value, new HashSet<>());
                valueMap.get(value).add(key);
            } else {
                keyMap.remove(key);
            }
        }
    }

    /**
     * Returns one of the keys with maximal value.
     */
    public String getMaxKey() {
        if (valueMap.isEmpty()) return "";
        Set<String> maxSet = valueMap.get(valueMap.lastKey());
        return maxSet.iterator().next();
    }

    /**
     * Returns one of the keys with Minimal value.
     */
    public String getMinKey() {
        if (valueMap.isEmpty()) return "";
        Set<String> minSet = valueMap.get(valueMap.firstKey());
        System.out.println(valueMap.firstKey());
        System.out.println(minSet);
        return minSet.iterator().next();
    }

    public static void main(String[] args) {
        AllOne solution = new AllOne();
        solution.inc("hello");
        solution.inc("hello");
        System.out.println(solution.getMaxKey());
        System.out.println(solution.getMinKey());
        solution.inc("leet");
        System.out.println(solution.getMaxKey());
        System.out.println(solution.getMinKey());
    }
}
