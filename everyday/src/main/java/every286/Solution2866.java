//package every286;
//
//import java.util.*;
//
///**
// * https://leetcode.cn/problems/beautiful-towers-ii/?envType=daily-question&envId=2023-12-21
// * 给你一个长度为 n 下标从 0 开始的整数数组 maxHeights 。
// * <p>
// * 你的任务是在坐标轴上建 n 座塔。第 i 座塔的下标为 i ，高度为 heights[i] 。
// * <p>
// * 如果以下条件满足，我们称这些塔是 美丽 的：
// * <p>
// * 1 <= heights[i] <= maxHeights[i]
// * heights 是一个 山脉 数组。
// * 如果存在下标 i 满足以下条件，那么我们称数组 heights 是一个 山脉 数组：
// * <p>
// * 对于所有 0 < j <= i ，都有 heights[j - 1] <= heights[j]
// * 对于所有 i <= k < n - 1 ，都有 heights[k + 1] <= heights[k]
// * 请你返回满足 美丽塔 要求的方案中，高度和的最大值 。
// * <p>
// * 提示：
// * <p>
// * 1 <= n == maxHeights <= 105
// * 1 <= maxHeights[i] <= 109
// */
//public class Solution2866 {
//    //左侧递增,右侧抵减,中间峰值,求该数组的最大值
//    //选中峰值,从峰值向两次依次递减
//    public long maximumSumOfHeights(List<Integer> maxHeights) {
//        if (maxHeights.size() <= 2) {
//            long sum = 0;
//            for (int value : maxHeights) {
//                sum += value;
//            }
//            return sum;
//        }
//
//        Iterator<Integer> iterator = maxHeights.iterator();
//        int value = iterator.next();
//        Index index = new Index();
//        index.upSum = value;
//        index.downSum = value;
//        index.value = value;
//        index.down = value;
//        int i = 0;
//
//        // 向下走
//        while (iterator.hasNext()) {
//            i++;
//            int current = iterator.next();
//            //和前一个值相等
//            if (current == index.value) {
//                index.upSum += current;
//                index.downSum += index.down;
//                System.out.println(index);
//                continue;
//            }
//
//            long continueDown = index.downSum + Math.min(index.down, current);
//            long topDown = index.upSum + Math.min(index.value, current);
//            if (continueDown > topDown) {
//                index.downSum = continueDown;
//                index.down = Math.min(index.down, current);
//            } else {
//                index.downSum = topDown;
//                index.down = Math.min(index.value, current);
//            }
//
//            //向上走,前面一定不是峰值;
//            //向下走,前面的一个有可能是峰值,也有可能不是峰值
//            if (current > index.value) {
//                index.upSum += current;
//            } else {
//                //从此刻向前的都需要减去相关的值
//                int maxHeight = maxHeights.get(i - 1);
//                index.upSum += current;
//                for (int j = i - 1; j >= 0; j--) {
//                    maxHeight = Math.min(maxHeights.get(j), maxHeight);
//                    int minus = maxHeight - current;
//                    if (minus <= 0) {
//                        break;
//                    }
//                    //有可能减多了
//                    index.upSum -= minus;
//                }
//            }
//
//            index.value = current;
//            System.out.println(index);
//        }
//
//        return Math.max(index.downSum, index.upSum);
//    }
//
//    private static class Index {
//        private long upSum;
//        private long downSum;
//        private long down;
//        private long value;
//
//        @Override
//        public String toString() {
//            return "Index{" + "upSum=" + upSum + ", downSum=" + downSum + ", down=" + down + ", value=" + value + '}';
//        }
//    }
//
//    private int[] downEnd(int start, Integer[] maxHeights) {
//        int sum = 0;
//        for (; start < maxHeights.length; start++) {
//            if (maxHeights[start] > maxHeights[start - 1]) {
//                break;
//            }
//            sum += maxHeights[start];
//        }
//        return new int[]{start, sum};
//    }
//
//    private int[] upEnd(int start, Integer[] maxHeights) {
//        int sum = 0;
//        for (; start < maxHeights.length; start++) {
//            if (maxHeights[start] < maxHeights[start - 1]) {
//                break;
//            }
//            sum += maxHeights[start];
//        }
//        return new int[]{start, sum};
//    }
//
//
//    //上下的拐点,
//    public long maximumSumOfHeights1(List<Integer> maxHeights) {
//        if (maxHeights.size() <= 2) {
//            long sum = 0;
//            for (int value : maxHeights) {
//                sum += value;
//            }
//            return sum;
//        }
//
//        Integer[] nums = maxHeights.toArray(new Integer[0]);
//        int start = 1;
//        int sum = 0;
//        Map<Integer, Long> bottomSum = new HashMap<>();
//        bottoms.add();
//        while (start < nums.length) {
//            int[] nextUp = upEnd(start, nums);
//            if (ne)
//
//        }
//    }
//
//    private static class Item {
//        private long sum;
//        private long value;
//
//        public Item(int value) {
//            this.value = value;
//            this.sum = value;
//        }
//    }
//
//    /**
//     * 示例 1：
//     *
//     * 输入：maxHeights = [5,3,4,1,1]
//     * 输出：13
//     * 解释：和最大的美丽塔方案为 heights = [5,3,3,1,1] ，这是一个美丽塔方案，因为：
//     * - 1 <= heights[i] <= maxHeights[i]
//     * - heights 是个山脉数组，峰值在 i = 0 处。
//     * 13 是所有美丽塔方案中的最大高度和。
//     * 示例 2：
//     *
//     * 输入：maxHeights = [6,5,3,9,2,7]
//     * 输出：22
//     * 解释： 和最大的美丽塔方案为 heights = [3,3,3,9,2,2] ，这是一个美丽塔方案，因为：
//     * - 1 <= heights[i] <= maxHeights[i]
//     * - heights 是个山脉数组，峰值在 i = 3 处。
//     * 22 是所有美丽塔方案中的最大高度和。
//     * 示例 3：
//     *
//     * 输入：maxHeights = [3,2,5,5,2,3]
//     * 输出：18
//     * 解释：和最大的美丽塔方案为 heights = [2,2,5,5,2,2] ，这是一个美丽塔方案，因为：
//     * - 1 <= heights[i] <= maxHeights[i]
//     * - heights 是个山脉数组，最大值在 i = 2 处。
//     * 注意，在这个方案中，i = 3 也是一个峰值。
//     * 18 是所有美丽塔方案中的最大高度和。
//     */
//}
