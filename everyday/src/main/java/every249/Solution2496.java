package every249;

import java.util.Map;

/**
 * https://leetcode.cn/problems/maximum-value-of-a-string-in-an-array/
 * 一个由字母和数字组成的字符串的 值 定义如下：
 * <p>
 * 如果字符串 只 包含数字，那么值为该字符串在 10 进制下的所表示的数字。
 * 否则，值为字符串的 长度 。
 * 给你一个字符串数组 strs ，每个字符串都只由字母和数字组成，请你返回 strs 中字符串的 最大值 。
 * <p>
 * 1 <= strs.length <= 100
 * 1 <= strs[i].length <= 9
 * strs[i] 只包含小写英文字母和数字。
 */
public class Solution2496 {
    public int maximumValue(String[] strs) {
        int value = 0;
        for (String str : strs) {
            value = Math.max(maximumValue(str), value);
        }
        return value;
    }

    public int maximumValue(String str) {
        if (str == null || str.length() == 0) {
            return 0;
        }

        int number = 0;
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (c >= '0' && c <= '9') {
                number = number * 10 + (c - '0');
            } else {
                return str.length();
            }
        }
        return number;
    }
}
