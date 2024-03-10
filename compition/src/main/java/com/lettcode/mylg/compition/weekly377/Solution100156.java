package com.lettcode.mylg.compition.weekly377;

/**
 * https://leetcode.cn/contest/weekly-contest-377/problems/minimum-cost-to-convert-string-i/
 *
 * 给你两个下标从 0 开始的字符串 source 和 target ，它们的长度均为 n 并且由 小写 英文字母组成。
 * <p>
 * 另给你两个下标从 0 开始的字符数组 original 和 changed ，以及一个整数数组 cost ，其中 cost[i] 代表将字符 original[i] 更改为字符 changed[i] 的成本。
 * <p>
 * 你从字符串 source 开始。在一次操作中，如果 存在 任意 下标 j 满足 cost[j] == z  、original[j] == x 以及 changed[j] == y 。你就可以选择字符串中的一个字符 x 并以 z 的成本将其更改为字符 y 。
 * <p>
 * 返回将字符串 source 转换为字符串 target 所需的 最小 成本。如果不可能完成转换，则返回 -1 。
 * <p>
 * 注意，可能存在下标 i 、j 使得 original[j] == original[i] 且 changed[j] == changed[i] 。
 * <p>
 * 1 <= source.length == target.length <= 105
 * source、target 均由小写英文字母组成
 * 1 <= cost.length== original.length == changed.length <= 2000
 * original[i]、changed[i] 是小写英文字母
 * 1 <= cost[i] <= 106
 * original[i] != changed[i]
 *
 * @author mylg
 * @date 24/12/23
 */
public class Solution100156 {
    public long minimumCost(String source, String target, char[] original, char[] changed, int[] cost) {
return 0;
    }
}
