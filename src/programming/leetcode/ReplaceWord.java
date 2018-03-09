package programming.leetcode;

import java.util.ArrayList;
import java.util.List;

public class ReplaceWord {
    class TrieNode {
        char value;
        boolean isLeaf = false;
        List<TrieNode> children = new ArrayList<>();

        public TrieNode(char value) {
            this.value = value;
            this.children = new ArrayList<>();
            this.isLeaf = false;
        }

        public TrieNode find(char value) {
            for (TrieNode child : children) {
                if (child.value == value) return child;
            }
            return null;
        }

    }

    public TrieNode root = new TrieNode('*');

    public String replaceWords(List<String> dict, String sentence) {
        StringBuilder result = new StringBuilder();
        //build trie
        for (String word : dict) {
            TrieNode node = root;
            for (int i = 0; i < word.length(); i++) {
                TrieNode child = node.find(word.charAt(i));
                if (child == null) {
                    child = new TrieNode(word.charAt(i));
                    node.children.add(child);
                }
                node = child;
            }//end for i
            node.isLeaf = true;
        }

        String[] tokens = sentence.split(" ");
        for (String token : tokens) {
            int n = token.length();
            TrieNode node = root;
            int i;
            for (i = 0; i < n; i++) {
                TrieNode child = node.find(token.charAt(i));
                if (child != null) {
                    if (child.isLeaf) {
                        result.append(token.substring(0, i + 1)).append(" ");
                        break;
                    }
                    node = child;
                } else {
                    result.append(token).append(" ");
                    break;
                }
            }
            if (i == n) result.append(token).append(" ");
        }
        return result.toString().trim();
    }
}
