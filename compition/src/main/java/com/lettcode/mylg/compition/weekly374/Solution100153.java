package com.lettcode.mylg.compition.weekly374;

import java.util.*;
import java.util.stream.Collectors;

/**
 * https://leetcode.cn/contest/weekly-contest-374/problems/minimum-number-of-coins-to-be-added/
 * 给你一个下标从 0 开始的整数数组 coins，表示可用的硬币的面值，以及一个整数 target 。
 * <p>
 * 如果存在某个 coins 的子序列总和为 x，那么整数 x 就是一个 可取得的金额 。
 * <p>
 * 返回需要添加到数组中的 任意面值 硬币的 最小数量 ，使范围 [1, target] 内的每个整数都属于 可取得的金额 。
 * <p>
 * 数组的 子序列 是通过删除原始数组的一些（可能不删除）元素而形成的新的 非空 数组，删除过程不会改变剩余元素的相对位置。
 * <p>
 * 1 <= target <= 105
 * 1 <= coins.length <= 105
 * 1 <= coins[i] <= target
 */
public class Solution100153 {
    public int minimumAddedCoins(int[] coins, int target) {
        List<Integer> list = Arrays.stream(coins).boxed().sorted().collect(Collectors.toList());
        int[] index = new int[target + 1];
        int[] sum = new int[target + 1];
        for (int coin : coins) {
            index[coin] += 1;
            sum[coin] = coin;
        }
        return 0;
    }
}
