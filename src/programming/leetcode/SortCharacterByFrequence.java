package programming.leetcode;

import java.util.*;

/**
 * Created by quuynh on 18/07/17.
 */
class CharNode implements Comparable<CharNode> {
    public char val;
    public int frequence;

    public CharNode(char val, int frequence) {
        this.val = val;
        this.frequence = frequence;
    }

    public int compareTo(CharNode that) {
        return Integer.compare(that.frequence, this.frequence);
    }
}

public class SortCharacterByFrequence {
    public String frequencySort(String s) {
        int[] countFrequence = new int[257];
        int n = s.length();
        for (int i = 0; i < n; i++) countFrequence[s.charAt(i)]++;
        List<CharNode> nodeList = new ArrayList<>();
        for (int i = 0; i < 257; i++)
            if (countFrequence[i] > 0) {
                nodeList.add(new CharNode((char) i, countFrequence[i]));
            }
        Collections.sort(nodeList);
        StringBuilder result = new StringBuilder();
        for (CharNode node : nodeList) {
            for (int i = 0; i < node.frequence; i++) result.append(node.val);
        }
        return result.toString();
    }

}
