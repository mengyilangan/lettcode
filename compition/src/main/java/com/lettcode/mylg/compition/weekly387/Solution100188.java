package com.lettcode.mylg.compition.weekly387;

/**
 * 给你三个 正整数 n 、x 和 y 。
 * <p>
 * 在城市中，存在编号从 1 到 n 的房屋，由 n 条街道相连。对所有 1 <= i < n ，都存在一条街道连接编号为 i 的房屋与编号为 i + 1 的房屋。另存在一条街道连接编号为 x 的房屋与编号为 y 的房屋。
 * <p>
 * 对于每个 k（1 <= k <= n），你需要找出所有满足要求的 房屋对 [house1, house2] ，即从 house1 到 house2 需要经过的 最少 街道数为 k 。
 * <p>
 * 返回一个下标从 1 开始且长度为 n 的数组 result ，其中 result[k] 表示所有满足要求的房屋对的数量，即从一个房屋到另一个房屋需要经过的 最少 街道数为 k 。
 * <p>
 * 注意，x 与 y 可以 相等 。
 * 2 <= n <= 100
 * 1 <= x, y <= n
 * <p>
 * <p>
 * [1,2,3,4,5,6,7,8]
 * [1,3]
 */
public class Solution100188 {
    public int[] countOfPairs(int n, int x, int y) {
        int min = x, max = y;
        if (x > y) {
            min = y;
            max = x;
        }
        int[] res = new int[n];
        int distance = max - min;
        if (distance <= 1) {
            //等同于没有
            statistics(n - 1, res);
            return res;
        }

        //分三段：[1,min][min,max][max,end]
        int end = (n - 1) - distance;
        //距离比较长:看最值
        //可以考虑分成三截
        for (int i = 0; i <= end; i++) {
            int value = (n - i) * 2;//可能会减少一些,也可能会增加一些

        }
        return res;
    }

    private void statistics(int end, int[] res) {
        for (int i = 0; i < end; i++) {
            res[i] = (end - i) * 2;
        }
    }
}
