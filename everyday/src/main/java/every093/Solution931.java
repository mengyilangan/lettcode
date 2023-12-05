package every093;

/**
 * https://leetcode.cn/problems/minimum-falling-path-sum/
 * 给你一个 n x n 的 方形 整数数组 matrix ，请你找出并返回通过 matrix 的下降路径 的 最小和 。
 * <p>
 * 下降路径 可以从第一行中的任何元素开始，并从每一行中选择一个元素。在下一行选择的元素和当前行所选元素最多相隔一列（即位于正下方或者沿对角线向左或者向右的第一个元素）。具体来说，位置 (row, col) 的下一个元素应当是 (row + 1, col - 1)、(row + 1, col) 或者 (row + 1, col + 1) 。
 * <p>
 * n == matrix.length == matrix[i].length
 * 1 <= n <= 100
 * -100 <= matrix[i][j] <= 100
 */
public class Solution931 {
    public int minFallingPathSum(int[][] matrix) {
        if (matrix.length == 1) {
            return matrix[0][0];
        }

        int n = matrix.length;
        int[] before = new int[n];
        int min = Integer.MAX_VALUE;
        for (int[] ints : matrix) {
            int[] current = new int[n];
            current[0] = ints[0] + Math.min(before[0], before[1]);
            current[n - 1] = ints[n - 1] + Math.min(before[n - 2], before[n - 1]);
            min = Math.min(current[0], current[n - 1]);
            for (int j = 1; j < n - 1; j++) {
                current[j] = ints[j] + Math.min(Math.min(before[j - 1], before[j]), before[j + 1]);
                min = Math.min(min, current[j]);
            }
            before = current;
        }
        return min;
    }
}
