package programming.leetcode;

import java.util.TreeSet;

public class TreeSetExample {
    public static void main(String[] args) {
        TreeSet<String> ts = new TreeSet();

        // Add elements to the tree set
        ts.add("C");
        ts.add("A");
        ts.add("B");
        ts.add("E");
        ts.add("F");
        ts.add("D");
        System.out.println(ts.first());
        System.out.println(ts.last());

        for (Object t : ts)
        {
            System.out.println(t);
        }
    }
}
