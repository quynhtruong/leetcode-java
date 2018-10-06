package programming.leetcode;

import java.util.*;

/**
 * Created by quuynh on 17/07/17.
 */

public class LFUCache {
    public Map<Integer, Integer> cache;
    public TreeMap<Integer, LinkedHashSet<Integer>> countKeyMap;
    public Map<Integer, Integer> keyCountMap;
    public int capacity;

    public LFUCache(int capacity) {
        this.capacity = capacity;
        cache = new HashMap<>();
        keyCountMap = new HashMap<>();
        countKeyMap = new TreeMap<>();
    }

    public int get(int key) {
        Integer result = cache.get(key);
        if (result == null) {
            return -1;
        } else {
            increaseCount(key);
            return result;
        }
    }

    private void increaseCount(int key) {
        Integer count = keyCountMap.get(key);
        countKeyMap.get(count).remove(key);
        if (countKeyMap.get(count).isEmpty()) countKeyMap.remove(count);
        count++;
        if (countKeyMap.get(count) == null) countKeyMap.put(count, new LinkedHashSet<>());
        countKeyMap.get(count).add(key);
        keyCountMap.put(key, count);
    }

    public void put(int key, int value) {
        if (cache.get(key) != null) {
            cache.put(key, value);
            increaseCount(key);
        } else if (capacity > 0){
            if (cache.size() == capacity) { //remove
                Integer minCount = countKeyMap.firstKey();
                Integer removedKey = countKeyMap.get(minCount).iterator().next();
                keyCountMap.remove(removedKey);
                cache.remove(removedKey);
                countKeyMap.get(minCount).remove(removedKey);
                if (countKeyMap.get(minCount).isEmpty()) {
                    //System.out.println("Remove all "+ minCount);
                    countKeyMap.remove(minCount);
                }
            }
            cache.put(key, value);
            keyCountMap.put(key, 1);
            LinkedHashSet set = countKeyMap.get(1) != null ? countKeyMap.get(1) : new LinkedHashSet<>();
            set.add(key);
            countKeyMap.put(1, set);
        }
    }

    public static void main(String[] args) {
        LFUCache cache = new LFUCache(2);
        cache.put(1,1);
        cache.put(2,2);
        System.out.println(cache.get(1));
        cache.put(3,3);
        System.out.println(cache.get(2));
        System.out.println(cache.get(3));
        cache.put(4,4);
        System.out.println(cache.get(1));
        System.out.println(cache.get(3));
        System.out.println(cache.get(4));
    }
}

