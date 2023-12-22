package every146;

import java.util.*;

/**
 * 深度优先搜索看不懂
 * https://leetcode.cn/problems/reorder-routes-to-make-all-paths-lead-to-the-city-zero/
 * n 座城市，从 0 到 n-1 编号，其间共有 n-1 条路线。因此，要想在两座不同城市之间旅行只有唯一一条路线可供选择（路线网形成一颗树）。去年，交通运输部决定重新规划路线，以改变交通拥堵的状况。
 * <p>
 * 路线用 connections 表示，其中 connections[i] = [a, b] 表示从城市 a 到 b 的一条有向路线。
 * <p>
 * 今年，城市 0 将会举办一场大型比赛，很多游客都想前往城市 0 。
 * <p>
 * 请你帮助重新规划路线方向，使每个城市都可以访问城市 0 。返回需要变更方向的最小路线数。
 * <p>
 * 题目数据 保证 每个城市在重新规划路线方向后都能到达城市 0 。
 * <p>
 * 2 <= n <= 5 * 10^4
 * connections.length == n-1
 * connections[i].length == 2
 * 0 <= connections[i][0], connections[i][1] <= n-1
 * connections[i][0] != connections[i][1]
 */
public class Solution1466 {
    public int minReorder(int n, int[][] connections) {
        boolean[] arrive = new boolean[n];
        arrive[0] = true;
        int result = 0;
        Map<Integer, Set<Integer>> startLeft = new HashMap<>();
        Map<Integer, Set<Integer>> endLeft = new HashMap<>();
        for (int[] connection : connections) {
            int start = connection[0];
            int end = connection[1];
            if (arrive[end]) {
                //该地址可以到达
                arrive[start] = true;
                continue;
            } else if (arrive[start]) {
                //翻转可达
                arrive[end] = true;
                result += 1;
                continue;
            }

            Set<Integer> sets = startLeft.getOrDefault(start, new HashSet<>());
            sets.add(end);
            startLeft.put(start, sets);
            Set<Integer> ends = endLeft.getOrDefault(end, new HashSet<>());
            sets.add(start);
            startLeft.put(end, ends);
        }
        return result;
    }


    public void recompute(Map<Integer, Set<Integer>> startLeft, Map<Integer, Set<Integer>> endLeft, boolean[] arrive) {

    }
}
