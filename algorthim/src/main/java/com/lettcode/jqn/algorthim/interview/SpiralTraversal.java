package com.lettcode.jqn.algorthim.interview;

/**
 * 螺旋遍历数组
 */
public class SpiralTraversal {
    public String search(int[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            return null;
        }
        StringBuilder stringBuilder = new StringBuilder();
        if (matrix.length == 1 || matrix[0].length == 1) {
            for (int a[] : matrix) {
                for (int v : a) {
                    stringBuilder.append(v).append(',');
                }
            }
            return stringBuilder.toString();
        }


        for (int i = 0; i < matrix.length; i++) {
            if (!append(matrix, i, stringBuilder)) {
                break;
            }
        }
        return stringBuilder.toString();
    }

    private boolean append(int[][] matrix, int index, StringBuilder stringBuilder) {
        if (index >= matrix.length) {
            return false;
        }
        int row = index;
        int endRow = matrix.length - row - 1;
        int col = index;
        int colEnd = matrix[index].length - col - 1;

        if (row >= endRow && col >= colEnd) {
            return false;
        }
        for (int i = col; i < colEnd; i++) {
            stringBuilder.append(matrix[row][i]).append(',');
        }

        for (int i = row; i < endRow; i++) {
            stringBuilder.append(matrix[i][colEnd]).append(',');
        }

        if (row == endRow || colEnd == col) {
            stringBuilder.append(matrix[endRow][colEnd]).append(",");
            return false;
        }

        for (int i = colEnd; i > col; i--) {
            stringBuilder.append(matrix[endRow][i]).append(',');
        }

        for (int i = endRow; i > row; i--) {
            stringBuilder.append(matrix[i][col]).append(',');
        }
        return true;
    }
}
