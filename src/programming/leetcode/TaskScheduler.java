package programming.leetcode;

import java.util.*;

public class TaskScheduler {
    class Pair implements Comparable<Pair> {
        public Character ch;
        public Integer count;

        public Pair(Character ch, Integer count) {
            this.ch = ch;
            this.count = count;
        }

        public int compareTo(Pair that) {
            return Integer.compare(that.count, this.count);
        }
    }

    public int leastInterval(char[] tasks, int n) {
        Map<Character, Integer> countMap = new HashMap<>();
        for (char ch : tasks) {
            Integer count = countMap.get(ch);
            if (count == null) count = 0;
            countMap.put(ch, count + 1);
        }
        PriorityQueue<Pair> queue = new PriorityQueue<>();
        for (char ch : countMap.keySet()) {
            queue.offer(new Pair(ch, countMap.get(ch)));
        }
        int result = 0;
        while (!queue.isEmpty()) {
            int time = Math.min(n + 1, queue.size());
            List<Pair> temp = new ArrayList<>();
            for (int i = 0; i < time; i++) {
                temp.add(queue.poll());
            }
            for (Pair pair : temp) {
                if (pair.count > 1) {
                    queue.offer(new Pair(pair.ch, pair.count - 1));
                }
            }
            if (queue.isEmpty()) {
                result += time;
            } else if (time < n + 1) {
                result += n + 1;
            } else {
                result += time;
            }
        }
        return result;
    }
}
