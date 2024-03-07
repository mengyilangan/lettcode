package com.lettcode.jqn.algorthim.interview;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class NumberSumTest {
    private NumberSum numberSum = new NumberSum();

    @Test
    void twoSum() {
        int[] array = {5, 12, 6, 3, 9, 2, 1, 7};
        List<int[]> resList = numberSum.twoSum(array, 13);
        for (int[] res : resList) {
            System.out.println(Arrays.toString(res));
        }
    }

    @Test
    void threeSum1() {
        int[] array = {5, 12, 6, 3, 9, 2, 1, 7};
        List<int[]> resList = numberSum.threeSum(array, 13);
        for (int[] res : resList) {
            System.out.println(Arrays.toString(res));
        }
    }

    @Test
    void threeSum2() {
        int[] array = {5, 12, 6, 3, 9, 2, 1, 7};
        List<int[]> resList = numberSum.threeSum1(array, 13);
        for (int[] res : resList) {
            System.out.println(Arrays.toString(res));
        }
    }
}