package com.lettcode.mylg.compition.weekly377;

/**
 * https://leetcode.cn/contest/weekly-contest-377/problems/minimum-cost-to-convert-string-ii/
 * 给你两个下标从 0 开始的字符串 source 和 target ，它们的长度均为 n 并且由 小写 英文字母组成。
 * <p>
 * 另给你两个下标从 0 开始的字符串数组 original 和 changed ，以及一个整数数组 cost ，其中 cost[i] 代表将字符串 original[i] 更改为字符串 changed[i] 的成本。
 * <p>
 * 你从字符串 source 开始。在一次操作中，如果 存在 任意 下标 j 满足 cost[j] == z  、original[j] == x 以及 changed[j] == y ，你就可以选择字符串中的 子串 x 并以 z 的成本将其更改为 y 。 你可以执行 任意数量 的操作，但是任两次操作必须满足 以下两个 条件 之一 ：
 * <p>
 * 在两次操作中选择的子串分别是 source[a..b] 和 source[c..d] ，满足 b < c  或 d < a 。换句话说，两次操作中选择的下标 不相交 。
 * 在两次操作中选择的子串分别是 source[a..b] 和 source[c..d] ，满足 a == c 且 b == d 。换句话说，两次操作中选择的下标 相同 。
 * 返回将字符串 source 转换为字符串 target 所需的 最小 成本。如果不可能完成转换，则返回 -1 。
 * <p>
 * 注意，可能存在下标 i 、j 使得 original[j] == original[i] 且 changed[j] == changed[i] 。
 * <p>
 * 1 <= source.length == target.length <= 1000
 * source、target 均由小写英文字母组成
 * 1 <= cost.length == original.length == changed.length <= 100
 * 1 <= original[i].length == changed[i].length <= source.length
 * original[i]、changed[i] 均由小写英文字母组成
 * original[i] != changed[i]
 * 1 <= cost[i] <= 106
 *
 * @author mylg
 * @date 24/12/23
 */
public class Solution100158 {
    public long minimumCost(String source, String target, String[] original, String[] changed, int[] cost) {
return 0;
    }
}
