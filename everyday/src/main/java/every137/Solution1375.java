package every137;

import java.util.HashMap;
import java.util.TreeMap;

/**
 * https://leetcode.cn/problems/number-of-times-binary-string-is-prefix-aligned/
 * 给你一个长度为 n 、下标从 1 开始的二进制字符串，所有位最开始都是 0 。我们会按步翻转该二进制字符串的所有位（即，将 0 变为 1）。
 * <p>
 * 给你一个下标从 1 开始的整数数组 flips ，其中 flips[i] 表示对应下标 i 的位将会在第 i 步翻转。
 * <p>
 * 二进制字符串 前缀一致 需满足：在第 i 步之后，在 闭 区间 [1, i] 内的所有位都是 1 ，而其他位都是 0 。
 * <p>
 * 返回二进制字符串在翻转过程中 前缀一致 的次数。
 * 输入：flips = [4,1,2,3]
 * 输出：1
 * 解释：二进制字符串最开始是 "0000" 。
 * 执行第 1 步：字符串变为 "0001" ，不属于前缀一致的情况。
 * 执行第 2 步：字符串变为 "1001" ，不属于前缀一致的情况。
 * 执行第 3 步：字符串变为 "1101" ，不属于前缀一致的情况。
 * 执行第 4 步：字符串变为 "1111" ，属于前缀一致的情况。
 * 在翻转过程中，前缀一致的次数为 1 ，所以返回 1 。
 */
public class Solution1375 {
    public int numTimesAllBlue(int[] flips) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        int sum = 0;
        for (int i = 0; i < flips.length; i++) {
            map.put(flips[i], 1);
            if (isPrefixSame(map, i + 1)) {
                sum += 1;
            }

        }
        return sum;
    }

    public boolean isPrefixSame(TreeMap<Integer, Integer> map, int i) {
        boolean isFirst = map.containsKey(1);

        boolean isEnd = map.lastKey() == i;

        return isFirst && isEnd && map.size() == i;
    }
}
