package programming.leetcode;

import java.util.ArrayList;
import java.util.List;

public class AllPathFromSourceToTarget {
    private List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        int  n = graph.length;
        List<Integer> temp = new ArrayList<>();
        temp.add(0);
        visit(0, n - 1, graph, temp);
        return result;
    }

    private void visit(int start, int end, int[][] graph, List<Integer> temp) {
        //System.out.println(start+" "+end);
        if (start == end) {
            List<Integer> newReuslt = new ArrayList<>();
            for(Integer value: temp) {
                newReuslt.add(value);
            }
            System.out.println();
            result.add(newReuslt);
        } else {
            for(int i : graph[start]) {
                temp.add(i);
                visit(i, end, graph, temp);
                temp.remove(temp.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
        AllPathFromSourceToTarget solution = new AllPathFromSourceToTarget();
        int[][]graph = {{1,2},{3},{3},{}};
        List<List<Integer>> result = solution.allPathsSourceTarget(graph);
        System.out.println(result.size());
    }
}
