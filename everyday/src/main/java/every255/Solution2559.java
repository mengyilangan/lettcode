package every255;

import java.util.*;

/**
 * https://leetcode.cn/problems/count-vowel-strings-in-ranges/
 */
public class Solution2559 {
    /**
     * 给你一个下标从 0 开始的字符串数组 words 以及一个二维整数数组 queries 。
     * <p>
     * 每个查询 queries[i] = [li, ri] 会要求我们统计在 words 中下标在 li 到 ri 范围内（包含 这两个值）并且以元音开头和结尾的字符串的数目。
     * <p>
     * 返回一个整数数组，其中数组的第 i 个元素对应第 i 个查询的答案。
     * <p>
     * 注意：元音字母是 'a'、'e'、'i'、'o' 和 'u' 。
     * 1 <= words.length <= 105
     * 1 <= words[i].length <= 40
     * words[i] 仅由小写英文字母组成
     * sum(words[i].length) <= 3 * 105
     * 1 <= queries.length <= 105
     * 0 <= queries[j][0] <= queries[j][1] < words.length
     *
     * @param words
     * @param queries
     * @return
     */
    public int[] vowelStrings(String[] words, int[][] queries) {
        Set<Character> vowel = new HashSet<>();
        vowel.add('a');
        vowel.add('e');
        vowel.add('i');
        vowel.add('o');
        vowel.add('u');
        int[] vowelCount = new int[words.length + 1];
        int has = 0;
        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            boolean status = vowel.contains(word.charAt(0)) && vowel.contains(word.charAt(word.length() - 1));
            if (status) {
                has = has + 1;
            }
            vowelCount[i + 1] = has;
        }

        int[] result = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int start = queries[i][0];
            int end = queries[i][1] + 1;
            result[i] = vowelCount[end] - vowelCount[start];
        }
        return result;
    }
}
