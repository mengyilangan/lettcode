package every261;

import java.util.*;

/**
 * 1 <= n == reward1.length == reward2.length <= 105
 * 1 <= reward1[i], reward2[i] <= 1000
 * 0 <= k <= n
 */
public class Solution2611 {
    public int miceAndCheese(int[] reward1, int[] reward2, int k) {
        if (k <= 0) {
            int sum = 0;
            for (int i = 0; i < reward2.length; i++) {
                sum += reward2[i];
            }
            return sum;
        } else if (k == reward1.length) {
            int sum = 0;
            for (int i = 0; i < reward1.length; i++) {
                sum += reward1[i];
            }
            return sum;
        }

        TreeMap<Integer, Set<Integer>> absMinusIndex = new TreeMap<>();
        int maxSum = 0;
        Set<Integer> selectOne = new HashSet<>();
        int n = reward1.length;
        for (int i = 0; i < n; i++) {
            if (reward1[i] > reward2[i]) {
                selectOne.add(i);
                maxSum += reward1[i];
            } else {
                maxSum += reward2[i];
            }
            int absMinus = Math.abs(reward1[i] - reward2[i]);
            Set<Integer> index = absMinusIndex.getOrDefault(absMinus, new HashSet<>());
            index.add(i);
            absMinusIndex.put(absMinus, index);
        }

        if (k == selectOne.size()) {
            return maxSum;
        } else if (k < selectOne.size()) {
            return maxSumLess(absMinusIndex, maxSum, selectOne, k);
        } else if (selectOne.size() == 0) {
            return maxSumMore(absMinusIndex, maxSum, k);
        } else {
            return maxSumMore(absMinusIndex, maxSum, selectOne, k);
        }
    }

    /**
     * 计算第一个老鼠不应该吃的场景
     *
     * @param absMinusIndex
     * @param sum
     * @param k
     * @return
     */
    private int maxSumMore(TreeMap<Integer, Set<Integer>> absMinusIndex, int sum, int k) {
        for (Map.Entry<Integer, Set<Integer>> entry : absMinusIndex.entrySet()) {
            int add = entry.getValue().size();
            if (add >= k) {
                sum -= k * entry.getKey();
                break;
            }

            k = k - add;
            sum -= add * entry.getKey();
        }
        return sum;
    }

    /**
     * reward1选取更少
     *
     * @param absMinusIndex
     * @param sum
     * @param one
     * @return
     */
    private int maxSumLess(TreeMap<Integer, Set<Integer>> absMinusIndex, int sum, Set<Integer> one, int k) {
        int need = one.size() - k;
        for (Map.Entry<Integer, Set<Integer>> entry : absMinusIndex.entrySet()) {
            Set<Integer> insert = insert(entry.getValue(), one);
            if (insert.isEmpty()) {
                continue;
            }

            int absMinus = entry.getKey();
            one.removeAll(insert);
            if (insert.size() >= need) {
                sum -= need * absMinus;
                break;
            }
            sum -= insert.size() * absMinus;
            need -= insert.size();
        }
        return sum;
    }

    private Set<Integer> insert(Set<Integer> s1, Set<Integer> s2) {
        Set<Integer> integerSet = new HashSet<>();
        Set<Integer> min = s1;
        Set<Integer> max = s2;
        if (s1.size() > s2.size()) {
            max = s1;
            min = s2;
        }
        for (Integer value : min) {
            if (max.contains(value)) {
                integerSet.add(value);
            }
        }
        return integerSet;
    }

    /**
     * reward1选取更多
     *
     * @param absMinusIndex
     * @param sum
     * @param selectOne
     * @param k
     * @return
     */
    private int maxSumMore(TreeMap<Integer, Set<Integer>> absMinusIndex, int sum, Set<Integer> selectOne, int k) {
        int need = k - selectOne.size();
        for (Map.Entry<Integer, Set<Integer>> entry : absMinusIndex.entrySet()) {
            Set<Integer> insert = insert(entry.getValue(), selectOne);
            Set<Integer> add = entry.getValue();
            add.removeAll(insert);
            if (add.isEmpty()) {
                continue;
            }

            int absMinus = entry.getKey();
            selectOne.addAll(add);
            if (add.size() >= need) {
                sum -= need * absMinus;
                break;
            }
            sum -= add.size() * absMinus;
            need -= add.size();
        }
        return sum;
    }
}
