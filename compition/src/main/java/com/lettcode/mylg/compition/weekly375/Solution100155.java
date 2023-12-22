package com.lettcode.mylg.compition.weekly375;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.cn/contest/weekly-contest-375/problems/double-modular-exponentiation/
 * 给你一个下标从 0 开始的二维数组 variables ，其中 variables[i] = [ai, bi, ci, mi]，以及一个整数 target 。
 * <p>
 * 如果满足以下公式，则下标 i 是 好下标：
 * <p>
 * 0 <= i < variables.length
 * ((aibi % 10)ci) % mi == target
 * 返回一个由 好下标 组成的数组，顺序不限 。
 * 1 <= variables.length <= 100
 * variables[i] == [ai, bi, ci, mi]
 * 1 <= ai, bi, ci, mi <= 103
 * 0 <= target <= 103
 */

public class Solution100155 {
    public List<Integer> getGoodIndices(int[][] variables, int target) {
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < variables.length; i++) {
            int[] variable = variables[i];
            if (variable[3] <= target) {
                continue;
            }
            int a = variable[0];
            int b = variable[1];
            int c = variable[2];
            int m = variable[3];
            int res = 1;
            for (int j = 1; j <= b; j++) {
                res = (res * a) % 10;
            }

            int multi = 1;
            for (int j = 1; j <= c; j++) {
                multi = (multi * res) % m;
            }

            if (multi == target) {
                result.add(i);
            }
        }
        return result;
    }
}
