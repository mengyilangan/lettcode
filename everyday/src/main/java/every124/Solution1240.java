package every124;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.cn/problems/tiling-a-rectangle-with-the-fewest-squares/
 * 你是一位施工队的工长，根据设计师的要求准备为一套设计风格独特的房子进行室内装修。
 * <p>
 * 房子的客厅大小为 n x m，为保持极简的风格，需要使用尽可能少的 正方形 瓷砖来铺盖地面。
 * <p>
 * 假设正方形瓷砖的规格不限，边长都是整数。
 * <p>
 * 请你帮设计师计算一下，最少需要用到多少块方形瓷砖？
 * 1 <= n <= 13
 * 1 <= m <= 13
 * http://int-e.eu/~bf3/squares/proofs.html
 */
public class Solution1240 {
    public int tilingRectangle(int n, int m) {
        Map<Integer, Map<Integer, Integer>> library = new HashMap<>();
        Map<Integer, Integer> libraryFour = new HashMap<>();
        libraryFour.put(5, 5);
        library.put(4, libraryFour);
        return tilingRectangle(n, m, library);
    }


    /**
     * 边界计算
     *
     * @param n
     * @param m
     * @return
     */
    private Integer computeBoundage(int n, int m) {
        if (n == 0 || m == 0) {
            return 0;
        } else if (m == n) {
            return 1;
        } else if (m == 1) {
            return n;
        } else if (n == 1) {
            return m;
        }
        return null;
    }

    /**
     * 对于边界值准备了library
     *
     * @param max
     * @param min
     * @return
     */
    private Integer library(int max, int min, Map<Integer, Map<Integer, Integer>> library) {
        Map<Integer, Integer> res = library.get(min);
        if (res == null) {
            return null;
        }
        return res.get(max);
    }


    public int tilingRectangle(int n, int m, Map<Integer, Map<Integer, Integer>> library) {
        //处理边界问题
        Integer res = computeBoundage(n, m);
        if (res != null) {
            return res;
        }

        int max = Math.max(n, m);
        int min = Math.min(n, m);
        int times = max / min;
        int left = max % min;
        //最接近正方形的内容
        int sum = times - 1;
        return sum + tilingRectangleV1(min + left, min, library);
    }


    /**
     * 长和宽比较看最少放多少个块
     *
     * @param max
     * @param min
     * @return
     */
    private int tilingRectangleV1(int max, int min, Map<Integer, Map<Integer, Integer>> library) {
        System.out.printf("%d_%d%n", max, min);
        Integer res = library(max, min, library);
        if (res != null) {
            return res;
        }


        //处理边界问题
        res = computeBoundage(min, max);
        if (res != null) {
            return res;
        }
        //第一刀到了尽头
        int first = 1 + max / 2;
        if (first == min) {
            return 1 + tilingRectangle(max - first, min,library);
        } else if (min / (max - min) < 4) {
            return 1 + tilingRectangle(max - min, min,library);
        }


        //第二刀
        int second = max - first;

        //第三刀
        int third = min - second;



        return 3 + tilingRectangle(min - first, max - third, library) + tilingRectangle(first - second, second - third, library);
    }
}
