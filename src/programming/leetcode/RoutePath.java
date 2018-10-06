package programming.leetcode;

import java.util.*;

class RoutePath {
    public int numBusesToDestination(int[][] routes, int S, int T) {
        int n = routes.length;
        Set<Integer>[] nodeSet = new Set[n];
        for(int i = 0; i < n; i++) {
            nodeSet[i] = new HashSet<>();
            for(int j: routes[i]) {
                nodeSet[i].add(j);
            }
        }//end for i
        Map<Integer, Set<Integer>> nodeMap  = new HashMap<>();
        for(int i = 0; i < n; i++) {
            for(int j = i + 1; j < n; j++) {
                for(int u: nodeSet[i]) if (nodeSet[j].contains(u)) {
                    add(nodeMap, i, j);
                    add(nodeMap, j, i);
                    break;
                }
            }
        }//end for i
        int[] f = new int[n];
        Arrays.fill(f, n + 1);
        Deque<Integer> queue = new LinkedList<>();
        for(int i =0; i < n; i++) if (nodeSet[i].contains(S)) {
            f[i] = 1;
            if (nodeSet[i].contains(T)) {
                return 1;
            }
            queue.addLast(i);
        }
        while(!queue.isEmpty()) {
            int i = queue.removeLast();
            Set<Integer> set = nodeMap.get(i);
            if (set != null) {
                for(int j: set) {
                    if (f[j] > f[i] + 1) {
                        f[j] = f[i] + 1;
                        if (nodeSet[j].contains(T)) return f[j];
                        queue.addLast(j);
                    }
                }
            }
        }
        return -1;
    }

    private void add(Map<Integer, Set<Integer>> nodeMap, int i, int j) {
        Set<Integer> set = nodeMap.get(i);
        if (set == null) set = new HashSet<>();
        set.add(j);
        nodeMap.put(i, set);
    }
}

