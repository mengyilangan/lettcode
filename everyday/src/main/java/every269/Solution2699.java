package every269;

import java.util.*;

/**
 * https://leetcode.cn/problems/modify-graph-edge-weights/
 * <p>
 * 给你一个 n 个节点的 无向带权连通 图，节点编号为 0 到 n - 1 ，再给你一个整数数组 edges ，其中 edges[i] = [ai, bi, wi] 表示节点 ai 和 bi 之间有一条边权为 wi 的边。
 * <p>
 * 部分边的边权为 -1（wi = -1），其他边的边权都为 正 数（wi > 0）。
 * <p>
 * 你需要将所有边权为 -1 的边都修改为范围 [1, 2 * 109] 中的 正整数 ，使得从节点 source 到节点 destination 的 最短距离 为整数 target 。如果有 多种 修改方案可以使 source 和 destination 之间的最短距离等于 target ，你可以返回任意一种方案。
 * <p>
 * 如果存在使 source 到 destination 最短距离为 target 的方案，请你按任意顺序返回包含所有边的数组（包括未修改边权的边）。如果不存在这样的方案，请你返回一个 空数组 。
 * <p>
 * 注意：你不能修改一开始边权为正数的边。
 * 1 <= n <= 100
 * 1 <= edges.length <= n * (n - 1) / 2
 * edges[i].length == 3
 * 0 <= ai, bi < n
 * wi = -1 或者 1 <= wi <= 107
 * ai != bi
 * 0 <= source, destination < n
 * source != destination
 * 1 <= target <= 109
 * 输入的图是连通图，且没有自环和重边。
 */
public class Solution2699 {
    public int[][] modifiedGraphEdges(int n, int[][] edges, int source, int destination, int target) {
        Map<Integer, Map<Integer, Integer>> direction = new HashMap<>();
        int min = Integer.MAX_VALUE;
        for (int[] edge : edges) {
            Map<Integer, Integer> value = direction.getOrDefault(edge[0], new HashMap<>());
            value.put(edge[1], edge[2]);
            direction.put(edge[0], value);
            min = Math.min(min, edge[2]);
            value = direction.getOrDefault(edge[1], new HashMap<>());
            value.put(edge[0], edge[2]);
            direction.put(edge[1], value);
        }
        if (min > target) {
            return new int[][]{};
        }

        //是否包含路径
        if (!direction.containsKey(source) || !direction.containsKey(destination)) {
            return new int[][]{};
        }

        //定义初始路径
        List<Destination> ways = new ArrayList<>();
        Destination init = new Destination(source);
        ways.add(init);
        boolean value = false;
        do {
            Iterator<Destination> iterator = ways.iterator();
            List<Destination> nextWays = new ArrayList<>();
            while (iterator.hasNext()) {
                Destination way = iterator.next();
                int before = way.currentCode;
                Map<Integer, Integer> tryDirection = direction.get(before);
                if (tryDirection == null) {
                    continue;
                }

                Destination nextway = new Destination(way);
                for (Map.Entry<Integer, Integer> entry : tryDirection.entrySet()) {
                    if (way.nodes.contains(entry.getKey())) {
                        //已经尝试过了,忽略
                        continue;
                    }

                    int negative = nextway.negative.size();
                    int positiveSum = nextway.positiveSum;
                    if (entry.getValue() > 0) {
                        positiveSum += entry.getValue();
                    } else {
                        negative += 1;
                    }

                    //不能用
                    if (positiveSum + negative > target) {
                        continue;
                    }

                    //如果到目的地了,还需要该长度也不行
                    if (entry.getKey() == destination && positiveSum < target && negative == 0) {
                        return new int[][]{};
                    }


                    nextway.currentCode = entry.getKey();
                    nextway.nodes.add(entry.getKey());
                    nextway.positiveSum = positiveSum;
                    if (entry.getValue() < 0) {
                        nextway.negative.add(new int[]{before, entry.getKey()});
                    }

                    if (entry.getKey() == destination) {
                        filter(nextway, target, edges);
                        value = true;
                    }
                    nextWays.add(nextway);
                    nextway = new Destination(way);
                }
            }
            ways = nextWays;
        } while (!ways.isEmpty() && !direction.get(destination).isEmpty());


        return value ? edges : new int[][]{};
    }

    private void filter(Destination destination, int target, int[][] edges) {
        if (destination.negative.isEmpty()) {
            for (int[] edge : edges) {
                if (edge[2] > 0) {
                    continue;
                }
                edge[2] = target;
            }
        } else {
            int negativeSum = target - destination.positiveSum;
            int avgValue = negativeSum / destination.negative.size();
            int extra = negativeSum % destination.negative.size() + avgValue;
            Map<Integer, Set<Integer>> value = new HashMap<>();
            for (int[] pair : destination.negative) {
                Set<Integer> sets = value.getOrDefault(pair[0], new HashSet<>());
                sets.add(pair[1]);
                value.put(pair[0], sets);
            }

            for (int[] edge : edges) {
                if (edge[2] > 0) {
                    continue;
                }
                edge[2] = target;
                //需要修改位对应的值
                if (destination.nodes.contains(edge[0]) && destination.nodes.contains(edge[1])) {
                    edge[2] = extra;
                    extra = avgValue;
                }
            }
        }


    }


    private static class Destination {
        /**
         * 已经存在的节点，不能搞成环
         */
        private Set<Integer> nodes = new HashSet<>();
        private int positiveSum = 0;

        private int currentCode;

        private List<int[]> negative = new ArrayList<>();

        public Destination(int currentCode) {
            this.currentCode = currentCode;
            this.nodes.add(currentCode);
        }

        public Destination(Destination destination) {
            this.currentCode = destination.currentCode;
            this.nodes = new HashSet<>(destination.nodes);
            this.negative = new ArrayList<>(destination.negative);
            this.positiveSum = destination.positiveSum;
        }

        @Override
        public String toString() {
            return "Destination{" +
                    "nodes=" + nodes +
                    ", positiveSum=" + positiveSum +
                    ", currentCode=" + currentCode +
                    ", negative=" + negative +
                    '}';
        }
    }
}
