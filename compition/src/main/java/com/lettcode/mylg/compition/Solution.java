package com.lettcode.mylg.compition;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Solution {
    public int[] getStrongest(int[] arr, int k) {
        if (arr == null || arr.length <= k) {
            return arr;
        } else if (k == 0) {
            return new int[]{};
        } else if (k == 1 && arr.length == 2) {
            return new int[]{ Math.max(arr[0], arr[1]) };
        }

        Arrays.sort(arr);
        int midIndex = (arr.length - 1) / 2;
        int mid = arr[midIndex];
        int[] need = new int[k];
        int num = 0;
        int twoMid = mid + mid;
        if (k <= midIndex) {
            //从两遍往中间走
            int start = 0, end = arr.length - 1;
            while (arr[start] < arr[midIndex] && arr[end] > arr[midIndex] && num < k) {
                int value = arr[start] + arr[end] - twoMid;
                if (value < 0) {
                    need[num++] = arr[start];
                    start++;
                } else {
                    need[num++] = arr[end];
                    end--;
                }
            }

            /**
             * 转移方针
             */
            while (num < k && arr[start] < arr[midIndex]) {
                need[num++] = arr[start++];
            }

            /**
             * 转移方针
             */
            while (num < k && arr[end] > arr[midIndex]) {
                need[num++] = arr[end--];
            }

            /**
             * 现在全部剩余相等的还是不够
             */
            while (num < k && end >= start) {
                need[num++] = arr[end--];
            }

        } else {
            //从中间向两边走
            int dismiss = arr.length - k;
            Set<Integer> integers = new HashSet<>(dismiss);
            integers.add(midIndex);
            int start = midIndex - 1;
            int end = midIndex + 1;
            while (integers.size() < dismiss && start >= 0 && end <= arr.length - 1) {
                int value = arr[start] + arr[end] - twoMid;
                if (value < 0) {
                    integers.add(end);
                    end++;
                } else {
                    integers.add(start);
                    start--;
                }
            }

            for (int i = 0; i < arr.length && num < k; i++) {
                if (!integers.contains(i)) {
                    need[num++] = arr[i];
                }
            }
        }
        return need;
    }
    /**
     * 5431. 给房子涂色 III 显示英文描述
     * 通过的用户数198
     * 尝试过的用户数321
     * 用户总通过次数210
     * 用户总提交次数530
     * 题目难度Hard
     * 在一个小城市里，有 m 个房子排成一排，你需要给每个房子涂上 n 种颜色之一（颜色编号为 1 到 n ）。有的房子去年夏天已经涂过颜色了，所以这些房子不需要被重新涂色。
     *
     * 我们将连续相同颜色尽可能多的房子称为一个街区。（比方说 houses = [1,2,2,3,3,2,1,1] ，它包含 5 个街区  [{1}, {2,2}, {3,3}, {2}, {1,1}] 。）
     *
     * 给你一个数组 houses ，一个 m * n 的矩阵 cost 和一个整数 target ，其中：
     *
     * houses[i]：是第 i 个房子的颜色，0 表示这个房子还没有被涂色。
     * cost[i][j]：是将第 i 个房子涂成颜色 j+1 的花费。
     * 请你返回房子涂色方案的最小总花费，使得每个房子都被涂色后，恰好组成 target 个街区。如果没有可用的涂色方案，请返回 -1 。
     * 示例 1：
     *
     * 输入：houses = [0,0,0,0,0], cost = [[1,10],[10,1],[10,1],[1,10],[5,1]], m = 5, n = 2, target = 3
     * 输出：9
     * 解释：房子涂色方案为 [1,2,2,1,1]
     * 此方案包含 target = 3 个街区，分别是 [{1}, {2,2}, {1,1}]。
     * 涂色的总花费为 (1 + 1 + 1 + 1 + 5) = 9。
     * 示例 2：
     *
     * 输入：houses = [0,2,1,2,0], cost = [[1,10],[10,1],[10,1],[1,10],[5,1]], m = 5, n = 2, target = 3
     * 输出：11
     * 解释：有的房子已经被涂色了，在此基础上涂色方案为 [2,2,1,2,2]
     * 此方案包含 target = 3 个街区，分别是 [{2,2}, {1}, {2,2}]。
     * 给第一个和最后一个房子涂色的花费为 (10 + 1) = 11。
     * 示例 3：
     *
     * 输入：houses = [0,0,0,0,0], cost = [[1,10],[10,1],[1,10],[10,1],[1,10]], m = 5, n = 2, target = 5
     * 输出：5
     * 示例 4：
     *
     * 输入：houses = [3,1,2,3], cost = [[1,1,1],[1,1,1],[1,1,1],[1,1,1]], m = 4, n = 3, target = 3
     * 输出：-1
     * 解释：房子已经被涂色并组成了 4 个街区，分别是 [{3},{1},{2},{3}] ，无法形成 target = 3 个街区。
     *
     *
     * 提示：
     *
     * m == houses.length == cost.length
     * n == cost[i].length
     * 1 <= m <= 100
     * 1 <= n <= 20
     * 1 <= target <= m
     * 0 <= houses[i] <= n
     * 1 <= cost[i][j] <= 10^4
     * https://leetcode-cn.com/contest/weekly-contest-192/problems/paint-house-iii/
     * @param houses
     * @param cost
     * @param m
     * @param n
     * @param target
     * @return
     */
   /* public int minCost(int[] houses, int[][] cost, int m, int n, int target) {

    }*/
}
