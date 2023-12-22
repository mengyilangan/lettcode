package every159;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * https://leetcode.cn/problems/minimum-cost-to-connect-two-groups-of-points/
 * 给你两组点，其中第一组中有 size1 个点，第二组中有 size2 个点，且 size1 >= size2 。
 * <p>
 * 任意两点间的连接成本 cost 由大小为 size1 x size2 矩阵给出，其中 cost[i][j] 是第一组中的点 i 和第二组中的点 j 的连接成本。如果两个组中的每个点都与另一组中的一个或多个点连接，则称这两组点是连通的。换言之，第一组中的每个点必须至少与第二组中的一个点连接，且第二组中的每个点必须至少与第一组中的一个点连接。
 * <p>
 * 返回连通两组点所需的最小成本
 * size1 == cost.length
 * size2 == cost[i].length
 * 1 <= size1, size2 <= 12
 * size1 >= size2
 * 0 <= cost[i][j] <= 100
 */
public class Solution1595 {
    public int connectTwoGroups(List<List<Integer>> cost) {
        if (cost.isEmpty()) {
            return 0;
        }
        if (cost.size() == 1) {
            return cost.get(0).get(0);
        }

        int col = cost.get(0).size();
        int row = cost.size();

        Set<Integer> selectedIndex = new HashSet<>();
        for (int i = 0; i < selectedIndex.size(); i++) {
            selectedIndex.add(i);
        }

        int[][] dp = new int[row][col];

        while (!selectedIndex.isEmpty()) {
            for (int i = 0; i < row; i++) {
                Set<Integer> sets = new HashSet<>();
                List<Integer> value = cost.get(i);
                sets.add(0);
                int min = value.get(0);
                for (int j = 1; j < col; j++) {
                    if (value.get(j) == min) {
                        sets.add(j);
                    } else if (value.get(j) < min) {
                        min = value.get(j);
                        sets.clear();
                        sets.add(j);
                    }
                }
                for (int index : sets) {

                    selectedIndex.remove(index);
                }
            }
        }


        return 1;
    }
}
