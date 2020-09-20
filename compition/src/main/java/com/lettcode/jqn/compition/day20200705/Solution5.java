package com.lettcode.jqn.compition.day20200705;

import java.util.Arrays;

public class Solution5 {
    public boolean canMakeArithmeticProgression(int[] arr) {
        if (arr == null || arr.length <= 1) {
            return true;
        }
        Arrays.sort(arr);
        int distance = arr[1] - arr[0];
        for (int i = 2; i < arr.length; i++) {
            if (arr[i] - arr[i - 1] != distance) {
                return false;
            }
        }
        return true;
    }

    public int getLastMoment(int n, int[] left, int[] right) {
        int max = 0;
        for (int value : left) {
            if (value > max) {
                max = value;
            }
        }

        for (int value : right) {
            if (n - value > max) {
                max = n - value;
            }
        }
        return max;
    }

    /**
     * https://leetcode-cn.com/contest/weekly-contest-196/problems/minimum-possible-integer-after-at-most-k-adjacent-swaps-on-digits/
     * 5455. 最多 K 次交换相邻数位后得到的最小整数 显示英文描述
     * 题目难度Hard
     * 给你一个字符串 num 和一个整数 k 。其中，num 表示一个很大的整数，字符串中的每个字符依次对应整数上的各个 数位 。
     * <p>
     * 你可以交换这个整数相邻数位的数字 最多 k 次。
     * <p>
     * 请你返回你能得到的最小整数，并以字符串形式返回。
     * 示例 1：
     * <p>
     * <p>
     * <p>
     * 输入：num = "4321", k = 4
     * 输出："1342"
     * 解释：4321 通过 4 次交换相邻数位得到最小整数的步骤如上图所示。
     * 示例 2：
     * <p>
     * 输入：num = "100", k = 1
     * 输出："010"
     * 解释：输出可以包含前导 0 ，但输入保证不会有前导 0 。
     * 示例 3：
     * <p>
     * 输入：num = "36789", k = 1000
     * 输出："36789"
     * 解释：不需要做任何交换。
     * 示例 4：
     * <p>
     * 输入：num = "22", k = 22
     * 输出："22"
     * 示例 5：
     * <p>
     * 输入：num = "9438957234785635408", k = 23
     * 输出："0345989723478563548"
     * <p>
     * <p>
     * 提示：
     * <p>
     * 1 <= num.length <= 30000
     * num 只包含 数字 且不含有 前导 0 。
     * 1 <= k <= 10^9
     */
    public String minInteger(String num, int k) {
        return "";
    }

    /**
     * https://leetcode-cn.com/contest/weekly-contest-196/problems/count-submatrices-with-all-ones/
     * 5454. 统计全 1 子矩形
     * 给你一个只包含 0 和 1 的 rows * columns 矩阵 mat ，请你返回有多少个 子矩形 的元素全部都是 1 。
     * 示例 1：
     *
     * 输入：mat = [[1,0,1],
     *             [1,1,0],
     *             [1,1,0]]
     * 输出：13
     * 解释：
     * 有 6 个 1x1 的矩形。
     * 有 2 个 1x2 的矩形。
     * 有 3 个 2x1 的矩形。
     * 有 1 个 2x2 的矩形。
     * 有 1 个 3x1 的矩形。
     * 矩形数目总共 = 6 + 2 + 3 + 1 + 1 = 13 。
     * 示例 2：
     *
     * 输入：mat = [[0,1,1,0],
     *             [0,1,1,1],
     *             [1,1,1,0]]
     * 输出：24
     * 解释：
     * 有 8 个 1x1 的子矩形。
     * 有 5 个 1x2 的子矩形。
     * 有 2 个 1x3 的子矩形。
     * 有 4 个 2x1 的子矩形。
     * 有 2 个 2x2 的子矩形。
     * 有 2 个 3x1 的子矩形。
     * 有 1 个 3x2 的子矩形。
     * 矩形数目总共 = 8 + 5 + 2 + 4 + 2 + 2 + 1 = 24 。
     * 示例 3：
     *
     * 输入：mat = [[1,1,1,1,1,1]]
     * 输出：21
     * 示例 4：
     *
     * 输入：mat = [[1,0,1],[0,1,0],[1,0,1]]
     * 输出：5
     *
     *
     * 提示：
     *
     * 1 <= rows <= 150
     * 1 <= columns <= 150
     * 0 <= mat[i][j] <= 1
     */

}
