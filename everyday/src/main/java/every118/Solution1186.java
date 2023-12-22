package every118;

import java.util.Map;
import java.util.TreeMap;

/**
 * https://leetcode.cn/problems/maximum-subarray-sum-with-one-deletion/
 * <p>
 * 给你一个整数数组，返回它的某个 非空 子数组（连续元素）在执行一次可选的删除操作后，
 * 所能得到的最大元素总和。换句话说，你可以从原数组中选出一个子数组，
 * 并可以决定要不要从中删除一个元素（只能删一次哦），
 * （删除后）子数组中至少应当有一个元素，然后该子数组（剩下）的元素总和是所有子数组之中最大的。
 * <p>
 * 注意，删除一个元素后，子数组 不能为空。
 * <p>
 * 1 <= arr.length <= 105
 * -104 <= arr[i] <= 104
 */
public class Solution1186 {

    private static class Deal {
        private int[] arr;

        private int max = Integer.MIN_VALUE;

        private int[] accumulation;

        private TreeMap<Integer, Integer> negativeMap;

        private int start = 0;

        private int end;

        public Deal(int[] arr) {
            this.arr = arr;
            accumulation = new int[arr.length + 1];
            negativeMap = new TreeMap<>();
            end = arr.length - 1;
        }

        /**
         * 全部遍历一遍
         */
        public void queryAll() {
            for (int i = 0; i < arr.length; i++) {
                if (arr[i] < 0) {
                    negativeMap.put(i, arr[i]);
                }
                max = Integer.max(arr[i], max);
                accumulation[i + 1] = arr[i] + accumulation[i];
            }
            trimNegativeMap();
        }

        public int compute() {
            //有0或者1个正数
            if (negativeMap.size() >= accumulation.length - 1) {
                return max;
            }


            int last = accumulation[end] - accumulation[start];

            //正数全部连在一起
            if (negativeMap.isEmpty()) {
                return last;
            }

            //还有一个负数,全部选择移除他即可
            if (negativeMap.size() == 1) {
                return last - negativeMap.firstEntry().getValue();
            }

            //逐个尝试移除项
            return max;
        }


        private void trimNegativeMap() {
            int size = negativeMap.size();
            //只有一个负数或者只有一个正数不用处理
            if (size <= 1 || size >= arr.length - 1) {
                end = arr.length;
                return;
            }

            for (; start < accumulation.length; start++) {
                //如果不存在，则停止
                if (negativeMap.remove(start) == null) {
                    break;
                }
            }

            for (; end >= 0; end--) {
                //如果不存在，则停止
                if (negativeMap.remove(end) == null) {
                    break;
                }
            }
            end = end + 1;
        }
    }


    public int maximumSum(int[] arr) {
        Deal deal = new Deal(arr);
        deal.queryAll();
        return deal.compute();
    }

}
