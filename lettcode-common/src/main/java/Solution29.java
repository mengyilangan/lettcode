import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 * https://leetcode-cn.com/problems/divide-two-integers/
 * 29. 两数相除
 * 给定两个整数，被除数 dividend 和除数 divisor。将两数相除，要求不使用乘法、除法和 mod 运算符。
 * <p>
 * 返回被除数 dividend 除以除数 divisor 得到的商。
 * <p>
 * 整数除法的结果应当截去（truncate）其小数部分，例如：truncate(8.345) = 8 以及 truncate(-2.7335) = -2
 * <p>
 * <p>
 * <p>
 * 示例 1:
 * <p>
 * 输入: dividend = 10, divisor = 3
 * 输出: 3
 * 解释: 10/3 = truncate(3.33333..) = truncate(3) = 3
 * 示例 2:
 * <p>
 * 输入: dividend = 7, divisor = -3
 * 输出: -2
 * 解释: 7/-3 = truncate(-2.33333..) = -2
 * <p>
 * <p>
 * 提示：
 * <p>
 * 被除数和除数均为 32 位有符号整数。
 * 除数不为 0。
 * 假设我们的环境只能存储 32 位有符号整数，其数值范围是 [−231,  231 − 1]。本题中，如果除法结果溢出，则返回 231 − 1。
 */
public class Solution29 {
    /**
     * 辗转相除
     */
    public int divide(int dividend, int divisor) {
        if (dividend == Integer.MIN_VALUE) {
            if (divisor == -1) {
                return Integer.MAX_VALUE;
            } else if (divisor == 2) {
                return 0 - 1 << 30;
            } else if (divisor == -2) {
                return 1 << 30;
            }
        }
        long dividendL = dividend;
        long divisorL = divisor;
        boolean sign = true;
        if (dividend < 0) {
            sign      = false;
            dividendL = 0 - dividendL;
        }

        if (divisor < 0) {
            sign     = !sign;
            divisorL = 0 - divisorL;
        }
        return sign ? divideSame1(dividendL, divisorL) : 0 - divideSame1(dividendL, divisorL);
    }

    /**
     * 按照倍数来
     *
     * @param dividend
     * @param divisor
     * @return
     */
    private int divideSame1(long dividend, long divisor) {
        if (divisor == 1) {
            return (int) dividend;
        } else if (dividend < divisor) {
            return 0;
        } else if (dividend == divisor) {
            return 1;
        }

        int maxTimes = 30;
        TreeMap<Long, Integer> times = new TreeMap<>();
        long a = divisor;
        int last = 1;
        for (int i = 1; i <= maxTimes && a <= dividend; i++) {
            times.put(a, last);
            a    = a << 1;
            last = last << 1;
        }

        /**
         * 计算值
         */
        int value = 0;
        Map.Entry<Long, Integer> entry = times.lowerEntry(dividend);
        while (entry != null && dividend >= divisor) {
            value += entry.getValue();
            dividend = dividend - entry.getKey();
            entry    = times.lowerEntry(dividend);
        }
        return value;
    }

}
