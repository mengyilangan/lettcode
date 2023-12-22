package com.lettcode.mylg.compition.weekly348;

import java.util.Map;
import java.util.TreeMap;

/**
 * https://leetcode.cn/contest/weekly-contest-348/problems/sum-of-matrix-after-queries/
 * 给你一个整数 n 和一个下标从 0 开始的 二维数组 queries ，其中 queries[i] = [typei, indexi, vali] 。
 * <p>
 * 一开始，给你一个下标从 0 开始的 n x n 矩阵，所有元素均为 0 。每一个查询，你需要执行以下操作之一：
 * <p>
 * 如果 typei == 0 ，将第 indexi 行的元素全部修改为 vali ，覆盖任何之前的值。
 * 如果 typei == 1 ，将第 indexi 列的元素全部修改为 vali ，覆盖任何之前的值。
 * 请你执行完所有查询以后，返回矩阵中所有整数的和。
 * <p>
 * 1 <= n <= 104
 * 1 <= queries.length <= 5 * 104
 * queries[i].length == 3
 * 0 <= typei <= 1
 * 0 <= indexi < n
 * 0 <= vali <= 105
 */
public class Solution6472 {

    public long matrixSumQueriesV1(int n, int[][] queries) {
        if (queries.length <= n) {
            return matrixSumQueriesDirect(n, queries);
        }
        return matrixSumQueriesRepeatMore(n, queries);
    }

    /**
     * 全部替换之后才处理
     *
     * @param n
     * @param queries
     * @return
     */
    public long matrixSumQueriesRepeatMore(int n, int[][] queries) {
        if (n == 1) {
            return queries[queries.length - 1][2];
        }

        TreeMap<Integer, Integer> row = new TreeMap<>();
        TreeMap<Integer, Integer> col = new TreeMap<>();
        for (int i = 0; i < queries.length; i++) {
            if (queries[i][0] == 0) {
                row.put(queries[i][1], i);
            } else {
                col.put(queries[i][1], i);
            }
        }

        //行是空
        if (row.isEmpty()) {
            return computeMulti(col, n, queries);
        } else if (col.isEmpty()) {
            //列是空的
            return computeMulti(row, n, queries);
        }


        //从头到尾计算
        long oneRow = oneRow(col, queries);
        int emptyCol = n - col.size();
        long sum = oneRow * (n - row.size());
        for (int rowIndex : row.values()) {
            long rowValue = queries[rowIndex][2];
            sum += rowValue * emptyCol;
            for (int index : col.values()) {
                long value = rowValue;
                if (index > rowIndex) {
                    value = queries[index][2];
                }
                sum += value;
            }
        }
        return sum;
    }

    private long computeMulti(Map<Integer, Integer> columnIndex, int n, int[][] queries) {
        long sum = 0;
        if (!columnIndex.isEmpty()) {
            for (int index : columnIndex.values()) {
                long value = queries[index][2];
                sum += value * n;
            }
        }
        return sum;
    }


    private long oneRow(Map<Integer, Integer> col, int[][] queries) {
        long sum = 0;
        for (int index : col.values()) {
            sum += queries[index][2];
        }
        return sum;
    }


    public long matrixSumQueriesDirect(int n, int[][] queries) {
        if (queries.length == 1) {
            long value = 1;
            return value * n * queries[0][2];
        }
        TreeMap<Integer, Integer> row = new TreeMap<>();
        TreeMap<Integer, Integer> col = new TreeMap<>();
        long plus = 0;
        for (int i = 0; i < queries.length; i++) {
            int[] query = queries[i];
            int type = query[0];
            int index = query[1];
            long val = query[2];
            long currentPlus = val * n;
            if (type == 0) {
                Integer beforeRow = row.get(index);
                currentPlus -= beforePlus(beforeRow, n, col, queries);
                row.put(index, i);
            } else {
                //直接新增的值,如果源数据有值就扣除
                Integer beforeCol = col.get(index);
                currentPlus -= beforePlus(beforeCol, n, row, queries);
                col.put(index, i);
            }
            plus += currentPlus;
        }
        return plus;
    }

    /**
     * 行和列的值
     *
     * @return
     */
    private long beforePlus(Integer colIndex, int n, Map<Integer, Integer> rowIndex, int[][] queries) {
        //列没有
        if (colIndex == null) {
            //行也没有
            if (rowIndex.isEmpty()) {
                return 0;
            }

            long sum = 0;
            //行的部分字段有
            for (int index : rowIndex.values()) {
                sum += queries[index][2];
            }
            return sum;
        }

        long colValue = queries[colIndex][2];

        long sum = colValue * n;
        if (!rowIndex.isEmpty()) {
            //行列都有
            for (Map.Entry<Integer, Integer> entry : rowIndex.entrySet()) {
                //重新被新行替换
                int index = entry.getValue();
                if (index > colIndex) {
                    sum += queries[index][2] - colValue;
                }
            }
        }
        return sum;
    }


    /**
     * 输入：n = 3, queries = [[0,0,1],[1,2,2],[0,2,3],[1,0,4]]
     * 输出：23
     * 解释：上图展示了每个查询以后矩阵的值。所有操作执行完以后，矩阵元素之和为 23 。
     */
    public long matrixSumQueries(int n, int[][] queries) {
        int[][] newData = new int[n][n];
        long plus = 0;
        for (int[] query : queries) {
            int type = query[0];
            int index = query[1];
            int val = query[2];
            if (type == 0) {
                plus += replaceRowData(newData, index, val);
            } else {
                plus += replaceColData(newData, index, val);
            }
        }
        return plus;
    }

    private long replaceColData(int[][] newData, int index, int val) {
        long plus = 0;
        for (int i = 0; i < newData.length; i++) {
            plus += val - newData[i][index];
            newData[i][index] = val;
        }
        return plus;
    }

    private long replaceRowData(int[][] newData, int index, int val) {
        int plus = 0;
        for (int i = 0; i < newData.length; i++) {
            plus += val - newData[index][i];
            newData[index][i] = val;
        }
        return plus;
    }
}
