package com.lettcode.jqn.algorthim.interview;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class KthLargestNumberTest {
    private KthLargestNumber largestNumber = new KthLargestNumber();

    private int[] buildArray() {
        return new int[]{7, 5, 15, 3, 17, 2, 20, 24, 1, 9, 12, 8};
    }


    /**
     * 选择排序
     */
    @Test
    public void sort() {
        int v = largestNumber.sortK(buildArray(), 5);
        System.out.println(v);
    }

    /**
     * 插入排序
     */
    @Test
    public void sortInsert() {
        int v = largestNumber.sortInsertK(buildArray(), 5);
        System.out.println(v);
    }

    @Test
    public void sortQuick() {
        int v = largestNumber.divideAndConquer(buildArray(), 5);
        System.out.println(v);
    }

    @Test
    public void testOther() {
        for (int i = 2; i < 12; i++) {
            int v1 = largestNumber.sortInsertK(buildArray(), i);
            int v2 = largestNumber.divideAndConquer(buildArray(), i);
            Assertions.assertEquals(v1, v2);
        }
    }
}