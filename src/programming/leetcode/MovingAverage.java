package programming.leetcode;

import java.util.Deque;
import java.util.LinkedList;

public class MovingAverage {
    private Deque<Integer> queue;
    private double sum;
    private int capacity;

    public MovingAverage(int size) {
        this.sum = 0;
        this.capacity = size;
        this.queue = new LinkedList<>();
    }

    public double next(int val) {
        if (queue.size() == capacity) {
            sum -= queue.removeFirst();
        }
        sum += val;
        queue.addLast(val);
        return sum / queue.size();
    }

}
