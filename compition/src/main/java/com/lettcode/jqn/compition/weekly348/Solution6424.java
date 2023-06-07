package com.lettcode.jqn.compition.weekly348;

/**
 * 给你一个下标从 0 开始、长度为 n 的整数排列 nums 。
 * <p>
 * 如果排列的第一个数字等于 1 且最后一个数字等于 n ，则称其为 半有序排列 。你可以执行多次下述操作，直到将 nums 变成一个 半有序排列 ：
 * <p>
 * 选择 nums 中相邻的两个元素，然后交换它们。
 * 返回使 nums 变成 半有序排列 所需的最小操作次数。
 * <p>
 * 排列 是一个长度为 n 的整数序列，其中包含从 1 到 n 的每个数字恰好一次。
 * /**
 * 2 <= nums.length == n <= 50
 * 1 <= nums[i] <= 50
 * nums 是一个 排列
 */
public class Solution6424 {
    public int semiOrderedPermutation(int[] nums) {
        int one = 1;
        int n = nums.length;
        if (nums[one - 1] == one && nums[n - 1] == n) {
            return 0;
        }

        //重新移动
        boolean min = true;
        boolean max = true;
        int oneIndex = 0;
        int nIndex = 0;
        for (int i = 0; i < nums.length && (min || max); i++) {
            if (nums[i] == one) {
                oneIndex = i;
                min = false;
            } else if (nums[i] == n) {
                nIndex = i;
                max = false;
            }
        }
        //各自左右移动
        if (oneIndex < nIndex) {
            return oneIndex + n - 1 - nIndex;
        }
        return oneIndex + n - 2 - nIndex;
    }
}
