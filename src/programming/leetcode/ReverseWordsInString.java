package programming.leetcode;

import java.util.ArrayList;
import java.util.List;

public class ReverseWordsInString {
    public String reverseWords(String s) {
        s = ' ' + s + ' ';
        int n = s.length();
        char[] arr = s.toCharArray();
        reverse(arr, 0, n - 1);
        int start = 0;
        for(int i = 1; i < n; i++) if (arr[i] == ' ') {
            reverse(arr, start, i - 1);
            start = i + 1;
        }
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < n; i++) {
            if (arr[i] != ' ' || sb.length() == 0 || sb.charAt(sb.length() - 1) != ' ') {
                sb.append(arr[i]);
            }
        }
        return sb.toString().trim();
    }

    private void reverse(char[] arr, int start, int end) {
        while(start < end) {
            char ch = arr[start];
            arr[start] = arr[end];
            arr[end] = ch;
            start++;
            end--;
        }
    }

    public static void main(String[] args) {
        ReverseWordsInString solution = new ReverseWordsInString();
        System.out.println(solution.reverseWords("the sky is blue"));
    }
}

