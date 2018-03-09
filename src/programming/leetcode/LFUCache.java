package programming.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by quuynh on 17/07/17.
 */
class LFUCacheNode implements Comparable<LFUCacheNode> {
    public int key, value, count, time;

    public LFUCacheNode(int key, int value, int time) {
        this.key = key;
        this.value = value;
        this.count = 1;
        this.time = time;
    }

    @Override
    public int compareTo(LFUCacheNode that) {
        if (this.count < that.count) return -1;
        if (this.count > that.count) return 1;
        return Integer.compare(this.time, that.time);
    }
}

public class LFUCache {
    private int capacity, timeStamp = 0, nNode = 0;
    private LFUCacheNode[] heap;
    private Map<Integer, Integer> posMap = new HashMap<>();

    public LFUCache(int capacity) {
        this.capacity = capacity;
        this.heap = new LFUCacheNode[capacity + 2];
        this.posMap = new HashMap<>();
    }

    private void swap(int pos, int i, LFUCacheNode[] heap) {
        LFUCacheNode temp = heap[pos];
        heap[pos] = heap[i];
        heap[i] = temp;
        posMap.put(heap[pos].key, pos);
        posMap.put(heap[i].key, i);
    }

    private void upHeap(int pos, LFUCacheNode[] heap) {
        while (pos > 1) {
            int i = pos >> 1;
            if (heap[pos].compareTo(heap[i]) > 0) return;
            swap(pos, i, heap);
            pos = i;
        }
    }

    private void downHeap(int pos, LFUCacheNode[] heap, int nNode) {
        while ((pos << 1) <= nNode) {
            int i = pos << 1;
            if (i < nNode && heap[i].compareTo(heap[i + 1]) > 0) i++;
            if (heap[pos].compareTo(heap[i]) < 0) return;
            swap(pos, i, heap);
            pos = i;
        }
    }

    public int get(int key) {
        Integer pos = posMap.get(key);
        if (pos == null) return -1;
        Integer result = heap[pos].value;
        timeStamp++;
        heap[pos].time = timeStamp;
        heap[pos].count++;
        downHeap(pos, heap, nNode);
        return result;
    }


    public void put(int key, int value) {
        if (capacity == 0) return;
        timeStamp++;
        Integer pos = posMap.get(key);
        if (pos != null) {
            heap[pos].value = value;
            heap[pos].time = timeStamp;
            heap[pos].count++;
            downHeap(pos, heap, nNode);
        } else {
            if (nNode == capacity) {
                swap(1, nNode, heap);
                posMap.remove(heap[nNode].key);
                nNode--;
                downHeap(1, heap, nNode);
            }
            nNode++;
            heap[nNode] = new LFUCacheNode(key, value, timeStamp);
            posMap.put(key, nNode);
            upHeap(nNode, heap);
        }
    }

    public static void main(String[] args) {
        LFUCache cache = new LFUCache(0);
        cache.put(0, 0);
        System.out.println(cache.get(0));
    }
}
