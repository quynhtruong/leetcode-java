/*package programming.codejam2018;

import java.io.*;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int nTest = scanner.nextInt();
        for (int test = 1; test <= nTest; test++) {
            int d = scanner.nextInt();
            String s = scanner.next();
            System.out.println("Case #" + test + ": " + calculate(d, s));
        }                
   }

    public static String calculate(int d, String s) {
        char[] arr = s.toCharArray();
        boolean stop = true;
        int result = 0;
        do {
            stop = true;
            int damage = 0, beam = 1;
            for(int i = 0; i < arr.length; i++) {
                if (arr[i] == 'S') damage += beam;
                else beam *= 2;
                if (damage > d) {
                    stop = false;
                    result++;
                    int j = i;
                    while (j > 0 && arr[j - 1] != 'C') j--;
                    if (j == 0) return "IMPOSSIBLE";
                    //swap
                    char temp = arr[j];
                    arr[j] = arr[j - 1];
                    arr[j - 1] = temp;
                    //System.out.println(arr);
                    break;
                }
            }
        }
        while(!stop);
        return "" + result;
    }
}

*/