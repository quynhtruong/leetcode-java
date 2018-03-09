package programming.leetcode;

import java.util.*;

/**
 * Created by quuynh on 24/06/17.
 */
public class ValidNumber {
    public boolean isNumber(String s) {
        if ("".equals(s.trim())) return false;
        s = s.trim();
        List<String> acceptList = Arrays.asList(".", "e");
        String[] tokens = s.split("\\d");
        Map<String, Integer> positionMap = new HashMap<>();
        for (int i = 0; i < tokens.length; i++)
            if (!"".equals(tokens[i])) {
                String token = tokens[i];
                if (token.length() > 1) return false;
                int j = 0;
                while (j < acceptList.size() && !token.equals(acceptList.get(j))) j++;
                if (j >= acceptList.size()) return false;
                if (positionMap.get(token) != null) return false;
                positionMap.put(token, i);
            }
        Integer ePosition = positionMap.get("e");
        Integer dotPosition = positionMap.get(".");
        if (ePosition != null) {
            if (s.charAt(s.length() - 1) == 'e' || s.charAt(0) == 'e') return false;
        }
        if (dotPosition != null) {
            if (s.charAt(s.length() - 1) == '.') return false;
            if (s.charAt(0) == '.') return true;
            if (ePosition != null) {
                if (ePosition > dotPosition) return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[] countChar = new int[256];
        countChar['A'] = 10;
        System.out.println(countChar['A']);
    }
}
