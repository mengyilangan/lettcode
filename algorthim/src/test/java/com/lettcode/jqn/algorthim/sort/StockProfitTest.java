package com.lettcode.jqn.algorthim.sort;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StockProfitTest {
    private StockProfit stockProfit = new StockProfit();

    @Test
    void oneTimes() {
        int[] arr = {9, 2, 7, 4, 3, 1, 8, 4};
        int v = stockProfit.oneTimes(arr);
        Assertions.assertEquals(7, v);
    }

    @Test
    void multiTimes() {
        int[] arr = {5, 1, 6, 3, 8, 2, 4, 7};
        int v = stockProfit.multiTimes(arr);
        Assertions.assertEquals(15, v);
    }

    @Test
    void test() {
        Integer i1 = new Integer(178);
        int i2 = 178;
        System.out.println(i1 == i2);
    }
}