package programming.leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by truongq on 5/29/18.
 */
public class CountNumberOfComponentInUndirectedGraph {
	public int countComponents(int n, int[][] edges) {
		Map<Integer, Set<Integer>> edgeMap = new HashMap<>();
		for (int i = 0; i < n; i++) edgeMap.put(i, new HashSet<>());
		for (int[] edge : edges) {
			edgeMap.get(edge[0]).add(edge[1]);
			edgeMap.get(edge[1]).add(edge[0]);
		}//end for i
		boolean[] visited = new boolean[n];
		int result = 0;
		for (int i = 0; i < n; i++) {
			if (!visited[i]) {
				result++;
				visit(i, edgeMap, visited);
			}
		}//end for i
		return result;
	}

	private void visit(int i, Map<Integer, Set<Integer>> edgeMap, boolean[] visited) {
		visited[i] = true;
		for (int j : edgeMap.get(i)) {
			if (!visited[j]) {
				visit(j, edgeMap, visited);
			}
		}
	}

}
