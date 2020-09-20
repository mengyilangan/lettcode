import java.util.ArrayList;
import java.util.List;

public class Solution56 {
    /**
     * 给出一个区间的集合，请合并所有重叠的区间。
     * <p>
     * 示例 1:
     * <p>
     * 输入: [[1,3],[2,6],[8,10],[15,18]]
     * 输出: [[1,6],[8,10],[15,18]]
     * 解释: 区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
     * 示例 2:
     * <p>
     * 输入: [[1,4],[4,5]]
     * 输出: [[1,5]]
     * 解释: 区间 [1,4] 和 [4,5] 可被视为重叠区间。
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/merge-intervals
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param intervals
     * @return
     */
    public int[][] merge(int[][] intervals) {
        if (intervals == null || intervals.length <= 1) {
            return intervals;
        }
        List<int[]> sort = sortList(intervals);
        List<int[]> list = new ArrayList<>(intervals.length);
        /**
         * 直接合并
         */

        int[] before = sort.remove(0);
        for (int[] item : sort) {
            if (before[1] < item[0]) {
                list.add(before);
                before = item;
            } else if (before[1] <= item[1]) {
                before[1] = item[1];
            }
        }
        list.add(before);

        int[][] result = new int[list.size()][2];
        for (int i = 0; i < list.size(); i++) {
            result[i] = list.get(i);
        }
        return result;
    }

    private List<int[]> sortList(int[][] intervals) {
        List<int[]> list = new ArrayList<>();
        list.add(intervals[0]);
        int[] last = intervals[0];
        for (int i = 1; i < intervals.length; i++) {
            int[] item = intervals[i];
            if (item[0] >= last[0]) {
                list.add(item);
                last = item;
            } else {
                for (int index = 0; index < list.size(); index++) {
                    int[] current = list.get(index);
                    if (current[0] >= item[0]) {
                        list.add(index, item);
                        break;
                    }
                }
            }

        }
        return list;
    }
}
