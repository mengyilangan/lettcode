package com.lettcode.jqn.algorthim.interview;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SpiralTraversalTest {
    private SpiralTraversal spiralTraversal = new SpiralTraversal();

    @Test
    void case1() {
        int[][] matrix = {
                {1, 2, 3, 4, 5},
                {6, 7, 8, 9, 10},
                {11, 12, 13, 14, 15},
                {16, 17, 18, 19, 20}
        };
        String value = spiralTraversal.search(matrix);
        System.out.println(value);
    }

    @Test
    void case2() {
        int[][] matrix = {
                {1, 2, 3, 4, 5},
                {6, 7, 8, 9, 10},
                {11, 12, 13, 14, 15}
        };
        String value = spiralTraversal.search(matrix);
        System.out.println(value);
    }

    @Test
    void case3() {
        int[][] matrix = {
                {1, 2, 3,},
                {4, 5, 6},
                {7, 8, 9},
                {10, 11, 12},
                {13, 14, 15},
        };
        String value = spiralTraversal.search(matrix);
        System.out.println(value);
    }

    @Test
    void case4() {
        int[][] matrix = {
                {1, 2},
                {3, 4}
        };
        String value = spiralTraversal.search(matrix);
        System.out.println(value);
    }
}