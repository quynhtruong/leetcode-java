package programming.leetcode;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 * Created by quuynh on 16/07/17.
 */
class CacheNode {
    public Integer key, value;

    public CacheNode(Integer key, Integer value) {
        this.key = key;
        this.value = value;
    }
}

public class LRUCache {

    class ListNode {
        public int key, value;
        public ListNode prev, next;

        public ListNode(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    private ListNode head, tail;
    private int capacity, currentTime, nNodes;
    private Map<Integer, ListNode> timeNodeMap;
    private Map<Integer, Integer> keyTimeMap;

    public void add(int time, int key, int value) {
        ListNode newNode = new ListNode(key, value);
        timeNodeMap.put(time, newNode);
        keyTimeMap.put(key, time);
        tail.next = newNode;
        newNode.prev = tail;
        tail = newNode;
        nNodes++;
    }

    public void remove(int time) {
        ListNode node = timeNodeMap.get(time);
        if (node != null) {
            nNodes--;
            ListNode prevNode = node.prev;
            prevNode.next = node.next;
            if (node.next != null) node.next.prev = prevNode;
            if (node == tail) tail = prevNode;
            int key = node.key;
            keyTimeMap.remove(key);
            timeNodeMap.remove(time);
        }
    }

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.currentTime = 0;
        this.timeNodeMap = new HashMap<>();
        this.keyTimeMap = new HashMap<>();
        this.head = new ListNode(-1, -1);
        this.tail = this.head;
    }

    public int get(int key) {
        Integer time = keyTimeMap.get(key);
        if (time == null) return -1;
        Integer value = timeNodeMap.get(time).value;
        remove(time);
        currentTime++;
        add(currentTime, key, value);
        return value;
    }

    public void put(int key, int value) {
        Integer time = keyTimeMap.get(key);
        if (time != null) {
            remove(time);
        }
        currentTime++;
        add(currentTime, key, value);
        if (nNodes > capacity) {
            ListNode removedNode = head.next;
            remove(keyTimeMap.get(removedNode.key));
        }
    }


    /* private Map<Integer, Integer> keyMap = new HashMap<>();
     private TreeMap<Integer, CacheNode> valueMap = new TreeMap<>(new Comparator<Integer>() {
         public int compare(Integer i1, Integer i2) {
             return Integer.compare(i1, i2);
         }
     });

     private Integer timeStamp = 0;
     private int capacity = 0;

     public LRUCache(int capacity) {
         this.capacity = capacity;
     }

     public int get(int key) {
         Integer time = keyMap.get(key);
         if (time == null) return -1;
         Integer value = valueMap.get(time).value;
         valueMap.remove(time);
         timeStamp++;
         keyMap.put(key, timeStamp);
         valueMap.put(timeStamp, new CacheNode(key, value));
         return value;
     }

     public void put(int key, int value) {
         if (keyMap.containsKey(key)) {
             Integer time = keyMap.get(key);
             keyMap.remove(key);
             valueMap.remove(time);
             timeStamp++;
             keyMap.put(key, timeStamp);
             valueMap.put(timeStamp, new CacheNode(key, value));
         } else {
             //add
             timeStamp++;
             keyMap.put(key, timeStamp);
             valueMap.put(timeStamp, new CacheNode(key, value));
             if (keyMap.size() > this.capacity) {
                 Integer removedTime = valueMap.firstKey();
                 Integer removedKey = valueMap.get(removedTime).key;
                 valueMap.remove(removedTime);
                 keyMap.remove(removedKey);
             }
         }
     }*/
    public static void main(String[] args) {
        Integer a = 5;
        System.out.println(a/2);
/*
        cache.put(1, 1);
        cache.put(2, 2);
        cache.get(1);       // returns 1
        cache.put(3, 3);    // evicts key 2
        cache.get(2);       // returns -1 (not found)
        cache.put(4, 4);    // evicts key 1
        cache.get(1);       // returns -1 (not found)
        cache.get(3);       // returns 3
        cache.get(4);       // returns 4
*/
    }
}
