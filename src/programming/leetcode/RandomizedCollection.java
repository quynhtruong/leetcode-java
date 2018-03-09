package programming.leetcode;

import java.util.*;

class RandomizedCollection {

    List<Integer> nums;
    Map<Integer, Set<Integer>> posMap;
    Random random;
    public RandomizedCollection() {
        nums = new ArrayList<>();
        posMap = new HashMap<>();
        random = new Random();
    }

    /**
     * Inserts a value to the collection. Returns true if the collection did not already contain the specified element.
     */
    public boolean insert(int val) {
        Set<Integer> posSet = posMap.get(val);
        if (posSet == null) posSet = new HashSet<>();
        nums.add(val);
        posSet.add(nums.size() - 1);
        posMap.put(val, posSet);
        return posSet.size()  == 1;
    }

    /**
     * Removes a value from the collection. Returns true if the collection contained the specified element.
     */
    public boolean remove(int val) {
        Set<Integer> posSet = posMap.get(val);
        if (posSet == null) return false;
        int removedPos = posSet.iterator().next();
        posSet.remove(removedPos);
        if (posSet.isEmpty()) posMap.remove(val);
        if (removedPos != nums.size() - 1) {
            int lastVal = nums.get(nums.size() - 1);
            posMap.get(lastVal).remove(nums.size() - 1);
            posMap.get(lastVal).add(removedPos);
            nums.set(removedPos, lastVal);
        }
        nums.remove(nums.size() - 1);
        return true;
    }

    /**
     * Get a random element from the collection.
     */
    public int getRandom() {
        return nums.get(random.nextInt(nums.size()));
    }
}

