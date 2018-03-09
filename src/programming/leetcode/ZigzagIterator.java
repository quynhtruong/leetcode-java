package programming.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by quuynh on 07/06/17.
 */
public class ZigzagIterator {

    private List<Integer> mergedList = new ArrayList<>();
    private int top = 0;

    public ZigzagIterator(List<Integer> v1, List<Integer> v2) {
        int minLen = Math.min(v1.size(), v2.size());
        for (int i = 0; i < minLen; i++) {
            mergedList.add(v1.get(i));
            mergedList.add(v2.get(i));
        }
        for (int i = minLen; i < v1.size(); i++) mergedList.add(v1.get(i));
        for (int i = minLen; i < v2.size(); i++) mergedList.add(v2.get(i));
    }

    public int next() {
        return mergedList.get(top++);
    }

    public boolean hasNext() {
        return top < mergedList.size();
    }
}
