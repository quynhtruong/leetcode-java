package programming.leetcode;

import java.util.*;

public class MergeAccounts {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        int n = accounts.size();
        Map<String, Integer> rootMap = new HashMap<>();
        boolean stop = true;
        do {
            stop = true;
            for (int i = 0; i < n; i++) {
                List<String> emailList = accounts.get(i);
                Integer minRoot = i;
                for (int j = 1; j < emailList.size(); j++) {
                    Integer index = rootMap.get(emailList.get(j));
                    if (index != null) {
                        minRoot = Math.min(minRoot, index);
                    }
                }
                for(int j = 1; j < emailList.size(); j++) {
                    Integer index = rootMap.get(emailList.get(j));
                    if (!minRoot.equals(index)) {
                        stop = false;
                        for(int u = 1; u < emailList.size(); u++) {
                            rootMap.put(emailList.get(u), minRoot);
                        }
                        break;
                    }
                }
            }
        } while (stop == false);
        Map<Integer, List<String>> mergedAccounts = new HashMap<>();
        for (String email : rootMap.keySet()) {
            Integer root = rootMap.get(email);
            List<String> list = mergedAccounts.get(root);
            if (list == null) list = new ArrayList<>();
            list.add(email);
            mergedAccounts.put(root, list);
        }
        List<List<String>> result = new ArrayList<>();
        for (Integer root : mergedAccounts.keySet()) {
            List<String> list = mergedAccounts.get(root);
            Collections.sort(list);
            list.add(0, accounts.get(root).get(0));
            result.add(list);
        }
        return result;
    }

    public static void main(String[] args) {
        MergeAccounts solution = new MergeAccounts();
        List<List<String>> input = new ArrayList<>();
        input.add(Arrays.asList("John","johnsmith@mail.com","john_newyork@mail.com"));
        input.add(Arrays.asList("John","johnsmith@mail.com","john00@mail.com"));
        input.add(Arrays.asList("Mary","mary@mail.com"));
        input.add(Arrays.asList("John","johnnybravo@mail.com"));
        solution.accountsMerge(input);
    }

}
