package programming.geeks_for_geeks;

import java.util.Deque;
import java.util.Iterator;
import java.util.LinkedList;

public class QueueTest {
    public static void main(String[] args) {
        Deque<Integer> queue = new LinkedList<>();
        queue.addLast(10);
        queue.addLast(20);
        queue.addLast(30);
        queue.addLast(40);
        queue.removeFirst();
        queue.removeFirst();
        Iterator<Integer> iterator = queue.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}
