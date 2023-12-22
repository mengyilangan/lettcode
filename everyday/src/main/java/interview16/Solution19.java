package interview16;

import java.util.*;
import java.util.stream.Collectors;

/**
 * https://leetcode.cn/problems/pond-sizes-lcci/
 * <p>
 * 你有一个用于表示一片土地的整数矩阵land，该矩阵中每个点的值代表对应地点的海拔高度。
 * 若值为0则表示水域。由垂直、水平或对角连接的水域为池塘。
 * 池塘的大小是指相连接的水域的个数。
 * 编写一个方法来计算矩阵中所有池塘的大小，返回值需要从小到大排序。
 * <p>
 * 0 < len(land) <= 1000
 * 0 < len(land[i]) <= 1000
 */
public class Solution19 {


    public int[] pondSizes(int[][] land) {
        if (land.length == 0) {
            return new int[0];
        }
        Pond pond = new Pond(land);
        for (int i = 0; i < land.length; i++) {
            for (int j = 0; j < land[i].length; j++) {
                if (land[i][j] == 0) {
                    pond.addWater(i, j);
                }
            }
        }
        if (pond.max == 0) {
            return new int[0];
        }

        int[] result = new int[pond.max + 1];
        int[][] waters = pond.waters;
        for (int i = 0; i < waters.length; i++) {
            for (int j = 0; j < waters[i].length; j++) {
                int sign = waters[i][j];
                result[sign] += 1;
            }
        }

        result[0] = 0;
        List<Integer> list = Arrays.stream(result).filter(i -> i > 0).boxed().sorted().collect(Collectors.toList());
        int[] finalResult = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            finalResult[i] = list.get(i);
        }
        return finalResult;
    }

    /**
     * 水域
     */
    private static class Pond {
        private static final int[][] directions = {{-1, -1}, {-1, 0}, {-1, 1}, {0, -1}, {0, 1}, {1, -1,}, {1, 0}, {1, 1}};

        private int[][] waters;

        private int[][] lands;
        private int max = 0;

        private int maxRow;

        private int maxColumn;

        public Pond(int[][] lands) {
            maxRow = lands.length - 1;
            maxColumn = lands[0].length - 1;
            waters = new int[lands.length][lands[0].length];
            this.lands = lands;
        }

        private void addWater(int row, int column) {
            //已经遍历过
            if (waters[row][column] > 0) {
                return;
            }

            for (int[] direction : directions) {
                int newRow = row + direction[0];
                int newColumn = column + direction[1];
                if (newColumn < 0 || newRow < 0 || newRow > maxRow || newColumn > maxColumn) {
                    continue;
                }
                if (waters[newRow][newColumn] > 0) {
                    int value = waters[newRow][newColumn];
                    waters[row][column] = value;
                    soundings(row, column, value);
                    return;
                }
            }

            max += 1;
            waters[row][column] = max;
            soundings(row, column, max);
        }

        /**
         * 遍历四周
         *
         * @param row
         * @param column
         */
        private void soundings(int row, int column, int value) {
            for (int[] direction : directions) {
                int newRow = row + direction[0];
                int newColumn = column + direction[1];
                if (newColumn < 0 || newRow < 0 || newRow > maxRow || newColumn > maxColumn) {
                    continue;
                }
                if (waters[newRow][newColumn] > 0) {
                    continue;
                }
                if (lands[newRow][newColumn] == 0) {
                    waters[newRow][newColumn] = value;
                    soundings(newRow, newColumn, value);
                }
            }
        }
    }
}
