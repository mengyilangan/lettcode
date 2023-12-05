package every117;

import java.util.*;

/**
 * https://leetcode.cn/problems/can-make-palindrome-from-substring/
 * 给你一个字符串 s，请你对 s 的子串进行检测。
 * <p>
 * 每次检测，待检子串都可以表示为 queries[i] = [left, right, k]。我们可以 重新排列 子串 s[left], ..., s[right]，并从中选择 最多 k 项替换成任何小写英文字母。
 * <p>
 * 如果在上述检测过程中，子串可以变成回文形式的字符串，那么检测结果为 true，否则结果为 false。
 * <p>
 * 返回答案数组 answer[]，其中 answer[i] 是第 i 个待检子串 queries[i] 的检测结果。
 * <p>
 * 注意：在替换时，子串中的每个字母都必须作为 独立的 项进行计数，也就是说，如果 s[left..right] = "aaa" 且 k = 2，我们只能替换其中的两个字母。（另外，任何检测都不会修改原始字符串 s，可以认为每次检测都是独立的）
 * 1 <= s.length, queries.length <= 10^5
 * 0 <= queries[i][0] <= queries[i][1] < s.length
 * 0 <= queries[i][2] <= s.length
 * s 中只有小写英文字母
 */
public class Solution1177 {
    /**
     * 1:0
     * 2:1
     * 3:1
     * 4:2
     * 5:2
     * 6:3
     *
     * @param s
     * @param queries
     * @return
     */
    public List<Boolean> canMakePaliQueries(String s, int[][] queries) {
        List<Boolean> result = new ArrayList<>(queries.length);
        for (int[] query : queries) {
            if (query[2] >= 26) {
                result.add(true);
                continue;
            }

            int minus = query[1] - query[0] + 1;
            int beginIndex = query[0];
            int endIndex = query[1];
            int difference = minus / 2;
            Set<Character> characters = new HashSet<>();
            for (int i = beginIndex; i <= endIndex && difference > query[2]; i++) {
                char c = s.charAt(i);
                if (characters.remove(c)) {
                    difference -= 1;
                } else {
                    characters.add(c);
                }
            }
            result.add(difference <= query[2]);
        }
        return result;
    }
}
