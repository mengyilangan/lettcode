package every190;

import java.util.Stack;

/**
 * 一个 2D 网格中的 峰值 是指那些 严格大于 其相邻格子(上、下、左、右)的元素。
 * <p>
 * 给你一个 从 0 开始编号 的 m x n 矩阵 mat ，其中任意两个相邻格子的值都 不相同 。找出 任意一个 峰值 mat[i][j] 并 返回其位置 [i,j] 。
 * <p>
 * 你可以假设整个矩阵周边环绕着一圈值为 -1 的格子。
 * 要求必须写出时间复杂度为 O(m log(n)) 或 O(n log(m)) 的算法
 * <p>
 * 输入: mat = [[1,4],[3,2]]
 * 输出: [0,1]
 * 解释: 3 和 4 都是峰值，所以[1,0]和[0,1]都是可接受的答案。
 * <p>
 * 输入: mat = [[10,20,15],[21,30,14],[7,16,32]]
 * 输出: [1,1]
 * 解释: 30 和 32 都是峰值，所以[1,1]和[2,2]都是可接受的答案。
 * <p>
 * m == mat.length
 * n == mat[i].length
 * 1 <= m, n <= 500
 * 1 <= mat[i][j] <= 105
 * 任意两个相邻元素均不相等.
 */
public class Solution1901 {
    //一行比较
    private int[] oneRow(int[] mat) {
        int maxIndex = mat.length - 1;
        int[] value = new int[2];
        if (maxIndex == 1) {
            return value;
        }

        for (int i = 0; i < maxIndex; i++) {
            if (mat[i] > mat[i + 1]) {
                value[1] = i;
                return value;
            }
        }
        return null;
    }

    //找峰值
    //一列比较
    private int[] oneCol(int[][] mat) {
        int maxIndex = mat.length - 1;
        int[] value = new int[2];
        for (int i = 0; i < maxIndex; i++) {
            if (mat[i][0] > mat[i + 1][0]) {
                value[0] = i;
                return value;
            }
        }
        return null;
    }


    public int[] findPeakGrid(int[][] mat) {
        int m = mat.length, n = mat[0].length;
        int low = 0, high = m - 1;
        while (low <= high) {
            int i = (low + high) / 2;
            int j = -1, maxElement = -1;
            for (int k = 0; k < n; k++) {
                if (mat[i][k] > maxElement) {
                    j = k;
                    maxElement = mat[i][k];
                }
            }

            //找到最大值
            if (i - 1 >= 0 && mat[i][j] < mat[i - 1][j]) {
                high = i - 1;
                continue;
            }
            if (i + 1 < m && mat[i][j] < mat[i + 1][j]) {
                low = i + 1;
                continue;
            }
            return new int[]{i, j};
        }
        return new int[0]; // impossible
    }
}
