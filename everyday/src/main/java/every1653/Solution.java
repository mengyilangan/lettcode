package every1653;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 给你一个字符串 s ，它仅包含字符 'a' 和 'b'。
 * 你可以删除 s 中任意数目的字符，使得 s 平衡 。当不存在下标对 (i,j) 满足 i < j ，且 s[i] = 'b' 的同时 s[j]= 'a' ，此时认为 s 是 平衡 的。
 * 请你返回使 s 平衡 的 最少 删除次数。
 * 示例 1：
 * 输入：s = "aababbab"
 * 输出：2
 * 解释：你可以选择以下任意一种方案：
 * 下标从 0 开始，删除第 2 和第 6 个字符（"aababbab" -> "aaabbb"），
 * 下标从 0 开始，删除第 3 和第 6 个字符（"aababbab" -> "aabbbb"）。
 * 示例 2：
 * 输入：s = "bbaaaaabb"
 * 输出：2
 * 解释：唯一的最优解是删除最前面两个字符。
 */
public class Solution {
    public int minimumDeletions(String s) {
        if (s == null || s.length() <= 1) {
            return 0;
        }
        char[] chars = s.toCharArray();
        char before = chars[0];
        int index = 1;
        List<Integer> list = new ArrayList<>();
        for (int i = 1; i < chars.length; i++) {
            if (chars[i] == before) {
                index++;
            } else {
                if (before == 'a') {
                    list.add(-index);
                } else if (before == 'b') {
                    list.add(index);
                }
                before = chars[i];
                index = 1;
            }
        }

        if (list.size() <= 1) {
            return 0;
        }

        //排序之后的队顺序
        List<Integer> sorted = new ArrayList<>(list);
        Collections.sort(sorted);

        //删除哪个字段之后两个可以一致
        //1,-1,-1,-1,2

        return 0;
    }
}
