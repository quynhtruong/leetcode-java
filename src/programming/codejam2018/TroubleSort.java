package programming.codejam2018;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class TroubleSort {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int nTest = scanner.nextInt();
        for (int test = 1; test <= nTest; test++) {
            int n = scanner.nextInt();
            List<Integer> firstList = new ArrayList<>();
            List<Integer> secondList = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                int x = scanner.nextInt();
                if (i % 2 == 0) {
                    firstList.add(x);
                } else {
                    secondList.add(x);
                }
            }
            Collections.sort(firstList);
            Collections.sort(secondList);
            List<Integer> result = new ArrayList<>();
            for (int i = 0; i < firstList.size() && i < secondList.size(); i++) {
                result.add(firstList.get(i));
                result.add(secondList.get(i));
            }
            if (firstList.size() > secondList.size()) {
                for (int i = secondList.size(); i < firstList.size(); i++)
                    result.add(firstList.get(i));
            } else {
                for (int i = firstList.size(); i < secondList.size(); i++) {
                    result.add(secondList.get(i));
                }
            }
            String resultStr = "OK";
            for (int i = 0; i < result.size() - 1; i++) {
                if (result.get(i) > result.get(i+1)) {
                    resultStr = ""+i;
                    break;
                }
            }
            System.out.println("Case #" + test + ": " + resultStr);
        }
    }
}
