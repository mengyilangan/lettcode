package every090;

/**
 * 单调栈，贡献值
 * https://leetcode.cn/problems/sum-of-subarray-minimums/discussion/?envType=daily-question&envId=2023-11-27
 * 给定一个整数数组 arr，找到 min(b) 的总和，其中 b 的范围为 arr 的每个（连续）子数组。
 * <p>
 * 由于答案可能很大，因此 返回答案模 10^9 + 7 。
 * 示例 1：
 * <p>
 * 输入：arr = [3,1,2,4]
 * 输出：17
 * 解释：
 * 子数组为 [3]，[1]，[2]，[4]，[3,1]，[1,2]，[2,4]，[3,1,2]，[1,2,4]，[3,1,2,4]。
 * 最小值为 3，1，2，4，1，1，2，1，1，1，和为 17。
 * 示例 2：
 * <p>
 * 输入：arr = [11,81,94,43,3]
 * 输出：444
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= arr.length <= 3 * 104
 * 1 <= arr[i] <= 3 * 104
 */
public class Solution907 {
    private static final int MOD = 1000_000_000 + 7;

    /**
     * 测试用例耗时太长
     *
     * @param arr
     * @return
     */
    public int sumSubarrayMins(int[] arr) {
        if (arr.length == 1) {
            return arr[0];
        }
        int sum = 0;
        int times = 0;
        for (int i = 0; i < arr.length; i++) {
            int value = sumSubarrayMins(i, arr);
            if (sum >= MOD || value >= MOD || times >= 10) {
                sum = (sum + value) % MOD;
                times = 0;
            } else {
                sum = sum + value;
                times++;
            }

        }

        //怎么将数组排个序,知道每个阶段里最小的是谁?
        return sum;
    }

    public int sumSubarrayMins(int start, int[] arr) {
        if (arr[start] == 1) {
            return arr.length - start;
        }

        /**
         * 逐步计算每个长度的最小值
         */
        int min = arr[start];
        int sum = min;
        for (int i = start + 1; i < arr.length; i++) {
            if (arr[i] < min) {
                min = arr[i];
                if (min == 1) {
                    sum += arr.length - i;
                    break;
                }
            }
            sum += min;
        }
        return sum;
    }
}
