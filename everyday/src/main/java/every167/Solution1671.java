package every167;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.cn/problems/minimum-number-of-removals-to-make-mountain-array/
 * 我们定义 arr 是 山形数组 当且仅当它满足：
 * <p>
 * arr.length >= 3
 * 存在某个下标 i （从 0 开始） 满足 0 < i < arr.length - 1 且：
 * arr[0] < arr[1] < ... < arr[i - 1] < arr[i]
 * arr[i] > arr[i + 1] > ... > arr[arr.length - 1]
 * 给你整数数组 nums​ ，请你返回将 nums 变成 山形状数组 的​ 最少 删除次数。
 * <p>
 * 3 <= nums.length <= 1000
 * 1 <= nums[i] <= 109
 * 题目保证 nums 删除一些元素后一定能得到山形数组。
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [1,3,1]
 * 输出：0
 * 解释：数组本身就是山形数组，所以我们不需要删除任何元素。
 * 示例 2：
 * <p>
 * 输入：nums = [2,1,1,5,6,2,3,1]
 * 输出：3
 * 解释：一种方法是将下标为 0，1 和 5 的元素删除，剩余元素为 [1,5,6,3,1] ，是山形数组。
 *
 * @author mylg
 * @date 22/12/23
 */
public class Solution1671 {

    //dp流程
    public int[] reverse(int[] nums) {
        int n = nums.length;
        int[] reversed = new int[n];
        for (int i = 0; i < n; i++) {
            reversed[i] = nums[n - 1 - i];
        }
        return reversed;
    }

    public int minimumMountainRemovals(int[] nums) {
        //不能判断等号
        int n = nums.length;
        int[] pre = lengthOfLIS(nums);
        int[] reversed = reverse(nums);
        int[] suf = lengthOfLIS(reversed);
        suf = reverse(suf);

        int ans = 0;
        for (int i = 0; i < n; ++i) {
            if (pre[i] > 1 && suf[i] > 1) {
                ans = Math.max(ans, pre[i] + suf[i] - 1);
            }
        }

        return n - ans;
    }

    //最大递增子数组
    public int[] lengthOfLIS(int[] nums) {
        if (nums.length == 1) {
            return new int[0];
        }

        //以最后一个必须选取为前提
        int[] dp = new int[nums.length];
        dp[0] = 1;
        int allMax = 0;
        for (int i = 1; i < nums.length; i++) {
            int result = 0;
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    result = Math.max(result, dp[j]);
                }
            }
            dp[i]  = result + 1;
            allMax = Math.max(dp[i], allMax);
        }
        return dp;
    }
}
