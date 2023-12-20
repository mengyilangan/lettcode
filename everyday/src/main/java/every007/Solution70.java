package every007;

import java.util.Map;
import java.util.TreeMap;

/**
 * https://leetcode.cn/problems/climbing-stairs/?envType=daily-question&envId=2023-12-10
 * 70. 爬楼梯
 * 提示
 * 简单
 * 3.4K
 * 相关企业
 * 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
 * <p>
 * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
 * <p>
 * 1 <= n <= 45
 * 斐波那契数列
 */
public class Solution70 {
    public int climbStairs(int n) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        map.put(1, 1);
        map.put(2, 2);
        for (int i = 3; i <= n; i++) {
            int a1 = map.get(i - 1);
            int a2 = map.get(i - 2);
            map.put(i, a1 + a2);
        }
        return map.get(n);
    }

    public int climbStairs(int n, Map<Integer, Integer> has) {
        Integer before = has.get(n);
        if (before != null) {
            return before;
        }

        int result = 0;
        if (n == 1) {
            result = 1;
        } else if (n == 2) {
            result = 2;
        } else {
            result = climbStairs(n - 1) + climbStairs(n - 2);
        }
        has.put(n, result);
        return result;
    }
}
