package com.lettcode.mylg.compition.weekly379;

/**
 * https://leetcode.cn/contest/weekly-contest-379/problems/minimum-moves-to-capture-the-queen/
 * 现有一个下标从 0 开始的 8 x 8 棋盘，上面有 3 枚棋子。
 * <p>
 * 给你 6 个整数 a 、b 、c 、d 、e 和 f ，其中：
 * <p>
 * (a, b) 表示白色车的位置。
 * (c, d) 表示白色象的位置。
 * (e, f) 表示黑皇后的位置。
 * 假定你只能移动白色棋子，返回捕获黑皇后所需的最少移动次数。
 * <p>
 * 请注意：
 * <p>
 * 车可以向垂直或水平方向移动任意数量的格子，但不能跳过其他棋子。
 * 象可以沿对角线方向移动任意数量的格子，但不能跳过其他棋子。
 * 如果车或象能移向皇后所在的格子，则认为它们可以捕获皇后。
 * 皇后不能移动。
 *
 * @author mylg
 * @date 7/1/24
 */
public class Solution100187 {
    public int minMovesToCaptureTheQueen(int a, int b, int c, int d, int e, int f) {
        int linex = Math.abs(c - e);
        int liney = Math.abs(d - f);
        if (linex == liney) {
            int carx = Math.abs(a - e);
            int cary = Math.abs(b - f);
            //没在斜线上
            if (carx != cary) {
                return 1;
            }

            //探索有可能斜着来
            int minX = Math.min(c, e);
            int maxX = Math.max(c, e);
            if (a <= minX || a >= maxX) {
                return 1;
            }

            int minY = Math.min(d, f);
            int maxY = Math.max(d, f);
            //探索有可能斜着来
            if (b <= minY || b >= maxY) {
                return 1;
            }

            //是否确实在他们的斜线上
            return 2;
        }


        //横向纵向在一条线上,但是车没在一条线上
        if (a == e) {
            if (c != e) {
                return 1;
            }

            int minY = Math.min(b, f);
            int maxY = Math.max(b, f);
            if (d < minY || d > maxY) {
                return 1;
            }

            return 2;
        }

        if (b == f) {
            if (d != f) {
                return 1;
            }


            int minX = Math.min(a, e);
            int maxX = Math.max(a, e);
            if (c < minX || c > maxX) {
                return 1;
            }
            return 2;
        }

        return 2;
    }
}
