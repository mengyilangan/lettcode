package every168;

import java.util.*;

/**
 * https://leetcode.cn/problems/minimum-incompatibility/
 * 给你一个整数数组 nums 和一个整数 k 。你需要将这个数组划分到 k 个相同大小的子集中，使得同一个子集里面没有两个相同的元素。
 * <p>
 * 一个子集的 不兼容性 是该子集里面最大值和最小值的差。
 * <p>
 * 请你返回将数组分成 k 个子集后，各子集 不兼容性 的 和 的 最小值 ，如果无法分成分成 k 个子集，返回 -1 。
 * <p>
 * 子集的定义是数组中一些数字的集合，对数字顺序没有要求。
 * 1 <= k <= nums.length <= 16
 * nums.length 能被 k 整除。
 * 1 <= nums[i] <= nums.length===>这句话代表什么意思呢?
 */
public class Solution1681 {

    public int minimumIncompatibility(int[] nums, int k) {
        //每个里面一个值
        if (nums.length == k) {
            int sum = 0;
            for (int num : nums) {
                sum += num;
            }
            return sum;
        }

        TreeMap<Integer, Integer> countIndex = new TreeMap<>();
        int maxTimes = 0;
        for (int num : nums) {
            int count = countIndex.getOrDefault(num, 0) + 1;
            countIndex.put(num, count);
            maxTimes = Math.max(count, maxTimes);
        }
        //子集合存在重复不ok
        if (maxTimes > k) {
            return -1;
        }

        //最大值和最小值都重复了k次,其他的随便组装
        Map.Entry<Integer, Integer> firstEntry = countIndex.firstEntry();
        Map.Entry<Integer, Integer> lastEntry = countIndex.lastEntry();
        if (firstEntry.getValue() == k && lastEntry.getValue() == k) {
            return (firstEntry.getKey() - lastEntry.getKey()) * k;
        }

        //将够次数的每个集合一个
        List<OneCollection> list = new ArrayList<>(k);
        int each = nums.length / k;
        for (int i = 0; i < k; i++) {
            OneCollection oneCollection = new OneCollection(each);
            list.add(oneCollection);
        }

        int left = nums.length;
        Iterator<Map.Entry<Integer, Integer>> iterator = countIndex.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<Integer, Integer> entry = iterator.next();
            if (entry.getValue() == k) {
                left -= k;
                for (OneCollection oneCollection : list) {
                    oneCollection.add(entry.getKey());
                }
                iterator.remove();
            }
        }

        //剩余k个,随意放
        if (left == k) {
            int sum = 0;
            iterator = countIndex.entrySet().iterator();
            int i = 0;
            while (iterator.hasNext()) {
                Map.Entry<Integer, Integer> entry = iterator.next();
                OneCollection oneCollection = list.get(i);
                oneCollection.add(entry.getKey());
                i += entry.getValue();
                sum += oneCollection.maxDiffs() * entry.getValue();
            }
            return sum;
        }

        //任意存在重复的;
        //max最大n.length-1;
        //min最小是1
        //8,6,3,2, 3,1 1,2
        //8->1===>
        //6->1===>5,4,3,2
        //3=>2===>1,2,3,5
        //2=>2===>1,1,4,7
        //1=>2===>1,2,5,7
        int sum = 0;
        for (OneCollection oneCollection : list) {
            iterator = countIndex.entrySet().iterator();
            while (iterator.hasNext() && oneCollection.collections.size() < each) {
                Map.Entry<Integer, Integer> entry = iterator.next();
                oneCollection.add(entry.getKey());
                if (entry.getValue() == 1) {
                    iterator.remove();
                } else {
                    entry.setValue(entry.getValue() - 1);
                }
            }

            //需要向前替换
            if (oneCollection.collections.size() < each) {

            }

            sum += oneCollection.maxDiffs();
        }
        return sum;
    }

    private static class OneCollection {
        private final Set<Integer> collections;

        private int min;

        private int max;

        public OneCollection(int n) {
            this.collections = new HashSet<>(n);
        }

        public void add(int v) {
            this.collections.add(v);
            min = Math.min(v, min);
            max = Math.min(v, max);
        }

        public int maxDiffs() {
            return max - min;
        }
    }
}
