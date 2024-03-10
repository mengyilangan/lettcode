package com.lettcode.mylg.compition.weekly379;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * https://leetcode.cn/contest/weekly-contest-379/problems/maximum-size-of-a-set-after-removals/
 * 给你两个下标从 0 开始的整数数组 nums1 和 nums2 ，它们的长度都是偶数 n 。
 * <p>
 * 你必须从 nums1 中移除 n / 2 个元素，同时从 nums2 中也移除 n / 2 个元素。移除之后，你将 nums1 和 nums2 中剩下的元素插入到集合 s 中。
 * <p>
 * 返回集合 s可能的 最多 包含多少元素。
 * <p>
 * n == nums1.length == nums2.length
 * 1 <= n <= 2 * 104
 * n是偶数。
 * 1 <= nums1[i], nums2[i] <= 109
 *
 * @author mylg
 * @date 7/1/24
 */
public class Solution100150 {
    public int maximumSetSize(int[] nums1, int[] nums2) {
        Map<Integer, Integer> count1 = new HashMap<>();
        Map<Integer, Integer> count2 = new HashMap<>();

        int n = nums1.length;
        for (int i = 0; i < n; i++) {
            int times = count1.getOrDefault(nums1[i], 0);
            count1.put(nums1[i], times + 1);

            times = count2.getOrDefault(nums2[i], 0);
            count2.put(nums2[i], times + 1);
        }

        Set<Integer> key1 = count1.keySet();
        Set<Integer> key2 = count2.keySet();


        int half = n / 2;
        //case1:没有交叉
        if (key1.size() <= half && key2.size() <= half) {

        }


        //case2:有交叉


        //最多是N
        return 0;
    }
}
