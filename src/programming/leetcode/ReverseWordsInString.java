package programming.leetcode;

import java.util.ArrayList;
import java.util.List;

public class ReverseWordsInString {
    public String reverseWords(String s) {
        s = s.trim();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (sb.length() == 0 || (sb.charAt(sb.length() - 1) != ' ' && s.charAt(i) == ' ')
                    || (s.charAt(i) != ' ')) {
                sb.append(s.charAt(i));
            }
        }
        int n = sb.length();
        if (n == 0) return s;
        char[] arr = sb.toString().toCharArray();
        reverse(arr, 0, n - 1);
        int first = 0, last = 0;
        while (first < n) {
            while (last < n && arr[last] != ' ') last++;
            reverse(arr, first, last - 1);
            first = last + 1;
            last = first;
        }
        return String.valueOf(arr);
    }

    public void reverse(char[] arr, int start, int end) {
        while (start < end) {
            char temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }
}

