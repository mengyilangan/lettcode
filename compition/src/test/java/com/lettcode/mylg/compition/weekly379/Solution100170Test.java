package com.lettcode.mylg.compition.weekly379;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author mylg
 * @date 7/1/24
 */
class Solution100170Test {
    private Solution100170 solution = new Solution100170();

    @Test
    void areaOfMaxDiagonal() {
        int[][] a = { { 2, 6 }, { 5, 1 }, { 3, 10 }, { 8, 4 } };
        solution.areaOfMaxDiagonal(a);
    }
}
