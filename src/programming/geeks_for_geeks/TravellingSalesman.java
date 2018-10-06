package programming.geeks_for_geeks;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class TravellingSalesman {
    public static int result;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int test  = scanner.nextInt();
        while(test > 0) {
            test--;
            int n = scanner.nextInt();
            int[][] cost = new int[n][n];
            for(int i = 0 ; i < n; i++) {
                for(int j = 0; j < n; j++) {
                    cost[i][j]  = scanner.nextInt();
                }
            }//end for i
            System.out.println(solve(n, cost));
        }
    }

    public static int solve(int n, int[][] cost) {
        if (n <= 1) return 0;
        int minCost = Integer.MAX_VALUE;
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) if (i != j) {
                minCost = Math.min(minCost, cost[i][j]);
            }
        }
        result = Integer.MAX_VALUE;
        List<Integer> path = new ArrayList<>();
        boolean[] free = new boolean[n];
        Arrays.fill(free, true);
        free[0] = false;
        path.add(0);
        int currentCost = 0;
        trySolve(path, n, currentCost, minCost, cost, free);
        return result;
    }

    public static void trySolve(List<Integer> path, int n, int currentCost, int minCost, int[][] cost, boolean[] free) {
        int top = path.get(path.size()  - 1);
        for(int i = 0; i < n; i++) {
            if (free[i] && currentCost + cost[top][i] + (n - path.size()) * minCost < result) {
                free[i]  = false;
                path.add(i);
                currentCost += cost[top][i];
                if (path.size() == n) {
                    if (currentCost + cost[i][0] < result) {
                        result = currentCost + cost[i][0];
                    }
                } else trySolve(path, n, currentCost, minCost, cost, free);
                free[i]  = true;
                path.remove(path.size() - 1);
                currentCost -= cost[top][i];
            }
        }//end for i
    }

}
