package com.lettcode.mylg.compition.weekly380;

/**
 * 100162. 最大频率元素计数
 * 给你一个由 正整数 组成的数组 nums 。
 * <p>
 * 返回数组 nums 中所有具有 最大 频率的元素的 总频率 。
 * <p>
 * 元素的 频率 是指该元素在数组中出现的次数
 * 提示：
 * <p>
 * 1 <= nums.length <= 100
 * 1 <= nums[i] <= 100
 */
public class Solution100162 {
    public int maxFrequencyElements(int[] nums) {
        int fluence[] = new int[101];
        int max = 0;
        for (int num : nums) {
            fluence[num] += 1;
            max = Math.max(fluence[num], max);
        }

        int sum=0;
        for (int value : fluence) {
            if (value == max) {
                sum += value;
            }
        }
        return sum;
    }
}
