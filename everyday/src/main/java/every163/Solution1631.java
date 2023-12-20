package every163;

import java.util.Arrays;

/**
 * https://leetcode.cn/problems/path-with-minimum-effort/?envType=daily-question&envId=2023-12-11
 * <p>
 * 你准备参加一场远足活动。给你一个二维 rows x columns 的地图 heights ，其中 heights[row][col] 表示格子 (row, col) 的高度。一开始你在最左上角的格子 (0, 0) ，且你希望去最右下角的格子 (rows-1, columns-1) （注意下标从 0 开始编号）。你每次可以往 上，下，左，右 四个方向之一移动，你想要找到耗费 体力 最小的一条路径。
 * <p>
 * 一条路径耗费的 体力值 是路径上相邻格子之间 高度差绝对值 的 最大值 决定的。
 * <p>
 * 请你返回从左上角走到右下角的最小 体力消耗值 。
 * <p>
 * rows == heights.length
 * columns == heights[i].length
 * 1 <= rows, columns <= 100
 * 1 <= heights[i][j] <= 106
 * case1:
 * 输入：heights = [[1,2,2],[3,8,2],[5,3,5]]
 * 输出：2
 * 解释：路径 [1,3,5,3,5] 连续格子的差值绝对值最大为 2 。
 * 这条路径比路径 [1,2,2,2,5] 更优，因为另一条路径差值最大值为 3 。
 * <p>
 * case2:
 * 输入：heights = [[1,2,3],[3,8,4],[5,3,5]]
 * 输出：1
 * 解释：路径 [1,2,3,4,5] 的相邻格子差值绝对值最大为 1 ，比路径 [1,3,5,3,5] 更优。
 * <p>
 * case3:
 * 输入：heights = [[1,2,1,1,1],[1,2,1,2,1],[1,2,1,2,1],[1,2,1,2,1],[1,1,1,2,1]]
 * 输出：0
 * 解释：上图所示路径不需要消耗任何体力。
 */
public class Solution1631 {

    /**
     * 最大里找最小
     *
     * @param heights
     * @return
     */
    public int minimumEffortPath(int[][] heights) {
        int m = heights.length;
        int n = heights[0].length;
        if (m == 1) {
            int max = 0;
            for (int[] row : heights) {
                for (int i = 1; i < n; i++) {
                    max = Math.max(Math.abs(row[i] - row[i - 1]), max);
                }
            }
            return max;
        } else if (n == 1) {
            int max = 0;
            for (int i = 1; i < m; i++) {
                max = Math.max(Math.abs(heights[i][0] - heights[i - 1][0]), max);
            }
            return max;
        }

        //dp思想
        int[][] dp = new int[m][n];
        for (int i = 0; i < dp.length; i++) {
            dp[i] = new int[n];
            Arrays.fill(dp[i], -1);
        }

        dp[0][0] = 0;
        return 0;
    }
}
