package programming.leetcode;

public class CompareVersionNumber {
    public int compareVersion(String version1, String version2) {
        String[] tokens1 = version1.split("\\.");
        String[] tokens2 = version2.split("\\.");
        int m = tokens1.length;
        int n = tokens2.length;
        int limit = Math.min(m, n);
        for (int i = 0; i < limit; i++) {
            Integer ver1 = Integer.parseInt(tokens1[i]);
            Integer ver2 = Integer.parseInt(tokens2[i]);
            if (Integer.compare(ver1, ver2) != 0) {
                return Integer.compare(ver1, ver2);
            }
        }// end for i
        while (limit < m) {
            if (Integer.parseInt(tokens1[limit]) > 0) return 1;
            limit++;
        }
        while (limit < n) {
            if (Integer.parseInt(tokens2[limit]) > 0) return -1;
            limit++;
        }
        return 0;
    }

    public static void main(String[] args) {
        CompareVersionNumber solution = new CompareVersionNumber();
        System.out.println(solution.compareVersion("0.1","13.37"));
    }
}
