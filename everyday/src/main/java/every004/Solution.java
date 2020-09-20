package every004;

public class Solution {
    double findMedianSortedArrays(int[] nums1, int[] nums2) {
        /**
         */
        if (nums1 == null || nums1.length == 0) {
            return findMedianSortedArrays(nums2);
        } else if (nums1.length == 1) {
            return findMedianSortedArrays(nums2, 0, nums2.length - 1, nums1[0]);
        } else if (nums2 == null || nums2.length == 0) {
            return findMedianSortedArrays(nums1);
        } else if (nums2.length == 1) {
            return findMedianSortedArrays(nums1, 0, nums1.length - 1, nums2[0]);
        }

        int start1 = 0;
        int start2 = 0;
        int end1 = nums1.length - 1;
        int end2 = nums2.length - 1;
        boolean bool1 = false, bool2 = false;
        while (true) {
            if (nums1[start1] <= nums2[start2]) {
                start1++;
                bool1 = true;
            } else {
                start2++;
                bool2 = true;
            }
            if (nums1[end1] >= nums2[end2]) {
                end1--;
                bool1 = true;
            } else {
                end2--;
                bool2 = true;
            }

            if (bool1) {
                if (start1 == end1) {
                    return findMedianSortedArrays(nums2, start2, end2, nums1[start1]);
                } else if (start1 > end1) {
                    return findMedianSortedArrays(nums2, start2, end2);
                }
                bool1 = false;
            }

            if (bool2) {
                if (start2 == end2) {
                    return findMedianSortedArrays(nums1, start1, end1, nums2[start2]);
                } else if (start2 > end2) {
                    return findMedianSortedArrays(nums1, start1, end1);
                }
                bool2 = false;
            }
        }
    }

    /**
     * 一个数据+一个数组 [start,end]
     *
     * @param nums
     * @param start
     * @param end
     * @param value
     * @return
     */
    private double findMedianSortedArrays(int[] nums, int start, int end, int value) {
        /**
         * 第一种情况：end>start; 直接返回value
         */
        if (start > end) {
            return value;
        }

        /**
         * 第二种情况：end=start;
         */
        if (end == start) {
            return (nums[start] + value) / 2.0;
        }


        /**
         * 第三种情况：array长度是偶数
         */
        int all = start + end;
        if (all % 2 == 1) {
            int low = nums[all / 2];
            int high = nums[(all + 1) / 2];
            return Math.max(Math.min(high, value), low);
        }

        /**
         * 第四种情况：array是奇数
         */
        int midIndex = all / 2;
        if (nums[midIndex] < value) {
            return (Math.min(nums[midIndex + 1], value) + nums[midIndex]) / 2.0;
        } else if (nums[midIndex] == value) {
            return value;
        } else {
            return (Math.max(nums[midIndex - 1], value) + nums[midIndex]) / 2.0;
        }
    }

    private double findMedianSortedArrays(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int low = nums[(nums.length - 1) / 2];
        int high = nums[nums.length / 2];
        return (low + high) / 2.0;
    }

    private double findMedianSortedArrays(int[] nums, int start, int end) {
        if (start > end) {
            return 0;
        }
        int low = nums[(start + end) / 2];
        int high = nums[(start + end + 1) / 2];
        return (low + high) / 2.0;
    }
}
