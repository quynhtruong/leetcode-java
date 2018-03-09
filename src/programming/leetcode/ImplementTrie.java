package programming.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by quuynh on 17/07/17.
 */
class TrieNode {
    public char val;
    public boolean isLeaf;
    public List<TrieNode> child;

    public TrieNode(char val) {
        this.val = val;
        this.isLeaf = false;
        this.child = new ArrayList<>();
    }

    public TrieNode find(char ch) {
        int j = 0;
        while (j < child.size() && child.get(j).val != ch) j++;
        if (j >= child.size()) return null;
        return child.get(j);
    }
}

public class ImplementTrie {
    private TrieNode root;

    /**
     * Initialize your data structure here.
     */
    public ImplementTrie() {
        root = new TrieNode('$');
    }

    /**
     * Inserts a word into the trie.
     */
    public void insert(String word) {
        int n = word.length();
        TrieNode node = root;
        for (int i = 0; i < n; i++) {
            char ch = word.charAt(i);
            TrieNode childNode = node.find(ch);
            if (childNode == null) {
                childNode = new TrieNode(ch);
                node.child.add(childNode);
            }
            node = childNode;
        }
        node.isLeaf = true;
    }

    /**
     * Returns if the word is in the trie.
     */
    public boolean search(String word) {
        int n = word.length();
        TrieNode node = root;
        for (int i = 0; i < n; i++) {
            char ch = word.charAt(i);
            TrieNode childNode = node.find(ch);
            if (childNode == null) return false;
            node = childNode;
        }
        return node.isLeaf;
    }

    /**
     * Returns if there is any word in the trie that starts with the given prefix.
     */
    public boolean startsWith(String prefix) {
        int n = prefix.length();
        TrieNode node = root;
        for (int i = 0; i < n; i++) {
            char ch = prefix.charAt(i);
            TrieNode childNode = node.find(ch);
            if (childNode == null) return false;
            node = childNode;
        }
        return true;
    }
}
