package com.lettcode.mylg.compition.weekly375;

import java.util.*;

/**
 * 子数组和图谱计算思路
 * https://leetcode.cn/contest/weekly-contest-375/problems/count-the-number-of-good-partitions/
 * 给你一个下标从 0 开始、由 正整数 组成的数组 nums。
 * <p>
 * 将数组分割成一个或多个 连续 子数组，如果不存在包含了相同数字的两个子数组，则认为是一种 好分割方案 。
 * <p>
 * 返回 nums 的 好分割方案 的 数目。
 * <p>
 * 由于答案可能很大，请返回答案对 10^9 + 7 取余 的结果。
 * <p>
 * 1 <= nums.length <= 105
 * 1 <= nums[i] <= 109
 * <p>
 * 答案：https://leetcode.cn/problems/count-the-number-of-good-partitions/solutions/2560938/he-bing-qu-jian-pythonjavacgo-by-endless-yxhw/
 */
public class Solution100136 {
    public int numberOfGoodPartitions(int[] nums) {
        HashMap<Integer, Integer> r = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            r.put(nums[i], i);
        }
        int ans = 1, max_r = 0;
        for (int i = 0; i < nums.length - 1; i++) { // 少统计最后一段区间
            max_r = Math.max(max_r, r.get(nums[i]));
            if (max_r == i) { // 区间无法延长
                ans = ans * 2 % 1_000_000_007;
            }
        }
        return ans;
    }
}
