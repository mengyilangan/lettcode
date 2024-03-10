package com.lettcode.jqn.algorthim.sort;

import java.util.Map;

/**
 * 股票交易，一次卖入卖出
 */
public class StockProfit {
    public int oneTimes(int[] prices) {
        int max = Integer.max(prices[1] - prices[0], 0);
        int min = Integer.min(prices[0], prices[1]);
        for (int i = 2; i < prices.length; i++) {
            int value = prices[i] - prices[min];
            if (value > 0) {
                max = Math.max(max, value);
            } else {
                min = i;
            }
        }
        return max;
    }

    public int multiTimes(int[] prices) {
        int sum = 0;
        int start = 0;
        while (start < prices.length) {
            int out = start;
            while (start < prices.length - 1 && prices[start + 1] > prices[start]) {
                start++;
            }
            if (start > out) {
                sum += prices[start] - prices[out];
            }
            start = start + 1;
        }
        return sum;
    }
}
