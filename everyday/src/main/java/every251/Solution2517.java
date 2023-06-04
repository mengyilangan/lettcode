package every251;

import java.util.*;

public class Solution2517 {
    public int maximumTastiness(int[] price, int k) {
        TreeMap<Integer, List<Combine>> combineTreeMap = new TreeMap<>();
        for (int i = 0; i < price.length; i++) {
            for (int j = i + 1; j < price.length; j++) {
                int a = price[i];
                int b = price[j];
                int minus = Math.abs(a - b);
                Combine combine = new Combine();
                combine.left = i;
                combine.right = j;
                combine.minus = minus;
                List<Combine> combineList = combineTreeMap.getOrDefault(minus, new ArrayList<>());
                combineList.add(combine);
                combineTreeMap.put(minus, combineList);
            }
        }

        //返回第一个
        if (combineTreeMap.size() == 1 || k == price.length) {
            return combineTreeMap.firstKey();
        }

        if (k == 2) {
            return combineTreeMap.lastKey();
        }

        //倒叙,应该出现k个数,均出现k-1次[该index出现了几次]
        Map<Integer, Integer> indexMap = new HashMap<>();
        TreeSet<Integer> fullIndex = new TreeSet<>();
        for (Map.Entry<Integer, List<Combine>> entry : combineTreeMap.descendingMap().entrySet()) {
            for (Combine combine : entry.getValue()) {
                int count = indexMap.getOrDefault(combine.left, 0) + 1;
                indexMap.put(combine.left, count);
                if (count >= k) {
                    fullIndex.add(combine.left);
                }
                count = indexMap.getOrDefault(combine.right, 0) + 1;
                indexMap.put(combine.right, count + 1);
                if (count >= k) {
                    fullIndex.add(combine.right);
                }

                if (fullIndex.size() >= k) {
                    System.out.println(fullIndex);
                    return entry.getKey();
                }
            }
        }


        //如何知道谁和谁组团大
        return combineTreeMap.firstKey();
    }

    public static class Combine {
        private int left = -1;

        private int right = -1;
        private int minus;

        @Override
        public String toString() {
            return "Combine{" +
                    "left=" + left +
                    ", right=" + right +
                    ", minus=" + minus +
                    '}';
        }
    }
}
