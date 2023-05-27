package every245;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * link:https://leetcode.cn/problems/odd-string-difference/
 * 3 <= words.length <= 100
 * n == words[i].length
 * 2 <= n <= 20
 */
public class Solution2451 {
    public String oddString(String[] words) {
        int eachLength = words[0].length() - 1;
        for (int i = 0; i < eachLength; i++) {
            Map<Integer, List<String>> value = new HashMap<>();
            for (int j = 0; j < words.length; j++) {
                String word = words[j];
                int different = word.charAt(i + 1) - word.charAt(i);
                List<String> same = value.getOrDefault(different, new ArrayList<>());
                same.add(word);
                value.put(different, same);
                if (value.size() == 2 && j >= 2) {
                    break;
                }
            }

            if (value.size() == 2) {
                for (Map.Entry<Integer, List<String>> entry : value.entrySet()) {
                    if (entry.getValue().size() == 1) {
                        return entry.getValue().iterator().next();
                    }
                }
            }
        }
        return null;
    }
}
