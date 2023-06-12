package every148;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * https://leetcode.cn/problems/kth-ancestor-of-a-tree-node/
 */
public class TreeAncestor {
    /**
     * 1 <= k <= n <= 5 * 104
     * parent[0] == -1 表示编号为 0 的节点是根节点。
     * 对于所有的 0 < i < n ，0 <= parent[i] < n 总成立
     * 0 <= node < n
     * 至多查询 5 * 104 次
     */
    private int n;
    private int[] parent;

    private Map<Integer, Integer> nodeLevel = new HashMap<>();

    private Map<Integer, Set<Integer>> nodeLevelMap = new HashMap<>();

    public TreeAncestor(int n, int[] parent) {
        this.n = n;
        this.parent = parent;
        for (int i = 0; i < parent.length; i++) {
            //0层
            int parentNode = parent[i];
            int level = parentNode + 1;
            if (parentNode >= 0) {
                level = nodeLevel.get(parentNode) + 1;
            }
            nodeLevel.put(i, level);
            Set<Integer> nodeIds = nodeLevelMap.getOrDefault(level, new HashSet<>());
            nodeIds.add(i);
            nodeLevelMap.put(level, nodeIds);
        }
    }

    public int getKthAncestor(int node, int k) {
        Integer level = nodeLevel.get(node);
        if (level == null || level < k) {
            return -1;
        }

        int minus = level - k;
        Set<Integer> nodeIds = nodeLevelMap.get(minus);
        if (nodeIds == null) {
            return -1;
        } else if (nodeIds.size() == 1) {
            return nodeIds.iterator().next();
        }

        while (k > 0 && node >= 0) {
            node = parent[node];
            k = k - 1;
        }

        if (k == 0) {
            return node;
        } else {
            return -1;
        }
    }
}
