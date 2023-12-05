package every068;

/**
 * 给你一个整数数组 nums 和一个整数 k ，找出三个长度为 k 、互不重叠、且全部数字和（3 * k 项）最大的子数组，并返回这三个子数组。
 * <p>
 * 以下标的数组形式返回结果，数组中的每一项分别指示每个子数组的起始位置（下标从 0 开始）。如果有多个结果，返回字典序最小的一个。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [1,2,1,2,6,7,5,1], k = 2
 * 输出：[0,3,5]
 * 解释：子数组 [1, 2], [2, 6], [7, 5] 对应的起始下标为 [0, 3, 5]。
 * 也可以取 [2, 1], 但是结果 [1, 3, 5] 在字典序上更大。
 * 示例 2：
 * <p>
 * 输入：nums = [1,2,1,2,1,2,1,2,1], k = 2
 * 输出：[0,2,4]
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 2 * 104
 * 1 <= nums[i] < 216
 * 1 <= k <= floor(nums.length / 3)
 * https://leetcode.cn/problems/maximum-sum-of-3-non-overlapping-subarrays/description/?envType=daily-question&envId=2023-11-23
 */
public class Solution689 {
    public int[] maxSumOfThreeSubarrays(int[] nums, int k) {
        int left = nums.length - k * 3;
        int[] result = new int[3];
        if (left == 0) {
            result[1] = k - 1;
            result[2] = 2 * k - 1;
            return result;
        }

        //如果k=1，直接挑选三个最大的就行==>大顶堆
        for (int i = 0; i < nums.length; i++) {

        }


        int high = 0;
        int mid = 1;
        int low = 2;
        if (k == 1) {

        }

        //如果不是,那相当于就是从Cnm(m就是不要的，可以直接抛弃的内容)，且要求选中的m之间剩下的k之间够长度

        return result;
    }
}
