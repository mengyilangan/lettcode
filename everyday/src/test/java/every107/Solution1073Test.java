package every107;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class Solution1073Test {

    private Solution1073 solution1073 = new Solution1073();

    @Test
    public void test1() {
        int[] arr1 = {1, 1, 1, 1, 1};
        int[] arr2 = {1, 0, 1};
        int[] res = solution1073.addNegabinary(arr1, arr2);
        System.out.printf(Arrays.toString(res));
    }

    @Test
    public void test2() {
        int[] arr1 = {0};
        int[] arr2 = {0};
        int[] res = solution1073.addNegabinary(arr1, arr2);
        System.out.printf(Arrays.toString(res));
    }

    @Test
    public void test3() {
        int[] arr1 = {0};
        int[] arr2 = {1};
        int[] res = solution1073.addNegabinary(arr1, arr2);
        System.out.printf(Arrays.toString(res));
    }
}