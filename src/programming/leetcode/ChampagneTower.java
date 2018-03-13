package programming.leetcode;

public class ChampagneTower {
    public double champagneTower(int poured, int query_row, int query_glass) {
        if (poured == 0) return 0.0;
        int layer = 0, sum = 0;
        while (sum + layer + 1 <= poured) {
            sum += layer + 1;
            layer++;
        }
        System.out.println(layer);
        if (query_row < layer) {
            return 1.0;
        } else if (query_row > layer) {
            return 0.0;
        } else {
            int remain = poured - sum;
            double big = ((double) remain) / layer;
            if (query_glass > 0 && query_glass < layer) return big;
            return big/2;
        }
    }

    public static void main(String[] args) {
        ChampagneTower champagneTower = new ChampagneTower();
        System.out.println(champagneTower.champagneTower(4, 2, 2));
    }
}
