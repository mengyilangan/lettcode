package every091;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 918. 环形子数组的最大和
 * 给定一个长度为 n 的环形整数数组 nums ，返回 nums 的非空 子数组 的最大可能和 。
 * <p>
 * 环形数组 意味着数组的末端将会与开头相连呈环状。形式上， nums[i] 的下一个元素是 nums[(i + 1) % n] ， nums[i] 的前一个元素是 nums[(i - 1 + n) % n] 。
 * <p>
 * 子数组 最多只能包含固定缓冲区 nums 中的每个元素一次。形式上，对于子数组 nums[i], nums[i + 1], ..., nums[j] ，不存在 i <= k1, k2 <= j 其中 k1 % n == k2 % n 。
 * n == nums.length
 * 1 <= n <= 3 * 104
 * -3 * 104 <= nums[i] <= 3 * 104
 */
public class Solution918 {
    public int maxSubarraySumCircular(int[] nums) {

        if (nums.length == 1) {
            return nums[0];
        }

        int i = 0;
        while (i < nums.length && nums[i] == 0) {
            i++;
        }

        if (i >= nums.length) {
            return 0;
        }

        ArrayList<Integer> list = new ArrayList<>();
        int max = Math.max(0, nums[i]);
        int sum = nums[i];
        boolean positive = nums[i] > 0;
        for (i = i + 1; i < nums.length; i++) {
            if (nums[i] == 0) {
                continue;
            }
            boolean currentPositive = nums[i] > 0;
            if (positive | currentPositive) {
                list.add(sum);
                max = Math.max(max, sum);
                sum = nums[i];
                positive = currentPositive;
            } else {
                sum += nums[i];
            }
        }
        max = Math.max(max, sum);
        list.add(sum);
        return Math.max(max, computeCircleList(list));
    }


    public int computeCircleList(List<Integer> list) {
        if (list.size() == 1) {
            return list.get(0);
        }

        if (list.size() == 2) {
            return Math.max(list.get(0), list.get(1));
        }

        if (list.size() == 3) {
            return Math.max(list.get(0) + list.get(1), list.get(2));
        }

        return 0;
    }
}
