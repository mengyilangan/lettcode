/**
 * https://leetcode-cn.com/problems/next-permutation/
 * 31. 下一个排列
 * 实现获取下一个排列的函数，算法需要将给定数字序列重新排列成字典序中下一个更大的排列。
 * <p>
 * 如果不存在下一个更大的排列，则将数字重新排列成最小的排列（即升序排列）。
 * <p>
 * 必须原地修改，只允许使用额外常数空间。
 * <p>
 * 以下是一些例子，输入位于左侧列，其相应输出位于右侧列。
 * 1,2,3 → 1,3,2
 * 3,2,1 → 1,2,3
 * 1,1,5 → 1,5,1
 */
public class Solution31 {
    public void nextPermutation(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return;
        }
        for (int i = nums.length - 2; i >= 0; i--) {
            if (nums[i] < nums[i + 1]) {
                loop(nums, i + 1);
                for (int index = i + 1; index < nums.length; index++) {
                    if (nums[index] > nums[i]) {
                        int temp = nums[index];
                        nums[index] = nums[i];
                        nums[i]     = temp;
                        break;
                    }
                }
                return;
            }
        }
        loop(nums, 0);
    }

    /**
     * 全部倒序一遍
     *
     * @param nums
     * @param start
     */
    private void loop(int[] nums, int start) {
        int low = start;
        int high = nums.length - 1;
        while (low < high) {
            int temp = nums[low];
            nums[low]  = nums[high];
            nums[high] = temp;
            low++;
            high--;
        }
    }
}
