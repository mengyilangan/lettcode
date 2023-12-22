package com.lettcode.mylg.compition.weekly375;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.cn/contest/weekly-contest-375/problems/count-subarrays-where-max-element-appears-at-least-k-times/
 * 给你一个整数数组 nums 和一个 正整数 k 。
 * <p>
 * 请你统计有多少满足 「 nums 中的 最大 元素」至少出现 k 次的子数组，并返回满足这一条件的子数组的数目。
 * <p>
 * 子数组是数组中的一个连续元素序列。
 * 1 <= nums.length <= 105
 * 1 <= nums[i] <= 106
 * 1 <= k <= 105
 */
public class Solution100137 {
    public long countSubarrays(int[] nums, int k) {
        List<Integer> indexList = new ArrayList<>();
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            if (num > max) {
                max = num;
                //重新计算
                indexList.clear();
                indexList.add(i);
            } else if (num == max) {
                indexList.add(i);
            }
        }

        //最大数出现频率不够
        if (indexList.size() < k) {
            return 0;
        }

        //依次计算每个数组对应的长度
        long sum = 0;
        indexList.add(nums.length);
        for (int i = 0; i < indexList.size() - k; i++) {
            //向左
            int left = indexList.get(i) + 1;
            long times = indexList.get(i + k) - indexList.get(i + k - 1);
            sum += left * times;
        }
        return sum;
    }
}
