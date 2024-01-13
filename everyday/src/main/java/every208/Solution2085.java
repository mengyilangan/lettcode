package every208;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Solution2085 {
    public int countWords(String[] words1, String[] words2) {
        Map<String, Integer> count = new HashMap<>();
        Set<String> sets = new HashSet<>();
        for (String word : words1) {
            int n = count.getOrDefault(word, 0);
            if (n > 0) {
                sets.remove(word);
            } else {
                sets.add(word);
            }
            count.put(word, n + 1);
        }

        if (sets.isEmpty()) {
            return 0;
        }

        count.clear();
        for (String word : words2) {
            if (sets.contains(word)) {
                int n = count.getOrDefault(word, 0);
                if (n > 0) {
                    sets.remove(word);
                    count.remove(word);
                } else {
                    count.put(word, n + 1);
                }
            }
        }
        return count.size();
    }
}
