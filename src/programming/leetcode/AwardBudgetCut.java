package programming.leetcode;

import java.util.Arrays;

public class AwardBudgetCut {
    static double findGrantsCap(double[] grantsArray, double newBudget) {
        int n = grantsArray.length;
        Arrays.sort(grantsArray);
        if (Double.compare(n * grantsArray[0], newBudget) >= 0) {
            return newBudget / n;
        }
        if (Double.compare(n * grantsArray[n - 1], newBudget) == 0) {
            return grantsArray[n - 1];
        }
        double[] sum = new double[n];
        sum[0] = grantsArray[0];
        for (int i = 1; i < n; i++) {
            sum[i] = sum[i - 1] + grantsArray[i];
        }
        for (int i = 0; i < n - 1; i++) {
            double cap = (newBudget - sum[i]) / (n - i - 1);
            if (cap >= grantsArray[i] && cap <= grantsArray[i + 1]) {
                return cap;
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        double[] input = new double[]{2,100,50,120,167};
        System.out.println(AwardBudgetCut.findGrantsCap(input, 400));
    }
}
