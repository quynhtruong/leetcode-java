package programming.leetcode;

import java.util.*;

/**
 * Created by truongq on 6/10/18.
 */
public class LoudAndRich {
	public int[] loudAndRich(int[][] richer, int[] quiet) {
		int n = quiet.length;
		Map<Integer, Set<Integer>> edge = new HashMap<>();
		for(int i = 0; i < n; i++) edge.put(i, new HashSet<>());
		for(int[] rich: richer) {
			edge.get(rich[1]).add(rich[0]);
		}
		int[] result = new int[n];
		for (int i = 0; i < n; i++) {
			result[i] = bfs(i, n, quiet, edge);
		}
		return result;
	}

	private int bfs(int  start, int n, int[] quiet, Map<Integer, Set<Integer>> edge) {
		Deque<Integer> queue = new LinkedList<>();
		boolean[] visited = new boolean[n];
		visited[start] = true;
		queue.addLast(start);
		int result = start;
		while(!queue.isEmpty()) {
			int i = queue.removeFirst();
			if (quiet[i] < quiet[result]) {
				result = i;
			}
			for(int j : edge.get(i)) if (!visited[j]) {
				visited[j] = true;
				queue.addLast(j);
			}
		}
		return result;
	}
}
