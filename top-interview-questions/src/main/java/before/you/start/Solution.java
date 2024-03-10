package before.you.start;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

public class Solution {
    /**
     * 给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。
     * <p>
     * 说明：
     * <p>
     * 你的算法应该具有线性时间复杂度。 你可以不使用额外空间来实现吗？
     * <p>
     * 示例 1:
     * <p>
     * 输入: [2,2,1]
     * 输出: 1
     * 示例 2:
     * <p>
     * 输入: [4,1,2,1,2]
     * 输出: 4
     *
     * @param nums
     * @return
     */
    public int singleNumber(int[] nums) {
        int a = nums[0];
        for (int i = 1; i < nums.length; i++) {
            a ^= nums[i];
        }
        return a;
    }

    /**
     * 给定一个大小为 n 的数组，找到其中的多数元素。多数元素是指在数组中出现次数大于 ⌊ n/2 ⌋ 的元素。
     * <p>
     * 你可以假设数组是非空的，并且给定的数组总是存在多数元素。
     */
    public int majorityElement(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        } else if (nums.length <= 2) {
            return nums[0];
        }
        int index = nums.length / 2;
        Map<Integer, AtomicInteger> map = new HashMap<>();
        int i = 0;
        for (; i <= index; i++) {
            map.putIfAbsent(nums[i], new AtomicInteger(0));
            map.get(nums[i]).incrementAndGet();
        }

        if (map.get(nums[i - 1]).get() > index) {
            return nums[i - 1];
        }

        for (; i < nums.length; i++) {
            if (map.containsKey(nums[i]) && map.get(nums[i]).incrementAndGet() > index) {
                return nums[i];
            }
        }
        return 0;
    }

    /**
     * 优秀代码
     */
    public int majorityElementV1(int[] nums) {
        if (nums.length == 0)
            return 0;
        int count = 1;
        int more = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == more) {
                count++;
            } else {
                count--;
            }
            if (count < 0) {
                count = 1;
                more  = nums[i];
            }
        }
        return more;
    }

    /**
     * 编写一个高效的算法来搜索 m x n 矩阵 matrix 中的一个目标值 target。该矩阵具有以下特性：
     * <p>
     * 每行的元素从左到右升序排列。
     * 每列的元素从上到下升序排列。
     * 示例:
     * <p>
     * 现有矩阵 matrix 如下：
     * <p>
     * [
     * [1,   4,  7, 11, 15],
     * [2,   5,  8, 12, 19],
     * [3,   6,  9, 16, 22],
     * [10, 13, 14, 17, 24],
     * [18, 21, 23, 26, 30]
     * ]
     * 给定 target = 5，返回 true。
     * <p>
     * 给定 target = 20，返回 false。
     *
     * @param matrix
     * @param target
     * @return
     */
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0) {
            return false;
        }
        int row = 0;
        int col = matrix[0].length - 1;
        while (row < matrix.length && col >= 0) {
            if (matrix[row][col] == target) {
                return true;
            } else if (matrix[row][col] < target) {
                row++;
            } else if (matrix[row][col] > target) {
                col--;
            }
        }
        return false;
    }

    /**
     * 给你两个有序整数数组 nums1 和 nums2，请你将 nums2 合并到 nums1 中，使 nums1 成为一个有序数组。
     * <p>
     * <p>
     * <p>
     * 说明:
     * <p>
     * 初始化 nums1 和 nums2 的元素数量分别为 m 和 n 。
     * 你可以假设 nums1 有足够的空间（空间大小大于或等于 m + n）来保存 nums2 中的元素。
     * <p>
     * <p>
     * 示例:
     * <p>
     * 输入:
     * nums1 = [1,2,3,0,0,0], m = 3
     * nums2 = [2,5,6],       n = 3
     * <p>
     * 输出: [1,2,2,3,5,6]
     *
     * @param nums1
     * @param m
     * @param nums2
     * @param n
     */
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        if (n == 0) {
            return;
        }

        int last = m + n - 1;
        int n1 = m - 1;
        int n2 = n - 1;
        while (n1 >= 0 && n2 >= 0) {
            if (nums1[n1] >= nums2[n2]) {
                nums1[last] = nums1[n1];
                n1--;
            } else {
                nums1[last] = nums2[n2];
                n2--;
            }
            last--;
        }
        for (int i = 0; i <= n2; i++) {
            nums1[i] = nums2[i];
        }
    }

    /**
     * 你将获得 K 个鸡蛋，并可以使用一栋从 1 到 N  共有 N 层楼的建筑。
     * <p>
     * 每个蛋的功能都是一样的，如果一个蛋碎了，你就不能再把它掉下去。
     * <p>
     * 你知道存在楼层 F ，满足 0 <= F <= N 任何从高于 F 的楼层落下的鸡蛋都会碎，从 F 楼层或比它低的楼层落下的鸡蛋都不会破。
     * <p>
     * 每次移动，你可以取一个鸡蛋（如果你有完整的鸡蛋）并把它从任一楼层 X 扔下（满足 1 <= X <= N）。
     * <p>
     * 你的目标是确切地知道 F 的值是多少。
     * <p>
     * 无论 F 的初始值如何，你确定 F 的值的最小移动次数是多少？
     * <p>
     * <p>
     * <p>
     * 示例 1：
     * <p>
     * 输入：K = 1, N = 2
     * 输出：2
     * 解释：
     * 鸡蛋从 1 楼掉落。如果它碎了，我们肯定知道 F = 0 。
     * 否则，鸡蛋从 2 楼掉落。如果它碎了，我们肯定知道 F = 1 。
     * 如果它没碎，那么我们肯定知道 F = 2 。
     * 因此，在最坏的情况下我们需要移动 2 次以确定 F 是多少。
     * 示例 2：
     * <p>
     * 输入：K = 2, N = 6
     * 输出：3
     * 示例 3：
     * <p>
     * 输入：K = 3, N = 14
     * 输出：4
     * <p>
     * <p>
     * 提示：
     * <p>
     * 1 <= K <= 100
     * 1 <= N <= 10000
     */
    public int superEggDrop(int K, int N) {
        /**
         * 三维坐标定位值；
         */
        int[][][] a = new int[K + 1][N + 1][N + 1];
        superEggDrop(K, 1, N, a);
        return a[K][1][N];
    }

    /**
     * start 是不包含,END包含
     *
     * @param K
     * @param start
     * @param end
     * @return
     */
    public void superEggDrop(int K, int start, int end, int[][][] a) {
        if (K < 0 || start <= 0 || end <= 0) {
            return;
        } else if (K == 0) {
            //没有鸡蛋，无需移动
            a[K][start][end] = Integer.MAX_VALUE;
            return;
        } else if (end == start) {
            //只剩一层
            a[K][start][end] = 1;
            return;
        } else if (K == 1) {
            //当只有一个鸡蛋的时候，智能逐层移动
            a[K][start][end] = end - start + 1;
            return;
        } else if (end - start <= 2) {
            a[K][start][end] = 2;
            return;
        }
        // 左侧剩余数量要小一些：理由，往左侧走代表碎鸡蛋了
        int value = end - start;
        //加上数组记忆功能
        for (int i = start + 1; i < end; i++) {
            if (a[K - 1][start][i - 1] <= 0) {
                superEggDrop(K - 1, start, i - 1, a);
            }

            if (a[K][i + 1][end] <= 0) {
                superEggDrop(K, i + 1, end, a);
            }
            value = Math.min(value, Math.max(a[K - 1][start][i - 1], a[K][i + 1][end]));
        }
        a[K][start][end] = value + 1;
    }
}
