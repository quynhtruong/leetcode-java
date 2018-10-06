package programming.viettel;

import java.util.*;

public class GenerateIntervals {

    public static final int boundary = 10;

    class Interval {
        public int start, end;

        public Interval(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    /*
        generate N intervals
     */

    public List<Interval> generateInterval(int n) {
        Map<Integer, Integer> indexMap = new HashMap<>();
        Deque<Integer> queue = new LinkedList<>();

        List<Interval> result = new ArrayList<>();
        Random random = new Random();

        for (int i = 0; i < n; i++) {
            int start = random.nextInt(boundary / 2);
            int end = start + random.nextInt(boundary / 2);
            result.add(new Interval(start, end));
        }
        int negativePercent = 30 + random.nextInt(70);
        int negative = negativePercent * n / 100;
        int counter = 0;

        for (int i = 0; i < negative; i++) {
            int negativeIndex = counter + random.nextInt(n - counter);
            int start = result.get(negativeIndex).start;

            result.get(negativeIndex).start = start - (start + random.nextInt(start + 1));
            result.get(negativeIndex).end = result.get(negativeIndex).start + random.nextInt(boundary);
            Collections.swap(result, counter, negativeIndex);
            counter++;
        }
        Collections.shuffle(result);
        return result;
    }

    public List<Interval> getMaxSeparateIntervals(List<Interval> intervals) {
        intervals.add(new Interval(boundary * 3, boundary * 4));
        int n = intervals.size();
        Collections.sort(intervals, new Comparator<Interval>() {
            @Override
            public int compare(Interval i1, Interval i2) {
                return Integer.compare(i1.start, i2.start);
            }
        });
        int[] f = new int[n];
        Arrays.fill(f, 1);
        int[] trace = new int[n];
        Arrays.fill(trace, -1);
        //dynamic programming
        for (int i = 0; i < n; i++) {
            for (int j = i - 1; j >= 0; j--) {
                if (intervals.get(j).end <= intervals.get(i).start && f[i] < f[j] + 1) {
                    f[i] = f[j] + 1;
                    trace[i] = j;
                }
            }
        }

        List<Interval> result = new ArrayList<>();
        int top = trace[n - 1];
        while (top != -1) {
            result.add(intervals.get(top));
            top = trace[top];
        }

        Collections.sort(result, new Comparator<Interval>() {
            @Override
            public int compare(Interval i1, Interval i2) {
                return Integer.compare(i1.end - i1.start, i2.end - i2.start);
            }
        });
        return result;
    }

    public static void main(String[] args) {
        GenerateIntervals solution = new GenerateIntervals();
        List<Interval> result = solution.generateInterval(12);

        System.out.println("Cau 1:");
        for (Interval interval : result) {
            System.out.println(interval.start + " " + interval.end);
        }

        System.out.println("Cau 2:");
        result = solution.getMaxSeparateIntervals(result);
        for (Interval interval : result) {
            System.out.println(interval.start + " " + interval.end);
        }
    }

}
