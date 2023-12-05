package every266;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.cn/problems/first-completely-painted-row-or-column/?envType=daily-question&envId=2023-12-01
 * 给你一个下标从 0 开始的整数数组 arr 和一个 m x n 的整数 矩阵 mat 。arr 和 mat 都包含范围 [1，m * n] 内的 所有 整数。
 * <p>
 * 从下标 0 开始遍历 arr 中的每个下标 i ，并将包含整数 arr[i] 的 mat 单元格涂色。
 * <p>
 * 请你找出 arr 中在 mat 的某一行或某一列上都被涂色且下标最小的元素，并返回其下标 i
 * <p>
 * m == mat.length
 * n = mat[i].length
 * arr.length == m * n
 * 1 <= m, n <= 105
 * 1 <= m * n <= 105
 * 1 <= arr[i], mat[r][c] <= m * n
 * arr 中的所有整数 互不相同
 * mat 中的所有整数 互不相同
 */
public class Solution2661 {
    public int firstCompleteIndex(int[] arr, int[][] mat) {
        //只有一行或者一列,需要遍历全部
        int m = mat.length;
        int n = mat[0].length;
        if (m == 1 || n == 1) {
            return arr.length - 1;
        }
        Map<Integer, Integer> numberIndex = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            numberIndex.put(arr[i], i);
        }
        return firstCompleteIndex(numberIndex, mat);
    }

    public int firstCompleteIndex(Map<Integer, Integer> numberIndex, int[][] mat) {
        int[] row = new int[mat.length];
        int[] col = new int[mat[0].length];
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[i].length; j++) {
                int index = numberIndex.get(mat[i][j]);
                row[i] = Integer.max(index, row[i]);
                col[j] = Integer.max(index, col[j]);
            }
        }
        int min = Integer.MAX_VALUE;
        for (int index : row) {
            min = Math.min(min, index);
        }

        for (int index : col) {
            min = Math.min(min, index);
        }

        return min;
    }
}
