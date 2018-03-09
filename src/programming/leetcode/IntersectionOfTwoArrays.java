package programming.leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class IntersectionOfTwoArrays {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> numSet = new HashSet<>();
        for(int num: nums1) {
            numSet.add(num);
        }
        List<Integer> resultList = new ArrayList<>();
        for(int num: nums2) {
            if (numSet.contains(num)) {
                resultList.add(num);
                numSet.remove(num);
            }
        }
        int[] result = new int[resultList.size()];
        for(int i = 0; i < resultList.size(); i++) result[i] = resultList.get(i);
        return result;
    }

}
