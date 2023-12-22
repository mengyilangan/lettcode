package every149;

/**
 * 给你一个数组 points 和一个整数 k 。数组中每个元素都表示二维平面上的点的坐标，并按照横坐标 x 的值从小到大排序。也就是说 points[i] = [xi, yi] ，并且在 1 <= i < j <= points.length 的前提下， xi < xj 总成立。
 * <p>
 * 请你找出 yi+ yj+ |xi- xj| 的 最大值，其中 |xi- xj|<= k 且 1 <= i < j <= points.length。
 * <p>
 * 题目测试数据保证至少存在一对能够满足 |xi- xj|<= k 的点。
 * <p>
 *
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/max-value-of-equation
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * <p>
 * 提示：
 * <p>
 * 2 <= points.length <= 10^5
 * points[i].length == 2
 * -10^8<= points[i][0], points[i][1] <= 10^8
 * 0 <= k <= 2 * 10^8
 * 对于所有的1 <= i < j <= points.length ，points[i][0] < points[j][0] 都成立。也就是说，xi 是严格递增的。
 * <p>
 * <p>
 */
public class Solution1499 {
    public int findMaxValueOfEquation(int[][] points, int k) {
        int maxMinus = points[points.length - 1][0] - points[0][0];
        //任意两个都符合
        int max = Integer.MIN_VALUE;
        if (maxMinus <= k) {
            for (int i = 0; i < points.length; i++) {
                for (int j = i + 1; j < points.length; j++) {
                    max = Math.max(max, points[j][0] - points[i][0] + points[j][1] + points[i][1]);
                }
            }
            return max;
        }
        //判断是否符合
        for (int i = 0; i < points.length; i++) {
            for (int j = i + 1; j < points.length; j++) {
                int xMinus = points[j][0] - points[i][0];
                if (xMinus <= k) {
                    max = Math.max(max, xMinus + points[j][1] + points[i][1]);
                }

            }
        }
        return max;
    }
}
