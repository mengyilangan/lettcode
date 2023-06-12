package every148;

import java.util.*;

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
        this.init();
    }

    private void init() {
        if (parent.length <= 0) {
            return;
        }

        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < parent.length && nodeLevel.size() < n; i++) {
            int node = i;
            boolean add = false;
            do {
                int parentNode = parent[node];
                if (parentNode == -1) {
                    nodeLevel.put(node, 0);
                    Set<Integer> nodeIds = nodeLevelMap.getOrDefault(0, new HashSet<>());
                    nodeIds.add(node);
                    nodeLevelMap.put(0, nodeIds);
                    add = true;
                    break;
                }
                stack.push(node);
                node = parentNode;
            } while (!nodeLevel.containsKey(node));

            while (!stack.isEmpty()) {
                node = stack.pop();
                int parentNode = parent[node];
                int level = nodeLevel.get(parentNode) + 1;
                nodeLevel.put(node, level);
                Set<Integer> nodeIds = nodeLevelMap.getOrDefault(level, new HashSet<>());
                nodeIds.add(node);
                nodeLevelMap.put(level, nodeIds);
            }
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
