package every165;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * 如果可以使用以下操作从一个字符串得到另一个字符串，则认为两个字符串 接近 ：
 * <p>
 * 操作 1：交换任意两个 现有 字符。
 * 例如，abcde -> aecdb
 * 操作 2：将一个 现有 字符的每次出现转换为另一个 现有 字符，并对另一个字符执行相同的操作。
 * 例如，aacabb -> bbcbaa（所有 a 转化为 b ，而所有的 b 转换为 a ）
 * 你可以根据需要对任意一个字符串多次使用这两种操作。
 * <p>
 * 给你两个字符串，word1 和 word2 。如果 word1 和 word2 接近 ，就返回 true ；否则，返回 false 。
 * <p>
 * https://leetcode.cn/problems/determine-if-two-strings-are-close/?envType=daily-question&envId=2023-11-30
 * 提示：
 * <p>
 * 示例 1：
 * <p>
 * 输入：word1 = "abc", word2 = "bca"
 * 输出：true
 * 解释：2 次操作从 word1 获得 word2 。
 * 执行操作 1："abc" -> "acb"
 * 执行操作 1："acb" -> "bca"
 * 示例 2：
 * <p>
 * 输入：word1 = "a", word2 = "aa"
 * 输出：false
 * 解释：不管执行多少次操作，都无法从 word1 得到 word2 ，反之亦然。
 * 示例 3：
 * <p>
 * 输入：word1 = "cabbba", word2 = "abbccc"
 * 输出：true
 * 解释：3 次操作从 word1 获得 word2 。
 * 执行操作 1："cabbba" -> "caabbb"
 * 执行操作 2："caabbb" -> "baaccc"
 * 执行操作 2："baaccc" -> "abbccc"
 * 1 <= word1.length, word2.length <= 105
 * word1 和 word2 仅包含小写英文字母
 */
public class Solution1657 {
    public boolean closeStrings(String word1, String word2) {
        if (word1.length() != word2.length()) {
            return false;
        }
        int[] num1 = new int[26];
        int[] num2 = new int[26];
        Set<Integer> has1 = new HashSet<>();
        Set<Integer> has2 = new HashSet<>();
        for (int i = 0; i < word1.length(); i++) {
            int index1 = word1.charAt(i) - 'a';
            has1.add(index1);
            num1[index1] = num1[index1] + 1;
            int index2 = word2.charAt(i) - 'a';
            num2[index2] = num2[index2] + 1;
            has2.add(index2);
        }

        if (has1.size() != has2.size() || !has1.containsAll(has2)) {
            return false;
        }


        Arrays.sort(num1);
        Arrays.sort(num2);
        for (int i = 0; i < num1.length; i++) {
            if (num1[i] != num2[i]) {
                return false;
            }
        }
        return true;
    }
}
