package every246;

import java.util.HashSet;
import java.util.Set;

/**
 * https://leetcode.cn/problems/number-of-distinct-averages/
 * 给你一个下标从 0 开始长度为 偶数 的整数数组 nums 。
 * <p>
 * 只要 nums 不是 空数组，你就重复执行以下步骤：
 * <p>
 * 找到 nums 中的最小值，并删除它。
 * 找到 nums 中的最大值，并删除它。
 * 计算删除两数的平均值。
 * 两数 a 和 b 的 平均值 为 (a + b) / 2 。
 * <p>
 * 比方说，2 和 3 的平均值是 (2 + 3) / 2 = 2.5 。
 * 返回上述过程能得到的 不同 平均值的数目。
 * <p>
 * 注意 ，如果最小值或者最大值有重复元素，可以删除任意一个。
 * <p>
 * 2 <= nums.length <= 100
 * nums.length 是偶数。
 * 0 <= nums[i] <= 100
 */
public class Solution2456 {
    public int distinctAverages(int[] nums) {
        if (nums.length <= 2) {
            return 1;
        }

        int[] sorts = new int[101];
        int min = 101;
        int max = 0;
        for (int value : nums) {
            sorts[value] += 1;
            min = Math.min(min, value);
            max = Math.max(max, value);
        }

        if (min == max) {
            return 1;
        }

        Set<Integer> values = new HashSet<>();
        int left = min;
        int right = max;
        while (left <= right) {
            for (; left <= right; left++) {
                if (sorts[left] > 0) {
                    break;
                }
            }

            for (; right >= left; right--) {
                if (sorts[right] > 0) {
                    break;
                }
            }

            if (left > right) {
                break;
            }
            values.add(right + left);
            sorts[right] -= 1;
            sorts[left] -= 1;
        }
        return values.size();
    }
}
