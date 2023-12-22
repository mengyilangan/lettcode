package every107;

import com.alibaba.fastjson.JSON;

import java.util.*;

public class Solution1072 {
    public int maxEqualRowsAfterFlips(int[][] matrix) {
        if (matrix == null || matrix.length <= 0) {
            return 0;
        }

        int cols = matrix[0].length;
        int[] statistics = new int[cols + 1];
        int max = 0;
        for (int[] row : matrix) {
            int one = 0;
            for (int value : row) {
                if (value == 1) {
                    one = one + 1;
                }
            }
            int left = cols - one;
            statistics[one] += 1;
            if (left != one) {
                statistics[cols - one] += 1;
            }
            if (statistics[one] > max) {
                max = statistics[one];
            }
        }
        System.out.println(Arrays.toString(statistics));
        return max;
    }

    /**
     * map:统计
     *
     * @param matrix
     * @return
     */
    public int maxEqualRowsAfterFlipsV1(int[][] matrix) {
        if (matrix == null || matrix.length <= 0) {
            return 0;
        }

        int length = (matrix[0].length + 1) / 2;
        int[] statistics = new int[length];
        int max = 0;
        Map<Integer, List<Integer>> statisticsMap = new HashMap<>();
        for (int i = 0; i < matrix.length; i++) {
            int[] row = matrix[i];
            int one = 0;
            for (int value : row) {
                if (value == 0) {
                    one = one + 1;
                }
            }
            List<Integer> rows = statisticsMap.getOrDefault(one, new ArrayList<>());
            rows.add(i);
            statisticsMap.put(one, rows);
        }
        System.out.println(JSON.toJSON(statisticsMap));
        System.out.println(Arrays.toString(statistics));
        return max;
    }
}
