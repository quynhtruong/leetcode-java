package programming.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by quuynh on 16/07/17.
 */
public class CloneGraph {


    Map<UndirectedGraphNode, UndirectedGraphNode> nodeMap = new HashMap<>();

    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if (node == null) return null;
        UndirectedGraphNode result = nodeMap.get(node);
        if (result == null) {
            result = new UndirectedGraphNode(node.label);
            nodeMap.put(node, result);
            for (UndirectedGraphNode neighbor : node.neighbors) {
                result.neighbors.add(cloneGraph(neighbor));
            }
        }
        return result;
    }

}
