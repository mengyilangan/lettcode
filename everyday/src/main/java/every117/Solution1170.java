package every117;

import java.util.TreeMap;

public class Solution1170 {
    public int[] numSmallerByFrequency(String[] queries, String[] words) {

        int[] b = new int[words.length];
        for (int i = 0; i < words.length; i++) {
            b[i] = computeQuery(words[i]);
        }

        int[] rewards = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int current = computeQuery(queries[i]);
            for (int number : b) {
                if (number > current) {
                    rewards[i] += 1;
                }
            }
        }
        return rewards;
    }

    private int computeQuery(String word) {
        TreeMap<Integer, Integer> values = new TreeMap<>();
        for (char c : word.toCharArray()) {
            int index = c - 'a';
            int before = values.getOrDefault(index, 0);
            values.put(index, before + 1);
        }
        return values.firstEntry().getValue();
    }
}
