package com.lettcode.mylg.compition.weekly355;

/**
 * 6915. 合并后数组中的最大元素 显示英文描述
 * 给你一个下标从 0 开始、由正整数组成的数组 nums 。
 * <p>
 * 你可以在数组上执行下述操作 任意 次：
 * <p>
 * 选中一个同时满足 0 <= i < nums.length - 1 和 nums[i] <= nums[i + 1] 的整数 i 。将元素 nums[i + 1] 替换为 nums[i] + nums[i + 1] ，并从数组中删除元素 nums[i] 。
 * 返回你可以从最终数组中获得的 最大 元素的值。
 * 提示：
 * <p>
 * 1 <= nums.length <= 105
 * 1 <= nums[i] <= 106
 */
public class Solution6915 {
    public long maxArrayValue(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        int high = nums.length - 1;
        int max = 0;
        while (high >= 0) {
            Result result = computeResult(high, nums);
            high = result.end;
            max = Math.max(result.max, max);
        }
        return max;
    }

    private Result computeResult(int end, int[] nums) {
        if (end <= 0) {
            return new Result(nums[end], -1);
        }

        int i = end - 1;
        while (i >= 0) {
            if (nums[end] >= nums[i]) {
                nums[end] += nums[i];
                nums[i] = 0;
                i = i - 1;
            } else {
                break;
            }
        }
        return new Result(nums[end], i);
    }

    private static class Result {
        private int max;

        private int end;

        public Result(int max, int end) {
            this.max = max;
            this.end = end;
        }
    }
}
