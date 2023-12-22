package every109;

import java.util.*;
import java.util.stream.Collectors;

/**
 * https://leetcode.cn/problems/car-pooling/?envType=daily-question&envId=2023-12-02
 * 车上最初有 capacity 个空座位。车 只能 向一个方向行驶（也就是说，不允许掉头或改变方向）
 * <p>
 * 给定整数 capacity 和一个数组 trips ,  trip[i] = [numPassengersi, fromi, toi] 表示第 i 次旅行有 numPassengersi 乘客，接他们和放他们的位置分别是 fromi 和 toi 。这些位置是从汽车的初始位置向东的公里数。
 * <p>
 * 当且仅当你可以在所有给定的行程中接送所有乘客时，返回 true，否则请返回 false。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：trips = [[2,1,5],[3,3,7]], capacity = 4
 * 输出：false
 * 示例 2：
 * <p>
 * 输入：trips = [[2,1,5],[3,3,7]], capacity = 5
 * 输出：true
 * 1 <= trips.length <= 1000
 * trips[i].length == 3
 * 1 <= numPassengersi <= 100
 * 0 <= fromi < toi <= 1000
 * 1 <= capacity <= 105
 */
public class Solution1094 {
    /**
     * @param trips
     * @param capacity
     * @return
     */
    public boolean carPooling(int[][] trips, int capacity) {
        List<int[]> sorted = Arrays.stream(trips).sorted(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1 == o2) {
                    return 0;
                }

                int compare = Integer.compare(o1[1], o2[1]);
                if (compare == 0) {
                    compare = Integer.compare(o1[2], o2[1]);
                }
                return compare;
            }
        }).collect(Collectors.toList());
        TreeMap<Integer, Integer> offMap = new TreeMap<>();
        int sum = 0;
        int minOff = Integer.MAX_VALUE;
        for (int[] trip : sorted) {
            int num = trip[0];
            int on = trip[1];
            int off = trip[2];
            //先下车
            if (minOff <= on) {
                Iterator<Map.Entry<Integer, Integer>> iterator = offMap.entrySet().iterator();
                while (iterator.hasNext()) {
                    Map.Entry<Integer, Integer> entry = iterator.next();
                    if (entry.getKey() > on) {
                        minOff = entry.getKey();
                        break;
                    }
                    sum -= entry.getValue();
                    iterator.remove();
                }
            }

            //再上车
            sum += num;
            if (sum > capacity) {
                return false;
            }
            int before = offMap.getOrDefault(off, 0);
            offMap.put(off, before + num);
            minOff = Math.min(off, minOff);
        }
        return true;
    }
}
