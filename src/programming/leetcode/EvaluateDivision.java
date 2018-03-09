package programming.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EvaluateDivision {

    public double[] calcEquation(String[][] equations, double[] values, String[][] queries) {
        Map<String, Integer> indexMap = new HashMap<>();
        List<String> nameList  = new ArrayList<>();
        for(String[] equation: equations) {
            if (indexMap.get(equation[0]) == null) {
                push(indexMap, nameList, equation[0]);
            }
            if (indexMap.get(equation[1]) == null) {
                push(indexMap, nameList, equation[1]);
            }
        }//end for equation
        int n = nameList.size();
        Double[][] cost = new Double[n][n];
        for(int i = 0; i < n; i++) {
            cost[i] = new Double[n];
            cost[i][i] = 1.0;
        }
        for(int i = 0; i < equations.length; i++) {
            String a = equations[i][0], b = equations[i][1];
            cost[indexMap.get(a)][indexMap.get(b)] = values[i];
            cost[indexMap.get(b)][indexMap.get(a)] = 1.0D / values[i];
        }//end for equation
        for(int u = 0; u < n; u++)
            for(int i = 0; i < n; i++)
                for(int j = 0; j < n; j++) {
                    if (cost[i][u] != null && cost[u][j] != null && cost[i][j] == null) {
                        cost[i][j] = cost[i][u] * cost[u][j];
                    }
                }
        double[] result = new double[queries.length];
        for(int i = 0; i < queries.length; i++) {
            String a = queries[i][0], b = queries[i][1];
            if (indexMap.get(a) == null || indexMap.get(b) == null) {
                result[i] = -1.0;
            } else if (cost[indexMap.get(a)][indexMap.get(b)] == null) {
                result[i] = -1.0;
            } else result[i] = cost[indexMap.get(a)][indexMap.get(b)];
        }//end for i
        return result;
    }

    private void push(Map<String, Integer> indexMap, List<String> nameList, String name) {
        nameList.add(name);
        indexMap.put(name, nameList.size() - 1);
    }

}
