package programming.leetcode;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MapSum {

    class TrieNode {
        public char value;
        public int sum;
        public boolean isLeaf;
        public Map<Character, TrieNode> children;
        public TrieNode parent;

        public TrieNode(char value, TrieNode parent) {
            this.value = value;
            this.sum = sum;
            this.parent = parent;
            this.isLeaf = false;
            this.children = new HashMap<>();
        }

        public TrieNode find(char value) {
            return children.get(value);
        }
    }

    public TrieNode root;

    public MapSum() {
        root = new TrieNode('$', null);
    }

    public void insert(String key, int val) {
        TrieNode node = root;
        for (int i = 0; i < key.length(); i++) {
            char ch = key.charAt(i);
            TrieNode child = node.find(ch);
            if (child == null) {
                child = new TrieNode(ch, node);
                node.children.put(ch, child);
            }
            node = child;
        }
        int offset = val;
        if (node.isLeaf) {
            offset = offset - node.sum;
        }
        node.isLeaf = true;
        while (node != root) {
            node.sum += offset;
            node = node.parent;
        }
    }

    public int sum(String prefix) {
        TrieNode node = root;
        for (int i = 0; i < prefix.length(); i++) {
            TrieNode child = node.find(prefix.charAt(i));
            if (child == null) return 0;
            node = child;
        }
        return node.sum;
    }

    public static void main(String[] args) {
        MapSum mapSum = new MapSum();
        mapSum.insert("apple", 3);
        System.out.println(mapSum.sum("ap"));
    }
}
