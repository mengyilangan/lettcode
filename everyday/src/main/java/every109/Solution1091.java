package every109;

import java.util.Arrays;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

/**
 * link:https://leetcode.cn/problems/shortest-path-in-binary-matrix/
 */
public class Solution1091 {
    /**
     * 给你一个 n x n 的二进制矩阵 grid 中，返回矩阵中最短 畅通路径 的长度。如果不存在这样的路径，返回 -1 。
     * <p>
     * 二进制矩阵中的 畅通路径 是一条从 左上角 单元格（即，(0, 0)）到 右下角 单元格（即，(n - 1, n - 1)）的路径，该路径同时满足下述要求：
     * <p>
     * 路径途经的所有单元格都的值都是 0 。
     * 路径中所有相邻的单元格应当在 8 个方向之一 上连通（即，相邻两单元之间彼此不同且共享一条边或者一个角）。
     * 畅通路径的长度 是该路径途经的单元格总数。
     *
     *  数据范围：n == grid.length
     *         n == grid[i].length
     *         1 <= n <= 100
     *         grid[i][j] 为 0 或 1
     * @param grid
     * @return
     */

    /**
     * 用递归
     *
     * @param grid
     * @return
     */
    public int shortestPathBinaryMatrix(int[][] grid) {
        int n = grid.length;
        if (grid[0][0] == 1 || grid[n - 1][n - 1] == 1) {
            return -1;
        }

        if (n == 1) {
            return 1;
        }
        int[][] dp = new int[n][n];
        dp[0][0] = 1;
        try {
            tryBoundaryJump(0, 0, grid, dp);
        } catch (Exception e) {
            e.printStackTrace();
        }

        if (dp[n - 1][n - 1] == 0) {
            return -1;
        } else {
            return dp[n - 1][n - 1];
        }
    }

    /**
     * 如何减少试探
     *
     * @param row
     * @param col
     * @param grid
     * @param dp
     */
    public void tryBoundaryJump(int row, int col, int[][] grid, int[][] dp) {
        //当前节点是1,不能跳，终止
        int up = row - 1;
        int down = row + 1;
        int left = col - 1;
        int right = col + 1;
        int newJump = dp[row][col] + 1;

        boolean upTry = up >= 0;

        boolean downTry = down < grid.length;

        boolean leftTry = left >= 0;

        boolean rightTry = right < grid.length;

        if (downTry && rightTry) {
            //向右下
            tryCurrentJump(down, right, newJump, grid, dp);
        }

        if (downTry) {
            //向下
            tryCurrentJump(down, col, newJump, grid, dp);
        }

        if (rightTry) {
            //向右
            tryCurrentJump(row, right, newJump, grid, dp);
        }


        if (upTry && rightTry) {
            //向右上
            tryCurrentJump(up, right, newJump, grid, dp);
        }

        if (downTry && leftTry) {
            //向左下
            tryCurrentJump(down, left, newJump, grid, dp);
        }


        if (upTry) {
            //向上
            tryCurrentJump(up, col, newJump, grid, dp);
        }


        if (leftTry) {
            //向左
            tryCurrentJump(row, left, newJump, grid, dp);
        }

        if (leftTry && upTry) {
            //向左上
            tryCurrentJump(up, left, newJump, grid, dp);
        }

    }

    public void tryCurrentJump(int row, int col, int newJump, int[][] grid, int[][] dp) {
        //不是1,调不过来
        if (grid[row][col] == 1) {
            return;
        }
        //现有已经ok不必重新试探
        if (dp[row][col] > 0 && dp[row][col] <= newJump) {
            return;
        }

        dp[row][col] = newJump;
        int n = grid.length - 1;
        //已经达到最佳,没必要全部计算了
        if (row == n && col == n && newJump == n + 2) {
            throw new IllegalArgumentException("不需要再次计算");
        }
        tryBoundaryJump(row, col, grid, dp);
    }


    public int shortestPathBinaryMatrixV1(int[][] grid) {
        Stack<int[]> stack = new Stack<>();
        int n = grid.length;
        if (grid[0][0] == 1 || grid[n - 1][n - 1] == 1) {
            return -1;
        }
        //是否观测过
        boolean[][] visited = new boolean[n][n];
        List<int[]> directions = Arrays.asList(new int[]{1, 1}, new int[]{1, 0}, new int[]{1, -1}, new int[]{0, 1}, new int[]{0, -1}, new int[]{-1, 1}, new int[]{-1, 0}, new int[]{-1, -1});
        if (n == 1) {
            return 1;
        }
        stack.push(new int[]{0, 0});
        int steps = 1;
        do {
            steps += 1;
            Stack<int[]> nextRound = new Stack<>();
            while (!stack.isEmpty()) {
                int[] point = stack.pop();
                for (int[] direction : directions) {
                    int row = point[0] + direction[0];
                    int col = point[1] + direction[1];
                    if (row < 0 || row >= n || col < 0 || col >= n) {
                        continue;
                    }
                    //访问过也不处理
                    if (visited[row][col]) {
                        continue;
                    }

                    if (grid[row][col] == 1) {
                        continue;
                    }

                    if (row == n - 1 && col == n - 1) {
                        return steps;
                    }
                    nextRound.push(new int[]{row, col});
                    visited[row][col] = true;
                }
            }
            stack = nextRound;
        } while (!stack.isEmpty());
        return -1;
    }


}
