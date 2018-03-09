package programming.leetcode;

import java.util.*;

public class RedundantConnectionII {
    public int[] findRedundantDirectedConnection(int[][] edges) {
        Map<Integer, Set<Integer>> edgeMap = new HashMap<>();
        int n = edges.length;
        for(int i = 1; i<=n; i++) edgeMap.put(i, new HashSet<>());
        int[] degree = new int[n + 1];
        for(int[] edge : edges) {
            int u = edge[0], v = edge[1];
            edgeMap.get(u).add(v);
            degree[v]++;
        }
        for(int i = n - 1; i >= 0; i--) {
            //try to remove edge u, v
            int u = edges[i][0], v = edges[i][1];
            edgeMap.get(u).remove(v);
            degree[v]--;
            if (buildTree(edgeMap, degree, n)) {
                return edges[i];
            }
            //recover
            edgeMap.get(u).add(v);
            degree[v]++;
        }
        return new int[0];
    }

    private boolean buildTree(Map<Integer,Set<Integer>> edgeMap, int[] degree, int n) {
        Deque<Integer> queue = new LinkedList<>();
        int count = 0;
        boolean[] visit = new boolean[n+1];
        for(int i = 1; i <= n; i++) {
            if (degree[i] == 0) {
                visit[i] = true;
                queue.addLast(i);
                count++;
                break;
            }
        }//end for i
        while(!queue.isEmpty()) {
            int i = queue.removeFirst();
            for(int j : edgeMap.get(i)) if (!visit[j]) {
                count++;
                visit[j] = true;
                queue.addLast(j);
            }
        }//end while
        return count == n;
    }

}
