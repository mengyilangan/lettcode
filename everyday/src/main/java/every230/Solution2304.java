package every230;

/**
 * 2304. 网格中的最小路径代价
 * 提示
 * 中等
 * 22
 * 相关企业
 * 给你一个下标从 0 开始的整数矩阵 grid ，矩阵大小为 m x n ，由从 0 到 m * n - 1 的不同整数组成。你可以在此矩阵中，从一个单元格移动到 下一行 的任何其他单元格。
 * 如果你位于单元格 (x, y) ，且满足 x < m - 1 ，你可以移动到 (x + 1, 0), (x + 1, 1), ..., (x + 1, n - 1) 中的任何一个单元格。
 * 注意： 在最后一行中的单元格不能触发移动。
 * <p>
 * 每次可能的移动都需要付出对应的代价，代价用一个下标从 0 开始的二维数组 moveCost 表示，该数组大小为 (m * n) x n ，
 * 其中 moveCost[i][j] 是从值为 i 的单元格移动到下一行第 j 列单元格的代价。从 grid 最后一行的单元格移动的代价可以忽略。
 * <p>
 * grid 一条路径的代价是：所有路径经过的单元格的 值之和 加上 所有移动的 代价之和 。从 第一行 任意单元格出发，返回到达 最后一行 任意单元格的最小路径代价。
 * https://leetcode.cn/problems/minimum-path-cost-in-a-grid/
 * <p>
 * 输入：grid = [[5,1,2],[4,0,3]], moveCost = [[12,10,15],[20,23,8],[21,7,1],[8,1,13],[9,10,25],[5,3,2]]
 * 输出：6
 * 解释：
 * 最小代价的路径是 2 -> 3 。
 * - 路径途经单元格值之和 2 + 3 = 5 。
 * - 从 2 移动到 3 的代价为 1 。
 * 路径总代价为 5 + 1 = 6 。
 * m == grid.length
 * n == grid[i].length
 * 2 <= m, n <= 50
 * grid 由从 0 到 m * n - 1 的不同整数组成
 * moveCost.length == m * n
 * moveCost[i].length == n
 * 1 <= moveCost[i][j] <= 100
 */
public class Solution2304 {
    public int minPathCost(int[][] grid, int[][] moveCost) {
        int m = grid.length;
        int value[] = initDefaultValue(moveCost.length);
        //初始化第一层
        for (int n : grid[0]) {
            value[n] = n;
        }

        //循环找每一层
        for (int i = 1; i < grid.length; i++) {
            distance(value, grid[i - 1], grid[i], moveCost);
        }

        //寻找最小的值
        int min = Integer.MAX_VALUE;
        for (int n : grid[m - 1]) {
            min = Math.min(value[n], min);
        }
        return min;
    }

    private int[] initDefaultValue(int n) {
        int value[] = new int[n];
        for (int i = 0; i < n; i++) {
            value[i] = Integer.MAX_VALUE;
        }
        return value;
    }


    //计算每一个距离
    private void distance(int[] value, int[] starts, int[] ends, int[][] moveCost) {
        for (int start : starts) {
            //这一轮的耗费值
            int[] costs = moveCost[start];
            for (int i = 0; i < ends.length; i++) {
                int end = ends[i];
                int cost = value[start] + costs[i] + end;
                value[end] = Math.min(value[end], cost);
            }
        }
    }
}
