package every283;

/**
 * 数不对,原因待查
 * https://leetcode.cn/problems/find-the-minimum-possible-sum-of-a-beautiful-array/description/?envType=daily-question&envId=2024-03-08
 * 给你两个正整数：n 和 target 。
 * <p>
 * 如果数组 nums 满足下述条件，则称其为 美丽数组 。
 * <p>
 * nums.length == n.
 * nums 由两两互不相同的正整数组成。
 * 在范围 [0, n-1] 内，不存在 两个 不同 下标 i 和 j ，使得 nums[i] + nums[j] == target 。
 * 返回符合条件的美丽数组所可能具备的 最小 和，并对结果进行取模 10^9 + 7。
 */
public class Solution2834 {
    private static final int mathPow = (int) (Math.pow(10, 9) + 7);

    public int minimumPossibleSum(int n, int target) {
        if (n == 1) {
            return 1;
        }


        if (target - n >= n) {
            return sum(1, n) % mathPow;
        }

        int end = target / 2;

        return sum(1, end) % mathPow + sum(target, (n - end)) % mathPow;
    }

    private int sum(int start, int num) {
        if (num % 2 == 0) {
            return num * start + num / 2 * (num - 1);
        } else {
            return num * start + (num - 1) / 2 * num;
        }
    }
}
