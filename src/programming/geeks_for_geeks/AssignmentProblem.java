package programming.geeks_for_geeks;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

class AssignmentProblem {
    public static int[] fx, fy, trace, matchX, matchY;
    public static Deque<Integer> queue;
    public static int n;
    public static int[][] cost;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int test = scanner.nextInt();
        while(test > 0) {
            test--;
            n = scanner.nextInt();
            cost = new int[n][n];
            for(int i = 0; i < n; i++) {
                for(int j = 0; j < n; j++) {
                    cost[i][j] = scanner.nextInt();
                }
            }//end for i
            System.out.println(solve());
        }//end while loop
    }

    public static int solve() {
        init();
        for(int i = 0; i < n; i++) {
            int finish = -1;
            do {
                finish = findPath(i);
                if (finish == -1) {
                    adjustGraph(i);
                } else {
                    incrementPath(finish);
                }
            }
            while(finish == -1);
        }//end for i
        int result = 0;
        for(int i = 0; i< n; i++) if (matchX[i] != -1) {
            result += cost[i][matchX[i]];
        }
        return result;
    }

    public static void init() {
        fx = new int[n];
        fy = new int[n];
        matchX = new int[n];
        matchY = new int[n];
        Arrays.fill(matchX, -1);
        Arrays.fill(matchY, -1);
    }

    public static int findPath(int start) {
        queue = new LinkedList<>();
        trace = new int[n];
        Arrays.fill(trace, -1);
        queue.addLast(start);
        while(!queue.isEmpty()) {
            int i = queue.removeFirst();
            for(int j = 0; j < n; j++) if (trace[j] == -1 && cost[i][j] - fx[i] - fy[j] == 0) {
                trace[j] = i;
                if (matchY[j] == -1) {
                    return j;
                }
                queue.addLast(matchY[j]);
            }
        }//end while loop
        return -1;
    }

    public static void incrementPath(int end) {
        while(end != -1) {
            int x = trace[end];
            int next = matchX[x];
            matchX[x] = end;
            matchY[end] = x;
            end = next;
        }
    }

    public static void adjustGraph(int start) {
        boolean[] visitedX = new boolean[n];
        visitedX[start] = true;
        for(int i = 0; i < n; i++)  if (trace[i] != -1) {
            visitedX[matchY[i]] = true;
        }

        //find delta
        int delta = Integer.MAX_VALUE;
        for(int i = 0; i < n; i++) if (visitedX[i]) {
            for(int j = 0; j < n; j++) if (trace[j] == -1) {
                delta = Math.min(delta, cost[i][j] - fx[i] - fy[j]);
            }
        }//end for i
        for(int i = 0; i < n; i++) {
            if (visitedX[i]) fx[i] += delta;
            if (trace[i] != -1) fy[i] -= delta;
        }
    }
}
