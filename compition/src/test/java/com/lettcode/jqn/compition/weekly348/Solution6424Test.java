package com.lettcode.jqn.compition.weekly348;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Solution6424Test {

    @Test
    void semiOrderedPermutation() {
        Solution6424 solution = new Solution6424();
        int[] value = {2, 1, 4, 3};
        int result = solution.semiOrderedPermutation(value);
        System.out.println(result);
    }

    @Test
    void semiOrderedPermutationCase2() {
        Solution6424 solution = new Solution6424();
        int[] value = {2, 4, 1, 3};
        int result = solution.semiOrderedPermutation(value);
        System.out.println(result);
    }
}