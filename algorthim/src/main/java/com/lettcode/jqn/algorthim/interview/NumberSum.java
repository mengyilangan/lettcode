package com.lettcode.jqn.algorthim.interview;

import java.util.*;

public class NumberSum {
    public List<int[]> twoSum(int[] array, int target) {
        List<int[]> list = new ArrayList<>();
        Map<Integer, Integer> missIndex = new HashMap<>();
        for (int i = 0; i < array.length; i++) {
            Integer index = missIndex.get(array[i]);
            missIndex.put(target - array[i], i);
            if (index != null) {
                list.add(new int[]{index, i});
            }

        }
        return list;
    }

    public List<int[]> threeSum(int[] array, int target) {
        List<int[]> list = new ArrayList<>();
        for (int i = 0; i < array.length - 2; i++) {
            int left = target - array[i];
            Set<Integer> miss = new HashSet<>();
            for (int j = i + 1; j < array.length; j++) {
                if (miss.contains(array[j])) {
                    list.add(new int[]{array[i], array[j], left - array[j]});
                }
                miss.add(left - array[j]);
            }
        }
        return list;
    }

    //有重复数值是，需要考虑左右移动的问题
    public List<int[]> threeSum1(int[] array, int target) {
        Arrays.sort(array);
        List<int[]> list = new ArrayList<>();
        for (int i = 0; i < array.length; i++) {
            int p = i + 1;
            int q = array.length - 1;
            int left = target - array[i];
            while (p < q) {
                int sum = array[p] + array[q];
                if (sum == left) {
                    list.add(new int[]{array[i], array[p], array[q]});
                    while (p < q && array[p] == array[p + 1]) {
                        p = p + 1;
                        list.add(new int[]{array[i], array[p], array[q]});
                    }
                    while (p < q && array[q] == array[q - 1]) {
                        q = q - 1;
                        list.add(new int[]{array[i], array[p], array[q]});
                    }
                    p = p + 1;
                    q = q - 1;
                } else if (sum > left) {
                    q = q - 1;
                } else {
                    p = p + 1;
                }
            }
        }
        return list;
    }
}
