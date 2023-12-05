package every217;

import java.util.*;

/**
 * https://leetcode.cn/problems/maximum-split-of-positive-even-integers/
 * 给你一个整数 finalSum 。请你将它拆分成若干个 互不相同 的正偶数之和，且拆分出来的正偶数数目 最多 。
 * <p>
 * 比方说，给你 finalSum = 12 ，那么这些拆分是 符合要求 的（互不相同的正偶数且和为 finalSum）：(2 + 10) ，(2 + 4 + 6) 和 (4 + 8) 。它们中，(2 + 4 + 6) 包含最多数目的整数。注意 finalSum 不能拆分成 (2 + 2 + 4 + 4) ，因为拆分出来的整数必须互不相同。
 * 请你返回一个整数数组，表示将整数拆分成 最多 数目的正偶数数组。如果没有办法将 finalSum 进行拆分，请你返回一个 空 数组。你可以按 任意 顺序返回这些整数。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/maximum-split-of-positive-even-integers
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * 1 <= finalSum <= 1010
 */
public class Solution2178 {
    /**
     * 拆分
     * 从2开始拆分,一直拆分到位置
     * <p>
     * Sn=n*a1+n(n-1)d/2
     * =n*2+n(n-1)=n(n+1)
     * 最多拆分N个
     *
     * @param finalSum
     * @return
     */
    public List<Long> maximumEvenSplit(long finalSum) {
        if (finalSum % 2 == 1) {
            return Collections.emptyList();
        } else if (finalSum <= 4) {
            return Collections.singletonList(finalSum);
        }

        long value = (long) Math.sqrt(finalSum);
        if (value * (value + 1) == finalSum) {
            List<Long> list = new ArrayList<>();
            for (long i = 1; i <= value; i++) {
                list.add(i * 2);
            }
            return list;
        }
        List<Long> list = new ArrayList<>();
        list.add(2L);
        long max = 2;
        finalSum -= max;
        //最多value个数
        Set<Long> sets = new TreeSet<>();
        sets.add(max);
        while (max < finalSum) {
            max += 2;
            long current = finalSum - max;
            if (sets.contains(current) || current == max) {
                list.add(finalSum);
                break;
            } else {
                sets.add(max);
                list.add(max);
                finalSum = current;
            }
        }
        return list;
    }
}
