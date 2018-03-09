package programming.leetcode;

import com.sun.org.apache.xpath.internal.SourceTree;
import org.omg.CORBA.INTERNAL;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ZummaGame {
    int result = Integer.MAX_VALUE;

    List<String> permutations = new ArrayList<>();

    public int findMinStep(String board, String hand) {
        int n = hand.length();
        StringBuilder sb = new StringBuilder();
        boolean[] free = new boolean[n];
        Arrays.fill(free, true);
        buildString(sb, free, hand);
        for (String permutation : permutations) {
            sb = new StringBuilder(board);
            tryInsert(sb, 0, permutation);
        }
        return result > hand.length() ? -1 : result;
    }

    public void tryInsert(StringBuilder sb, int index, String permutation) {
        for (int i = 0; i < sb.length(); i++) {
            if (sb.charAt(i) == permutation.charAt(index) && (i == 0 || sb.charAt(i - 1) != sb.charAt(i))) {
                sb.insert(i, permutation.charAt(index));
                StringBuilder reducer = reduce(sb.toString());
                if (reducer.length() == 0) {
                    result = Math.min(result, index + 1);
                } else if (index < permutation.length() - 1) {
                    tryInsert(reducer, index + 1, permutation);
                }
                sb.deleteCharAt(i);
            }
        }
    }


    public StringBuilder reduce(String s) {
        s = s + "$";
        int n = s.length();
        Character[] stack = new Character[n];
        int top = -1;
        for (int i = 0; i < n; i++) {
            if (top >= 2 && stack[top] != s.charAt(i) && stack[top] == stack[top - 1] && stack[top - 1] == stack[top - 2]) {
                Character ch = stack[top];
                while (top >= 0 && stack[top] == ch) top--;
                stack[++top] = s.charAt(i);
            } else {
                stack[++top] = s.charAt(i);
            }
        }
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < top; i++) result.append(stack[i]);
        return result;
    }


    public void buildString(StringBuilder sb, boolean[] free, String hand) {
        for (int i = 0; i < hand.length(); i++) {
            if (free[i]) {
                sb.append(hand.charAt(i));
                free[i] = false;
                if (sb.length() == hand.length()) permutations.add(sb.toString());
                else buildString(sb, free, hand);
                free[i] = true;
                sb.deleteCharAt(sb.length() - 1);
            }
        }
    }

    public static void main(String[] args) {
        BigInteger number = new BigInteger("345235232523522342342342342342342342423423423");
        BigInteger numbur2 = new BigInteger("345235232523522342342342342342342342423423423");
        System.out.println(number.add(numbur2));
        System.out.println(number);
        //ZummaGame solution = new ZummaGame();
        //System.out.println(solution.findMinStep("RBYYBBRRB", "YRBGB"));
    }

}
