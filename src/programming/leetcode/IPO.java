package programming.leetcode;

import java.util.*;

public class IPO {
    class Pair implements Comparable<Pair> {
        public int p, c;

        public Pair(int p, int c) {
            this.p = p;
            this.c = c;
        }

        public int compareTo(Pair that) {
            return Integer.compare(this.c, that.c);
        }
    }

    public int findMaximizedCapital(int k, int W, int[] Profits, int[] Capital) {
        int n = Profits.length;
        if (n == 0 || k == 0) return 0;
        List<Pair> pairList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            pairList.add(new Pair(Profits[i], Capital[i]));
        }
        Collections.sort(pairList);
        PriorityQueue<Integer> queue = new PriorityQueue<>(new Comparator<Integer>() { //max heap
            public int compare(Integer a, Integer b) {
                return Integer.compare(b, a);
            }
        });
        //initialize
        int limit = 0;
        int result = W;
        while (limit < n && pairList.get(limit).c <= result) {
            queue.offer(pairList.get(limit++).p);
        }
        int currentP = 0;
        while (!queue.isEmpty()) {
            currentP++;
            result += queue.poll();
            if (currentP == k) break;
            while (limit < n && pairList.get(limit).c <= result) {
                queue.offer(pairList.get(limit++).p);
            }
        }
        return result;
    }
}
