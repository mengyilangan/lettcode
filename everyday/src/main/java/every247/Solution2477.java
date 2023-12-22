package every247;

import java.util.*;

/**
 * https://leetcode.cn/problems/minimum-fuel-cost-to-report-to-the-capital/?envType=daily-question&envId=2023-12-05
 * 给你一棵 n 个节点的树（一个无向、连通、无环图），每个节点表示一个城市，编号从 0 到 n - 1 ，且恰好有 n - 1 条路。0 是首都。给你一个二维整数数组 roads ，其中 roads[i] = [ai, bi] ，表示城市 ai 和 bi 之间有一条 双向路 。
 * <p>
 * 每个城市里有一个代表，他们都要去首都参加一个会议。
 * <p>
 * 每座城市里有一辆车。给你一个整数 seats 表示每辆车里面座位的数目。
 * <p>
 * 城市里的代表可以选择乘坐所在城市的车，或者乘坐其他城市的车。相邻城市之间一辆车的油耗是一升汽油。
 * <p>
 * 请你返回到达首都最少需要多少升汽油。
 * <p>
 * 提示：
 * <p>
 * 1 <= n <= 105
 * roads.length == n - 1
 * roads[i].length == 2
 * 0 <= ai, bi < n
 * ai != bi
 * roads 表示一棵合法的树。
 * 1 <= seats <= 105
 * <p>
 * 题解：https://leetcode.cn/problems/minimum-fuel-cost-to-report-to-the-capital/solutions/1981361/kao-lu-mei-tiao-bian-shang-zhi-shao-xu-y-uamv/?envType=daily-question&envId=2023-12-05
 */
public class Solution2477 {
    public long minimumFuelCost(int[][] roads, int seats) {
        int n = roads.length + 1;
        List<Integer>[] g = new ArrayList[n];
        Arrays.setAll(g, e -> new ArrayList<>());
        for (int[] e : roads) {
            int x = e[0], y = e[1];
            g[x].add(y); // 记录每个点的邻居
            g[y].add(x);
        }

        dfs(0, -1, g, seats);
        return ans;
    }

    private long ans;

    private int dfs(int x, int fa, List<Integer>[] g, int seats) {
        int size = 1;
        for (int y : g[x]) {
            if (y != fa) { // 递归子节点，不能递归父节点
                size += dfs(y, x, g, seats); // 统计子树大小
            }
        }
        if (x > 0) { // x 不是根节点
            ans += (size - 1) / seats + 1; // ceil(size/seats)
        }
        return size;
    }

}
