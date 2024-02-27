package com.lettcode.mylg.compition.weekly375;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class Solution100137Test {
    private Solution100137 solution = new Solution100137();

    @Test
    void countSubarrays1() {
        int[] nums = {1, 3, 2, 3, 3};
        int k = 2;
        long res = solution.countSubarrays(nums, k);
        System.out.println(res);
    }

    @Test
    void countSubarrays2() {
        int[] nums = {61, 23, 38, 23, 56, 40, 82, 56, 82, 82, 82, 70, 8, 69, 8, 7, 19, 14, 58, 42, 82, 10, 82, 78, 15, 82};
        int k = 2;
        long res = solution.countSubarrays(nums, k);
        System.out.println(res);
    }

    @Test
    void count3() {
        int[] nums = {37, 20, 38, 66, 34, 38, 9, 41, 1, 14, 25, 63, 8, 12, 66, 66, 60, 12, 35, 27, 16, 38, 12, 66, 38, 36, 59, 54, 66, 54, 66, 48, 59, 66, 34, 11, 50, 66, 42, 51, 53, 66, 31, 24, 66, 44, 66, 1, 66, 66, 29, 54};
        int k = 5;
        long res = solution.countSubarrays(nums, k);
        Assertions.assertEquals(594, res);
    }
}