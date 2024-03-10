package com.lettcode.mylg.compition.weekly379;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author mylg
 * @date 7/1/24
 */
class Solution100187Test {

    private Solution100187 solution = new Solution100187();

    @Test
    void minMovesToCaptureTheQueen() {
        /**
         * 4
         * 3
         * 3
         * 4
         * 5
         * 2
         */
        int res = solution.minMovesToCaptureTheQueen(4, 3, 3, 4, 5, 2);
        System.out.println(res);
    }
}
