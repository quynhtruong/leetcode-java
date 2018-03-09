package programming.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by quuynh on 16/07/17.
 */
public class UndirectedGraphNode {
    int label;
    List<UndirectedGraphNode> neighbors;

    UndirectedGraphNode(int x) {
        label = x;
        neighbors = new ArrayList<UndirectedGraphNode>();
    }
}