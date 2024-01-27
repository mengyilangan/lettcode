package every286;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 假设你是一家合金制造公司的老板，你的公司使用多种金属来制造合金。现在共有 n 种不同类型的金属可以使用，并且你可以使用 k 台机器来制造合金。每台机器都需要特定数量的每种金属来创建合金。
 * <p>
 * 对于第 i 台机器而言，创建合金需要 composition[i][j] 份 j 类型金属。最初，你拥有 stock[i] 份 i 类型金属，而每购入一份 i 类型金属需要花费 cost[i] 的金钱。
 * <p>
 * 给你整数 n、k、budget，下标从 1 开始的二维数组 composition，两个下标从 1 开始的数组 stock 和 cost，请你在预算不超过 budget 金钱的前提下，最大化 公司制造合金的数量。
 * <p>
 * 所有合金都需要由同一台机器制造。
 * <p>
 * 返回公司可以制造的最大合金数。
 * <p>
 * 提示：
 * <p>
 * 1 <= n, k <= 100
 * 0 <= budget <= 10^8
 * composition.length == k
 * composition[i].length == n
 * 1 <= composition[i][j] <= 100
 * stock.length == cost.length == n
 * 0 <= stock[i] <= 108
 * 1 <= cost[i] <= 100
 */
public class Solution2861 {


    /**
     * 二分法没看懂
     * 只让选择其中的一种
     *
     * @param n           n类金属,composition[i].size=n=stock.size=cost.size
     * @param k           k台机器,composition.size=k
     * @param budget      可以补充的花费
     * @param composition 一台内容的花费情况
     * @param stock：现有库存
     * @param cost：耗费
     * @return
     */
    public int maxNumberOfAlloys(int n, int k, int budget, List<? extends List<Integer>> composition, List<Integer> stock, List<Integer> cost) {
        //可以挨个尝试每一种耗费多少钱
        int max = 0;
        for (List<Integer> machine : composition) {
            //对于每一台机器
            max = Math.max(max, maxNumberOfAlloys(n, budget, machine, stock, cost));
        }
        return max;
    }

    public int maxNumberOfAlloys(int n, int budget, List<Integer> machine, List<Integer> stocks, List<Integer> cost) {
        int missAllPrice = 0;
        Map<Integer, Integer> stockLeft = new HashMap<>();
        Map<Integer, Integer> stockTimesMap = new HashMap<>();
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            int stock = stocks.get(i);
            int need = machine.get(i);
            if (stock == 0) {
                missAllPrice += cost.get(i) * need;
            } else {
                int left = stock % need;
                int times = stock / need;
                if (left > 0) {
                    stockLeft.put(i, left);
                }
                stockTimesMap.put(i, times);
                min = Math.min(min, times);
            }
        }

        //直接就没有stock
        if (stockTimesMap.isEmpty()) {
            return budget / missAllPrice;
        }

        //先看看最小的够不够
        if (missAllPrice > 0) {
            int need = min * missAllPrice;
            if (budget > need) {
                budget -= need;
            } else if (budget == need) {
                return min;
            } else {
                return budget / missAllPrice;
            }
        }


        Iterator<Map.Entry<Integer, Integer>> it = stockTimesMap.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<Integer, Integer> entry = it.next();
            entry.setValue(entry.getValue() - min);
            if (entry.getValue() == 0 && !stockLeft.containsKey(entry.getKey())) {
                it.remove();
                missAllPrice += cost.get(entry.getKey()) * machine.get(entry.getKey());
            }
        }

        System.out.println("init_res=" + min);
        int res = min; //先讲min的值减掉
        while (true) {
            //全部都没有内容了,那就只能
            if (stockTimesMap.isEmpty()) {
                return res + budget / missAllPrice;
            }

            //逐步+1尝试
            budget -= missAllPrice;
            Iterator<Map.Entry<Integer, Integer>> iterator = stockTimesMap.entrySet().iterator();
            while (iterator.hasNext()) {
                Map.Entry<Integer, Integer> entry = iterator.next();
                if (entry.getValue() > 0) {
                    entry.setValue(entry.getValue() - 1);
                    continue;
                }
                int key = entry.getKey();
                int left = stockLeft.getOrDefault(key, 0);
                budget = budget - (machine.get(key) - left) * cost.get(key);
                if (budget < 0) {
                    return res;
                }
                missAllPrice += machine.get(key) * cost.get(key);
                iterator.remove();
            }

            if (budget < 0) {
                break;
            }
            res = res + 1;
        }
        return res;
    }

}
