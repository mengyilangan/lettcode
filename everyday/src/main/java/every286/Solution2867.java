package every286;

import bean.TreeNode;

import java.lang.reflect.Array;
import java.util.*;

/**
 * https://leetcode.cn/problems/count-valid-paths-in-a-tree/description/?envType=daily-question&envId=2024-02-27
 * <p>
 * 给你一棵 n 个节点的无向树，节点编号为 1 到 n 。给你一个整数 n 和一个长度为 n - 1 的二维整数数组 edges ，其中 edges[i] = [ui, vi] 表示节点 ui 和 vi 在树中有一条边。
 * <p>
 * 请你返回树中的 合法路径数目 。
 * <p>
 * 如果在节点 a 到节点 b 之间 恰好有一个 节点的编号是质数，那么我们称路径 (a, b) 是 合法的 。
 * <p>
 * 注意：
 * <p>
 * 路径 (a, b) 指的是一条从节点 a 开始到节点 b 结束的一个节点序列，序列中的节点 互不相同 ，且相邻节点之间在树上有一条边。
 * 路径 (a, b) 和路径 (b, a) 视为 同一条 路径，且只计入答案 一次 。
 * <p>
 * <p>
 * 输入：n = 5, edges = [[1,2],[1,3],[2,4],[2,5]]
 * 输出：4
 * 解释：恰好有一个质数编号的节点路径有：
 * - (1, 2) 因为路径 1 到 2 只包含一个质数 2 。
 * - (1, 3) 因为路径 1 到 3 只包含一个质数 3 。
 * - (1, 4) 因为路径 1 到 4 只包含一个质数 2 。
 * - (2, 4) 因为路径 2 到 4 只包含一个质数 2 。
 * 只有 4 条合法路径。
 * <p>
 * <p>
 * 输入：n = 6, edges = [[1,2],[1,3],[2,4],[3,5],[3,6]]
 * 输出：6
 * 解释：恰好有一个质数编号的节点路径有：
 * - (1, 2) 因为路径 1 到 2 只包含一个质数 2 。
 * - (1, 3) 因为路径 1 到 3 只包含一个质数 3 。
 * - (1, 4) 因为路径 1 到 4 只包含一个质数 2 。
 * - (1, 6) 因为路径 1 到 6 只包含一个质数 3 。
 * - (2, 4) 因为路径 2 到 4 只包含一个质数 2 。
 * - (3, 6) 因为路径 3 到 6 只包含一个质数 3 。
 * 只有 6 条合法路径。
 * <p>
 * 提示：
 * <p>
 * 1 <= n <= 10^5
 * edges.length == n - 1
 * edges[i].length == 2
 * 1 <= ui, vi <= n
 * 输入保证 edges 形成一棵合法的树。
 *
 * @author mylg
 * @date 27/2/24
 */
public class Solution2867 {
    private static final Set<Integer> PRIME_NUMBER = new HashSet<>();

    static {
        PRIME_NUMBER.addAll(Arrays.asList(2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97, 101, 103));
    }

    public long countPaths(int n, int[][] edges) {
        Map<Integer, Set<Integer>> relations = recordRelations(edges);

        return 0;
    }

    /**
     * 寻找不同的集合数,该集合代表一个路径,
     * 且该集合中只有一个质数
     *
     * @return
     */
    public Map<Integer, Set<Integer>> recordRelations(int[][] edges) {
        Map<Integer, Set<Integer>> relations = new HashMap<>();
        for (int[] edge : edges) {
            int from = edge[0];
            int to = edge[1];
            Set<Integer> tos = relations.getOrDefault(from, new HashSet<>());
            tos.add(to);
            relations.put(from, tos);

            tos = relations.getOrDefault(to, new HashSet<>());
            tos.add(from);
            relations.put(to, tos);
        }
        return relations;
    }

    public static class Collection {
        private Set<Integer> collections = new HashSet<>();

        private boolean hasPrime;

        public Collection(int start, int end) {
            this.collections.add(start);
            this.collections.add(end);
        }
    }

}
