//package every143;
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.TreeMap;
//
///**
// * https://leetcode.cn/problems/find-the-kth-smallest-sum-of-a-matrix-with-sorted-rows/
// * 给你一个 m * n 的矩阵 mat，以及一个整数 k ，矩阵中的每一行都以非递减的顺序排列。
// * <p>
// * 你可以从每一行中选出 1 个元素形成一个数组。返回所有可能数组中的第 k 个 最小 数组和。
// * <p>
// * <p>
// * <p>
// * 示例 1：
// * <p>
// * 输入：mat = [[1,3,11],[2,4,6]], k = 5
// * 输出：7
// * 解释：从每一行中选出一个元素，前 k 个和最小的数组分别是：
// * [1,2], [1,4], [3,2], [3,4], [1,6]。其中第 5 个的和是 7 。
// * 示例 2：
// * <p>
// * 输入：mat = [[1,3,11],[2,4,6]], k = 9
// * 输出：17
// * 示例 3：
// * <p>
// * 输入：mat = [[1,10,10],[1,4,5],[2,3,6]], k = 7
// * 输出：9
// * 解释：从每一行中选出一个元素，前 k 个和最小的数组分别是：
// * [1,1,2], [1,1,3], [1,4,2], [1,4,3], [1,1,6], [1,5,2], [1,5,3]。其中第 7 个的和是 9 。
// * <p>
// * 输入：mat = [[1,1,10],[2,2,9]], k = 7
// * <p>
// * 可以重复
// * 输出：12
// * <p>
// * m == mat.length
// * n == mat.length[i]
// * 1 <= m, n <= 40
// * 1 <= k <= min(200, n ^ m)
// * 1 <= mat[i][j] <= 5000
// * mat[i] 是一个非递减数组
// */
//public class Solution1439 {
//
//    /**
//     * 当前遍历情况
//     */
//    private static class Traverse {
//        private int[] columns;
//
//        private int searchIndex;
//
//        public static Traverse generate(int[][] mat, int row, int col) {
//            Traverse traverse = new Traverse();
//            traverse.columns = mat[row];
//            traverse.searchIndex = col;
//            return traverse;
//        }
//    }
//
//    /**
//     * 遍历集合
//     */
//    public static class TraverseCollection {
//        private final int[][] mat;
//
//        private final TreeMap<Integer, List<Traverse>> collection = new TreeMap<>();
//
//        private ResultDescribe start;
//
//        public TraverseCollection(int[][] mat) {
//            this.mat = mat;
//        }
//
//        /**
//         * 开始寻找第一个位置
//         */
//        public ResultDescribe start() {
//            start = new ResultDescribe(mat.length);
//            for (int row = 0; row < mat.length; row++) {
//                int col = 0;
//                int number = mat[row][col];
//                for (; col < mat[row].length && mat[row][col] == number; col++) ;
//                start.accumulative(number, row, col);
//                this.add(row, col - 1);
//            }
//            return start;
//        }
//
//        /**
//         * 全部都移动到某一个值
//         */
//        public ResultDescribe scrollEnd(int max, int[] point) {
//            ResultDescribe end = new ResultDescribe(mat.length);
//            for (int row = 0; row < mat.length; row++) {
//                int col = point[row];
//                col = col + 1;
//                if (col == mat.length) {
//                    end.accumulative(mat[row][col - 1], row, col - 1);
//                    continue;
//                }
//                int number = mat[row][col];
//                while (number < max) {
//                    number = mat[row][col];
//                    for (; col < mat[row].length && mat[row][col] == number; col++) ;
//                    end.accumulative(number, row, col - 1);
//                    this.add(row, col - 1);
//                }
//            }
//            return end;
//        }
//
//        public ResultDescribe startScrollNext() {
//            ResultDescribe end = new ResultDescribe(mat.length);
//            for (int row = 0; row < mat.length; row++) {
//                int col = point[row];
//                col = col + 1;
//                if (col == mat.length) {
//                    end.accumulative(mat[row][col - 1], row, col - 1);
//                    continue;
//                }
//                int number = mat[row][col];
//                while (number < max) {
//                    number = mat[row][col];
//                    for (; col < mat[row].length && mat[row][col] == number; col++) ;
//                    end.accumulative(number, row, col - 1);
//                    this.add(row, col - 1);
//                }
//            }
//            return end;
//        }
//
//        public void setStart(ResultDescribe start) {
//            this.start = start;
//        }
//
//
//        public void add(int row, int col) {
//            int value = mat[row][col];
//            List<Traverse> traverses = collection.getOrDefault(value, new ArrayList<>());
//            Traverse traverse = Traverse.generate(mat, row, col);
//            traverses.add(traverse);
//            collection.put(value, traverses);
//        }
//    }
//
//    public static class ResultDescribe {
//        /**
//         * 多少个数
//         */
//        private long power = 1;
//
//        private int sum = 0;
//
//        private int[] point;
//
//        public ResultDescribe(int n) {
//            point = new int[n];
//        }
//
//        public void accumulative(int value, int row, int col) {
//            point[row] = col;
//            power = power * (col + 1);
//            sum += value;
//        }
//    }
//
//
//    public int kthSmallest(int[][] mat, int k) {
//        //遍历过去的点
//        TraverseCollection traverseCollection = new TraverseCollection(mat);
//        ResultDescribe resultDescribe = traverseCollection.start();
//        //第一版已经够了
//        if (resultDescribe.power >= k) {
//            return resultDescribe.sum;
//        }
//
//        TreeMap<Integer, List<Traverse>> segment = traverseCollection.collection;
//        int min = segment.firstKey();
//        int max = segment.lastKey();
//        if (max > min) {
//            //直接移动到最大值
//            ResultDescribe end = traverseCollection.scrollEnd(max, resultDescribe.point);
//            if (end.power == k) {
//                return end.sum;
//            } else if (end.power > k) {
//                //在这中间
//
//            }
//        }
//
//        return resultDescribe.sum;
//    }
//}
