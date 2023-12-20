package every204;

import java.util.*;

/**
 * https://leetcode.cn/problems/next-greater-numerically-balanced-number/?envType=daily-question&envId=2023-12-09
 * 如果整数  x 满足：对于每个数位 d ，这个数位 恰好 在 x 中出现 d 次。那么整数 x 就是一个 数值平衡数 。
 * <p>
 * 给你一个整数 n ，请你返回 严格大于 n 的 最小数值平衡数 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：n = 1
 * 输出：22
 * 解释：
 * 22 是一个数值平衡数，因为：
 * - 数字 2 出现 2 次
 * 这也是严格大于 1 的最小数值平衡数。
 * 示例 2：
 * <p>
 * 输入：n = 1000
 * 输出：1333
 * 解释：
 * 1333 是一个数值平衡数，因为：
 * - 数字 1 出现 1 次。
 * - 数字 3 出现 3 次。
 * 这也是严格大于 1000 的最小数值平衡数。
 * 注意，1022 不能作为本输入的答案，因为数字 0 的出现次数超过了 0 。
 * 示例 3：
 * <p>
 * 输入：n = 3000
 * 输出：3133
 * 解释：
 * 3133 是一个数值平衡数，因为：
 * - 数字 1 出现 1 次。
 * - 数字 3 出现 3 次。
 * 这也是严格大于 3000 的最小数值平衡数。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 0 <= n <= 10^6
 */
public class Solution2048 {
    private static final List<List<List<Integer>>> list = new ArrayList<>();

    static {
        //1只要一个1
        List<List<Integer>> result = new ArrayList<>();
        result.add(Collections.singletonList(1));
        list.add(result);


        //2只要一个2
        result = new ArrayList<>();
        result.add(Collections.singletonList(2));
        list.add(result);

        //3=0+3=1+2;
        result = new ArrayList<>();
        result.add(Collections.singletonList(3));
        result.add(Arrays.asList(1, 2));
        list.add(result);


        //4=0+4=1+3;
        result = new ArrayList<>();
        result.add(Collections.singletonList(4));
        result.add(Arrays.asList(1, 3));
        list.add(result);

        //5=0+5=1+4=2+3;
        result = new ArrayList<>();
        result.add(Collections.singletonList(5));
        result.add(Arrays.asList(1, 4));
        result.add(Arrays.asList(2, 3));
        list.add(result);

        //6=0+6=1+5=1+2+3=2+4;
        result = new ArrayList<>();
        result.add(Arrays.asList(1, 5));
        result.add(Arrays.asList(2, 4));
        result.add(Arrays.asList(1, 2, 3));
        result.add(Collections.singletonList(6));
        list.add(result);


        //7=0+7=1+6=1+2+4=2+5=3+4;
        result = new ArrayList<>();
        result.add(Arrays.asList(1, 6));
        result.add(Arrays.asList(2, 5));
        result.add(Arrays.asList(3, 4));
        result.add(Arrays.asList(1, 2, 4));
        result.add(Collections.singletonList(7));
        list.add(result);
    }

    //最多7位
    //1位,2位
    public int nextBeautifulNumber(int n) {
        //先把最小的处理了
        if (n == 0) {
            return 1;
        } else if (n <= 21) {
            return 22;
        } else if (n <= 121) {
            return 122;
        }

        String word = String.valueOf(n);

        int length = word.length();
        int a = 0;
        for (int i = 0; i < length; i++) {
            a = a * 10 + a;
        }

        //应该再进一位,找一个进一位的最小值
        if (a <= n) {
            a = 0;
            for (int num : list.get(length).get(0)) {
                for (int i = 1; i <= num; i++) {
                    a = a * 10 + num;
                }
            }
            return a;
        }

        //相同长度里找到一个合适的
        for (char num : word.toCharArray()) {
            if (num - '0' <= length) {

            }
        }


        return 0;
    }
}
