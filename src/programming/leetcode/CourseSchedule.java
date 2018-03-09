package programming.leetcode;

import java.util.*;

public class CourseSchedule {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] degree = new int[numCourses];
        Map<Integer, Set<Integer>> requireMap = new HashMap<>();
        for (int i = 0; i < numCourses; i++) requireMap.put(i, new HashSet<>());
        for (int[] edge : prerequisites) {
            if (!requireMap.get(edge[1]).contains(edge[0])) {
                requireMap.get(edge[1]).add(edge[0]);
                degree[edge[0]]++;
            }
        }//end for edge
        Deque<Integer> queue = new LinkedList<>();
        int count = 0;
        for (int i = 0; i < numCourses; i++) {
            if (degree[i] == 0) {
                count++;
                queue.addLast(i);
            }
        }//end for i
        while (!queue.isEmpty()) {
            int i = queue.removeFirst();
            for (int j : requireMap.get(i)) {
                degree[j]--;
                if (degree[j] == 0) {
                    queue.addLast(j);
                    count++;
                }
            }
        }//end while loop
        return count == numCourses;
    }

}
