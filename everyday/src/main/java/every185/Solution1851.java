package every185;

import java.util.*;

/**
 * 给你一个二维整数数组 intervals ，其中 intervals[i] = [lefti, righti] 表示第 i 个区间开始于 lefti 、结束于 righti（包含两侧取值，闭区间）。区间的 长度 定义为区间中包含的整数数目，更正式地表达是 righti - lefti + 1 。
 * <p>
 * 再给你一个整数数组 queries 。第 j 个查询的答案是满足 lefti <= queries[j] <= righti 的 长度最小区间 i 的长度 。如果不存在这样的区间，那么答案是 -1 。
 * <p>
 * 以数组形式返回对应查询的所有答案。
 * <p>
 * <p>
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/minimum-interval-to-include-each-query
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * 1 <= intervals.length <= 105
 * 1 <= queries.length <= 105
 * queries[i].length == 2
 * 1 <= lefti <= righti <= 107
 * 1 <= queries[j] <= 107
 * <p>
 */
public class Solution1851 {

    private static void freshIndex(TreeMap<Integer, Set<Integer>> container, int value, int index) {
        Set<Integer> indexSets = container.getOrDefault(value, new HashSet<>());
        indexSets.add(index);
        container.put(value, indexSets);
    }

    public int[] minInterval(int[][] intervals, int[] queries) {
        int[] result = new int[queries.length];
        int[] minus = new int[intervals.length];
        TreeMap<Integer, Set<Integer>> beginIndex = new TreeMap<>();
        TreeMap<Integer, Set<Integer>> endIndex = new TreeMap<>();
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < intervals.length; i++) {
            minus[i] = intervals[i][1] - intervals[i][0] + 1;
            min = Math.min(min, minus[i]);
            freshIndex(beginIndex, intervals[i][0], i);
            freshIndex(endIndex, intervals[i][1], i);
        }

        int start = beginIndex.lastKey();
        int end = endIndex.firstKey();
        for (int i = 0; i < queries.length; i++) {
            int query = queries[i];
            //全部都包含
            if (query >= start && query <= end) {
                result[i] = min;
                continue;
            }

            Set<Integer> hits = matchIndexSets(beginIndex, endIndex, queries[i]);
            int value = -1;
            if (!hits.isEmpty()) {
                value = Integer.MAX_VALUE;
                for (int hit : hits) {
                    value = Math.min(value, minus[hit]);
                }
            }
            result[i] = value;
        }
        return result;
    }

    private Set<Integer> matchIndexSets(TreeMap<Integer, Set<Integer>> beginIndex, TreeMap<Integer, Set<Integer>> endIndex, int value) {
        Map.Entry<Integer, Set<Integer>> entry = beginIndex.floorEntry(value);
        Set<Integer> hits = new HashSet<>();
        while (entry != null) {
            hits.addAll(entry.getValue());
            entry = beginIndex.lowerEntry(entry.getKey());
        }

        if (hits.isEmpty()) {
            return Collections.emptySet();
        }

        Set<Integer> endHits = new HashSet<>();
        entry = endIndex.ceilingEntry(value);
        while (entry != null) {
            endHits.addAll(entry.getValue());
            entry = endIndex.higherEntry(entry.getKey());
        }

        Set<Integer> min = hits;
        Set<Integer> max = endHits;
        if (min.size() > max.size()) {
            min = endHits;
            max = hits;
        }

        if (max.containsAll(min)) {
            return min;
        }

        Set<Integer> finalHits = new HashSet<>(min.size());
        for (int index : min) {
            if (max.contains(index)) {
                finalHits.add(index);
            }
        }
        return finalHits;
    }
}
