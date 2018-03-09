package programming.leetcode;

import java.util.HashMap;
import java.util.Map;

public class Bai2 {
    static int verifyItems(String[] origItems, float[] origPrices, String[] items, float[] prices) {
        Map<String, Double> priceMap = new HashMap<>();
        int n = origItems.length;
        for (int i = 0; i < n; i++) {
            priceMap.put(origItems[i], (double) origPrices[i]);
        }
        int result = 0;
        int m = items.length;
        for (int i = 0; i < m; i++) {
            Double price = priceMap.get(items[i]);
            if (price == null) {
                result++;
            } else if (Double.compare(price, prices[i]) != 0) {
                result++;
            }
        }
        return result;
    }
}
