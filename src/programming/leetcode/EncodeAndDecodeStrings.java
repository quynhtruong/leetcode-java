package programming.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by truongq on 5/24/18.
 */
public class EncodeAndDecodeStrings {
    public String encode(List<String> strs) {
        int n = strs.size();
        StringBuilder result = new StringBuilder();
        for(String str: strs) {
            result.append(str.length()).append("#").append(str);
        }
        return result.toString();
    }

    public List<String> decode(String s) {
        List<String> result = new ArrayList<>();
        while(s.length() > 0) {
            int hashIndex = 0;
            for(hashIndex = 0; hashIndex < s.length(); hashIndex++) {
                if (s.charAt(hashIndex) == '#') break;
            }
            int len = Integer.parseInt(s.substring(0, hashIndex));
            result.add(s.substring(hashIndex + 1, hashIndex + len + 1));
            s = s.substring(hashIndex + len + 1);
        }//end while
        return result;
    }
}
