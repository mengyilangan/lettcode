package com.lettcode.jqn.compition;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

class SolutionTest {

    Solution solution29 = new Solution();

    @Test
    void strong() {
        int[] result = solution29.getStrongest(new int[]{ 1, 2, 3, 4, 5 }, 2);
        System.out.println(Arrays.toString(result));
        Assertions.assertArrayEquals(new int[]{ 1, 5 }, result);
    }

    @Test
    void strong1() {
        int[] result = solution29.getStrongest(new int[]{ 1, 1, 3, 5, 5 }, 2);
        System.out.println(Arrays.toString(result));
        Assertions.assertArrayEquals(new int[]{ 5, 5 }, result);
    }

    @Test
    void strong2() {
        int[] result = solution29.getStrongest(new int[]{ 6, 6, 7, 7, 8, 11 }, 5);
        System.out.println(Arrays.toString(result));
        Assertions.assertArrayEquals(new int[]{ 6, 6, 7, 8, 11 }, result);
    }

    @Test
    void strong3() {
        int[] result = solution29.getStrongest(new int[]{ 6, -3, 7, 2, 11 }, 3);
        System.out.println(Arrays.toString(result));
        Assertions.assertArrayEquals(new int[]{ -3, 11, 2 }, result);
    }
}
